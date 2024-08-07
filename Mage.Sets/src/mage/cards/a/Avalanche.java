
package mage.cards.a;

import mage.abilities.dynamicvalue.common.GetXValue;
import mage.abilities.effects.common.DestroyTargetEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SuperType;
import mage.filter.FilterPermanent;
import mage.filter.common.FilterLandPermanent;
import mage.target.TargetPermanent;
import mage.target.targetadjustment.TargetsCountAdjuster;

import java.util.UUID;

/**
 * @author TheElk801
 */
public final class Avalanche extends CardImpl {
    private static final FilterPermanent filter = new FilterLandPermanent("snow lands");

    static {
        filter.add(SuperType.SNOW.getPredicate());
    }

    public Avalanche(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.SORCERY}, "{X}{2}{R}{R}");

        // Destroy X target snow lands.
        this.getSpellAbility().addEffect(new DestroyTargetEffect("Destroy X target snow lands"));
        this.getSpellAbility().addTarget(new TargetPermanent(1, 1, filter, false));
        this.getSpellAbility().setTargetAdjuster(new TargetsCountAdjuster(GetXValue.instance));

    }

    private Avalanche(final Avalanche card) {
        super(card);
    }

    @Override
    public Avalanche copy() {
        return new Avalanche(this);
    }
}
