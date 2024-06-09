package views.screen.popup;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import views.screen.BaseScreenHandler;
import views.screen.ViewsConfig;

import java.io.IOException;


public class SuccessPopupScreen extends PopupScreen {

    @FXML
    ImageView icon;

    @FXML
    Label message;
    public SuccessPopupScreen(Stage stage) throws IOException{
        super(stage, ViewsConfig.POPUP_PATH);
    }

    public static showPopup(String message) throws IOException {
        SuccessPopupScreen successPopupScreen = new SuccessPopupScreen(new Stage());
        successPopupScreen.stage.initStyle(StageStyle.UNDECORATED);
        successPopupScreen.message.setText(message);
        successPopupScreen.setImage(ViewsConfig.IMAGE_PATH + "/" + "tickgreen.png");
        successPopupScreen.show();
        successPopupScreen.close(0.8);
    }
}