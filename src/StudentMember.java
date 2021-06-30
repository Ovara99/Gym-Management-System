

import java.util.Arrays;
import java.util.Collection;


public class StudentMember {
    private static String SchoolName;
    public static void setName(String sn) throws InvalidNameException {
        char[] chars = sn.toCharArray();
        Collection<Character> specificChars = Arrays.asList(' ');
        for (char c : chars) {
            //Below if condition means that if the character is a letter or a space, the name gets set to the MemberName variable, else an exception is thrown which will be caught in the class which calls this set method
            if(Character.isLetter(c)||specificChars.contains(c)) {
                SchoolName=sn;
            }else {
                throw new InvalidNameException();
            }
        }

    }
    public static String getName(){
        return SchoolName;
    }
}

