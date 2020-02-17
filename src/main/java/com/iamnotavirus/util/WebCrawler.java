package com.iamnotavirus.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebCrawler {

    public Object getNewsInfoKr() throws Exception{
        Document document = new WebCrawler().getCrawlingResult("https://www.google.com/search?q=%EC%BD%94%EB%A1%9C%EB%82%98+%EC%9D%B8%EC%A2%85%EC%B0%A8%EB%B3%84&hl=ko&source=lnms&tbm=nws&sa=X&ved=2ahUKEwj8krCdnNPnAhWq-GEKHeyfClgQ_AUoAnoECAsQBA&biw=1280&bih=578");
        Elements el = document.select("#search .bkWMgd");
        return el.html();
    }

    public void getNewsInfoUs() throws Exception{

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
