package com.iamnotavirus.web;

import com.google.gson.Gson;
import com.iamnotavirus.service.patients.PatientsService;
import com.iamnotavirus.util.WebCrawler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.Object;

@RequiredArgsConstructor
@RestController
public class CrawlerApiController {

    private final PatientsService patientsService;

    @ResponseBody
    @RequestMapping("/crawling/patient")
    public Object PatientResponse(){
        Gson gson = new Gson();
        return gson.toJson(patientsService.findAllDesc());
    }

    @ResponseBody
    @RequestMapping("/crawling/news/kr")
    public Object newResponseKr() throws Exception {
        Object elements = new WebCrawler().getNewsInfoKr();
        return elements;
    }
}
