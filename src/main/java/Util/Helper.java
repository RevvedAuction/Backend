package Util;

import org.apache.commons.validator.routines.EmailValidator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Helper {

    public static boolean isNullOrEmpty(Object obj){
        if(obj == null){
            return true;
        }

        if(obj instanceof String) return ((String) obj).isEmpty();
        if(obj instanceof Integer) return ((Integer) obj) == 0;
        if(obj instanceof Double) return ((Double) obj) == 0.0;
        if(obj instanceof Short) return ((Short) obj) == 0;
        if(obj instanceof LocalDate) return ((LocalDate) obj).isEqual(LocalDate.now());
        if(obj instanceof LocalTime) return ((LocalTime) obj).equals(LocalTime.now());
        if(obj instanceof Boolean) return !((Boolean) obj);
        if(obj instanceof LocalDateTime) return ((LocalDateTime) obj).isEqual(LocalDateTime.now());
        return false;
    }

    public static boolean isValidEmail(String email){
        EmailValidator validator =EmailValidator.getInstance();
        return validator.isValid(email);
    }
}
