package commonLibrary;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 * Created by D-LT27HK on 6/10/2017.
 */
public class Patternmather {
    public static void main(String[] args) {

        String text    =
                "John writes about this, and [user_name] John Doe writes about that," +
                        " and John Wayne [user_mail] about everything."
                ;

        String patternString1 = "(\\[.+?\\])";
        String strParam = null;
        Pattern pattern = Pattern.compile(patternString1);
        Matcher matcher = pattern.matcher(text);
        int lastEnd = 0;
        String replaceFirst = null;
        while (matcher.find())
        {
           // if (lastEnd != matcher.start())
            System.out.println(matcher.group(1));
            text = text.replace(matcher.group(1),"111");
            //lastEnd = matcher.end();
        }

    }
}
