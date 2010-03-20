/*
* Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
*
* Redistribution and use in source and binary forms, with or without modification, are
* permitted provided that the following conditions are met:
*
*    1. Redistributions of source code must retain the above copyright notice, this list of
*       conditions and the following disclaimer.
*
*    2. Redistributions in binary form must reproduce the above copyright notice, this list
*       of conditions and the following disclaimer in the documentation and/or other materials
*       provided with the distribution.
*
* THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
* WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
* FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
* CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
* CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
* SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
* ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
* NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
* ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*
* The views and conclusions contained in the software and documentation are those of the
* authors and should not be interpreted as representing official policies, either expressed
* or implied, of BetaSteward_at_googlemail.com.
*/

package mage.sets;

import mage.sets.shardsofalara.*;
import mage.cards.ExpansionSet;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class ShardsOfAlara extends ExpansionSet {

	private static final ShardsOfAlara fINSTANCE =  new ShardsOfAlara();

	public static ShardsOfAlara getInstance() {
		return fINSTANCE;
	}

	private ShardsOfAlara() {
		this.name = "Shards Of Alara";
		this.cards.add(AjaniVengeant.class);
		this.cards.add(Blightning.class);
		this.cards.add(BroodmateDragon.class);
		this.cards.add(CrumblingNecropolis.class);
		this.cards.add(JundPanorama.class);
		this.cards.add(KnightOfTheWhiteOrchid.class);
		this.cards.add(RangerOfEos.class);
		this.cards.add(SarkhanVol.class);
		this.cards.add(SavageLands.class);
		this.cards.add(SproutingThrinax.class);
		this.cards.add(WildNacatl.class);
		this.cards.add(WoollyThoctar.class);
	}

}
