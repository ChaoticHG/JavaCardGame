import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class GameController {
    public Button buttonStart;
    public HBox p1;
    public HBox p2;
    public HBox p3;
    public ImageView imgViewP1a, imgViewP1b, imgViewP1c, imgViewP1d, imgViewP1e, imgViewP2a, imgViewP2b, imgViewP2c, imgViewP2d, imgViewP2e, imgViewP3a, imgViewP3b, imgViewP3c, imgViewP3d, imgViewP3e;

    public void startClick() throws Exception{
        imgViewP1a.setImage(new Image("PNG/c2.png"));
        imgViewP1b.setImage(new Image("PNG/c3.png"));
        imgViewP1c.setImage(new Image("PNG/ck.png"));
        imgViewP1d.setImage(new Image("PNG/h6.png"));
        imgViewP1e.setImage(new Image("PNG/s4.png"));
        imgViewP2a.setImage(new Image("PNG/c2.png"));
        imgViewP2b.setImage(new Image("PNG/sk.png"));
        imgViewP2c.setImage(new Image("PNG/sq.png"));
        imgViewP2d.setImage(new Image("PNG/d6.png"));
        imgViewP2e.setImage(new Image("PNG/s4.png"));
        imgViewP3a.setImage(new Image("PNG/c2.png"));
        imgViewP3b.setImage(new Image("PNG/c3.png"));
        imgViewP3c.setImage(new Image("PNG/ck.png"));
        imgViewP3d.setImage(new Image("PNG/h6.png"));
        imgViewP3e.setImage(new Image("PNG/s4.png"));
    }
}
