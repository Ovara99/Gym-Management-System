import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Collection;

class outOFLength extends Exception{

}
class InvalidNameException extends Exception{

}

public class Default {
    private static String ID;
    private static String Name;
    public static void setID(String id) throws Exception{
        if(id.length()==6){
            ID=id;
        }else{
            throw new outOFLength();
        }
    }
    public static String getID(){
        return ID;
    };
    public static void setName(String name) throws Exception{
        char[] chars = name.toCharArray();
        Collection<Character> specificChars = Arrays.asList(' ');
        for (char c : chars) {
            //Below if condition means that if the character is a letter or a space, the name gets set to the MemberName variable, else an exception is thrown which will be caught in the class which calls this set method
            if(Character.isLetter(c)||specificChars.contains(c)) {
                Name=name;
            }else {
                throw new InvalidNameException();
            }
        }

    }
    public static String getName(){
        return Name;
    }


}
