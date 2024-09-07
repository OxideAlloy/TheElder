package TheElderMod.cards;

        import TheElderMod.character.TheElder;
        import TheElderMod.util.CardStats;
        import com.badlogic.gdx.math.MathUtils;
        import com.megacrit.cardcrawl.actions.common.*;
        import com.megacrit.cardcrawl.cards.AbstractCard;
        import com.megacrit.cardcrawl.characters.AbstractPlayer;
        import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Defend extends BaseCard {
    public static final String ID = makeID(Defend.class.getSimpleName());
    private static final CardStats info = new CardStats(
            TheElder.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.BASIC,
            CardTarget.SELF,
            1
    );


    private static final int BLOCK = 5;
    private static final int UPG_BLOCK = 2;
    double shiftNum = 1;


    public Defend() {
        super(ID, info);
        setBlock(BLOCK, UPG_BLOCK);
        this.tags.add(CardTags.STARTER_DEFEND);
    }

    @Override
    public void triggerWhenDrawn() {
        shiftNum = MathUtils.random()+.5;
        setBlock(Math.toIntExact(Math.round(BLOCK*shiftNum)), Math.toIntExact(Math.round(UPG_BLOCK*shiftNum)));
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new GainBlockAction(p, p, block));

    }

    @Override
    public AbstractCard makeCopy() {
        return new Defend();
    }
}