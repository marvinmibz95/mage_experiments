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

package mage.sets.shardsofalara;

import java.util.UUID;
import mage.Constants.CardType;
import mage.Constants.Outcome;
import mage.Constants.Zone;
import mage.MageInt;
import mage.abilities.common.EntersBattlefieldTriggeredAbility;
import mage.abilities.effects.OneShotEffect;
import mage.abilities.effects.common.SearchLibraryRevealPutInHandEffect;
import mage.cards.Card;
import mage.cards.CardImpl;
import mage.cards.Cards;
import mage.cards.CardsImpl;
import mage.filter.Filter.ComparisonType;
import mage.filter.FilterCard;
import mage.game.Game;
import mage.players.Player;
import mage.target.TargetCard;
import mage.target.common.TargetCardInLibrary;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class RangerOfEos extends CardImpl {

	private static FilterCard filter = new FilterCard("creature cards with converted mana cost 1 or less");

	static {
		filter.getCardType().add(CardType.CREATURE);
		filter.setConvertedManaCost(2);
		filter.setConvertedManaCostComparison(ComparisonType.LessThan);
	}

	public RangerOfEos(UUID ownerId) {
		super(ownerId, "Ranger Of Eos", new CardType[]{CardType.CREATURE}, "{3}{W}");
		this.color.setWhite(true);
		this.subtype.add("Human");
		this.subtype.add("Soldier");
		this.art = "114946_typ_reg_sty_010.jpg";
		this.power = new MageInt(3);
		this.toughness = new MageInt(2);

		TargetCardInLibrary target = new TargetCardInLibrary(0, 2, filter);
		this.addAbility(new EntersBattlefieldTriggeredAbility(new SearchLibraryRevealPutInHandEffect(target), true));
	}

}

//class RangerOfEosEffect extends OneShotEffect {
//
//	private static FilterCard filter = new FilterCard();
//
//	static {
//		filter.getCardType().add(CardType.CREATURE);
//		filter.setConvertedManaCost(2);
//		filter.setConvertedManaCostComparison(ComparisonType.LessThan);
//	}
//
//	@Override
//	public boolean apply(Game game) {
//		Player player = game.getPlayer(this.getSource().getControllerId());
//		TargetCard target = new TargetCard(0, 2, Zone.LIBRARY, filter);
//		player.searchCards(new CardsImpl(Zone.LIBRARY, player.getLibrary().getCards()), target, game);
//		Cards cards = new CardsImpl(Zone.REVEALED);
//		for (UUID cardId: target.getTargets()) {
//			Card card = player.getLibrary().remove(cardId);
//			if (card != null) {
//				player.putInHand(card, game);
//				cards.add(card);
//			}
//		}
//		if (cards.size() > 0)
//			player.revealCards(cards, game);
//		return true;
//	}
//
//	@Override
//	public String getText() {
//		return "you may search your library for up to two creature cards with converted mana cost 1 or less, reveal them, and put them into your hand. If you do, shuffle your library.";
//	}
//}