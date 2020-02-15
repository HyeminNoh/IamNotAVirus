package com.iamnotavirus.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebCrawler {
    public Elements getPatientsInfo() throws Exception{
        Document document = new WebCrawler().getCrawlingResult("http://ncov.mohw.go.kr/bdBoardList.do?brdId=1&brdGubun=11&dataGubun=&ncvContSeq=&contSeq=&board_id=&gubun=");
        Elements el = document.select(".bvc_txt .s_listin_dot");
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
