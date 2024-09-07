package TheElderMod.cards;

        import TheElderMod.actions.DiscardLeftAction;
        import TheElderMod.actions.MimicAction;
        import TheElderMod.actions.OfferAction;
        import TheElderMod.character.TheElder;
        import TheElderMod.util.CardStats;
        import com.megacrit.cardcrawl.actions.AbstractGameAction;
        import com.megacrit.cardcrawl.actions.common.*;
        import com.megacrit.cardcrawl.cards.AbstractCard;
        import com.megacrit.cardcrawl.cards.DamageInfo;
        import com.megacrit.cardcrawl.characters.AbstractPlayer;
        import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Nibble extends BaseCard {
    public static final String ID = makeID(Nibble.class.getSimpleName());
    private static final CardStats info = new CardStats(
            TheElder.Enums.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            0
    );


    private static final int DAMAGE = 1;
    private static final int UPG_DAMAGE = 2;


    public Nibble() {
        super(ID, info);
        setDamage(DAMAGE, UPG_DAMAGE);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        this.addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
        this.addToBot(new MimicAction(this));
//        this.addToBot(new DiscardLeftAction());
//        this.addToBot(new DrawCardAction(1));
    }

    @Override
    public AbstractCard makeCopy() {
        return new Nibble();
    }
}