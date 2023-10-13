import java.util.LinkedList;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public class cardList {
  public static final int CARDS_NUM = 52;
  private static Map<String, Integer> cardValue=new HashMap<String, Integer>(); 
  private static String[] suits = {"c", "d", "h", "s"};
  private static String[] faces = {"a", "2", "3", "4", "5", "6", "7", "8", "9", "x", "j", "q", "k"};
  private static String[] deck = new String[52];

  public static String[] getDeck(){
    return (String[]) deck.clone();
  }

  public static Map<String, Integer> getCardValue(){
    return cardValue;
  }

  public static void generateCardValue(){
    for ( int i = 1, j =0; j < cardList.getDeck().length; i++, j++){
      cardValue.put( deck[j], i);
  }
  }
  public static void generateCard(){
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < faces.length; j++) {
                deck[faces.length*i + j] = suits[i] + faces[j];
            }
        } 
  }

  public static LinkedList<card> pick(LinkedList<card> list, int j, int k) {        
       LinkedList<card> pick5 = new LinkedList<card>(list.subList(j, k));
       return pick5;
  }

  public static void shuffle(String deck[]) {   
      Random rand = new Random();       
      for (int i = 0; i < CARDS_NUM; i++) { 
          int r = i + rand.nextInt(52 - i);   
            //swapping the elements 
           String temp = deck[r]; 
           deck[r] = deck[i]; 
           deck[i] = temp; 
      } 
  }

  public static int sumC(LinkedList<card> subList){
    int sumC = 0;
    for(int i=0; i<5;i++){
      for (int j=2; j<=9; j++){
        if(subList.get(i).getCard().equals("c" + j)){
           sumC += j;
         }
       }
       if(subList.get(i).getCard().equals("ca")){
        sumC += 1;
       }
       if(subList.get(i).getCard().equals("cx")){
        sumC += 10;
       }
       if(subList.get(i).getCard().equals("cj")){
        sumC += 10;
      }
      if(subList.get(i).getCard().equals("cq")){
         sumC += 10;
       }
      if(subList.get(i).getCard().equals("ck")){
         sumC += 10;
      }
    }
  return sumC;
  }
  
  public static int sumD(LinkedList<card> subList){
    int sumD = 0;
    for(int i=0; i<5;i++){
      for (int j=2; j<=9; j++){
        if(subList.get(i).getCard().equals("d" + j)){
           sumD += j;
         }
       }
       if(subList.get(i).getCard().equals("da")){
        sumD += 1;
       }
       if(subList.get(i).getCard().equals("dx")){
        sumD += 10;
       }
       if(subList.get(i).getCard().equals("dj")){
        sumD += 10;
      }
      if(subList.get(i).getCard().equals("dq")){
         sumD += 10;
       }
      if(subList.get(i).getCard().equals("dk")){
         sumD += 10;
      }
    }
  return sumD;
  }
  
  public static int sumH(LinkedList<card> subList){
    int sumH = 0;
    for(int i=0; i<5;i++){
      for (int j=2; j<=9; j++){
        if(subList.get(i).getCard().equals("h" + j)){
           sumH += j;
         }
       }
       if(subList.get(i).getCard().equals("ha")){
        sumH += 1;
       }
       if(subList.get(i).getCard().equals("hx")){
        sumH += 10;
       }
       if(subList.get(i).getCard().equals("hj")){
        sumH += 10;
      }
      if(subList.get(i).getCard().equals("hq")){
         sumH += 10;
       }
      if(subList.get(i).getCard().equals("hk")){
         sumH += 10;
      }
    }
  return sumH;
  }
  
  public static int sumS(LinkedList<card> subList){
    int sumS = 0;
    for(int i=0; i<5;i++){
      for (int j=2; j<=9; j++){
        if(subList.get(i).getCard().equals("s" + j)){
          sumS += j;
         }
       }
       if(subList.get(i).getCard().equals("sa")){
        sumS += 1;
       }
       if(subList.get(i).getCard().equals("sx")){
        sumS += 10;
       }
       if(subList.get(i).getCard().equals("sj")){
        sumS += 10;
      }
      if(subList.get(i).getCard().equals("sq")){
        sumS += 10;
       }
      if(subList.get(i).getCard().equals("sk")){
        sumS += 10;
      }
    }
  return sumS;
  }
}
