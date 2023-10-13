import java.io.IOException;
import java.util.LinkedList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Phase2RemainingCardController {
    public String player1, player2;
    public Button goBackButton;
    public Label round, player1Name, player2Name;
    public ImageView p1a,p1b,p1c,p1d,p1e,p1f,p1g,p1h,p1i,p1j,p1k,p1l,p1m,p1n,p1o,p1p,p1q,p1r,p1s,p1t,p1u,p1v,p1w,p1x,p1y,p1z;
    public ImageView p2a,p2b,p2c,p2d,p2e,p2f,p2g,p2h,p2i,p2j,p2k,p2l,p2m,p2n,p2o,p2p,p2q,p2r,p2s,p2t,p2u,p2v,p2w,p2x,p2y,p2z;
    public LinkedList<game> games = new LinkedList<>();
    public LinkedList<card> player1DeckOnHand;
    public LinkedList<card> player2DeckOnHand;
    public String[] deck1 ;
    public String[] deck2 ;
    public int p2winner[][];
    public int no1,no2, totalRounds;

    public void setRounds(int totalRounds){
        this.totalRounds=totalRounds;
        switch(totalRounds){
            case 1:
            round.setText("Round 1");
            player1DeckOnHand= cardList.pick(games.get(1).getPlayers().get(0).getCards(),5,26);
            player2DeckOnHand= cardList.pick(games.get(1).getPlayers().get(1).getCards(),5,26);
            loadImageRound1();
            break;

            case 2:
            round.setText("Round 2");
            player1DeckOnHand= cardList.pick(games.get(1).getPlayers().get(0).getCards(),10,26);
            player2DeckOnHand= cardList.pick(games.get(1).getPlayers().get(1).getCards(),10,26);
            loadImageRound2();
            break;

            case 3:
            round.setText("Round 3");
            player1DeckOnHand= cardList.pick(games.get(1).getPlayers().get(0).getCards(),15,26);
            player2DeckOnHand= cardList.pick(games.get(1).getPlayers().get(1).getCards(),15,26);
            loadImageRound3();
            break;

            case 4:
            round.setText("Round 4");
            player1DeckOnHand= cardList.pick(games.get(1).getPlayers().get(0).getCards(),20,26);
            player2DeckOnHand= cardList.pick(games.get(1).getPlayers().get(1).getCards(),20,26);
            loadImageRound4();
            break;
        }
    }

    public void goBackClick(){
        Stage stage = (Stage) goBackButton.getScene().getWindow();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Phase2Round.fxml"));
            Scene scene = new Scene(loader.load());
            Phase2RoundController controller = loader.getController();
            controller.setGames(games,no1,no2);
            controller.setPlayerName(games.get(0).getPlayers().get(no1).getName(), games.get(0).getPlayers().get(no2).getName());
            controller.setDeck(deck1, deck2);
            controller.setPhase(1);
            if(totalRounds>1){
                controller.setData(p2winner);
                for(int i=1; i<totalRounds; i++)
                controller.nextClick();
            }
            stage.setScene(scene);
        }catch(IOException io){
            io.printStackTrace();
        }
    }

    public void setPlayerName(String player1, String player2){
        this.player1=player1;
        this.player2=player2;
        player1Name.setText(player1);
        player2Name.setText(player2);
    }

    public void setData(int p2winner[][]){
        this.p2winner=p2winner;
    }

    public void setDeck(String[]deck1,String[] deck2){
        this.deck1=deck1;
        this.deck2=deck2;
    }

    public void setGames(LinkedList<game> games, int no1, int no2){
        this.games=games;
        this.no1=no1;
        this.no2=no2;
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
        p1n.setImage(new Image("PNG/"+ player1DeckOnHand.get(13) +".png"));
        p1o.setImage(new Image("PNG/"+ player1DeckOnHand.get(14) +".png"));
        p1p.setImage(new Image("PNG/"+ player1DeckOnHand.get(15) +".png"));
        p1q.setImage(new Image("PNG/"+ player1DeckOnHand.get(16) +".png"));
        p1r.setImage(new Image("PNG/"+ player1DeckOnHand.get(17) +".png"));
        p1s.setImage(new Image("PNG/"+ player1DeckOnHand.get(18) +".png"));
        p1t.setImage(new Image("PNG/"+ player1DeckOnHand.get(19) +".png"));
        p1u.setImage(new Image("PNG/"+ player1DeckOnHand.get(20) +".png"));

        p2a.setImage(new Image("PNG/"+ player2DeckOnHand.get(1) +".png"));
        p2b.setImage(new Image("PNG/"+ player2DeckOnHand.get(2) +".png"));
        p2c.setImage(new Image("PNG/"+ player2DeckOnHand.get(3) +".png"));
        p2d.setImage(new Image("PNG/"+ player2DeckOnHand.get(4) +".png"));
        p2e.setImage(new Image("PNG/"+ player2DeckOnHand.get(5) +".png"));
        p2f.setImage(new Image("PNG/"+ player2DeckOnHand.get(6) +".png"));
        p2g.setImage(new Image("PNG/"+ player2DeckOnHand.get(7) +".png"));
        p2h.setImage(new Image("PNG/"+ player2DeckOnHand.get(8) +".png"));
        p2i.setImage(new Image("PNG/"+ player2DeckOnHand.get(9) +".png"));
        p2j.setImage(new Image("PNG/"+ player2DeckOnHand.get(10) +".png"));
        p2k.setImage(new Image("PNG/"+ player2DeckOnHand.get(11) +".png"));
        p2l.setImage(new Image("PNG/"+ player2DeckOnHand.get(12) +".png"));
        p2m.setImage(new Image("PNG/"+ player2DeckOnHand.get(13) +".png"));
        p2n.setImage(new Image("PNG/"+ player2DeckOnHand.get(14) +".png"));
        p2o.setImage(new Image("PNG/"+ player2DeckOnHand.get(15) +".png"));
        p2p.setImage(new Image("PNG/"+ player2DeckOnHand.get(16) +".png"));
        p2q.setImage(new Image("PNG/"+ player2DeckOnHand.get(17) +".png"));
        p2r.setImage(new Image("PNG/"+ player2DeckOnHand.get(18) +".png"));
        p2s.setImage(new Image("PNG/"+ player2DeckOnHand.get(19) +".png"));
        p2t.setImage(new Image("PNG/"+ player2DeckOnHand.get(20) +".png"));
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
        p1i.setImage(new Image("PNG/"+ player1DeckOnHand.get(8) +".png"));
        p1j.setImage(new Image("PNG/"+ player1DeckOnHand.get(9) +".png"));
        p1k.setImage(new Image("PNG/"+ player1DeckOnHand.get(10) +".png"));
        p1l.setImage(new Image("PNG/"+ player1DeckOnHand.get(11) +".png"));
        p1m.setImage(new Image("PNG/"+ player1DeckOnHand.get(12) +".png"));
        p1n.setImage(new Image("PNG/"+ player1DeckOnHand.get(13) +".png"));
        p1o.setImage(new Image("PNG/"+ player1DeckOnHand.get(14) +".png"));
        p1p.setImage(new Image("PNG/"+ player1DeckOnHand.get(15) +".png"));

        p2a.setImage(new Image("PNG/"+ player2DeckOnHand.get(1) +".png"));
        p2b.setImage(new Image("PNG/"+ player2DeckOnHand.get(2) +".png"));
        p2c.setImage(new Image("PNG/"+ player2DeckOnHand.get(3) +".png"));
        p2d.setImage(new Image("PNG/"+ player2DeckOnHand.get(4) +".png"));
        p2e.setImage(new Image("PNG/"+ player2DeckOnHand.get(5) +".png"));
        p2f.setImage(new Image("PNG/"+ player2DeckOnHand.get(6) +".png"));
        p2g.setImage(new Image("PNG/"+ player2DeckOnHand.get(7) +".png"));
        p2h.setImage(new Image("PNG/"+ player2DeckOnHand.get(8) +".png"));
        p2i.setImage(new Image("PNG/"+ player2DeckOnHand.get(9) +".png"));
        p2j.setImage(new Image("PNG/"+ player2DeckOnHand.get(10) +".png"));
        p2k.setImage(new Image("PNG/"+ player2DeckOnHand.get(11) +".png"));
        p2l.setImage(new Image("PNG/"+ player2DeckOnHand.get(12) +".png"));
        p2m.setImage(new Image("PNG/"+ player2DeckOnHand.get(13) +".png"));
        p2n.setImage(new Image("PNG/"+ player2DeckOnHand.get(14) +".png"));
        p2o.setImage(new Image("PNG/"+ player2DeckOnHand.get(15) +".png"));
    }

    public void loadImageRound3(){
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
        

        p2a.setImage(new Image("PNG/"+ player2DeckOnHand.get(1) +".png"));
        p2b.setImage(new Image("PNG/"+ player2DeckOnHand.get(2) +".png"));
        p2c.setImage(new Image("PNG/"+ player2DeckOnHand.get(3) +".png"));
        p2d.setImage(new Image("PNG/"+ player2DeckOnHand.get(4) +".png"));
        p2e.setImage(new Image("PNG/"+ player2DeckOnHand.get(5) +".png"));
        p2f.setImage(new Image("PNG/"+ player2DeckOnHand.get(6) +".png"));
        p2g.setImage(new Image("PNG/"+ player2DeckOnHand.get(7) +".png"));
        p2h.setImage(new Image("PNG/"+ player2DeckOnHand.get(8) +".png"));
        p2i.setImage(new Image("PNG/"+ player2DeckOnHand.get(9) +".png"));
        p2j.setImage(new Image("PNG/"+ player2DeckOnHand.get(10) +".png"));
        
    }

    public void loadImageRound4(){
        p1a.setImage(new Image("PNG/"+ player1DeckOnHand.get(0) +".png"));
        p1b.setImage(new Image("PNG/"+ player1DeckOnHand.get(1) +".png"));
        p1c.setImage(new Image("PNG/"+ player1DeckOnHand.get(2) +".png"));
        p1d.setImage(new Image("PNG/"+ player1DeckOnHand.get(3) +".png"));
        p1e.setImage(new Image("PNG/"+ player1DeckOnHand.get(4) +".png"));
        p1f.setImage(new Image("PNG/"+ player1DeckOnHand.get(5) +".png"));
        

        p2a.setImage(new Image("PNG/"+ player2DeckOnHand.get(1) +".png"));
        p2b.setImage(new Image("PNG/"+ player2DeckOnHand.get(2) +".png"));
        p2c.setImage(new Image("PNG/"+ player2DeckOnHand.get(3) +".png"));
        p2d.setImage(new Image("PNG/"+ player2DeckOnHand.get(4) +".png"));
        p2e.setImage(new Image("PNG/"+ player2DeckOnHand.get(5) +".png"));
        
    }
}
