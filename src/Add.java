import com.mongodb.DBCollection;

import java.util.Scanner;
import java.util.Set;

public class Add {
    public static void add() throws Exception {
        Scanner s=new Scanner(System.in);
        System.out.println("Please enter the type of member you're going to add");
        System.out.println("Type 'Default' for default member");
        System.out.println("Type 'Student' for student member");
        System.out.println("Type 'Over 60' for Over 60");
        while (true){
            String input=s.nextLine();
            SetupDB.setDB();
            DBCollection table = SetupDB.database.getCollection("Members");
            if (input.equals("Default")){
                AddDefault.addDefault();
                AddDefault.basicDBObject.put("Type","Default");
                table.insert(AddDefault.basicDBObject);
                break;
            }else if(input.equals("Student")){
                AddDefault.addDefault();
                AddStudent.addStudent();
                AddDefault.basicDBObject.put("Type","Student");
                table.insert(AddDefault.basicDBObject);
                break;
            }else if(input.equals("Over 60")){
                AddDefault.addDefault();
                Over60Member.addover60();
                AddDefault.basicDBObject.put("Type","Over 60");
                table.insert(AddDefault.basicDBObject);
                break;
            }else{
                System.out.println("Invlaid input. Please re-enter");
            }

        }
    }

}

