package hangman;

import java.util.Random;

public class Game {
    Random r = new Random();
    
    private String phrase;
    private int quantity;
    private int rand;
    private String category;
    private String incompletePhrase;
    

    public String getCategory() {
        return category;
    }

    public String getIncompletePhrase() {
        return incompletePhrase;
    }
    
    void randomPhrase(){
        SingletonConnection singletonConnection = SingletonConnection.getInstance();
        quantity = singletonConnection.getQuantity();
        rand = r.nextInt(quantity)+1;
        phrase = singletonConnection.getPhrase(rand);
        category = singletonConnection.getCategory(rand);
        
    }
    
    void createIncompletePhrase(){  // tablica boolowska jesli false wpisz _ jak true litere z phrase
        
    }
    
}
