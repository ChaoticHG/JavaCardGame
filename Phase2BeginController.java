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

public class Phase2BeginController implements Initializable{
    public int no1,no2;
    public String player1, player2;
    public LinkedList<card> player1Card= new LinkedList<>();
    public LinkedList<card> player2Card= new LinkedList<>();
    public LinkedList<card> player3Card= new LinkedList<>();
    public LinkedList<player> allPlayer= new LinkedList<>();
    public LinkedList<game> games = new LinkedList<>();
    public Button goBackButton, shuffleButton, startButton;
    public Label player1Name, player2Name;
    public ImageView p1a,p1b,p1c,p1d,p1e,p1f,p1g,p1h,p1i,p1j,p1k,p1l,p1m,p1n,p1o,p1p,p1q,p1r,p1s,p1t,p1u,p1v,p1w,p1x,p1y,p1z;
    public ImageView p2a,p2b,p2c,p2d,p2e,p2f,p2g,p2h,p2i,p2j,p2k,p2l,p2m,p2n,p2o,p2p,p2q,p2r,p2s,p2t,p2u,p2v,p2w,p2x,p2y,p2z;
    String[] deck1 = new String[52];
    String[] deck2 = new String[52];

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setPlayerName(String player1, String player2){
        this.player1=player1;
        this.player2=player2;
        player1Name.setText(player1);
        player2Name.setText(player2);
    }

    public void goBackClick(){
        Stage stage = (Stage) goBackButton.getScene().getWindow();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Phase1Begin.fxml"));
            Scene scene = new Scene(loader.load());
            Phase1BeginController controller = loader.getController();
            controller.setPlayerName(games.get(0).getPlayers().get(0).getName(), games.get(0).getPlayers().get(1).getName(),games.get(0).getPlayers().get(2).getName());
            controller.setDeck(deck1);
            stage.setScene(scene);
            }catch(IOException io){
                io.printStackTrace();
        }
    }

    public void shuffleClick(){
        cardList.shuffle(deck2);
        loadImage();
    }

    public void startClick(){
        player p1 = new player(player1,player1Card,0);
        player p2 = new player(player2,player2Card,0);
        allPlayer.add(p1);
        allPlayer.add(p2);
        game phase2 = new game(2, allPlayer);
        games.add(phase2);
        Stage stage = (Stage) goBackButton.getScene().getWindow();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Phase2Round.fxml"));
            Scene scene = new Scene(loader.load());
            Phase2RoundController controller = loader.getController();
            controller.setGames(games,no1,no2);
            controller.setPlayerName(player1, player2);
            controller.setDeck(deck1,deck2);
            controller.setPhase(1);
            stage.setScene(scene);
        }catch(IOException io){
            io.printStackTrace();
        }
    }

    public void setDeck(String[]deck1,String[] deck2){
        this.deck1=deck1;
        this.deck2=deck2;
        loadImage();
    }

    public void setGames(LinkedList<game> games, int no1, int no2){
        this.games=games;
        this.no1=no1;
        this.no2=no2;
    }


    public void loadImage(){
        p1a.setImage(new Image("PNG/"+ deck2[0] +".png"));
        p1b.setImage(new Image("PNG/"+ deck2[1] +".png"));
        p1c.setImage(new Image("PNG/"+ deck2[2] +".png"));
        p1d.setImage(new Image("PNG/"+ deck2[3] +".png"));
        p1e.setImage(new Image("PNG/"+ deck2[4] +".png"));
        p1f.setImage(new Image("PNG/"+ deck2[5] +".png"));
        p1g.setImage(new Image("PNG/"+ deck2[6] +".png"));
        p1h.setImage(new Image("PNG/"+ deck2[7] +".png"));
        p1i.setImage(new Image("PNG/"+ deck2[8] +".png"));
        p1j.setImage(new Image("PNG/"+ deck2[9] +".png"));
        p1k.setImage(new Image("PNG/"+ deck2[10] +".png"));
        p1l.setImage(new Image("PNG/"+ deck2[11] +".png"));
        p1m.setImage(new Image("PNG/"+ deck2[12] +".png"));
        p1n.setImage(new Image("PNG/"+ deck2[13] +".png"));
        p1o.setImage(new Image("PNG/"+ deck2[14] +".png"));
        p1p.setImage(new Image("PNG/"+ deck2[15] +".png"));
        p1q.setImage(new Image("PNG/"+ deck2[16] +".png"));
        p1r.setImage(new Image("PNG/"+ deck2[17] +".png"));
        p1s.setImage(new Image("PNG/"+ deck2[18] +".png"));
        p1t.setImage(new Image("PNG/"+ deck2[19] +".png"));
        p1u.setImage(new Image("PNG/"+ deck2[20] +".png"));
        p1v.setImage(new Image("PNG/"+ deck2[21] +".png"));
        p1w.setImage(new Image("PNG/"+ deck2[22] +".png"));
        p1x.setImage(new Image("PNG/"+ deck2[23] +".png"));
        p1y.setImage(new Image("PNG/"+ deck2[24] +".png"));
        p1z.setImage(new Image("PNG/"+ deck2[25] +".png"));

        p2a.setImage(new Image("PNG/"+ deck2[26] +".png"));
        p2b.setImage(new Image("PNG/"+ deck2[27] +".png"));
        p2c.setImage(new Image("PNG/"+ deck2[28] +".png"));
        p2d.setImage(new Image("PNG/"+ deck2[29] +".png"));
        p2e.setImage(new Image("PNG/"+ deck2[30] +".png"));
        p2f.setImage(new Image("PNG/"+ deck2[31] +".png"));
        p2g.setImage(new Image("PNG/"+ deck2[32] +".png"));
        p2h.setImage(new Image("PNG/"+ deck2[33] +".png"));
        p2i.setImage(new Image("PNG/"+ deck2[34] +".png"));
        p2j.setImage(new Image("PNG/"+ deck2[35] +".png"));
        p2k.setImage(new Image("PNG/"+ deck2[36] +".png"));
        p2l.setImage(new Image("PNG/"+ deck2[37] +".png"));
        p2m.setImage(new Image("PNG/"+ deck2[38] +".png"));
        p2n.setImage(new Image("PNG/"+ deck2[39] +".png"));
        p2o.setImage(new Image("PNG/"+ deck2[40] +".png"));
        p2p.setImage(new Image("PNG/"+ deck2[41] +".png"));
        p2q.setImage(new Image("PNG/"+ deck2[42] +".png"));
        p2r.setImage(new Image("PNG/"+ deck2[43] +".png"));
        p2s.setImage(new Image("PNG/"+ deck2[44] +".png"));
        p2t.setImage(new Image("PNG/"+ deck2[45] +".png"));
        p2u.setImage(new Image("PNG/"+ deck2[46] +".png"));
        p2v.setImage(new Image("PNG/"+ deck2[47] +".png"));
        p2w.setImage(new Image("PNG/"+ deck2[48] +".png"));
        p2x.setImage(new Image("PNG/"+ deck2[49] +".png"));
        p2y.setImage(new Image("PNG/"+ deck2[50] +".png"));
        p2z.setImage(new Image("PNG/"+ deck2[51] +".png"));
    }
}

