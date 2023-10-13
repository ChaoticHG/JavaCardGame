import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PlayerSelectController{
    public Button start;
    public TextField p1Name, p2Name, p3Name;
    String[] deck = cardList.getDeck();
    
    public void startClick(){
        String player1 = p1Name.getText();
        String player2 = p2Name.getText();
        String player3 = p3Name.getText();
        Stage stage = (Stage) start.getScene().getWindow();
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Phase1Begin.fxml"));
        Scene scene = new Scene(loader.load());
        Phase1BeginController controller = loader.getController();
        controller.setPlayerName(player1, player2,player3);
        controller.setDeck(deck);
        stage.setScene(scene);
        }catch(IOException io){
            io.printStackTrace();
        }
    }

    public void setPlayerName(String name1, String name2, String name3){
        p1Name.setText(name1);
        p2Name.setText(name2);
        p3Name.setText(name3);
    }
}
