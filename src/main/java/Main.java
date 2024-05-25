
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document ;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import sun.security.util.Length;

import java.io.File;
import java.io.IOException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) {

        File file = new File("data.csv");

        Document doc = null;
        String url = "https://75.ru/news";
        for (int i = 0; i< 10; i++){
            System.out.println("PAGE: " + (i+1));
            try {
                doc = Jsoup.connect(url)
                        .userAgent("Chrome/4.0.249.0 Safari/532.5")
                        .referrer("http://www.google.com")
                        .get();
            } catch (IOException e) {
                e.printStackTrace();
            }

//            Elements listNews = doc.select("div.news");
            Elements listNews = doc.select("a.news-item");
            for (Element element : listNews){
                String PageUrl = element.attr("abs:href");
                String row = element.select("div.news-item-title-inner").select("span").text();
                (new PageReader(PageUrl, row.substring(0,10), row.substring(11))).start();
            }

            Elements next = doc.select("ul.yiiPager").select("li.next").select("a");
            url = next.attr("abs:href");

        }

    }
}

//([0-3]\d\.[0-1]\d\.\d{4}) ([a-zA-ZА-яЁё0-9«»:.\- ]{3,})