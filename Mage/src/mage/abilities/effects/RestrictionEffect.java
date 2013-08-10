/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 * 
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 * 
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 * 
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 * 
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */

package mage.abilities.effects;

import mage.abilities.Ability;
import mage.constants.Duration;
import mage.constants.EffectType;
import mage.constants.Outcome;
import mage.filter.FilterPermanent;
import mage.game.Game;
import mage.game.permanent.Permanent;
import mage.players.Player;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public abstract class RestrictionEffect<T extends RestrictionEffect<T>> extends ContinuousEffectImpl<T> {

    private boolean notMoreThanRestriction;
    private int notMoreThanNumber;
    private FilterPermanent notMoreThanNumberFilter;

    public RestrictionEffect(Duration duration) {
        this(duration, false, 0, null);
    }

    public RestrictionEffect(Duration duration, boolean notMoreThanRestriction, int notMoreThanNumber, FilterPermanent notMoreThanNumberFilter) {
        super(duration, Outcome.Detriment);
        this.effectType = EffectType.RESTRICTION;
        this.notMoreThanRestriction = notMoreThanRestriction;
        this.notMoreThanNumber = notMoreThanNumber;
        this.notMoreThanNumberFilter = notMoreThanNumberFilter;
    }

    public RestrictionEffect(final RestrictionEffect effect) {
        super(effect);
        this.notMoreThanRestriction = effect.notMoreThanRestriction;
        if (this.notMoreThanNumberFilter != null) {
            this.notMoreThanNumberFilter = effect.notMoreThanNumberFilter.copy();
        }
    }

    @Override
    public boolean apply(Game game, Ability source) {
        throw new UnsupportedOperationException("Not supported.");
    }

    public abstract boolean applies(Permanent permanent, Ability source, Game game);


    /*
     * only used for the notMoreThanRestrictions, called to check if the effect shall be applied for a player
     *
     */ 
    public boolean appliesNotMoreThan(Player player, Ability source, Game game) {
        return false;
    }

    public boolean canAttack(Game game) {
        return true;
    }

    public boolean canBlock(Permanent attacker, Permanent blocker, Ability source, Game game) {
        return true;
    }

    public boolean canBeBlocked(Permanent attacker, Permanent blocker, Ability source, Game game) {
        return true;
    }

    public boolean canBeUntapped(Permanent permanent, Game game) {
        return true;
    }

    public boolean canUseActivatedAbilities(Permanent permanent, Ability source, Game game) {
        return true;
    }

    public boolean isNotMoreThanRestriction() {
        return notMoreThanRestriction;
    }

    public int getNotMoreThanNumber() {
        return notMoreThanNumber;
    }

    public FilterPermanent getNotMoreThanNumberFilter() {
        return notMoreThanNumberFilter;
    }
    
}
