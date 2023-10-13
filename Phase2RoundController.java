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

public class Phase2RoundController implements Initializable{
    public int no1=0,no2=0;
    public int totalRounds = 1;
    public Label player1Label, player2Label, player3Label;
    public Button buttonGoBack, buttonCard, buttonNext, buttonPrevious, buttonNextPhase;
    public String[] rounds= {"Round 1","Round 2","Round 3"};
    String[] deck1 = new String[52];
    String[] deck2 = new String[52];
    public ImageView p1a,p1b,p1c,p1d,p1e,p2a,p2b,p2c,p2d,p2e;
    public TextField roundPoints, player1,player11, player2,player22, p1rp, p2rp, p1total, p2total;
    public LinkedList<card> player1Card= new LinkedList<>();
    public LinkedList<card> player2Card= new LinkedList<>();
    public LinkedList<card> player3Card= new LinkedList<>();
    public LinkedList<game> games = new LinkedList<>();
    public LinkedList<card> player1DeckOnHand;
    public LinkedList<card> player2DeckOnHand;
    public Deque<Integer>phase2P1,phase2P2;
    public Stack<Integer> stack1 = new Stack<Integer>();
    public Stack<Integer> stack2 = new Stack<Integer>();
    public int p2winner[][];

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setPlayerName(String p1, String p2){
        player1Label.setText(p1);
        player2Label.setText(p2);
        player1.setText(p1);
        player2.setText(p2);
        player11.setText(p1);
        player22.setText(p2);
    }

    public void setDeck(String[] deck1,String[] deck2){
        this.deck1=deck1;
        this.deck2=deck2;
        if(games.get(1).getPlayers().get(0).getCards().isEmpty()){
            for (int i = 0; i < 26; i ++) {
                games.get(1).getPlayers().get(0).getCards().add(new card(deck2[i]));
            }

                for (int i = 26; i < 52; i ++) {
                games.get(1).getPlayers().get(1).getCards().add(new card(deck2[i]));
            }
        }
        else {
            for (int i = 0; i < 26; i ++) {
                games.get(1).getPlayers().get(0).getCards().set(i, new card(deck1[i]));
            }

                for (int a=0, i = 26; i < 52; a ++,i ++) {
                games.get(1).getPlayers().get(1).getCards().set(a, new card(deck2[i]));
            }
        }
    }

    public void setPhase(int totalRounds){
        
        switch(totalRounds){
            case 1:
            roundPoints.setText("Round 1 Points");
            player1DeckOnHand= cardList.pick(games.get(1).getPlayers().get(0).getCards(),0,5);
            Collections.sort(player1DeckOnHand);
            player2DeckOnHand= cardList.pick(games.get(1).getPlayers().get(1).getCards(),0,5);
            Collections.sort(player2DeckOnHand);
            p2winner=games.get(1).findPhase2RoundWinner();
            phase2P1= new LinkedList<>(game.getphase2P1());
            phase2P2= new LinkedList<>(game.getphase2P2());
            p1rp.setText(String.valueOf(game.getphase2P1().peek()));
            p2rp.setText(String.valueOf(game.getphase2P2().peek()));
            for(int i=0; i<2; i++){
                games.get(1).getPlayers().get(i).totalPoints=0;
                if(p2winner[0][i]==p2winner[0][2]){
                    games.get(1).getPlayers().get(i).totalPoints+=p2winner[0][i];
                }
            }
            loadImage();
            break;

            case 2:
            roundPoints.setText("Round 2 Points");
            player1DeckOnHand= cardList.pick(games.get(1).getPlayers().get(0).getCards(),5,10);
            Collections.sort(player1DeckOnHand);
            player2DeckOnHand= cardList.pick(games.get(1).getPlayers().get(1).getCards(),5,10);
            Collections.sort(player2DeckOnHand);
            loadImage();
            break;

            case 3:
            roundPoints.setText("Round 3 Points");
            player1DeckOnHand= cardList.pick(games.get(1).getPlayers().get(0).getCards(),10,15);
            Collections.sort(player1DeckOnHand);
            player2DeckOnHand= cardList.pick(games.get(1).getPlayers().get(1).getCards(),10,15);
            Collections.sort(player2DeckOnHand);
            loadImage();
            break;

            case 4:
            roundPoints.setText("Round 4 Points");
            player1DeckOnHand= cardList.pick(games.get(1).getPlayers().get(0).getCards(),15,20);
            Collections.sort(player1DeckOnHand);
            player2DeckOnHand= cardList.pick(games.get(1).getPlayers().get(1).getCards(),15,20);
            Collections.sort(player2DeckOnHand);
            loadImage();
            break;
        }
    }

    public void goBackClick(){
        Stage stage = (Stage) buttonGoBack.getScene().getWindow();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Phase2Begin.fxml"));
            Scene scene = new Scene(loader.load());
            Phase2BeginController controller = loader.getController();
            controller.setPlayerName(player1.getText(), player2.getText());
            controller.setDeck(deck1,deck2);
            controller.setGames(games, no1, no2);
            stage.setScene(scene);
            }catch(IOException io){
                io.printStackTrace();
        }
    }

    public void cardClick(){
        Stage stage = (Stage) buttonGoBack.getScene().getWindow();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Phase2RemainingCard.fxml"));
            Scene scene = new Scene(loader.load());
            Phase2RemainingCardController controller = loader.getController();
            controller.setDeck(deck1,deck2);
            controller.setGames(games,no1,no2);
            controller.setRounds(totalRounds);
            if(totalRounds>1){
                controller.setData(p2winner);
            }
            stage.setScene(scene);
        }catch(IOException io){
            io.printStackTrace();
        }
    }

    public void nextClick(){
        if(totalRounds < 4){
            totalRounds+=1;
            for(int i=0; i<2; i++){
                if(p2winner[totalRounds-1][i]==p2winner[totalRounds-1][2]){
                    games.get(1).getPlayers().get(i).totalPoints+=p2winner[totalRounds-1][i];
                }
            }
            stack1.push(phase2P1.remove());
            stack2.push(phase2P2.remove());
            p1rp.setText(String.valueOf(phase2P1.peek()));
            p2rp.setText(String.valueOf(phase2P2.peek()));
            setPhase(totalRounds);
        }
    }

    public void previousClick(){
        if(totalRounds > 1){
            for(int i=0; i<2; i++){
                if(p2winner[totalRounds-1][i]==p2winner[totalRounds-1][2]){
                    games.get(1).getPlayers().get(i).totalPoints-=p2winner[totalRounds-1][i];
                }
            }
            phase2P1.addFirst(stack1.pop());
            phase2P2.addFirst(stack2.pop());
            p1rp.setText(String.valueOf(phase2P1.peek()));
            p2rp.setText(String.valueOf(phase2P2.peek()));
            totalRounds-=1;
            setPhase(totalRounds);
        }
    }

    public void nextPhaseClick(){
        Stage stage = (Stage) buttonGoBack.getScene().getWindow();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("results.fxml"));
            Scene scene = new Scene(loader.load());
            resultsController controller = loader.getController();
            controller.setData(player1.getText(), player2.getText(), deck1, deck2, games, no1, no2);
            stage.setScene(scene);
        }catch(IOException io){
            io.printStackTrace();
        }
    }

    
    public void setData(int p2winner[][]){
        this.p2winner=p2winner;
    }

    public void setRounds(int totalRounds){
        this.totalRounds=totalRounds;
    }

    public void loadImage(){
        p1total.setText(String.valueOf(games.get(0).getPlayers().get(no1).getTotalPoints() + games.get(1).getPlayers().get(0).getTotalPoints()));
        p2total.setText(String.valueOf(games.get(0).getPlayers().get(no2).getTotalPoints() + games.get(1).getPlayers().get(1).getTotalPoints()));
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
    }

    public void setGames(LinkedList<game> games, int no1, int no2){
        this.games=games;
        this.no1=no1;
        this.no2=no2;
    }
}

