package TheElderMod.cards;

import TheElderMod.character.TheElder;
import TheElderMod.util.CardStats;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ConstrictedPower;
import com.megacrit.cardcrawl.powers.FrailPower;

public class Taste extends BaseCard {
    public static final String ID = makeID(Taste.class.getSimpleName());
    private static final CardStats info = new CardStats(
            TheElder.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            1
    );


    private static final int MAGIC = 1;
    private static final int UPG_MAGIC = 1;


    public Taste() {
        super(ID, info);

        setMagic(MAGIC, UPG_MAGIC);
        //setCustomVar("secondMagic", 1, 1);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(m, p, new ConstrictedPower(m, p, this.magicNumber), this.magicNumber));
        addToBot(new ApplyPowerAction(m, p, new FrailPower(m, this.magicNumber, false), this.magicNumber));
        //addToBot(new ApplyPowerAction(m, p, new FrailPower(m, customVar("secondMagic"), false), customVar("secondMagic")));
    }

    @Override
    public AbstractCard makeCopy() {
        return new Taste();
    }
}