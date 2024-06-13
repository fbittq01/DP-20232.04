package views.screen.popup;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import views.screen.BaseScreenHandler;
import views.screen.ViewsConfig;

import java.io.IOException;

public class PopupScreen extends BaseScreenHandler {

    @FXML
    ImageView icon;

    @FXML
    Label message;
    public static final float closeTime = 0.8f;

    public PopupScreen(Stage stage, String popupPath) throws IOException {
        super(stage, ViewsConfig.POPUP_PATH);
    }

    public void setImage(String path) {
        super.setImage(icon, path);
    }

    public void showPopup(Boolean autoClose) {
        super.show();
        if (autoClose)
            close(closeTime);
    }

    public void showPopup(double time) {
        super.show();
        close(time);
    }

    public void close(double time) {
        PauseTransition delay = new PauseTransition(Duration.seconds(time));
        delay.setOnFinished(event -> stage.close());
        delay.play();
    }

    protected void setupData(Object dto) throws Exception {
    }

    protected void setupFunctionality() throws Exception {
    }
}