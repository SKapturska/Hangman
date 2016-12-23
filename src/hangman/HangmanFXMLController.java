package hangman;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HangmanFXMLController implements Initializable {
    Game game = new Game();

    @FXML
    private Label categoryLabel;

    @FXML
    private Label toGuessLabel;

    @FXML
    void startGame(ActionEvent event) {
        game.randomPhrase();
        toGuessLabel.setText(game.getIncompletePhrase());
        categoryLabel.setText("Kategoria: " + game.getCategory());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    

}
