package hangman;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
        game.createIncompletePhrase();
        toGuessLabel.setText(game.getIncompletePhrase());
        categoryLabel.setText("Kategoria: " + game.getCategory());
    }


    @FXML
    void letterPressed(ActionEvent e) {
        Button source = (Button)e.getSource();
        if(!game.getPhrase().equals("")){
        game.buttonPressed(source.getText().charAt(0));
        source.setDisable(true);
        game.createIncompletePhrase();
        toGuessLabel.setText(game.getIncompletePhrase());   
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    

}
