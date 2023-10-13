import java.util.Map;

public class card implements Comparable<card>{
  protected String card;

  public card(String card){
      this.card=card;
  }

  public String getCard(){
    return card;
  }

  public void setCard(String card) {
    this.card = card;
  }

  @Override
  public String toString() {
      return card;
  }


  @Override
    public int compareTo(card c1) {
        Map<String, Integer> cardValue = cardList.getCardValue();
        int c1value = cardValue.get(c1.getCard());
        int c2value = cardValue.get(this.getCard());
        return c2value-c1value;
    }
}
