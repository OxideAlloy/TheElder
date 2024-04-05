package TheElderMod.cards;

import TheElderMod.actions.ForeshadowAction;
import TheElderMod.character.TheElder;
import TheElderMod.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;

public class Rend extends BaseCard {
    public static final String ID = makeID(Rend.class.getSimpleName());
    private static final CardStats info = new CardStats(
            TheElder.Enums.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            1
    );

    private static final int DAMAGE = 2;

    private static final int MAGIC = 1;
    private static final int UPG_MAGIC = 1;


    public Rend() {
        super(ID, info);

        setDamage(DAMAGE);
        setMagic(MAGIC, UPG_MAGIC);
        cardsToPreview = new Shred();
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
        addToBot(new ApplyPowerAction(m, p, new VulnerablePower(m, this.magicNumber, false), this.magicNumber));

        this.addToBot(new ForeshadowAction(m,AbstractDungeon.player.hand.group.indexOf(this), cardsToPreview.cardID));
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    //// NOTE: Need to add AddToDeckPatch to gain a Shred when adding this to your deck ////
    ////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public AbstractCard makeCopy() {
        return new Rend();
    }
}