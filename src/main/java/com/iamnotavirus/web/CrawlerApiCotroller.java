package com.iamnotavirus.web;

import com.google.gson.Gson;
import com.iamnotavirus.util.WebCrawler;
import com.iamnotavirus.web.dto.PatientList;
import lombok.RequiredArgsConstructor;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.Object;

@RequiredArgsConstructor
@RestController
public class CrawlerApiCotroller {
    @ResponseBody
    @RequestMapping("/crawling/patient")
    public Object PatientResponseDto() throws Exception {
        Elements elements = new WebCrawler().getPatientsInfo();
        PatientList patientList = new PatientList(elements);
        Gson gson = new Gson();
        return gson.toJson(patientList);
    }
}
