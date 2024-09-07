package TheElderMod.cards;

import TheElderMod.character.TheElder;
import TheElderMod.powers.BloatPower;
import TheElderMod.powers.HungerPower;
import TheElderMod.util.CardStats;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ConstrictedPower;
import com.megacrit.cardcrawl.powers.ThousandCutsPower;

public class Bloat extends BaseCard {
    public static final String ID = makeID(Bloat.class.getSimpleName());
    private static final CardStats info = new CardStats(
            TheElder.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.SPECIAL,
            CardTarget.NONE,
            2
    );

    //private static final int BLOCK = 8;
    //private static final int UPG_BLOCK = 2;

    private static final int MAGIC = 8;
    private static final int UPG_MAGIC = 4;

    public Bloat() {
        super(ID, info);

        //setBlock(BLOCK, UPG_BLOCK);
        setMagic(MAGIC, UPG_MAGIC);
        this.exhaust = true;
        this.isInnate = true;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        this.addToBot(new ApplyPowerAction(p, p, new BloatPower(p, this.magicNumber), this.magicNumber));
        this.addToBot(new ApplyPowerAction(p, p, new HungerPower(p, this.magicNumber), this.magicNumber));
        //this.addToBot(new ApplyPowerAction(p, p, new ThousandCutsPower(p, this.magicNumber), this.magicNumber));

    }


    @Override
    public AbstractCard makeCopy() {
        return new Bloat();
    }
}