package TheElderMod.actions;

        import TheElderMod.powers.BloatPower;
        import com.megacrit.cardcrawl.actions.AbstractGameAction;
        import com.megacrit.cardcrawl.actions.common.*;
        import com.megacrit.cardcrawl.actions.utility.WaitAction;
        import com.megacrit.cardcrawl.cards.AbstractCard;
        import com.megacrit.cardcrawl.cards.DamageInfo;
        import com.megacrit.cardcrawl.core.AbstractCreature;
        import com.megacrit.cardcrawl.core.Settings;
        import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
        import com.megacrit.cardcrawl.helpers.GetAllInBattleInstances;
        import com.megacrit.cardcrawl.vfx.combat.FlashAtkImgEffect;

        import java.util.Iterator;
        import java.util.UUID;

public class OfferAction extends AbstractGameAction {
    private AbstractCard card;
    private UUID uuid;
    private boolean cardCreated;

    public OfferAction(AbstractCreature target, AbstractCreature source, int amount) {
        this.setValues(target, source, amount);
        this.actionType = ActionType.DAMAGE;
        this.duration = 0.33F;
    }

    public void update() {


        if (this.duration == 0.33F && this.target.currentHealth > 0) {
            AbstractDungeon.effectList.add(new FlashAtkImgEffect(this.target.hb.cX, this.target.hb.cY, this.attackEffect));
        }

        this.tickDuration();
        if (this.isDone) {

            if (this.target.hasPower("theelder:BloatPower")) {
                int bloatAmount = AbstractDungeon.player.getPower(BloatPower.POWER_ID).amount;
                if (this.amount <= bloatAmount) {
                    this.addToTop(new ReducePowerAction(this.target, this.target, "theelder:BloatPower", this.amount));
                } else {
                    this.addToTop(new RemoveSpecificPowerAction(this.target, this.target, "theelder:BloatPower"));
                    AbstractDungeon.player.decreaseMaxHealth(this.amount-bloatAmount);
                }
            } else {
                AbstractDungeon.player.decreaseMaxHealth(this.amount);
            }

            if (AbstractDungeon.getCurrRoom().monsters.areMonstersBasicallyDead()) {
                AbstractDungeon.actionManager.clearPostCombatActions();
            }

            if (!Settings.FAST_MODE) {
                this.addToTop(new WaitAction(0.1F));
            }
        }

    }
}

