import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.util.Formatter;

public class Write {
    private Formatter y;
    //to open the file
    public void openFile(){
        try{
            y= new Formatter("ViewMembers.txt");  //to create a text file
        }catch (Exception e){
            System.out.println("No file detected");
        }
    }
    public void getData(){
        BasicDBObject basicDBObject=new BasicDBObject("Name",1);
        SetupDB.setDB();
        DBCollection table = SetupDB.database.getCollection("Members");
        DBCursor counter = table.find();
        for (DBObject count : counter) {
            String MemID = (String) count.get("ID");
            String MemName=(String) count.get("Name");
            String MemType=(String) count.get("Type");
            String SchoolName=(String) count.get("SchoolName");
            String MemAge=(String) count.get("Age");

            y.format(String.format("ID: %s",MemID));
            y.format("  Name: " + MemName);
            y.format("   Type: " + MemType);
            if(MemType.equals("Student")) {
                y.format("   School Name: " + SchoolName);
            }else if(MemType.equals("Over 60")) {
                y.format("   Age: " + MemAge);
            }
            y.format("   \n"+"   \n");
        }
    }
    public void closeFile(){
        y.close();
    }
}

