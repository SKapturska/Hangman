package hangman;

import java.io.File;
import javafx.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HangmanFXMLController{
    Game game;
    
    List<Button> pressedButtons = new ArrayList<Button>();
    
    @FXML
    private Label categoryLabel;

    @FXML
    private Label toGuessLabel;

    @FXML
    private ImageView imageView;
    
    
    
    @FXML
    void startGame(ActionEvent event) {
        for(Button x : pressedButtons){
            x.setDisable(false);
        }
        pressedButtons.clear();
        game = new Game();
        game.randomPhrase();
        game.createPhrase(false);
        toGuessLabel.setText(game.getIncompletePhrase());
        categoryLabel.setText("Kategoria: " + game.getCategory());
        setImage(game.getError());
    }


    @FXML
    void letterPressed(ActionEvent e) {
        Button source = (Button)e.getSource();
        if(game != null){
            game.buttonPressed(source.getText().charAt(0));
            source.setDisable(true);
            pressedButtons.add(source);    
            game.createPhrase(false);
            toGuessLabel.setText(game.getIncompletePhrase());
            if(game.getError() < 8){
                setImage(game.getError());
            }if (game.getError() == 7 || !game.isWin()){
                stop();
            }  
        } 
    }
    
    void setImage(int errors){
        File file = new File( errors + ".png");
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
    }
    
    void stop(){
        game.createPhrase(true);
        toGuessLabel.setText(game.getIncompletePhrase());
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        if(game.getError() == 7){
            alert.setContentText("Przegrana, prawidłowe hasło to: " + game.getPhrase().toLowerCase());
        }else{
            alert.setContentText("Wygrana");
        }   
        alert.showAndWait();
        
        game = null;
    }

  

}
