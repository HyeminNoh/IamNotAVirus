package com.iamnotavirus.web;

import com.iamnotavirus.util.WebCrawler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.Object;

@RequiredArgsConstructor
@RestController
public class CrawlerApiController {

    @ResponseBody
    @RequestMapping("/crawling/news/kr")
    public Object newResponseKr() throws Exception {
        Object elements = new WebCrawler().getNewsInfoKr();
        return elements;
    }
}
