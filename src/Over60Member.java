import com.mongodb.DBCollection;

import java.util.Scanner;

public class Over60Member {
    public static void addover60() {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Please enter your age");

            String input = in.nextLine();

            if (isNumber(input)) {
                DBCollection table = SetupDB.database.getCollection("Members");
                AddDefault.basicDBObject.put("Age", input);
                System.out.println("Data added successfully");
                break;
            }

            else {
                System.out.println("Invalid");
            }

        }
    }
    public static boolean isNumber(String i){
        try {
            Integer j=Integer.parseInt(i);
            if (j>=60) {
                return true;
            }else {
                return false;
            }
        }
        catch (Exception e){
            return false;

        }
    }

}
