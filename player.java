import java.util.LinkedList;

public class player {
    String name;
    int totalPoints;
    //Association
    protected LinkedList<card> cards;

    player(String name, LinkedList<card> cards, int totalPoints){
        this.name=name;
        this.cards=cards;
        this.totalPoints=totalPoints;
    }

    public LinkedList<card> getCards(){
        return cards;
    }

    public String getName(){
        return name;
    }

    public int getTotalPoints(){
        return totalPoints;
    }
}
