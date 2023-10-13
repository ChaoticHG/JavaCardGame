import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.Stack;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Phase1RoundController implements Initializable{
    public int totalRounds = 1;
    public Label player1Label, player2Label, player3Label;
    public Button buttonGoBack, buttonCard, buttonNext, buttonPrevious, buttonNextPhase;
    public String[] rounds= {"Round 1","Round 2","Round 3"};
    public String deck[];
    String[] deck2 = cardList.getDeck();
    public ImageView p1a,p1b,p1c,p1d,p1e,p2a,p2b,p2c,p2d,p2e,p3a,p3b,p3c,p3d,p3e;
    public TextField roundPoints, player1,player11, player2,player22, player3,player33, p1rp, p2rp, p3rp, p1total, p2total, p3total;
    public LinkedList<card> player1Card= new LinkedList<>();
    public LinkedList<card> player2Card= new LinkedList<>();
    public LinkedList<card> player3Card= new LinkedList<>();
    public LinkedList<game> games = new LinkedList<>();
    public LinkedList<card> player1DeckOnHand;
    public LinkedList<card> player2DeckOnHand;
    public LinkedList<card> player3DeckOnHand;
    public Deque<Integer>phase1P1,phase1P2,phase1P3;
    public Stack<Integer> stack1 = new Stack<Integer>();
    public Stack<Integer> stack2 = new Stack<Integer>();
    public Stack<Integer> stack3 = new Stack<Integer>();
    public int p1winner[][];

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setPlayerName(String p1, String p2, String p3){
        player1Label.setText(p1);
        player2Label.setText(p2);
        player3Label.setText(p3);
        player1.setText(p1);
        player2.setText(p2);
        player3.setText(p3);
        player11.setText(p1);
        player22.setText(p2);
        player33.setText(p3);
    }

    public void setDeck(String[] deck){
        this.deck=deck;
        for (int i = 0; i < 18; i ++) {
            games.get(0).getPlayers().get(0).getCards().add(new card(deck[i]));
        }

        for (int i = 18; i < 35; i ++) {
            games.get(0).getPlayers().get(1).getCards().add(new card(deck[i]));
        }

        for (int i = 35; i < 52; i ++) {
            games.get(0).getPlayers().get(2).getCards().add(new card(deck[i]));
        }
    }

    public void setPhase(int totalRounds){
        
        switch(totalRounds){
            case 1:
            roundPoints.setText("Round 1 Points");
            player1DeckOnHand= cardList.pick(games.get(0).getPlayers().get(0).getCards(),0,5);
            Collections.sort(player1DeckOnHand);
            player2DeckOnHand= cardList.pick(games.get(0).getPlayers().get(1).getCards(),0,5);
            Collections.sort(player2DeckOnHand);
            player3DeckOnHand= cardList.pick(games.get(0).getPlayers().get(2).getCards(),0,5);
            Collections.sort(player3DeckOnHand);
            p1winner=games.get(0).findPhase1RoundWinner();
            phase1P1= new LinkedList<>(game.getphase1P1());
            phase1P2= new LinkedList<>(game.getphase1P2());
            phase1P3= new LinkedList<>(game.getphase1P3());
            p1rp.setText(String.valueOf(game.getphase1P1().peek()));
            p2rp.setText(String.valueOf(game.getphase1P2().peek()));
            p3rp.setText(String.valueOf(game.getphase1P3().peek()));
            for(int i=0; i<3; i++){
                games.get(0).getPlayers().get(i).totalPoints=0;
                if(p1winner[0][i]==p1winner[0][3]){
                    games.get(0).getPlayers().get(i).totalPoints+=p1winner[0][i];
                }
            }
            loadImage();
            break;

            case 2:
            roundPoints.setText("Round 2 Points");
            player1DeckOnHand= cardList.pick(games.get(0).getPlayers().get(0).getCards(),5,10);
            Collections.sort(player1DeckOnHand);
            player2DeckOnHand= cardList.pick(games.get(0).getPlayers().get(1).getCards(),5,10);
            Collections.sort(player2DeckOnHand);
            player3DeckOnHand= cardList.pick(games.get(0).getPlayers().get(2).getCards(),5,10);
            Collections.sort(player3DeckOnHand);
            loadImage();
            break;

            case 3:
            roundPoints.setText("Round 3 Points");
            player1DeckOnHand= cardList.pick(games.get(0).getPlayers().get(0).getCards(),10,15);
            Collections.sort(player1DeckOnHand);
            player2DeckOnHand= cardList.pick(games.get(0).getPlayers().get(1).getCards(),10,15);
            Collections.sort(player2DeckOnHand);
            player3DeckOnHand= cardList.pick(games.get(0).getPlayers().get(2).getCards(),10,15);
            Collections.sort(player3DeckOnHand);
            loadImage();
            break;
        }
    }

    public void goBackClick(){
        Stage stage = (Stage) buttonGoBack.getScene().getWindow();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Phase1Begin.fxml"));
            Scene scene = new Scene(loader.load());
            Phase1BeginController controller = loader.getController();
            controller.setPlayerName(player1.getText(), player2.getText(),player3.getText());
            controller.setDeck(deck);
            stage.setScene(scene);
            }catch(IOException io){
                io.printStackTrace();
        }
    }

    public void cardClick(){
        Stage stage = (Stage) buttonGoBack.getScene().getWindow();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Phase1RemainingCard.fxml"));
            Scene scene = new Scene(loader.load());
            Phase1RemainingCardController controller = loader.getController();
            controller.setDeck(deck);
            controller.setGames(games);
            controller.setPhase(totalRounds);
            controller.setRounds(totalRounds);
            if(totalRounds>1){
                controller.setData(p1winner);
                controller.setStack(totalRounds);
            }
            stage.setScene(scene);
        }catch(IOException io){
            io.printStackTrace();
        }
    }

    public void nextClick(){
        if(totalRounds < 3){
            totalRounds+=1;
            for(int i=0; i<3; i++){
                if(p1winner[totalRounds-1][i]==p1winner[totalRounds-1][3]){
                    games.get(0).getPlayers().get(i).totalPoints+=p1winner[totalRounds-1][i];
                }
            }
            stack1.push(phase1P1.remove());
            stack2.push(phase1P2.remove());
            stack3.push(phase1P3.remove());
            p1rp.setText(String.valueOf(phase1P1.peek()));
            p2rp.setText(String.valueOf(phase1P2.peek()));
            p3rp.setText(String.valueOf(phase1P3.peek()));
            setPhase(totalRounds);
        }
    }

    public void previousClick(){
        if(totalRounds > 1){
            for(int i=0; i<3; i++){
                if(p1winner[totalRounds-1][i]==p1winner[totalRounds-1][3]){
                    games.get(0).getPlayers().get(i).totalPoints-=p1winner[totalRounds-1][i];
                }
            }
            phase1P1.addFirst(stack1.pop());
            phase1P2.addFirst(stack2.pop());
            phase1P3.addFirst(stack3.pop());
            p1rp.setText(String.valueOf(phase1P1.peek()));
            p2rp.setText(String.valueOf(phase1P2.peek()));
            p3rp.setText(String.valueOf(phase1P3.peek()));
            totalRounds-=1;
            setPhase(totalRounds);
        }
    }

    public void nextPhaseClick(){
        p1winner=games.get(0).findPhase1RoundWinner();
        BST<Integer> tree1 = new BST<>();
        int []totalPoints= games.get(0).findPhase1Score(p1winner, 3, 3);
        int no1=0;
        int no2=0;
        int multipleLargest=0;
        for(int i=0; i<3; i++){
            tree1.insert(totalPoints[i]);
        }
        int largest=tree1.maxElement().getData();
        int secondLargest=tree1.secondLargestElement().getData();
        no1=game.findIndex(totalPoints, largest);
        for(int i=0; i<3; i++){
            if(totalPoints[i]==largest){
            multipleLargest++;
            if(multipleLargest==2){
                no2=i;
                break;
            }
            }
        }
        if(multipleLargest==1){
        no2=game.findIndex(totalPoints, secondLargest);
        }
        Stage stage = (Stage) buttonGoBack.getScene().getWindow();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Phase2Begin.fxml"));
            Scene scene = new Scene(loader.load());
            Phase2BeginController controller = loader.getController();
            controller.setGames(games,no1,no2);
            controller.setPlayerName(games.get(0).getPlayers().get(no1).getName(), games.get(0).getPlayers().get(no2).getName());
            controller.setDeck(deck, deck2);
            stage.setScene(scene);
        }catch(IOException io){
            io.printStackTrace();
        }
    }

    
    public void setData(int p1winner[][]){
        this.p1winner=p1winner;
    }

        
    public void setStack(int totalRounds){
            Deque<Integer> phase1P1= new LinkedList<>(game.getphase1P1());
            Deque<Integer> phase1P2= new LinkedList<>(game.getphase1P2());
            Deque<Integer> phase1P3= new LinkedList<>(game.getphase1P3());
            for(int i=1; i < totalRounds; i++){
            stack1.push(phase1P1.remove());
            stack2.push(phase1P2.remove());
            stack3.push(phase1P3.remove());
            }
    }

    public void setRounds(int totalRounds){
        this.totalRounds=totalRounds;
    }

    public void loadImage(){
        p1total.setText(String.valueOf(games.get(0).getPlayers().get(0).getTotalPoints()));
        p2total.setText(String.valueOf(games.get(0).getPlayers().get(1).getTotalPoints()));
        p3total.setText(String.valueOf(games.get(0).getPlayers().get(2).getTotalPoints()));
        p1a.setImage(new Image("PNG/"+ player1DeckOnHand.get(0) +".png"));
        p1b.setImage(new Image("PNG/"+ player1DeckOnHand.get(1) +".png"));
        p1c.setImage(new Image("PNG/"+ player1DeckOnHand.get(2) +".png"));
        p1d.setImage(new Image("PNG/"+ player1DeckOnHand.get(3) +".png"));
        p1e.setImage(new Image("PNG/"+ player1DeckOnHand.get(4) +".png"));
        p2a.setImage(new Image("PNG/"+ player2DeckOnHand.get(0) +".png"));
        p2b.setImage(new Image("PNG/"+ player2DeckOnHand.get(1) +".png"));
        p2c.setImage(new Image("PNG/"+ player2DeckOnHand.get(2) +".png"));
        p2d.setImage(new Image("PNG/"+ player2DeckOnHand.get(3) +".png"));
        p2e.setImage(new Image("PNG/"+ player2DeckOnHand.get(4) +".png"));
        p3a.setImage(new Image("PNG/"+ player3DeckOnHand.get(0) +".png"));
        p3b.setImage(new Image("PNG/"+ player3DeckOnHand.get(1) +".png"));
        p3c.setImage(new Image("PNG/"+ player3DeckOnHand.get(2) +".png"));
        p3d.setImage(new Image("PNG/"+ player3DeckOnHand.get(3) +".png"));
        p3e.setImage(new Image("PNG/"+ player3DeckOnHand.get(4) +".png"));
    }

    public void setGames(LinkedList<game> games){
        this.games=games;
    }
}
