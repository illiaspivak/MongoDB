package sk.kosickaakademia.spivak.hobby.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    /**
     * Current date and time
     * @return yyyy-MM-dd HH:mm:ss
     */
    public String getCurrentTime(){
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatForDateNow.format(dateNow);
    }

}
