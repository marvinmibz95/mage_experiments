#!/usr/bin/perl -w
# yes, I know that this task can be done by more simple .bat, but perl script is more portable between OS


use strict;
use Archive::Extract;
use Archive::Zip;
use File::Copy;
use File::Path;

print "Start compiling...\n";
chdir("..");
system("mvn clean install -DskipTests");
chdir("Mage.Client");
system("mvn package assembly:single");
chdir("../Mage.Server");
system("mvn package assembly:single");
chdir("..");
mkdir("temp");
chdir("temp");
move("../Mage.Client/target/mage-client.zip", "client.zip");
move("../Mage.Server/target/mage-server.zip", "server.zip");

my $f = Archive::Extract->new( archive => "client.zip");
$f->extract( to => "client/");
$f = Archive::Extract->new( archive => "server.zip");
$f->extract( to => "server/");
unlink("client.zip");
unlink("server.zip");

my $zip = Archive::Zip->new();;
$zip->addTree("client", "mage-client");
$zip->addTree("server", "mage-server");
$zip->writeToFileNamed("../mage-bundle.zip");
chdir("..");

rmtree("temp");