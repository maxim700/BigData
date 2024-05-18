
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document ;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import sun.security.util.Length;

import java.io.IOException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) {
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
            Elements listNews = doc.select("div.news-item-title-inner");
//            Elements listNews = doc.select("span.news-item-date");

            String row = listNews.select("span").text();
            //todo save to csv
//            System.out.println(listNews);

            Pattern pattern = Pattern.compile("(([0-3]\\d\\.[0-1]\\d\\.\\d{4}) ([a-zA-Z]*))");
            Matcher matcher = pattern.matcher(row);

            while (matcher.find()) {
                System.out.println(row.substring(matcher.start(), matcher.end()));
            }

//            System.out.println(row.text());

            Elements next = doc.select("ul.yiiPager").select("li.next").select("a");
            url = next.attr("abs:href");

        }

        //System.out.println(doc);
//        Elements listNews = doc.select("div#tabnews_newsc.content-tabs__items.content-tabs__items_active_true");
//        Elements listNews = doc.select("div.news");

//        System.out.println(listNews);

//        for (Element element : listNews.select("a"))
//            System.out.println(element.text());

//        System.out.println(listNews.select("a").get(2).text());
    }
}
