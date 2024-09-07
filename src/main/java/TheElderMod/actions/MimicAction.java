package TheElderMod.actions;

        import com.megacrit.cardcrawl.actions.AbstractGameAction;
        import com.megacrit.cardcrawl.actions.common.DrawCardAction;
        import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
        import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
        import com.megacrit.cardcrawl.actions.utility.UseCardAction;
        import com.megacrit.cardcrawl.cards.AbstractCard;
        import com.megacrit.cardcrawl.core.Settings;
        import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
        import com.megacrit.cardcrawl.helpers.GetAllInBattleInstances;

        import java.util.Iterator;
        import java.util.UUID;

public class MimicAction extends AbstractGameAction {
    private AbstractCard c;

    public MimicAction(AbstractCard c) {
        this.c = c;

        this.actionType = ActionType.CARD_MANIPULATION;
        this.duration = Settings.ACTION_DUR_FAST;
        this.actionType = ActionType.WAIT;
    }

    public void update() {
//        this.addToBot(new DiscardLeftAction());
//        this.addToBot(new DrawCardAction(1));

        Iterator var2 = AbstractDungeon.actionManager.actions.iterator();
        while (var2.hasNext()) {
            AbstractGameAction act = (AbstractGameAction) var2.next();
            if (act instanceof UseCardAction) {
                UseCardAction action = (UseCardAction) act;
                action.reboundCard = true;
            }
        }
        this.isDone = true;
    }
}

