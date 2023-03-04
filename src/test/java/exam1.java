import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
public class exam1 {
    public static void sumCountDate() throws ParseException {
        String start ="20170220";
        String end = "20211224";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date startDate = simpleDateFormat.parse(start);
        Date endDate = simpleDateFormat.parse(end);
        long result = Math.abs(startDate.getTime()-endDate.getTime())/(24*60*60*1000);
        System.out.println("total number of days from the start date to the end date :"+result);
    }
    public static void countMonth() throws ParseException {
        String start ="20180220";
        LocalDate startDate = LocalDate.parse(start, DateTimeFormatter.ofPattern("yyyyMMdd"));
        LocalDate nextMonth = (startDate.plusMonths(1));
        System.out.println("next month : "+nextMonth.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
    }

    public static void main(String[] args) throws ParseException {
        sumCountDate();
        countMonth();
    }
}
