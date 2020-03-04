package com.iamnotavirus.web;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.iamnotavirus.util.WebCrawler;
import lombok.RequiredArgsConstructor;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.Object;
import java.nio.charset.Charset;

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

    @ResponseBody
    @RequestMapping("/status/data")
    public Object infectionDataResponse() throws Exception{
        Gson gson = new Gson();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.valueOf("text/plain; charset=utf-8"));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)" +
                " AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("", headers);
        ResponseEntity<String> res = restTemplate
                .exchange("http://happycastle.club/status", HttpMethod.GET, entity, String.class);

        //String jsonStr = restTemplate.getForObject("http://happycastle.club/status", String.class);
        JsonArray convertedObject = gson.fromJson(res.getBody(), JsonElement.class).getAsJsonArray();

        //JsonArray 선언
        JsonArray returnArray = new JsonArray();

        for(int i=0; i<convertedObject.size()-2; i++){
            //JsonObject 선언
            JsonObject returnObject = new JsonObject();
            JsonElement el = convertedObject.get(i);
            String country = el.getAsJsonObject().get("country").getAsString();
            returnObject.addProperty("country", country);
            returnObject.addProperty("engCountry",toEng(country));
            returnObject.addProperty("die", el.getAsJsonObject().get("die").getAsString());
            returnObject.addProperty("infected", el.getAsJsonObject().get("infected").getAsString());
            returnObject.addProperty("restore", el.getAsJsonObject().get("restore").getAsString());
            returnObject.addProperty("sus", el.getAsJsonObject().get("sus").getAsString());
            returnObject.addProperty("postal", postalCheck(country));

            returnArray.add(returnObject);
        }

        return gson.toJson(returnArray);
        //return gson.toJson(res.getBody());
    }

    public String toEng(String country){
        switch (country){
            case "대한민국":
                return "SouthKorea";
            case "중국":
                return "China";
            case "국제 운송수단[a][b](다이아몬드 프린세스호)":
            case "국제 운송수단":
                return "Diamond Princess Cruise";
            case "일본[b]":
            case "일본":
                return "Japan";
            case "미국":
            case "미국[10]":
                return "USA";
            case "싱가포르":
                return "Singapore";
            case "홍콩":
                return "HongKong";
            case "태국":
                return "Thailand";
            case "바레인":
                return "Bahrain";
            case "중화민국":
                return "Taiwan";
            case "말레이시아":
                return "Malaysia";
            case "이란":
            case "이란[a]":
                return "Iran";
            case "오만":
                return "Oman";
            case "크로아티아":
                return "Croatia";
            case "오스트레일리아":
                return "Australia";
            case "오스트리아":
                return "Austria";
            case "쿠웨이트":
                return "Kuwait";
            case "독일":
                return "Germany";
            case "베트남":
                return "Vietnam";
            case "프랑스":
                return "France";
            case "마카오":
                return "Makao";
            case "이라크":
                return "Iraq";
            case "영국":
                return "UK";
            case "아랍에미리트":
                return "UAE";
            case "캐나다":
                return "Canada";
            case "이탈리아":
                return "Itary";
            case "필리핀":
                return "Philippine";
            case "인도":
                return "India";
            case "러시아":
                return "Russia";
            case "스페인":
                return "Spain";
            case "스웨덴":
                return "Sweden";
            case "에스토니아":
                return "Estonia";
            case "북마케도니아":
                return "Northern Macedonia";
            case "덴마크":
                return "Denmark";
            case "이스라엘":
                return "Israel";
            case "파키스탄":
                return "Pakistan";
            case "레바논":
                return "Lebanon";
            case "네덜란드":
                return "Netherlands";
            case "네팔":
                return "Nepal";
            case "벨기에":
                return "Belgium";
            case "스리랑카":
                return "Sri Lanka";
            case "캄보디아":
                return "Cambodia";
            case "핀란드":
                return "Finland";
            case "이집트":
                return "Egypt";
            case "조지아":
                return "Georgia";
            case "루마니아":
                return "Romania";
            case "노르웨이":
                return "Norway";
            case "그리스":
                return "Greece";
            case "브라질":
                return "Brazil";
            case "알제리":
                return "Algeria";
            case "스위스":
                return "Switzerland";
            case "아프가니스탄":
                return "Afghanistan";
            case "멕시코":
                return "Mexico";
            case "아제르바이잔":
                return "Azerbaijan";
            case "체코":
                return "Czech";
            case "아르메니아":
                return "Armenia";
            case "벨라루스":
                return "Belarus";
            case "도미니카 공화국":
                return "Dominican";
            case "에콰도르":
                return "Ecuador";
            case "아이슬란드":
                return "Iceland";
            case "아일랜드":
                return "Ireland";
            case "리투아니아":
                return "Lithuania";
            case "룩셈부르크":
                return "Luxembourg";
            case "모나코":
                return "Monaco";
            case "뉴질랜드":
                return "New Zealand";
            case "나이지리아":
                return "Nigeria";
            case "카타르":
                return "Qatar";
            case "산마리노":
                return "San Marino";
            case "인도네시아":
                return "Indonesia";
            case "포르투갈":
                return "Portugal";
            case "안도라":
                return "Andorra";
            case "요르단":
                return "Jordan";
            case "라트비아":
                return "Latvia";
            case "모로코":
                return "Morocco";
            case "사우디아라비아":
                return "Saudi Arabia";
            case "세네갈":
                return "Senegal";
            case "튀니지":
                return "Tunisia";
            case "아르헨티나":
                return "Argentina";
            case "칠레":
                return "Chile";
            case "리히텐슈타인":
                return "Liechtenstein";
            case "우크라이나":
                return "Ukraine";
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
            case "일본[b]":
            case "일본":
                return "J";
            case "미국[10]":
            case "미국":
                return "US";
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
            case "이란[a]":
                return "IRN";
            case "오만":
                return "OM";
            case "크로아티아":
                return "HR";
            case "오스트레일리아":
                return "AU";
            case "오스트리아":
                return "A";
            case "쿠웨이트":
                return "KW";
            case "독일":
                return "D";
            case "베트남":
                return "VN";
            case "프랑스":
                return "F";
            case "마카오":
                return "MO";
            case "이라크":
                return "IRQ";
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
            case "에스토니아":
                return "EST";
            case "북마케도니아":
                return "MK";
            case "덴마크":
                return "DK";
            case "이스라엘":
                return "IS";
            case "파키스탄":
                return "PK";
            case "레바논":
                return "LB";
            case "네덜란드":
                return "NL";
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
            case "조지아":
                return "GE";
            case "루마니아":
                return "RO";
            case "노르웨이":
                return "N";
            case "그리스":
                return "GR";
            case "브라질":
                return "BR";
            case "알제리":
                return "DZ";
            case "스위스":
                return "CH";
            case "아프가니스탄":
                return "AF";
            case "멕시코":
                return "MX";
            case "아제르바이잔":
                return "AZ";
            case "체코":
                return "CZ";
            case "아르메니아":
                return "ARM";
            case "벨라루스":
                return "BY";
            case "도미니카 공화국":
                return "DO";
            case "에콰도르":
                return "EC";
            case "아이슬란드":
                return "IS";
            case "아일랜드":
                return "IRL";
            case "리투아니아":
                return "LT";
            case "룩셈부르크":
                return "L";
            case "뉴질랜드":
                return "NZ";
            case "나이지리아":
                return "NG";
            case "카타르":
                return "QA";
            case "인도네시아":
                return "INDO";
            case "포르투갈":
                return "P";
            case "요르단":
                return "J";
            case "라트비아":
                return "LV";
            case "모로코":
                return "MA";
            case "사우디아라비아":
                return "SA";
            case "세네갈":
                return "SN";
            case "튀니지":
                return "TN";
            case "아르헨티나":
                return "AR";
            case "칠레":
                return "CL";
            case "우크라이나":
                return "UA";
            case "합계":
                return "total";
            default:
                return "";
        }
    }
}

