package JavaGame;
import java.util.*;

public class GameLogic {
    static Scanner sc = new Scanner(System.in);
    public static int readInt(String prompt, int userChoices){
        int input;
    
        //So the user does not get booted when pressing something wrong by mistake.
        do{
            System.out.println(prompt);
            try{
                input = Integer.parseInt(sc.next());
            }catch(Exception e){
                input = -1;
                System.out.println("Please enter an Integer!");
            }
        }while(input < 1 || input > userChoices);
        return input;
    }

    //method to clear the Console
    public static void clearConsole(){
        for(int i = 0; i < 100; i++)
        System.out.println();
    }

    //method so the user can pause to read/continue later
    public static void anythingToContinue(){
        System.out.println("\nEnter anything to continue...");
        sc.next();
    }
}