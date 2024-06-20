package utils;

import java.io.File;

public class FileUtil {

    public static File getValidUserFile(){
        return new File("src/test/resources/validUserData.json");
    }

    public static File getInvalidUserFile(){
        return new File("src/test/resources/invalidUserData.json");
    }

    public static File getIncorrectLoginFile(){
        return new File("src/test/resources/incorrectLogin.json");
    }

    public static File getNonexistentLoginFile(){
        return new File("src/test/resources/nonexistentLogin.json");
    }

    public static File getOnlyPasswordFile(){
        return new File("src/test/resources/onlyPassword.json");
    }

    public static File getOrderFile(){
        return new File("src/test/resources/order.json");
    }
}
