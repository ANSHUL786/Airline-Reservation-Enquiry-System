import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmailValidator {
	Boolean b;
public boolean check(String email){
   	try {    	            
            String emailregex = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
             b = email.matches(emailregex);
           }
   	catch (Exception e) {
   		e.printStackTrace();
        System.out.println(e.getMessage());
        }
            	return b;
}
}