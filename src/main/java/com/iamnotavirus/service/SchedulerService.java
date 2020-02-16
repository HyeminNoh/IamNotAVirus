package com.iamnotavirus.service;

import com.iamnotavirus.util.WebCrawler;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerService {

    @Scheduled(cron = "0 0 9 * * *")
    public void cronJobSch() throws Exception {
        WebCrawler crawler = new WebCrawler();
        crawler.getPatientsInfo();
        crawler.getNewsInfoKr();
        crawler.getNewsInfoUs();
    }
}
