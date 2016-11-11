package util;

public class StringUtil {

    public static String setText(String text) {
        return (text == null || text.isEmpty()) ? "" : text;
    }
}
