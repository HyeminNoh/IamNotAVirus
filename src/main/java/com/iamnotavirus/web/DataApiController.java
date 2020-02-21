package com.iamnotavirus.web;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.iamnotavirus.util.WebCrawler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.Object;

@RequiredArgsConstructor
@RestController
public class DataApiController {

    @ResponseBody
    @RequestMapping("/crawling/news/kr")
    public Object newResponseKr() throws Exception {
        Object elements = new WebCrawler().getNewsInfoKr();
        return elements;
    }

    @RequestMapping(value="/infection/data", produces = "application/json; charset=utf-8")
    public Object infectionDataResponse() throws Exception{
        Gson gson = new Gson();
        RestTemplate restTemplate = new RestTemplate();

        String jsonStr = restTemplate.getForObject("http://happycastle.club/status", String.class);
        JsonArray convertedObject = gson.fromJson(jsonStr, JsonElement.class).getAsJsonArray();

        //JsonArray 선언
        JsonArray returnArray = new JsonArray();

        for(int i=0; i<convertedObject.size(); i++){
            //JsonObject 선언
            JsonObject returnObject = new JsonObject();
            JsonElement el = convertedObject.get(i);

            returnObject.addProperty("country", el.getAsJsonObject().get("country").getAsString());
            returnObject.addProperty("die", el.getAsJsonObject().get("die").getAsString());
            returnObject.addProperty("infected", el.getAsJsonObject().get("infected").getAsString());
            returnObject.addProperty("restore", el.getAsJsonObject().get("restore").getAsString());
            returnObject.addProperty("sus", el.getAsJsonObject().get("sus").getAsString());
            returnObject.addProperty("postal", postalCheck(el.getAsJsonObject().get("country").getAsString()));

            returnArray.add(returnObject);
        }

        return gson.toJson(returnArray);
    }

    public String postalCheck(String country){
        switch (country){
            case "대한민국":
                return "KR";
            case "중국":
                return "CN";
            case "일본":
                return "J";
            case "싱가포르":
                return "SG";
            case "홍콩":
                return "HK";
            case "태국":
                return "TH";
            case "중화민국":
                return "TW";
            case "말레이시아":
                return "MY";
            case "이란":
                return "IRN";
            case "오스트레일리아":
                return "AU";
            case "독일":
                return "D";
            case "베트남":
                return "VN";
            case "프랑스":
                return "F";
            case "마카오":
                return "MO";
            case "영국":
                return "GB";
            case "아랍에미리트":
                return "AE";
            case "캐나다":
                return "CA";
            case "이탈리아":
                return "I";
            case "필리핀":
                return "PH";
            case "인도":
                return "IND";
            case "러시아":
                return "RUS";
            case "스페인":
                return "E";
            case "스웨덴":
                return "S";
            case "이스라엘":
                return "IS";
            case "레바논":
                return "LB";
            case "네팔":
                return "NP";
            case "벨기에":
                return "B";
            case "스리랑카":
                return "LK";
            case "캄보디아":
                return "KH";
            case "핀란드":
                return "AI";
            case "이집트":
                return "EG";
            case "합계":
                return "total";
            default:
                return "";
        }
    }
}

