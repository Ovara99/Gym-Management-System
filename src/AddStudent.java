
import com.mongodb.DBCollection;

import java.util.Scanner;

public class AddStudent {
    public static void addStudent(){
        Scanner input=new Scanner(System.in);
        System.out.println("Please enter the school name");
        while (true) {
            try {
                String name = input.nextLine();

                if(name.isEmpty()) {
                    System.out.println("No School Name entered. Please re-enter");
                }else{
                    StudentMember.setName(name);
                    SetupDB.setDB();
                    DBCollection table = SetupDB.database.getCollection("Members");
                    AddDefault.basicDBObject.put("SchoolName", StudentMember.getName());
                    System.out.println("Data added successfully");
                    break;

                }


            }catch (InvalidNameException exceptionO){
                System.out.println("Invalid School Name");
                break;
            }
        }
    }
}

