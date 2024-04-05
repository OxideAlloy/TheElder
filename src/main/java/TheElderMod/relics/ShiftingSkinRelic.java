package TheElderMod.relics;


import TheElderMod.actions.DiscardLeftAction;
import TheElderMod.character.TheElder;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import static TheElderMod.TheElderMod.makeID;

public class ShiftingSkinRelic extends BaseRelic {
    private static final String NAME = "ShiftingSkinRelic"; //The name will be used for determining the image file as well as the ID.
    public static final String ID = makeID(NAME); //This adds the mod's prefix to the relic ID, resulting in modID:MyRelic
    private static final RelicTier RARITY = RelicTier.COMMON; //The relic's rarity.
    private static final LandingSound SOUND = LandingSound.CLINK; //The sound played when the relic is clicked.

    public ShiftingSkinRelic() {
        super(ID, NAME, TheElder.Enums.CARD_COLOR, RARITY, SOUND);
    }


    @Override
    public void onUseCard(AbstractCard targetCard, UseCardAction useCardAction) {
        if (AbstractDungeon.player.hand.size()>1) {
            this.flash();
            this.addToBot(new DiscardLeftAction());
            this.addToBot(new DrawCardAction(1));
        }
    }
}