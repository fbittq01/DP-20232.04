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


public class LoadingPopupScreen extends PopupScreen {

    @FXML
    ImageView icon;

    @FXML
    Label message;
    public LoadingPopupScreen(Stage stage) throws IOException{
        super(stage, ViewsConfig.POPUP_PATH);
    }

    public static showPopup(String message) throws IOException {
        LoadingPopupScreen loadingPopup = new LoadingPopupScreen(new Stage());
        loadingPopup.stage.initStyle(StageStyle.UNDECORATED);
        loadingPopup.message.setText(message);
        loadingPopup.setImage(ViewsConfig.IMAGE_PATH + "/" + "loading.gif");
    }
}