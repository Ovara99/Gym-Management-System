

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class SetupDB {
    public static DB database;
    //Connects to the localhost server
    public static MongoClient mongoClient = new MongoClient("localhost", 27017);

    public static void setDB() {
        //created the database and the table named Members if it already doesn't exist
        database = mongoClient.getDB("GymManagement");
        database.createCollection("Members", null);
    }
}

