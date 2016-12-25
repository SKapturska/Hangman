package hangman;

import java.util.Random;

public class Game {
    Random r = new Random();
    
    private String phrase = "";
    private int quantity;
    private int rand;
    private String category;
    private String incompletePhrase;
    private boolean [] isGuessed;
    private int error = 0;

    public int getError() {
        return error;
    }

    public String getCategory() {
        return category;
    }

    public String getIncompletePhrase() {
        return incompletePhrase;
    }

    public String getPhrase() {
        return phrase;
    }
    
    void randomPhrase(){
        SingletonConnection singletonConnection = SingletonConnection.getInstance();
        quantity = singletonConnection.getQuantity();
        rand = r.nextInt(quantity)+1;
        phrase = singletonConnection.getPhrase(rand);
        category = singletonConnection.getCategory(rand);  
        isGuessed = new boolean [phrase.length()];
    }
    
    void createPhrase(boolean isPhrase){  
        incompletePhrase = "";
        for(int i = 0 ; i < isGuessed.length ; i++){
            if(isGuessed[i] == false && !isPhrase){
                incompletePhrase += "_  ";
            } else {
                incompletePhrase += (phrase.charAt(i) + "  ");
            }
        }
    }
    
    void buttonPressed(char letter){
        boolean isOk = false;
        for(int i = 0; i < phrase.length(); i++){
            if(phrase.charAt(i) == letter){
                isGuessed[i] = true;
                isOk = true;
            }
        }
        if(!isOk){
            error ++;
        }
    }
    
    boolean isWin(){
        boolean isOk = false;      
        for(int i = 0; i < isGuessed.length; i++){
            if(isGuessed[i] == false){
                isOk = true;
            }
        }
        return isOk;
    }

}
