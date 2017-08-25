package jianshu.xin.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by AnLu on
 * 2017/8/25 15:00.
 * jianshu
 */
public class TimeFormatTag extends SimpleTagSupport {

    private String time;

    public void setTime(String time) {
        this.time = time;
    }

    private static Date getDate(String rawTime) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return df.parse(rawTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getFormattedTime(String rawtime) {
        String result;
        Calendar cal = Calendar.getInstance();
        Date nowDate = cal.getTime();
        Date rawDate = getDate(rawtime);
        if (rawDate == null) {
            return "很久以前";
        }
        long difSeconds = (nowDate.getTime() - rawDate.getTime()) / (1000);
        if (difSeconds < 0) {
            result = "穿越了！";
        } else if (rawDate.before(getStartOfDay(nowDate)) && rawDate.after(getStartOfYesterday(nowDate))) {
            result = "昨天";
        } else if (difSeconds < 60) {
            result = "刚刚";
        } else if (difSeconds < 60 * 60) {
            String minuteDiff = String.valueOf(difSeconds / 60);
            result = minuteDiff + " 分钟前";
        } else if (difSeconds < 60 * 60 * 24) {
            String hourDiff = String.valueOf(difSeconds / (60 * 60));
            result = hourDiff + " 小时前";
        } else if (difSeconds < 60 * 60 * 24 * 7) {
            String dayDiff = String.valueOf(difSeconds / (60 * 60 * 24));
            result = dayDiff + " 天前";
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            result = simpleDateFormat.format(rawDate);
        }
        return result;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.print(getFormattedTime(time));
    }

    private static Date getStartOfYesterday(Date date) {
        return new Date(getStartOfDay(date).getTime() - 1000 * 60 * 60 * 24);
    }

    private static Date getStartOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
}
