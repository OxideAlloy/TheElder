package TheElderMod.cards;

import static com.megacrit.cardcrawl.core.CardCrawlGame.languagePack;

public abstract class AbstractElderCard extends AbstractDefaultCard {

    // "How come DefaultCommonAttack extends CustomCard and not DynamicCard like all the rest?"

    // Well every card, at the end of the day, extends CustomCard.
    // Abstract Default Card extends CustomCard and builds up on it, adding a second magic number. Your card can extend it and
    // bam - you can have a second magic number in that card (Learn Java inheritance if you want to know how that works).
    // Abstract Dynamic Card builds up on Abstract Default Card even more and makes it so that you don't need to add
    // the NAME and the DESCRIPTION into your card - it'll get it automatically. Of course, this functionality could have easily
    // Been added to the default card rather than creating a new Dynamic one, but was done so to deliberately.

    public int hatchNumber;        // Just like magic number, or any number for that matter, we want our regular, modifiable stat
    public int hatchBaseNumber;    // And our base stat - the number in it's base state. It will reset to that by default.
    public boolean upgradedHatchNumber; // A boolean to check whether the number has been upgraded or not.
    public boolean isHatchNumberModified; // A boolean to check whether the number has been modified or not, for coloring purposes. (red/green)



    public AbstractElderCard(  final String id,
                               final String img,
                               final int cost,
                               final CardType type,
                               final CardColor color,
                               final CardRarity rarity,
                               final CardTarget target) {

        super(id, languagePack.getCardStrings(id).NAME, img, cost, languagePack.getCardStrings(id).DESCRIPTION, type, color, rarity, target);

        // Set all the things to their default values.
        isCostModified = false;
        isCostModifiedForTurn = false;
        isDamageModified = false;
        isBlockModified = false;
        isMagicNumberModified = false;
        isHatchNumberModified = false;

    }

    public void displayUpgrades() { // Display the upgrade - when you click a card to upgrade it
        super.displayUpgrades();
        if (upgradedHatchNumber) { // If we set upgradedDefaultSecondMagicNumber = true in our card.
            hatchNumber = hatchBaseNumber; // Show how the number changes, as out of combat, the base number of a card is shown.
            isHatchNumberModified = true; // Modified = true, color it green to highlight that the number is being changed.
        }

    }

    public void upgradeDefaultSecondMagicNumber(int amount) { // If we're upgrading (read: changing) the number. Note "upgrade" and NOT "upgraded" - 2 different things. One is a boolean, and then this one is what you will usually use - change the integer by how much you want to upgrade.
        hatchBaseNumber += amount; // Upgrade the number by the amount you provide in your card.
        hatchNumber = hatchBaseNumber; // Set the number to be equal to the base value.
        upgradedHatchNumber = true; // Upgraded = true - which does what the above method does.
    }


}