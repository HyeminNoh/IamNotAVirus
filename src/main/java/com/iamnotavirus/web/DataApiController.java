package com.iamnotavirus.web;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.iamnotavirus.util.WebCrawler;
import lombok.RequiredArgsConstructor;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.Object;

@RequiredArgsConstructor
@RestController
public class DataApiController {

    @ResponseBody
    @RequestMapping("/crawling/news/ko")
    public Object newResponseKo() throws Exception {
        Elements elements = new WebCrawler().getNewsInfoKo();

        Gson gson = new Gson();
        //JsonArray 선언
        JsonArray returnArray = new JsonArray();

        for(Element news : elements.select("li")){
            if(news.select("dt").hasText()) {
                //JsonObject 선언
                JsonObject returnObject = new JsonObject();

                returnObject.addProperty("title", news.select("dt").text());
                returnObject.addProperty("source", news.select("span._sp_each_source").text() + " " + news.select("span.bar").text());
                returnObject.addProperty("img", news.select("img").attr("abs:src"));
                returnObject.addProperty("link", news.select("div.thumb>a").attr("abs:href"));

                returnArray.add(returnObject);
            }
        }
        return gson.toJson(returnArray);
    }

    @ResponseBody
    @RequestMapping("/crawling/news/en")
    public Object newResponseEn() throws Exception {
        Elements elements = new WebCrawler().getNewsInfoEn();

        Gson gson = new Gson();

        //JsonArray 선언
        JsonArray returnArray = new JsonArray();

        for(Element news : elements.select("div.g")){
            if(news.select("h3").hasText()) {
                //JsonObject 선언
                JsonObject returnObject = new JsonObject();

                returnObject.addProperty("title", news.select("h3").text());
                returnObject.addProperty("source", news.select("div.slp").text());
                returnObject.addProperty("img", news.select("img").attr("abs:src"));
                returnObject.addProperty("link", news.select("div>h3>a").attr("abs:href"));

                returnArray.add(returnObject);
            }
        }
        return gson.toJson(returnArray);

        //return elements.html();
    }

    @RequestMapping(value="/infection/data", produces = "application/json; charset=utf-8")
    public Object infectionDataResponse() throws Exception{
        Gson gson = new Gson();
        RestTemplate restTemplate = new RestTemplate();

        String jsonStr = restTemplate.getForObject("http://happycastle.club/status", String.class);
        JsonArray convertedObject = gson.fromJson(jsonStr, JsonElement.class).getAsJsonArray();

        //JsonArray 선언
        JsonArray returnArray = new JsonArray();

        for(int i=0; i<convertedObject.size()-2; i++){
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

    public String countryEng(String country){
        switch (country){
            case "대한민국":
                return "KOREA";
            case "중국":
                return "CHINA";
            case "일본":
                return "JAPAN";
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

