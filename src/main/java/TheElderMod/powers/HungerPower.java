package TheElderMod.powers;

import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static TheElderMod.TheElderMod.makeID;

public class HungerPower extends BasePower {
    public static final String POWER_ID = makeID("HungerPower");
    private static final AbstractPower.PowerType TYPE = AbstractPower.PowerType.BUFF;
    private static final boolean TURN_BASED = false;

    public HungerPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    @Override
    public void onAttack(DamageInfo info, int damageAmount, AbstractCreature target) {
        //this.addToBot(new HungerAction(this.owner, this.amount));
        //this.addToBot(new DrawCardAction(this.owner, this.amount));
        //Testing that this works
        //addToBot(new GainBlockAction(AbstractDungeon.player, AbstractDungeon.player, 10));

        //System.out.println("targets last damage taken was " + target.lastDamageTaken);
//        System.out.println("hunger amount is " + this.amount);
//        System.out.println("damageAmount  is " + damageAmount);
//
//        if (target != null) {
//            this.addToBot(new VFXAction(new BiteEffect(target.hb.cX, target.hb.cY - 40.0F * Settings.scale, Color.SCARLET.cpy()), 0.3F));
//        }
//        //Using DamageInfo.DamageType.NORMAL might break something... FINGERS CROSSED
//        addToBot(new VampireDamageAction(target, new DamageInfo(owner, damageAmount, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.NONE));
//        this.addToBot(new ReducePowerAction(this.owner, this.owner, POWER_ID, damageAmount));


        //this.addToBot(new HungerAction(this.owner, target, damageTypeForTurn, damageAmount));

//        if (damageAmount > 0 && target != this.owner && info.type == DamageInfo.DamageType.NORMAL) {
//            System.out.println("hunger amount is " + this.amount);
//            System.out.println("damageAmount  is " + damageAmount);
//            this.flash();
//            //this.addToTop(new ApplyPowerAction(target, this.owner, new PoisonPower(target, this.owner, this.amount), this.amount, true));
//            //this.addToBot(new VampireDamageAction(target, info, AbstractGameAction.AttackEffect.NONE));
//            if (target.lastDamageTaken > 0) {
//
//                //this.addToTop(new HealAction(this.source, this.source, target.lastDamageTaken));
//                this.addToBot(new ReducePowerAction(this.owner, this.owner, POWER_ID, damageAmount));
//            }
//
//        }

        if (damageAmount > 0 && target != this.owner && info.type == DamageInfo.DamageType.NORMAL) {
            this.flash();
            this.addToBot(new HealAction(this.owner, this.owner, 1));
            this.addToBot(new ReducePowerAction(this.owner, this.owner, POWER_ID, 1));
        }


//        int healAmount = 10;
//        if(target.lastDamageTaken<1){
//            healAmount = 0;
//        } else if (target.lastDamageTaken >= this.amount) {
//            healAmount = this.amount;
//        } else {
//            healAmount = target.lastDamageTaken;
//        }
//
//        if (healAmount > 0) {
//            //AbstractDungeon.effectList.add(new FlashAtkImgEffect(target.hb.cX, target.hb.cY, AbstractGameAction.AttackEffect.NONE));
//            this.addToTop(new HealAction(this.source, this.source, healAmount));
//            this.addToBot(new ReducePowerAction(this.owner, this.owner, POWER_ID, healAmount));
//            this.addToTop(new WaitAction(0.1F));
//        }


    }

//    public float atDamageGive(float damage, DamageInfo.DamageType type) {
//        System.out.println("atDamageGive was " + damage);
//        return damage;
//    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }
}
