package TheElderMod.cards;

import TheElderMod.actions.HatchAction;
import TheElderMod.character.TheElder;
import TheElderMod.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class FleshWall extends BaseCard {
    public static final String ID = makeID(FleshWall.class.getSimpleName());
    private static final CardStats info = new CardStats(
            TheElder.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.NONE,
            1
    );

    private static final int BLOCK = 8;
    private static final int UPG_BLOCK = 2;

    private static final int MAGIC = 2;
    //private static final int UPG_MAGIC = -2;

    //private boolean discardCheck = false;

    public FleshWall() {
        super(ID, info);

        setBlock(BLOCK, UPG_BLOCK);
        setMagic(MAGIC);
        this.cardsToPreview = new FleshBlossom();
        if (this.upgraded) {
            //might need to have code for if upgrade happens during battle
            this.cardsToPreview.upgrade();
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new HatchAction(this.uuid));
        this.addToBot(new GainBlockAction(p, p, block));

        //discardCheck = true;
    }

    public void onMoveToDiscard() {
        this.addToBot(new HatchAction(this.uuid));
    }



    ////////////////
    // Hatch code //
    ////////////////
//    @Override
//    public void triggerOnEndOfTurnForPlayingCard() { discardCheck = true; }
//    @Override
//    public void triggerOnManualDiscard() {
//        discardCheck = true;
//    }
//    @Override
//    public void triggerOnScry() {
//        discardCheck = true;
//    }
//    @Override
//    public void onMoveToDiscard() {
//        if(discardCheck == true) {
//            this.addToBot(new HatchAction(this.uuid));
//            discardCheck = false;
//        }
//    }

    @Override
    public AbstractCard makeCopy() {
        return new FleshWall();
    }
}