package TheElderMod.cards;

        import TheElderMod.character.TheElder;
        import TheElderMod.util.CardStats;
        import com.badlogic.gdx.math.MathUtils;
        import com.megacrit.cardcrawl.actions.AbstractGameAction;
        import com.megacrit.cardcrawl.actions.common.*;
        import com.megacrit.cardcrawl.cards.AbstractCard;
        import com.megacrit.cardcrawl.cards.DamageInfo;
        import com.megacrit.cardcrawl.characters.AbstractPlayer;
        import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Strike extends BaseCard {
    public static final String ID = makeID(Strike.class.getSimpleName());
    private static final CardStats info = new CardStats(
            TheElder.Enums.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.BASIC,
            CardTarget.ENEMY,
            1
    );


    private static final int DAMAGE = 6;
    private static final int UPG_DAMAGE = 3;
    double shiftNum = 1;


    public Strike() {
        super(ID, info);
        setDamage(DAMAGE, UPG_DAMAGE);
        this.tags.add(CardTags.STARTER_STRIKE);
        this.tags.add(CardTags.STRIKE);
    }

    @Override
    public void triggerWhenDrawn() {
        shiftNum = MathUtils.random()+.5;
        setDamage(Math.toIntExact(Math.round(DAMAGE*shiftNum)), Math.toIntExact(Math.round(UPG_DAMAGE*shiftNum)));
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
    }

    @Override
    public AbstractCard makeCopy() {
        return new Strike();
    }
}