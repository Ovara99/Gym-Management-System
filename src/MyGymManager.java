import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Scanner;

public class MyGymManager extends Application {
    public static String sort;

    @Override
    public void start(Stage primaryStage) throws Exception {
        while(true) {
            sort="no";
            Scanner input = new Scanner(System.in);
            System.out.println("OPTIONS");
            System.out.println("_ _ _ _  _ _ _ _ _ _ _ _  _ _ _ _");
            System.out.println("Press A to Add a new member");
            System.out.println("Press D to delete a member");
            System.out.println("Press S to sort the member list");
            System.out.println("Press P to print the member list");
            System.out.println("Press W to text file");
            System.out.println("Press G to open the graphical user interface");
            String userchoice = input.nextLine();
            while (true) {

                if (userchoice.equals("A")) {
                    Add.add(); //call method to add new member
                    break;
                } else if (userchoice.equals("D")) {
                    Delete.delete();
                    break;
                } else if (userchoice.equals("W")) {
                    Write text= new Write();
                    text.openFile();
                    text.getData();
                    text.closeFile();
                    break;
                } else if (userchoice.equals("P")) {
                    print.PrintMembers();
                    break;
                }else if (userchoice.equals("S")) {
                    sort = "yes";
                    print.PrintMembers();
                    break;
                } else if (userchoice.equals("G")) {
                    Table.ViewTable();
                    break;

                }
                else {
                    System.out.println("Invalid. Please enter a valid letter from the menu options");
                    break;

                }
            }


        }


    }
}

