package mage.cards.decks.importer;

import mage.cards.repository.CardCriteria;
import mage.cards.repository.CardInfo;

import java.util.*;

/**
 * Tests only: mock of card repository for deck import tests
 * TODO: move that tests from Mage to Test project
 */
public class FakeCardLookup extends CardLookup {

    private final Map<String, CardInfo> lookup = new HashMap<>();
    private final boolean alwaysMatches;

    public FakeCardLookup() {
        this(true);
    }

    public FakeCardLookup(boolean alwaysMatches) {
        this.alwaysMatches = alwaysMatches;
    }

    public FakeCardLookup addCard(String cardName) {
        lookup.put(cardName, new CardInfo() {{
            name = cardName;
        }});
        return this;
    }

    public Optional<CardInfo> lookupCardInfo(String cardName) {
        CardInfo card = lookup.get(cardName);
        if (card != null) {
            return Optional.of(card);
        }

        if (alwaysMatches) {
            return Optional.of(new CardInfo() {{
                name = cardName;
            }});
        }

        return Optional.empty();
    }

    @Override
    public List<CardInfo> lookupCardInfo(CardCriteria criteria) {
        return lookupCardInfo(criteria.getName())
                .map(Collections::singletonList)
                .orElse(Collections.emptyList());
    }

}
