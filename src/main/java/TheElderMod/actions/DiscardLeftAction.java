package TheElderMod.actions;


import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.GameActionManager;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class DiscardLeftAction extends AbstractGameAction {
    private float startingDuration;

    public DiscardLeftAction() {
        //this.target = AbstractDungeon.player;
        this.actionType = ActionType.CARD_MANIPULATION;

    }

    public void update() {
        AbstractCard c;

        if (this.duration == this.startingDuration) {
            int count = AbstractDungeon.player.hand.size();
            if (count > 0) {
                c = AbstractDungeon.player.hand.group.get(0);
                AbstractDungeon.player.hand.moveToDiscardPile(c);
                c.triggerOnManualDiscard();
            }
            this.isDone = true;
        }
    }

}