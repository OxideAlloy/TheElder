package TheElderMod.cards;

import TheElderMod.character.TheElder;
import TheElderMod.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.tempCards.Smite;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.Objects;

public class Shred extends BaseCard {
    public static final String ID = makeID(Shred.class.getSimpleName());
    private static final CardStats info = new CardStats(
            TheElder.Enums.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.SPECIAL,
            CardTarget.ENEMY,
            3
    );

    private static final int DAMAGE = 24;
    private static final int UPG_DAMAGE = 12;

    public Shred() {
        super(ID, info);

        setDamage(DAMAGE, UPG_DAMAGE);
        this.setPortraitTextures("TheElderMod/images/cards/special/ET_Shred512.png", "TheElderMod/images/cards/special/ET_Shred.png");
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
    }


    @Override
    public AbstractCard makeCopy() {
        return new Shred();
    }
}