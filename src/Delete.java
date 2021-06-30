import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.util.Scanner;

public class Delete {

    public static Boolean IDexists;
    public static void delete() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter ID to delete");
        while (true) {
            try {
                IDexists = false;
                String id = s.nextLine();
                Default.setID(id);
                SetupDB.setDB();
                DBCollection table = SetupDB.database.getCollection("Members");
                DBCursor findIterable = table.find();
                for (DBObject count : findIterable) {
                    String DBID = (String) count.get("ID");
                    String type = (String) count.get("Type");
                    String enteredID = Default.getID();
                    if (DBID.equals(enteredID)) {
                        System.out.println("Type of Member: "+type);
                        IDexists = true;
                        break;
                    }
                }
                if (IDexists) {
                    BasicDBObject basicDBObject = new BasicDBObject();
                    basicDBObject.put("ID", Default.getID());
                    table.findAndRemove(basicDBObject);
                    System.out.println("Data has been deleted successfully.");
                    break;
                } else{
                        System.out.println("ID does not exist");
                    }

            } catch (outOFLength exceptionO) {
                System.out.println("ID out of range");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

