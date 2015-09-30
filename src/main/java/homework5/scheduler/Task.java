package homework5.scheduler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Razer on 29.09.15.
 */
public class Task {

    public void action() {
        Date data = new Date();
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String s = formatter.format(data);
        System.out.println(s);
    }
}
