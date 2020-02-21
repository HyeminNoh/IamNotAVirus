package com.iamnotavirus.web;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
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
        RestTemplate restTemplate = new RestTemplate();
        String jsonStr = restTemplate.getForObject("http://happycastle.club/status", String.class);

        Gson gson = new Gson();
        // 스트링 데이터 리스트로 변환, 국가 영어 key 값 추가필요
        Infection[] array = gson.fromJson(jsonStr, Infection[].class);

        return gson.toJson(jsonStr);
    }
}

class Infection{
    String id;
    String country;
    int die;
    int infected;
    int restore;
    int sus;
    Infection(String id, String country, int die, int infected, int restore, int sus){
        this.country = country;
        this.die = die;
        this.infected = infected;
        this.restore = restore;
        this.sus = sus;
        switch (country){
            case "대한민국":
                this.id = "KR";
            case "중국":
                this.id = "CN";
            case "싱가포르":
                this.id = "SG";
            case "홍콩":
                this.id = "HK";
            case "태국":
                this.id = "TH";
            case "중화민국":
                this.id = "TW";
            case "말레이시아":
                this.id = "MY";
            case "이란":
                this.id = "IRN";
            case "오스트레일리아":
                this.id = "AU";
            case "독일":
                this.id = "D";
            case "베트남":
                this.id = "";
            case "프랑스":
                this.id = "";
            case "마카오":
                this.id = "";
            case "영국":
                this.id = "";
            case "아랍에미리트":
                this.id = "";
            case "캐나다":
                this.id = "";
            case "이탈리아":
                this.id = "ITA";
            case "필리핀":
                this.id = "";
            case "인도":
                this.id = "IND";
            case "러시아":
                this.id = "";
            case "스페인":
                this.id = "";
            case "스웨덴":
                this.id = "";
            case "이스라엘":
                this.id = "";
            case "레바논":
                this.id = "";
            case "네팔":
                this.id = "";
            case "벨기에":
                this.id = "";
            case "스리랑카":
                this.id = "";
            case "캄보디아":
                this.id = "";
            case "핀란드":
                this.id = "";
            case "이집트":
                this.id = "";
            default:
                this.id = "total";
        }
    }
}
