package design.pgy.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String getBCrypt(String string) {
        return bCryptPasswordEncoder.encode(string);
    }

    public static void main(String[] args) {
        System.out.println(BCryptPasswordEncoderUtils.getBCrypt("123"));    // $2a$10$YqfwF6UOLte4mA4eLn0ZvuSZdkpoxJuIbbuQbQAHTgZdbSFSDyQdy
        System.out.println(BCryptPasswordEncoderUtils.getBCrypt("456"));    // $2a$10$UmEPasMoGO14L9t/prDsXe7SX1MJ/J8Hbdvoh4i4qJNtqDnhawcsy
    }

}
