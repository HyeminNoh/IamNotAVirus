package com.iamnotavirus.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebCrawler {
    public Elements getInfectionInfoGlobe() throws Exception{
        Document document = new WebCrawler().getCrawlingResult("http://bitly.kr/eventvillagecovid1");
        Elements el = document.select("#bodyContent #mw-content-text table.wikitable");
        return el;
    }

    public Elements getNewsInfoKo() throws Exception{
        Document document = new WebCrawler().getCrawlingResult("http://bitly.kr/HKXQFTjMb");
        Elements el = document.select("#main_pack .news.mynews.section._prs_nws .type01");
        return el;
    }

    public Elements getNewsInfoEn() throws Exception{
        Document document = new WebCrawler().getCrawlingResult("http://bitly.kr/q35EF7dBK");
        Elements el = document.select("#search");
        return el;
    }

    public Document getCrawlingResult(String url){
        try{
            return Jsoup.connect(url)
                    .timeout(2000)
                    .get();
        }catch(IOException e){
          throw new RuntimeException("crawling fail");
        }
    }
}
