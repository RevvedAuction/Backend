package Util;

import org.apache.commons.validator.routines.EmailValidator;

public class Helper {

    public static boolean isNullOrEmpty(String s){
        if(s.isEmpty() || s==null){
            return true;
        }
        return false;
    }

    public static boolean isValidEmail(String email){
        EmailValidator validator =EmailValidator.getInstance();
        return validator.isValid(email);
    }
}
