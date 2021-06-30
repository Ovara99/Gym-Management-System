
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.util.Scanner;

public class AddDefault {
    public static Boolean IDexists;
    public static BasicDBObject basicDBObject=new BasicDBObject();
    public static void addDefault() throws Exception {
        Scanner input=new Scanner(System.in);
        System.out.println("Please enter ID");
        while (true) {
            try {
                IDexists=false;
                String id = input.nextLine();
                Default.setID(id);
                SetupDB.setDB();
                DBCollection table = SetupDB.database.getCollection("Members");
                DBCursor findIterable = table.find();
                for (DBObject count : findIterable) {
                    String DBID = (String) count.get("ID");
                    String enteredID=Default.getID();
                    if (DBID.equals(enteredID)) {
                        IDexists = true;
                        break;
                    }
                }
                if(IDexists){
                    System.out.println("ID already exists, please enter another");
                }else{
                    basicDBObject.put("ID", Default.getID());

                    System.out.println("Data added succesfully");
                    break;
                }

            }catch (outOFLength exceptionO){
                System.out.println("ID out of range");
            }

        }
        System.out.println("Please enter the Name");
        while (true) {

            try {


                String name = input.nextLine();

                if(name.isEmpty()){
                    System.out.println("No Name entered. Please re-enter");


                }else {

                    Default.setName(name);
                    SetupDB.setDB();
                    DBCollection table = SetupDB.database.getCollection("Members");
                    basicDBObject.put("Name", Default.getName());
                    System.out.println("Data added successfully");
                    break;
                }

            }catch (InvalidNameException exceptionO){
                System.out.println("Invalid Name");
                break;
            }

        }
        Date.Date();

    }
}

