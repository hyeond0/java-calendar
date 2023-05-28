package hyeond0.Calendar;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class PlanItem {
    public Date planDate;
    public String detail;
    public String people = "";

    public static Date getDatefromString(String strDate) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }
    public PlanItem(String date, String detail) {
        this.planDate = getDatefromString(date);
        this.detail = detail;
    }

    public Date getDate() {
        return planDate;
    }
    public void addPeoeple(String name) {
        people += name + ",";
    }
}
