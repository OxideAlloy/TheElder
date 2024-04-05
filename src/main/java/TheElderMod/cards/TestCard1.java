package TheElderMod.cards;

import TheElderMod.actions.DiscardLeftAction;
import TheElderMod.character.TheElder;
import TheElderMod.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.TalkAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;

public class TestCard1 extends BaseCard {
    public static final String ID = makeID(TestCard1.class.getSimpleName());
    private static final CardStats info = new CardStats(
            TheElder.Enums.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            1
    );

    private static final int MAGIC = 5;
    private static final int UPG_MAGIC = 2;

    private static final int DAMAGE = 5;
    private static final int UPG_DAMAGE = 2;

    private static final int BLOCK = 5;
    private static final int UPG_BLOCK = 2;

    //double hand_pos = (double)AbstractDungeon.player.hand.group.indexOf(this);

    public TestCard1() {
        super(ID, info);
        setMagic(MAGIC, UPG_MAGIC);
        setDamage(DAMAGE, UPG_DAMAGE);
        setBlock(BLOCK, UPG_BLOCK);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
        addToBot(new ApplyPowerAction(m, p, new WeakPower(m, this.magicNumber, false), this.magicNumber));

        AbstractDungeon.actionManager.addToBottom(new SFXAction("VO_GREMLINNOB_1A"));
        this.addToBot(new TalkAction(true, "@RRrroohrrRGHHhhh!!@", 1.5F, 1.5F));

        addToBot(new DiscardLeftAction());

//        System.out.println("******** Card hand position is ********");
//        System.out.println(AbstractDungeon.player.hand.group.indexOf(this));
//        System.out.println(AbstractDungeon.player.hand.group.get(AbstractDungeon.player.hand.group.indexOf(this)));

        //System.out.println(AbstractDungeon.player.hand.group.get(AbstractDungeon.player.hand.group.indexOf(this)+1));
        //System.out.println("******** Top card in deck is ********");
        //System.out.println(AbstractDungeon.player.drawPile.getTopCard());

        //AbstractCard card = AbstractDungeon.player.drawPile.getTopCard();
        //this.addToTop(new NewQueueCardAction(card, this.target, false, true));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new TestCard1();
    }
}