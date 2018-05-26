import java.io.IOException;

public class GuessingGame {
    private Jar mJar;
  
    public static void main(String[] args) {
       GuessingGame game = new GuessingGame();
      
       game.setUpGame();      
      
       int attempts = game.play();      
      
       game.printResults(attempts);

    }
  
  
    private void setUpGame() {
       // Administrator setup.
       Prompter.printLine("\nADMINISTRATOR SETUP \n-------------------");      
       Prompter.print("What type of item? : ");
       String itemName = Prompter.readLine();
       Prompter.printFormat("What is the maximum amount of %s? : ", itemName);
    
       mJar = new Jar(itemName, Prompter.readPositiveInt());
      
       // Player setup.
       Prompter.printLine("\nPLAYER  \n-------------------");      
       Prompter.printFormat("How many %s are in the jar? ", mJar.getItemName() ); 
       Prompter.printFormat("Pick a number between 1 and %d : ", mJar.getMaxItemsAllowed());  
      
    }
      
  
    private int play() {
       int answer = mJar.fill();
       int attemptCount = 0;
       int playerGuess = 0;
      
       do {
         
         playerGuess = Prompter.readPositiveInt();
         
         // Prevent guessing over the maximum amount.
         if(playerGuess > mJar.getMaxItemsAllowed()) {
           Prompter.printFormat("Your guess must be less than or equal to %d: ", mJar.getMaxItemsAllowed());
           continue; // Don't count this attempt.
         }
         
         // Provide 'too high' and 'too low' hints.
         if(playerGuess > answer) 
           Prompter.print("Your guess is too high, try again: ");
         else if(playerGuess < answer) 
           Prompter.print("Your guess is too low, try again: ");
           
         attemptCount++;
       } while(answer != playerGuess);
      
       return attemptCount;       
    }
  
  
    private void printResults(int attempts) {            
       if(attempts == 1) 
          Prompter.printLine(String.format("\nCORRECT!! You got it in %d attempt", attempts));
       else
          Prompter.printLine(String.format("\nCORRECT!! You got it in %d attempts", attempts));
    }
    
           
}













