package gss.guru.loginnormal.utils.utils;

import java.util.regex.Pattern;

import gss.guru.loginnormal.data.network.response.Auth;


public class AuthValidate {

    private static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );

    public static boolean isEmailValid(String email){
        return email != null && email.length() != 0 && EMAIL_ADDRESS_PATTERN.matcher(email).matches();
    }

    public static boolean isPasswdValid(String passwd){
        return passwd != null && passwd.length() >= 6;
    }

    public static boolean isEmailPasswdValid(String email, String passwd){
        return isEmailValid(email) && isPasswdValid(passwd);
    }



    public static boolean authValid(Auth auth){
        if(auth.getKey() != null && auth.getUser()!= 0 && auth.getCreated() != null)
            return true;
        return false;
    }


}
