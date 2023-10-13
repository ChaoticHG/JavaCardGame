import java.util.LinkedList;
import java.util.Queue;

public class game {
    Integer phase;
    private LinkedList<player> players;
    private static Queue<Integer>phase1P1 = new LinkedList<Integer>();
    private static Queue<Integer>phase1P2 = new LinkedList<Integer>();
    private static Queue<Integer>phase1P3 = new LinkedList<Integer>();
    private static Queue<Integer>phase2P1 = new LinkedList<Integer>();
    private static Queue<Integer>phase2P2 = new LinkedList<Integer>();

    game(Integer phase, LinkedList<player> players){
        this.phase=phase;
        this.players=players;
    }

    public int[][] findPhase1RoundWinner(){
        phase1P1 = new LinkedList<Integer>();
        phase1P2 = new LinkedList<Integer>();
        phase1P3 = new LinkedList<Integer>();
        int phase1RoundScores[][]= new int[3][4];
        for(int i=0, k=5, j=0; i<3; i++, k+=5, j+=5){
            BST<Integer> tree1 = new BST<>();
            BST<Integer> tree2 = new BST<>();
            BST<Integer> tree3 = new BST<>();
            BST<Integer> tree4 = new BST<>();
            LinkedList<card> player1Card = cardList.pick(players.get(0).getCards(),j,k);
            tree1.insert(cardList.sumC(player1Card));
            tree1.insert(cardList.sumD(player1Card));
            tree1.insert(cardList.sumH(player1Card));
            tree1.insert(cardList.sumS(player1Card));
            phase1P1.add(tree1.maxElement().getData());
            LinkedList<card> player2Card = cardList.pick(players.get(1).getCards(),j,k);
            tree2.insert(cardList.sumC(player2Card));
            tree2.insert(cardList.sumD(player2Card));
            tree2.insert(cardList.sumH(player2Card));
            tree2.insert(cardList.sumS(player2Card));
            phase1P2.add(tree2.maxElement().getData());
            LinkedList<card> player3Card = cardList.pick(players.get(2).getCards(),j,k);
            tree3.insert(cardList.sumC(player3Card));
            tree3.insert(cardList.sumD(player3Card));
            tree3.insert(cardList.sumH(player3Card));
            tree3.insert(cardList.sumS(player3Card));
            phase1P3.add(tree3.maxElement().getData());
            tree4.insert(tree1.maxElement().getData());
            tree4.insert(tree2.maxElement().getData());
            tree4.insert(tree3.maxElement().getData());
            phase1RoundScores[i][0]=tree1.maxElement().getData();
            phase1RoundScores[i][1]=tree2.maxElement().getData();
            phase1RoundScores[i][2]=tree3.maxElement().getData();
            phase1RoundScores[i][3]=tree4.maxElement().getData();
        }
        return phase1RoundScores;
    }

    public int[][] findPhase2RoundWinner(){
        phase2P1 = new LinkedList<Integer>();
        phase2P2 = new LinkedList<Integer>();
        int phase2RoundScores[][]= new int[4][3];
        for(int i=0, k=5, j=0; i<4; i++, k+=5, j+=5){
            BST<Integer> tree1 = new BST<>();
            BST<Integer> tree2 = new BST<>();
            BST<Integer> tree3 = new BST<>();
            LinkedList<card> player1Card = cardList.pick(players.get(0).getCards(),j,k);
            tree1.insert(cardList.sumC(player1Card));
            tree1.insert(cardList.sumD(player1Card));
            tree1.insert(cardList.sumH(player1Card));
            tree1.insert(cardList.sumS(player1Card));
            phase2P1.add(tree1.maxElement().getData());
            LinkedList<card> player2Card = cardList.pick(players.get(1).getCards(),j,k);
            tree2.insert(cardList.sumC(player2Card));
            tree2.insert(cardList.sumD(player2Card));
            tree2.insert(cardList.sumH(player2Card));
            tree2.insert(cardList.sumS(player2Card));
            phase2P2.add(tree2.maxElement().getData());
            tree3.insert(tree1.maxElement().getData());
            tree3.insert(tree2.maxElement().getData());
            phase2RoundScores[i][0]=tree1.maxElement().getData();
            phase2RoundScores[i][1]=tree2.maxElement().getData();
            phase2RoundScores[i][2]=tree3.maxElement().getData();
        }
        return phase2RoundScores;
    }

    public int[] findPhase1Score(int phase1RoundScores[][],int totalPlayer, int totalRounds){
        int winner[]= new int[totalPlayer];
        for(int i=0; i < totalPlayer; i++){
            for(int j=0; j<totalRounds; j++)
                if(phase1RoundScores[j][i]==phase1RoundScores[j][totalPlayer])
                    winner[i]+=phase1RoundScores[j][i];
        }
        return winner;
    }

    public static int findIndex(int arr[], int t)
    {
        if (arr == null) {
            return -1;
        }
 
        // find length of array
        int len = arr.length;
        int i = 0;
 
        // traverse in the array
        while (i < len) {
 
            // if the i-th element is t
            // then return the index
            if (arr[i] == t) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }

    public static Queue<Integer> getphase1P1(){
        return new LinkedList<Integer>(phase1P1);
    }

    public static Queue<Integer> getphase1P2(){
        return new LinkedList<Integer>(phase1P2);
    }

    public static Queue<Integer> getphase1P3(){
        return new LinkedList<Integer>(phase1P3);
    }

    public static Queue<Integer> getphase2P1(){
        return new LinkedList<Integer>(phase2P1);
    }

    public static Queue<Integer> getphase2P2(){
        return new LinkedList<Integer>(phase2P2);
    }

    public LinkedList<player> getPlayers(){
        return new LinkedList<player>(players);
    }

}
