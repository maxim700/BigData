import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class PageReader extends Thread {
    String Nurl;
    String Ndate;
    String Nlabel;

    public PageReader(String url, String date, String label) {
        Nurl = url;
        Ndate = date;
        Nlabel = label;
    }

    public void run() {
        System.out.println(Nurl);
        System.out.println(Ndate);
        System.out.println(Nlabel);

//        Document doc = null;
//        try {
//            doc = Jsoup.connect(Nurl)
//                    .userAgent("Chrome/4.0.249.0 Safari/532.5")
//                    .referrer("http://www.google.com")
//                    .get();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Elements content = doc.select("div.cont-main").select("p");
//        for (Element element : content){
//            System.out.println(element);
//        }

    }
}