package hangman;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HangmanFXMLController implements Initializable {

    @FXML
    private Label categoryLabel;

    @FXML
    private Label toGuessLabel;

    @FXML
    void startGame(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
