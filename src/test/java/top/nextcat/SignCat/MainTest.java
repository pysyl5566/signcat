package top.nextcat.SignCat;

import org.junit.jupiter.api.Test;
import top.nextcat.SignCat.api.SignApi;
import top.nextcat.SignCat.helper.AuthHelper;
import top.nextcat.SignCat.helper.ServerChanHelper;
import top.nextcat.SignCat.helper.SignHelper;
import top.nextcat.SignCat.helper.StringHelper;
import top.nextcat.SignCat.model.CpdailyUser;
import top.nextcat.SignCat.model.SignTask;
import top.nextcat.SignCat.model.result.ResultAuthSchoolInfo;


public class MainTest {
    @Test
    void test () {
//        CpdailyUser cpdailyUser = new CpdailyUser();
//        cpdailyUser.setStudentId("20172311");
//        cpdailyUser.setSchoolCode("ccut");
//        cpdailyUser.setTgc("iap-1018615876819107-TGT-01066434-10b9-479b-8f65-d58301ba2f32");
//
//        String modAuthCas = AuthHelper.getModAuthCas(cpdailyUser);;
//        SignHelper.getSignInfo(cpdailyUser,modAuthCas);

//        String signDate = "2020-09-15 14:25";
//        Integer signMonth = Integer.parseInt(StringHelper.getSubString(signDate,"-","-"));
//        Integer signDay = Integer.parseInt(StringHelper.getSubString(signDate.replaceFirst("-",""),"-"," "));
//
//        String signTime = resultSignTask.getRateTaskBeginTime();
//        Integer signH = Integer.parseInt(StringHelper.getSubString(signTime,"",":"));
//        Integer signM = Integer.parseInt(StringHelper.getSubString(signTime,":",""));

//        String currentTime = "2020-09-15 14:25";
//        Integer currentMonth = Integer.parseInt(StringHelper.getSubString(currentTime,"-","-"));
//        Integer currentDay = Integer.parseInt(StringHelper.getSubString(currentTime.replaceFirst("-",""),"-"," "));
//        Integer currentH = Integer.parseInt(StringHelper.getSubString(currentTime,"",":"));
//        Integer currentM = Integer.parseInt(StringHelper.getSubString(currentTime,":",""));

//        Integer currentMonth = Integer.parseInt(StringHelper.getSubString(currentTime,"-","-"));
//        Integer currentDay = Integer.parseInt(StringHelper.getSubString(currentTime.replaceFirst("-",""),"-"," "));
//        Integer currentH = Integer.parseInt(StringHelper.getSubString(currentTime," ",":"));
//        Integer currentM = Integer.parseInt(StringHelper.getSubString(currentTime,":",""));
//
//            System.out.println(currentMonth + " " + currentDay + " " + currentH + ":" + currentM);

//        ServerChanHelper.sendMessage("SCU109804Tace5504b45afc9c7dad2daf24672b9c15f3b4907b7ddc","ok!!!");

//        System.out.println(SignTask.class.getSimpleName());

//        String signDate = "2020-09-14 (周一)";
//        Integer signMonth = Integer.parseInt(StringHelper.getSubString(signDate,"-","-"));
//        Integer signDay = Integer.parseInt(StringHelper.getSubString(signDate.replaceFirst("-",""),"-"," "));
//
//        System.out.println(signMonth);
//
//        System.out.println(signDay);

//        CpdailyUser cpdailyUser = new CpdailyUser();
//        cpdailyUser.setStudentId("2019304865");
//        cpdailyUser.setSchoolCode("f401a6c9-e20e-432c-8cd1-fec2bfd6ac04");
//        cpdailyUser.setTgc("iap-1020372549012747-TGT-94b70bfc-bd92-4cd7-b0e0-dd04a22fa771");
//        SignHelper.getSignInfo(cpdailyUser,"ST-iap:1020372549012747:ST:c5580e71-5203-4e0a-a146-27320f58f9ae:20200914130640");
//        String url = "https://aust.campusphere.net/iap";
//        String protocol = StringHelper.getSubString(url,"","://");
//        String schoolUrl = StringHelper.getSubString(url,"://","/");
//        String s = protocol + "://" + schoolUrl + SignApi.API_SUBMIT_SIGN;
//        System.out.println(s);
    }
}
