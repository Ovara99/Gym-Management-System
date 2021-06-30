import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class print {
    public static DBCursor counter;
    public static void PrintMembers(){
        BasicDBObject basicDBObject=new BasicDBObject("Name",1);
        SetupDB.setDB();
        DBCollection table = SetupDB.database.getCollection("Members");
        if (MyGymManager.sort.equals("yes")) {
            counter = table.find().sort(basicDBObject);
        }else{
            counter = table.find();
        }
        for (DBObject count : counter) {
            String MemID = (String) count.get("ID");
            String MemName=(String) count.get("Name");
            String MemType=(String) count.get("Type");
            String SchoolName=(String) count.get("SchoolName");
            String MemAge=(String) count.get("Age");
            String  MemDate=(String) count.get("DateJoined");
            System.out.println("ID: "+MemID);
            System.out.println("Name: "+MemName);
            System.out.println("Type: "+MemType);
            System.out.print("Membership Date:"+MemDate+"\n");

            if(MemType.equals("Student")) {
                System.out.println("School Name: " + SchoolName);
            }else if(MemType.equals("Over 60")) {
                System.out.println("Age: " + MemAge+ " years");
            }
            System.out.println("_ _ _ _  _ _ _ _ _ _ _ _  _ _ _ _");
        }
    }
}

