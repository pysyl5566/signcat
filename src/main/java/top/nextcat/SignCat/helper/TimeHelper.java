package top.nextcat.SignCat.helper;

import com.alibaba.fastjson.JSON;

import java.util.Date;

public class TimeHelper {
    public static String getCurrentTime() {
        return JSON.toJSONStringWithDateFormat(new Date(), "yyyy-MM-dd HH:mm:ss.SSS");
    }

    public static boolean isNeedSign(String signDate,String signTime,String currentTime) {
//        String signDate = resultSignTask.getRateSignDate();
        Integer signMonth = Integer.parseInt(StringHelper.getSubString(signDate,"-","-"));
        Integer signDay = Integer.parseInt(StringHelper.getSubString(signDate.replaceFirst("-",""),"-"," "));

//        String signTime = resultSignTask.getRateTaskBeginTime();
        Integer signH = Integer.parseInt(StringHelper.getSubString(signTime,"",":"));
        Integer signM = Integer.parseInt(StringHelper.getSubString(signTime,":",""));

//        String currentTime = resultSignTask.getCurrentTime();
        Integer currentMonth = Integer.parseInt(StringHelper.getSubString(currentTime,"-","-"));
        Integer currentDay = Integer.parseInt(StringHelper.getSubString(currentTime.replaceFirst("-",""),"-"," "));
        Integer currentH = Integer.parseInt(StringHelper.getSubString(currentTime," ",":"));
        Integer currentM = Integer.parseInt(StringHelper.getSubString(currentTime,":",""));

        if (currentMonth.equals(signMonth) && currentDay.equals(signDay)) {
            return currentH > signH || currentH.equals(signH) && currentM >= signM;
        }
        return false;
    }
}
