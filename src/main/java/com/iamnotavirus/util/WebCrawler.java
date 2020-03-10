package com.iamnotavirus.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebCrawler {
    public Elements getInfectionInfoGlobe() throws Exception{
        Document document = new WebCrawler().getCrawlingResult("https://ko.wikipedia.org/wiki/%EB%82%98%EB%9D%BC%EB%B3%84_%EC%BD%94%EB%A1%9C%EB%82%98%EB%B0%94%EC%9D%B4%EB%9F%AC%EC%8A%A4%EA%B0%90%EC%97%BC%EC%A6%9D-19_%EC%9C%A0%ED%96%89");
        Elements el = document.select("#bodyContent #mw-content-text table.wikitable");
        return el;
    }

    public Elements getNewsInfoKo() throws Exception{
        Document document = new WebCrawler().getCrawlingResult("https://search.naver.com/search.naver?where=news&query=%EC%BD%94%EB%A1%9C%EB%82%98%20%EC%9D%B8%EC%A2%85%EC%B0%A8%EB%B3%84&sm=tab_srt&sort=0&photo=0&field=0&reporter_article=&pd=0&ds=&de=&docid=&nso=so%3Ar%2Cp%3Aall%2Ca%3Aall&mynews=0&refresh_start=0&related=0");
        Elements el = document.select("#main_pack .news.mynews.section._prs_nws .type01");
        return el;
    }

    public Elements getNewsInfoEn() throws Exception{
        Document document = new WebCrawler().getCrawlingResult("https://www.google.com/search?q=corona+racism&source=lnms&tbm=nws&sa=X&ved=2ahUKEwjrytnG_O7nAhUVFogKHat_BnYQ_AUoAnoECAsQBA&biw=1280&bih=578");
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
