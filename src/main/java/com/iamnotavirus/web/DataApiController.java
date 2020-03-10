package com.iamnotavirus.web;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.internal.$Gson$Preconditions;
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

    /* api가 업데이트 되지 않아 제외시킴

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
            returnObject.addProperty("ISO_A3", postalCheck(country));

            returnArray.add(returnObject);
        }

        return gson.toJson(returnArray);
        //return gson.toJson(res.getBody());
    }
     */

    @ResponseBody
    @RequestMapping("/status/data")
    public Object infectionDataResponse() throws Exception {
        Elements globeElements = new WebCrawler().getInfectionInfoGlobe();

        Gson gson = new Gson();
        //JsonArray 선언
        JsonArray returnArray = new JsonArray();
        Elements globe = globeElements.select("tr");

        for(int i=2; i<globe.size()-3; i++){
            JsonObject globeObject = new JsonObject();

            String country = globe.get(i).select("th a").text();
            if(country.contains("[")){
                country = country.substring(0, country.indexOf("[")-1);
            }

            String[] data = globe.get(i).select("td").text().replace(",","").split(" ");
            String infected = data[0];
            String die = data[1];
            String restore = data[2];
            globeObject.addProperty("no",String.valueOf(i-2));
            globeObject.addProperty("country", country);
            globeObject.addProperty("engCountry",toEng(country));
            globeObject.addProperty("die", die);
            globeObject.addProperty("infected", infected);
            globeObject.addProperty("restore", restore);
            globeObject.addProperty("ISO_A3", postalCheck(country));

            returnArray.add(globeObject);
        }
        return gson.toJson(returnArray);
    }

    public String toEng(String country){
        switch (country){
            case "대한민국":
                return "South Korea";
            case "중국":
            case "중국 대륙":
                return "China";
            case "국제 운송수단":
            case "국제 운송":
            case "다이아몬드 프린세스":
                return "Diamond Princess Cruise";
            case "일본":
                return "Japan";
            case "미국":
                return "USA";
            case "싱가포르":
                return "Singapore";
            case "홍콩":
                return "HongKong";
            case "태국":
                return "Thailand";
            case "바레인":
                return "Bahrain";
            case "타이완":
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
            case "팔레스타인":
                return "Palestine";
            case "슬로베니아":
                return "Slovenia";
            case "폴란드":
                return "Poland";
            case "헝가리":
                return "Hungary";
            case "알바니아":
                return "Albania";
            case "코스타리카":
                return "Costa Rica";
            case "페루":
                return "Peru";
            case "슬로바키아":
                return "Slovakia";
            case "남아프리카 공화국":
                return "South Africa";
            case "브루나이":
                return "Brunei";
            case "몰디브":
                return "Maldives";
            case "보스니아 헤르체고비나":
                return "Bosnia and Herzegovina";
            case "불가리아":
                return "Bulgaria";
            case "몰타":
                return "Malta";
            case "방글라데시":
                return "Bangladesh";
            case "콜롬비아":
                return "Colombia";
            case "부르키나파소":
                return "Burkina Faso";
            case "카메룬":
                return "Cameroon";
            case "키프로스":
                return "Cyprus";
            case "세르비아":
                return "Serbia";
            case "부탄":
                return "Bhutan";
            case "몰도바":
                return "Moldova";
            case "몽골":
                return "Mongolia";
            case "파나마":
                return "Panama";
            case "파라과이":
                return "Paraguay";
            case "토고":
                return "Togo";
            case "바티칸 시국":
                return "Vatican";
            default:
                return "";
        }
    }

    public String postalCheck(String country){
        switch (country){
            case "대한민국":
                return "KOR";
            case "중국":
            case "중국 대륙":
                return "CHN";
            case "일본":
                return "JPN";
            case "미국":
                return "USA";
            case "싱가포르":
                return "SGP";
            case "홍콩":
                return "HKG";
            case "태국":
                return "THA";
            case "타이완":
            case "중화민국":
                return "TWN";
            case "말레이시아":
                return "MYS";
            case "이란":
                return "IRN";
            case "오만":
                return "OMN";
            case "크로아티아":
                return "HRV";
            case "오스트레일리아":
                return "AUS";
            case "오스트리아":
                return "AUT";
            case "쿠웨이트":
                return "KWT";
            case "독일":
                return "DEU";
            case "베트남":
                return "VNM";
            case "프랑스":
                return "FRA";
            case "마카오":
                return "MAC";
            case "이라크":
                return "IRQ";
            case "영국":
                return "GBR";
            case "아랍에미리트":
                return "ARE";
            case "캐나다":
                return "CAN";
            case "이탈리아":
                return "ITA";
            case "필리핀":
                return "PHL";
            case "인도":
                return "IND";
            case "러시아":
                return "RUS";
            case "스페인":
                return "ESP";
            case "스웨덴":
                return "SWE";
            case "에스토니아":
                return "EST";
            case "북마케도니아":
                return "MKD";
            case "덴마크":
                return "DNK";
            case "이스라엘":
                return "ISR";
            case "파키스탄":
                return "PAK";
            case "레바논":
                return "LBN";
            case "네덜란드":
                return "NLD";
            case "네팔":
                return "NPL";
            case "벨기에":
                return "BEL";
            case "스리랑카":
                return "LKA";
            case "캄보디아":
                return "KHM";
            case "핀란드":
                return "FIN";
            case "이집트":
                return "EGY";
            case "조지아":
                return "GEO";
            case "루마니아":
                return "ROU";
            case "노르웨이":
                return "NOR";
            case "그리스":
                return "GRC";
            case "브라질":
                return "BRA";
            case "알제리":
                return "DZA";
            case "스위스":
                return "CHE";
            case "아프가니스탄":
                return "AFG";
            case "멕시코":
                return "MEX";
            case "아제르바이잔":
                return "AZE";
            case "체코":
                return "CZE";
            case "아르메니아":
                return "ARM";
            case "벨라루스":
                return "BLR";
            case "도미니카 공화국":
                return "DOM";
            case "에콰도르":
                return "ECU";
            case "아이슬란드":
                return "ISL";
            case "아일랜드":
                return "IRL";
            case "리투아니아":
                return "LTU";
            case "룩셈부르크":
                return "LUX";
            case "모나코":
                return "MCO";
            case "뉴질랜드":
                return "NZL";
            case "나이지리아":
                return "NGA";
            case "카타르":
                return "QAT";
            case "산마리노":
                return "SMR";
            case "인도네시아":
                return "IDN";
            case "포르투갈":
                return "PRT";
            case "안도라":
                return "AND";
            case "요르단":
                return "JOR";
            case "라트비아":
                return "LVA";
            case "모로코":
                return "MAR";
            case "사우디아라비아":
                return "SAU";
            case "세네갈":
                return "SEN";
            case "튀니지":
                return "TUN";
            case "아르헨티나":
                return "ARG";
            case "칠레":
                return "CHL";
            case "리히텐슈타인":
                return "LIE";
            case "우크라이나":
                return "UKR";
            case "팔레스타인":
                return "PSE";
            case "슬로베니아":
                return "SVN";
            case "폴란드":
                return "POL";
            case "헝가리":
                return "HUN";
            case "알바니아":
                return "ALB";
            case "코스타리카":
                return "CRI";
            case "페루":
                return "PER";
            case "슬로바키아":
                return "SVK";
            case "남아프리카 공화국":
                return "ZAF";
            case "브루나이":
                return "BRN";
            case "몰디브":
                return "MDV";
            case "보스니아 헤르체고비나":
                return "BIH";
            case "불가리아":
                return "BGR";
            case "몰타":
                return "MLT";
            case "방글라데시":
                return "BGD";
            case "콜롬비아":
                return "COL";
            case "부르키나파소":
                return "BFA";
            case "카메룬":
                return "CMR";
            case "키프로스":
                return "-99";
            case "세르비아":
                return "SRB";
            case "부탄":
                return "BTN";
            case "몰도바":
                return "MDA";
            case "몽골":
                return "MNG";
            case "파나마":
                return "PAN";
            case "파라과이":
                return "PRY";
            case "토고":
                return "TGO";
            case "바티칸 시국":
                return "VAT";
            default:
                return "";
        }
    }
}

