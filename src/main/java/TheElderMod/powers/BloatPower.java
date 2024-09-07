package TheElderMod.powers;

        import com.megacrit.cardcrawl.actions.animations.VFXAction;
        import com.megacrit.cardcrawl.core.AbstractCreature;
        import com.megacrit.cardcrawl.core.Settings;
        import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
        import com.megacrit.cardcrawl.powers.AbstractPower;
        import com.megacrit.cardcrawl.vfx.TextAboveCreatureEffect;
        import com.megacrit.cardcrawl.vfx.combat.HemokinesisEffect;

        import static TheElderMod.TheElderMod.makeID;

public class BloatPower extends BasePower {
    public static final String POWER_ID = makeID("BloatPower");
    private static final AbstractPower.PowerType TYPE = AbstractPower.PowerType.BUFF;
    private static final boolean TURN_BASED = false;

    public BloatPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }


//    @Override
//    public void onInitialApplication() {
//        this.addToBot(new VFXAction(new HemokinesisEffect(this.owner.hb.cX, this.owner.hb.cY, this.owner.hb.cX, this.owner.hb.cY), 0.5F));
//        AbstractDungeon.player.increaseMaxHp(amount, false);
//    }

    @Override
    public void onApplyPower(AbstractPower power, AbstractCreature target, AbstractCreature source) {
        this.addToBot(new VFXAction(new HemokinesisEffect(this.owner.hb.cX, this.owner.hb.cY, this.owner.hb.cX, this.owner.hb.cY), 0.5F));
        //AbstractDungeon.player.increaseMaxHp(amount, false);

        //increase max HP (without healing) | update health bar
        AbstractDungeon.player.maxHealth += amount;
        AbstractDungeon.player.healthBarUpdatedEvent();

        //increase character size?
        //AbstractDungeon.player.animX += amount/10;
        //AbstractDungeon.player.animY += amount/10;

    }



    @Override
    public void onVictory() {
        AbstractDungeon.player.decreaseMaxHealth(this.amount);
    }


    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }
}
