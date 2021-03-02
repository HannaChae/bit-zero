package com.example.demo.cmm.utl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.prd.domain.ProductDto;

import lombok.RequiredArgsConstructor;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// @Component @RequiredArgsConstructor
public class Crawler extends Proxy{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	// private final Vector<ReviewDto> artBag;
    public Vector<ProductDto>  crawling(String url2){
    	String url = "https://tickets.interpark.com/goods/20009147";
    	logger.info(" URL : "+url);
    	ArrayList<ProductDto> artBag = new ArrayList<>();
        try{
            Document rawData = Jsoup.connect(url).timeout(10 * 1000).get();
            Elements titles = rawData.getElementsByClass("bbsTitle");
            Elements contents = rawData.select("b[class=bbsText]");
            ProductDto article = null;
            logger.info(" titles.size() " + titles.size());
            for(int i=0; i< titles.size(); i++){
            	logger.info(" for 내부 ");
                article = new ProductDto();
                article.setPrdName(titles.get(i).text());
                article.setPrdInv(contents.get(i).text());
                logger.info("제품 번호"+ i+"번: " +article.toString());
                artBag.add(article);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
    	Crawler c = new Crawler();
    	c.crawling("");
	}
}