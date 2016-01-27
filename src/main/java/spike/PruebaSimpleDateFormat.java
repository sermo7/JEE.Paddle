package spike;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PruebaSimpleDateFormat {

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        String time = new SimpleDateFormat("HH:00 dd-MMM-yyyy ").format(cal.getTime());
        System.out.println(time);
    }
}
