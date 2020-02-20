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
