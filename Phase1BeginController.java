import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Phase1BeginController implements Initializable{
    public String player1, player2, player3;
    public LinkedList<card> player1Card= new LinkedList<>();
    public LinkedList<card> player2Card= new LinkedList<>();
    public LinkedList<card> player3Card= new LinkedList<>();
    public LinkedList<player> allPlayer= new LinkedList<>();
    public LinkedList<game> games = new LinkedList<>();
    public Button goBackButton, shuffleButton, startButton;
    public Label player1Name, player2Name, player3Name;
    public ImageView p1a,p1b,p1c,p1d,p1e,p1f,p1g,p1h,p1i,p1j,p1k,p1l,p1m,p1n,p1o,p1p,p1q,p1r;
    public ImageView p2a,p2b,p2c,p2d,p2e,p2f,p2g,p2h,p2i,p2j,p2k,p2l,p2m,p2n,p2o,p2p,p2q;
    public ImageView p3a,p3b,p3c,p3d,p3e,p3f,p3g,p3h,p3i,p3j,p3k,p3l,p3m,p3n,p3o,p3p,p3q;
    String[] deck = new String[52];

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setPlayerName(String player1, String player2, String player3){
        this.player1=player1;
        this.player2=player2;
        this.player3=player3;
        player1Name.setText(player1);
        player2Name.setText(player2);
        player3Name.setText(player3);
    }

    public void goBackClick(){
        Stage stage = (Stage) goBackButton.getScene().getWindow();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PlayerSelect.fxml"));
            Scene scene = new Scene(loader.load());
            PlayerSelectController controller = loader.getController();
            controller.setPlayerName(player1, player2,player3);
            stage.setScene(scene);
            }catch(IOException io){
                io.printStackTrace();
        }
    }

    public void shuffleClick(){
        cardList.shuffle(deck);
        loadImage();
    }

    public void startClick(){
        player p1 = new player(player1,player1Card,0);
        player p2 = new player(player2,player2Card,0);
        player p3 = new player(player3,player3Card,0);
        allPlayer.add(p1);
        allPlayer.add(p2);
        allPlayer.add(p3);
        game phase1 = new game(1, allPlayer);
        games.add(phase1);
        Stage stage = (Stage) goBackButton.getScene().getWindow();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Phase1Round.fxml"));
            Scene scene = new Scene(loader.load());
            Phase1RoundController controller = loader.getController();
            controller.setGames(games);
            controller.setPlayerName(player1, player2,player3);
            controller.setDeck(deck);
            controller.setPhase(1);
            stage.setScene(scene);
        }catch(IOException io){
            io.printStackTrace();
        }
    }

    public void setDeck(String[] deck){
        this.deck=deck;
        loadImage();
    }

    public void loadImage(){
        p1a.setImage(new Image("PNG/"+ deck[0] +".png"));
        p1b.setImage(new Image("PNG/"+ deck[1] +".png"));
        p1c.setImage(new Image("PNG/"+ deck[2] +".png"));
        p1d.setImage(new Image("PNG/"+ deck[3] +".png"));
        p1e.setImage(new Image("PNG/"+ deck[4] +".png"));
        p1f.setImage(new Image("PNG/"+ deck[5] +".png"));
        p1g.setImage(new Image("PNG/"+ deck[6] +".png"));
        p1h.setImage(new Image("PNG/"+ deck[7] +".png"));
        p1i.setImage(new Image("PNG/"+ deck[8] +".png"));
        p1j.setImage(new Image("PNG/"+ deck[9] +".png"));
        p1k.setImage(new Image("PNG/"+ deck[10] +".png"));
        p1l.setImage(new Image("PNG/"+ deck[11] +".png"));
        p1m.setImage(new Image("PNG/"+ deck[12] +".png"));
        p1n.setImage(new Image("PNG/"+ deck[13] +".png"));
        p1o.setImage(new Image("PNG/"+ deck[14] +".png"));
        p1p.setImage(new Image("PNG/"+ deck[15] +".png"));
        p1q.setImage(new Image("PNG/"+ deck[16] +".png"));
        p1r.setImage(new Image("PNG/"+ deck[17] +".png"));

        p2a.setImage(new Image("PNG/"+ deck[18] +".png"));
        p2b.setImage(new Image("PNG/"+ deck[19] +".png"));
        p2c.setImage(new Image("PNG/"+ deck[20] +".png"));
        p2d.setImage(new Image("PNG/"+ deck[21] +".png"));
        p2e.setImage(new Image("PNG/"+ deck[22] +".png"));
        p2f.setImage(new Image("PNG/"+ deck[23] +".png"));
        p2g.setImage(new Image("PNG/"+ deck[24] +".png"));
        p2h.setImage(new Image("PNG/"+ deck[25] +".png"));
        p2i.setImage(new Image("PNG/"+ deck[26] +".png"));
        p2j.setImage(new Image("PNG/"+ deck[27] +".png"));
        p2k.setImage(new Image("PNG/"+ deck[28] +".png"));
        p2l.setImage(new Image("PNG/"+ deck[29] +".png"));
        p2m.setImage(new Image("PNG/"+ deck[30] +".png"));
        p2n.setImage(new Image("PNG/"+ deck[31] +".png"));
        p2o.setImage(new Image("PNG/"+ deck[32] +".png"));
        p2p.setImage(new Image("PNG/"+ deck[33] +".png"));
        p2q.setImage(new Image("PNG/"+ deck[34] +".png"));


        p3a.setImage(new Image("PNG/"+ deck[35] +".png"));
        p3b.setImage(new Image("PNG/"+ deck[36] +".png"));
        p3c.setImage(new Image("PNG/"+ deck[37] +".png"));
        p3d.setImage(new Image("PNG/"+ deck[38] +".png"));
        p3e.setImage(new Image("PNG/"+ deck[39] +".png"));
        p3f.setImage(new Image("PNG/"+ deck[40] +".png"));
        p3g.setImage(new Image("PNG/"+ deck[41] +".png"));
        p3h.setImage(new Image("PNG/"+ deck[42] +".png"));
        p3i.setImage(new Image("PNG/"+ deck[43] +".png"));
        p3j.setImage(new Image("PNG/"+ deck[44] +".png"));
        p3k.setImage(new Image("PNG/"+ deck[45] +".png"));
        p3l.setImage(new Image("PNG/"+ deck[46] +".png"));
        p3m.setImage(new Image("PNG/"+ deck[47] +".png"));
        p3n.setImage(new Image("PNG/"+ deck[48] +".png"));
        p3o.setImage(new Image("PNG/"+ deck[49] +".png"));
        p3p.setImage(new Image("PNG/"+ deck[50] +".png"));
        p3q.setImage(new Image("PNG/"+ deck[51] +".png"));
    }
}
