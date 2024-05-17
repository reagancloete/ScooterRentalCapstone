package za.ac.cput.util;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Employee;
import org.apache.commons.validator.routines.EmailValidator;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Helper {
    //    public static boolean testLong(String employee){
//        return employee != null;
//    }
    public static boolean isNullOrEmpty (String employee){
        if (employee ==null || employee.isEmpty())
            return true;
        return false;
    }
    public static boolean testString(String s){
        return s != null && !s.isEmpty();
    }

    public static boolean testEmail(){
        return EmailValidator.getInstance().isValid(null);
    }

    //    public static boolean testContact(Contact obj){
//        return obj !=null;
//    }
    public static boolean testEmployee(Employee employee){
        return employee !=null;
    }

    public static boolean testEmail(String contact){
        return EmailValidator.getInstance().isValid(contact);
    }

    public static boolean testValidContact(String employee){
        String regexPattern = "^\\d{10}$";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(employee);
        return matcher.matches();
    }

    public static String generateId(){
        return UUID.randomUUID().toString();//generates a random numbrr
    }
}

