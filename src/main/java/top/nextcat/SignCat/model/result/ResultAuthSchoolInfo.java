package top.nextcat.SignCat.model.result;

import java.util.List;

public class ResultAuthSchoolInfo {
//    {
//        "errCode": 0,
//            "errMsg": "success",
//            "data": [{
//        "id": "f401a6c9-e20e-432c-8cd1-fec2bfd6ac04",
//                "name": "安徽理工大学",
//                "tenantCode": "10361",
//                "img": "https://res.campushoy.com/cpdaily-upload-resources/z0/tb/2020/34210fe4-31fd-40c3-80f4-febaa457aaf2-dyAYpzF4sQ.jpg",
//                "distance": "",
//                "shortName": "安徽理工大学",
//                "joinType": "CLOUD",
//                "casLoginUrl": "",
//                "isEnter": 1,
//                "idsUrl": "https://aust.campusphere.net/iap",
//                "ampUrl": "https://aust.campusphere.net/wec-portal-mobile/client",//从这里拼接下面的接口
//                "ampUrl2": "",
//                "priorityUrl": "",
//                "appId": "d7de360368c94a808225",
//                "appSecret": "bd21d6dbee4245c2a726a73220afc2a6",
//                "msgUrl": "https://openapi.cpdaily.com/message_pocket_web",
//                "msgAccessToken": "ffd02929f16f94470a64fee4767a1436",
//                "msgAppId": "amp-ios-10361",
//                "msgAppIdIos": "amp-ios-10361",
//                "zgAppKey": "",
//                "yktBalanceUrl": "",
//                "yktTransferUrl": "",
//                "yktQrCodeUrl": "",
//                "xykUrl": "",
//                "userShowCollege": "DISABLE",
//                "scheduleOpenUrl": "",
//                "scheduleDataUrl": "",
//                "isIdsProxy": "NO",
//                "tenantNameImg": "",
//                "isNeedAlias": "YES",
//                "modifyPassUrl": "",
//                "modifyPassSuccessUrl": "",
//                "modifyPassDescr": "",
//                "taskUrl": "",
//                "taskAppId": "",
//                "circleShowType": "ALL_SHOW",
//                "isShowHotList": "YES",
//                "appStyleVersionId": "ab3693b6-fe70-434a-bb3d-cb54ec4de5c51594784027000",
//                "appStyleResUrl": "http://res.campushoy.com/cpdailyAdmin/20190813/1565663373547OpPgVbR4OLfAXCV98rCx.zip",
//                "likeBtnSpace": "INNER",
//                "iRobotUrl": "",
//                "servicePagePlace": "BOTTOM",
//                "scheduleAllDataUrl": "",
//                "scheduleUpdateDataUrl": "",
//                "shopUrl": "",
//                "homePageDisplayItem": "NAME,ACADEMY,MAJOR,SIGNATURE,TAG,GRADE",
//                "taoBannerId": "",
//                "canIdsLogin": "YES",
//                "appCacheDisable": "NO",
//                "homePageDisplayItemTeacher": "NAME,DEPART,JOB,TAG",
//                "lossPwdDesc": "",
//                "isAmpProxy": "NO",
//                "provinceId": "080",
//                "ybSwitch": "ACCOUNT_ENABLE,INFO",
//                "amp3Url": "",
//                "isOpenFission": "NO",
//                "isOpenOauth": "NO",
//                "ampRobotUrl": "",
//                "mediaVersion": "NEW",
//                "badHttpsBlock": "YES",
//                "faqForumId": "",
//                "campusReqProxy": "NO",
//                "appStoreUrl": "",
//                "studentVersion": "CPDAILY_CAMPUS",
//                "circleCanSeeOffCampus": "NO",
//                "contactDisplayItem": "FIND_CLASSMATE,FIND_MEDIA",
//                "contactDisplayItemTeacher": "FIND_TEACHER,FIND_CLASSMATE",
//                "homeFirstShow": "RECOMMEND",
//                "allowSendMsg": 1,
//                "teacherVersion": "OLD",
//                "yibanBuild": 0,
//                "freshPostRange": "PUBLIC",
//                "yibanAuthType": "",
//                "canInteractive": 0,
//                "secondHandSwitch": "NO"
//    }]
//    }
    public static class Data {
        private String id;
        private String name;
        private String ampUrl;

        public Data() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAmpUrl() {
            return ampUrl;
        }

        public void setAmpUrl(String ampUrl) {
            this.ampUrl = ampUrl;
        }
    }

    private Integer errCode;
    private String errMsg;
    private List<Data> data;

    public ResultAuthSchoolInfo() {
    }

    public ResultAuthSchoolInfo(Integer errCode, String errMsg, List<Data> data) {
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.data = data;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
