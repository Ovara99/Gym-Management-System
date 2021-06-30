import com.mongodb.DBCollection;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Date {
    public static void Date() {
        Scanner input= new Scanner(System.in);

        while (true) {
            System.out.println("Please enter the Membership Date as dd/MM/yyyy:");
            String dob = input.nextLine();

            if (Date(dob)) {
                SetupDB.setDB();
                DBCollection table = SetupDB.database.getCollection("Members");
                AddDefault.basicDBObject.put("DateJoined", dob);
                System.out.println("Data added successfully");
                break;
            } else if(dob.isEmpty()) {
                System.out.println("Please re-enter");
            }else {
                System.out.println("Invalid input. Please re-enter");
            }
        }
    }

    public static boolean Date(String DOB) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date MD = null;
        df.setLenient(false);
        try {
            MD = df.parse(DOB);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

