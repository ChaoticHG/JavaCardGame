import java.io.IOException;
import java.util.LinkedList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class resultsController {
    public Label player1, player2, p1Points, p2Points, winner;
    public Button goBackButton, restartButton;
    public LinkedList<game> games = new LinkedList<>();
    public int p1winner[][];
    public int p2winner[][];
    int no1=0, no2=0;
    String[] deck1 = new String[52];
    String[] deck2 = new String[52];
    
    public void goBackClick(){
        Stage stage = (Stage) goBackButton.getScene().getWindow();
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

    public void restartClick(){
        Stage stage = (Stage) goBackButton.getScene().getWindow();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PlayerSelect.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            }catch(IOException io){
                io.printStackTrace();
        }
    }

    public void setData(String player1, String player2, String[]deck1, String[] deck2, LinkedList<game> games, int no1, int no2){
        p1winner=games.get(0).findPhase1RoundWinner();
        p2winner=games.get(1).findPhase2RoundWinner();
        int []totalPointsp1= games.get(0).findPhase1Score(p1winner, 3, 3);
        int []totalPointsp2= games.get(1).findPhase1Score(p2winner, 2, 4);
        int totalScore1=0,totalScore2=0;
        this.player1.setText(player1);
        this.player2.setText(player2);
        this.deck1=deck1;
        this.deck2=deck2;
        this.games=games;
        this.no1=no1;
        this.no2=no2;
        totalScore1= totalPointsp1[no1] + totalPointsp2[0];
        totalScore2= totalPointsp1[no2]+totalPointsp2[1];
        p1Points.setText(String.valueOf(totalScore1));
        p2Points.setText(String.valueOf(totalScore2));
        if(totalScore1 > totalScore2)
            winner.setText(games.get(1).getPlayers().get(0).getName());
        else 
            winner.setText(games.get(1).getPlayers().get(1).getName());
    }
}
