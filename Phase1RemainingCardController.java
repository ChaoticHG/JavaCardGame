import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Phase1RemainingCardController {
    public Button goBackButton;
    public Label round, player1Name, player2Name, player3Name;
    public ImageView p1a,p1b,p1c,p1d,p1e,p1f,p1g,p1h,p1i,p1j,p1k,p1l,p1m,p1n,p1o,p1p,p1q,p1r;
    public ImageView p2a,p2b,p2c,p2d,p2e,p2f,p2g,p2h,p2i,p2j,p2k,p2l,p2m,p2n,p2o,p2p,p2q;
    public ImageView p3a,p3b,p3c,p3d,p3e,p3f,p3g,p3h,p3i,p3j,p3k,p3l,p3m,p3n,p3o,p3p,p3q;
    public int totalRounds;
    public LinkedList<card> player1DeckOnHand;
    public LinkedList<card> player2DeckOnHand;
    public LinkedList<card> player3DeckOnHand;
    public LinkedList<game> games = new LinkedList<>();
    public Deque<Integer>phase1P1,phase1P2,phase1P3;
    public Stack<Integer> stack1 = new Stack<Integer>();
    public Stack<Integer> stack2 = new Stack<Integer>();
    public Stack<Integer> stack3 = new Stack<Integer>();
    public int p1winner[][];
    public String[] deck;
    
    public void setPhase(int totalRounds){
        this.totalRounds=totalRounds;
        switch(totalRounds){
            case 1:
            round.setText("Round 1");
            player1DeckOnHand= cardList.pick(games.get(0).getPlayers().get(0).getCards(),5,18);
            player2DeckOnHand= cardList.pick(games.get(0).getPlayers().get(1).getCards(),5,17);
            player3DeckOnHand= cardList.pick(games.get(0).getPlayers().get(2).getCards(),5,17);
            loadImageRound1();
            break;

            case 2:
            round.setText("Round 2");
            player1DeckOnHand= cardList.pick(games.get(0).getPlayers().get(0).getCards(),10,18);
            player2DeckOnHand= cardList.pick(games.get(0).getPlayers().get(1).getCards(),10,17);
            player3DeckOnHand= cardList.pick(games.get(0).getPlayers().get(2).getCards(),10,17);
            loadImageRound2();
            break;

            case 3:
            round.setText("Round 3");
            player1DeckOnHand= cardList.pick(games.get(0).getPlayers().get(0).getCards(),15,18);
            player2DeckOnHand= cardList.pick(games.get(0).getPlayers().get(1).getCards(),15,17);
            player3DeckOnHand= cardList.pick(games.get(0).getPlayers().get(2).getCards(),15,17);
            loadImageRound3();
            break;
        }
    }

    public void goBackClick(){
        Stage stage = (Stage) goBackButton.getScene().getWindow();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Phase1Round.fxml"));
            Scene scene = new Scene(loader.load());
            Phase1RoundController controller = loader.getController();
            controller.setGames(games);
            controller.setPlayerName(games.get(0).getPlayers().get(0).getName(), games.get(0).getPlayers().get(1).getName(), games.get(0).getPlayers().get(2).getName());
            controller.setDeck(deck);
            controller.setPhase(1);
            if(totalRounds>1){
                controller.setData(p1winner);
                for(int i=1; i<totalRounds; i++)
                controller.nextClick();
            }
            stage.setScene(scene);
        }catch(IOException io){
            io.printStackTrace();
        }
    }

    public void setDeck(String[] deck){
        this.deck=deck;
    }

    public void setGames(LinkedList<game> games){
        this.games=games;
        player1Name.setText(games.get(0).getPlayers().get(0).getName()); 
        player2Name.setText(games.get(0).getPlayers().get(1).getName());
        player3Name.setText(games.get(0).getPlayers().get(2).getName());
    }

    public void setData(int p1winner[][]){
        this.p1winner=p1winner;
    }

    public void setRounds(int totalRounds){
        this.totalRounds=totalRounds;
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
    
    public void loadImageRound1(){
        
        p1a.setImage(new Image("PNG/"+ player1DeckOnHand.get(0) +".png"));
        p1b.setImage(new Image("PNG/"+ player1DeckOnHand.get(1) +".png"));
        p1c.setImage(new Image("PNG/"+ player1DeckOnHand.get(2) +".png"));
        p1d.setImage(new Image("PNG/"+ player1DeckOnHand.get(3) +".png"));
        p1e.setImage(new Image("PNG/"+ player1DeckOnHand.get(4) +".png"));
        p1f.setImage(new Image("PNG/"+ player1DeckOnHand.get(5) +".png"));
        p1g.setImage(new Image("PNG/"+ player1DeckOnHand.get(6) +".png"));
        p1h.setImage(new Image("PNG/"+ player1DeckOnHand.get(7) +".png"));
        p1i.setImage(new Image("PNG/"+ player1DeckOnHand.get(8) +".png"));
        p1j.setImage(new Image("PNG/"+ player1DeckOnHand.get(9) +".png"));
        p1k.setImage(new Image("PNG/"+ player1DeckOnHand.get(10) +".png"));
        p1l.setImage(new Image("PNG/"+ player1DeckOnHand.get(11) +".png"));
        p1m.setImage(new Image("PNG/"+ player1DeckOnHand.get(12) +".png"));

        
        p2a.setImage(new Image("PNG/"+ player2DeckOnHand.get(0) +".png"));
        p2b.setImage(new Image("PNG/"+ player2DeckOnHand.get(1) +".png"));
        p2c.setImage(new Image("PNG/"+ player2DeckOnHand.get(2) +".png"));
        p2d.setImage(new Image("PNG/"+ player2DeckOnHand.get(3) +".png"));
        p2e.setImage(new Image("PNG/"+ player2DeckOnHand.get(4) +".png"));
        p2f.setImage(new Image("PNG/"+ player2DeckOnHand.get(5) +".png"));
        p2g.setImage(new Image("PNG/"+ player2DeckOnHand.get(6) +".png"));
        p2h.setImage(new Image("PNG/"+ player2DeckOnHand.get(7) +".png"));
        p2i.setImage(new Image("PNG/"+ player2DeckOnHand.get(8) +".png"));
        p2j.setImage(new Image("PNG/"+ player2DeckOnHand.get(9) +".png"));
        p2k.setImage(new Image("PNG/"+ player2DeckOnHand.get(10) +".png"));
        p2l.setImage(new Image("PNG/"+ player2DeckOnHand.get(11) +".png"));
        

        p3a.setImage(new Image("PNG/"+ player3DeckOnHand.get(0) +".png"));
        p3b.setImage(new Image("PNG/"+ player3DeckOnHand.get(1) +".png"));
        p3c.setImage(new Image("PNG/"+ player3DeckOnHand.get(2) +".png"));
        p3d.setImage(new Image("PNG/"+ player3DeckOnHand.get(3) +".png"));
        p3e.setImage(new Image("PNG/"+ player3DeckOnHand.get(4) +".png"));
        p3f.setImage(new Image("PNG/"+ player3DeckOnHand.get(5) +".png"));
        p3g.setImage(new Image("PNG/"+ player3DeckOnHand.get(6) +".png"));
        p3h.setImage(new Image("PNG/"+ player3DeckOnHand.get(7) +".png"));
        p3i.setImage(new Image("PNG/"+ player3DeckOnHand.get(8) +".png"));
        p3j.setImage(new Image("PNG/"+ player3DeckOnHand.get(9) +".png"));
        p3k.setImage(new Image("PNG/"+ player3DeckOnHand.get(10) +".png"));
        p3l.setImage(new Image("PNG/"+ player3DeckOnHand.get(11) +".png"));
        
    }

    public void loadImageRound2(){
        
        p1a.setImage(new Image("PNG/"+ player1DeckOnHand.get(0) +".png"));
        p1b.setImage(new Image("PNG/"+ player1DeckOnHand.get(1) +".png"));
        p1c.setImage(new Image("PNG/"+ player1DeckOnHand.get(2) +".png"));
        p1d.setImage(new Image("PNG/"+ player1DeckOnHand.get(3) +".png"));
        p1e.setImage(new Image("PNG/"+ player1DeckOnHand.get(4) +".png"));
        p1f.setImage(new Image("PNG/"+ player1DeckOnHand.get(5) +".png"));
        p1g.setImage(new Image("PNG/"+ player1DeckOnHand.get(6) +".png"));
        p1h.setImage(new Image("PNG/"+ player1DeckOnHand.get(7) +".png"));
        
        p2a.setImage(new Image("PNG/"+ player2DeckOnHand.get(0) +".png"));
        p2b.setImage(new Image("PNG/"+ player2DeckOnHand.get(1) +".png"));
        p2c.setImage(new Image("PNG/"+ player2DeckOnHand.get(2) +".png"));
        p2d.setImage(new Image("PNG/"+ player2DeckOnHand.get(3) +".png"));
        p2e.setImage(new Image("PNG/"+ player2DeckOnHand.get(4) +".png"));
        p2f.setImage(new Image("PNG/"+ player2DeckOnHand.get(5) +".png"));
        p2g.setImage(new Image("PNG/"+ player2DeckOnHand.get(6) +".png"));
        
        p3a.setImage(new Image("PNG/"+ player3DeckOnHand.get(0) +".png"));
        p3b.setImage(new Image("PNG/"+ player3DeckOnHand.get(1) +".png"));
        p3c.setImage(new Image("PNG/"+ player3DeckOnHand.get(2) +".png"));
        p3d.setImage(new Image("PNG/"+ player3DeckOnHand.get(3) +".png"));
        p3e.setImage(new Image("PNG/"+ player3DeckOnHand.get(4) +".png"));
        p3f.setImage(new Image("PNG/"+ player3DeckOnHand.get(5) +".png"));
        p3g.setImage(new Image("PNG/"+ player3DeckOnHand.get(6) +".png"));
    }

    public void loadImageRound3(){
        
        p1a.setImage(new Image("PNG/"+ player1DeckOnHand.get(0) +".png"));
        p1b.setImage(new Image("PNG/"+ player1DeckOnHand.get(1) +".png"));
        p1c.setImage(new Image("PNG/"+ player1DeckOnHand.get(2) +".png"));
        
        p2a.setImage(new Image("PNG/"+ player2DeckOnHand.get(0) +".png"));
        p2b.setImage(new Image("PNG/"+ player2DeckOnHand.get(1) +".png"));
        
        p3a.setImage(new Image("PNG/"+ player3DeckOnHand.get(0) +".png"));
        p3b.setImage(new Image("PNG/"+ player3DeckOnHand.get(1) +".png"));
    }
}
