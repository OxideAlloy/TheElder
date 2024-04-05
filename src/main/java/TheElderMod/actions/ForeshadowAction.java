package TheElderMod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class ForeshadowAction extends AbstractGameAction {
    private int CardPos;
    private String MatchingCard;

    public ForeshadowAction(AbstractCreature target, int card_position, String matching_card) {
        this.actionType = ActionType.CARD_MANIPULATION;
//        this.target = target;
//        this.info = info;
        this.target = target;
        this.CardPos = card_position;
        this.MatchingCard = matching_card;
    }

    public void update() {
        //System.out.println("******** Card played position in hand is ********");

        if(AbstractDungeon.player.hand.group.size()>=CardPos+1){
            System.out.println("SETTING: "+AbstractDungeon.player.hand.group.get(CardPos).cardID);
            AbstractCard card = AbstractDungeon.player.hand.group.get(CardPos);

            if(card.cardID == MatchingCard) {
                System.out.println("MATCHED!");
                this.addToTop(new NewQueueCardAction(card, this.target, false, true));
            }
        }

        this.isDone = true;
    }
}
