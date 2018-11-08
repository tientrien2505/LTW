/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.util.ArrayList;
import model.News;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author TruongDao
 */
public class NewsToJson {
    public void get(String path) throws IOException{
        String url = "http://genk.vn";
        Document doc = Jsoup.connect(url).get();
        Element ul = doc.getElementById("LoadListCate");
        Elements li = ul.getElementsByClass("shownews");
        ArrayList<News> listNews = new ArrayList<>();
        int i = 0;
        for (Element lii : li){
            i++;
            if (i==21)
                continue;
            News news = new News();
            Element link = lii.getElementsByTag("a").first();
            news.setLink(url+link.attr("href"));
            Element image = lii.getElementsByTag("img").first();
            news.setImage(image.attr("src"));
            Element title = lii.getElementsByClass("kscliw-ava").first();
            news.setTitle(title.attr("title").replace("\"", "\'"));
            Element con = lii.getElementsByClass("knswli-sapo").first();
            news.setContent(con.text().replace("\"", "\\\""));
            Element time = lii.getElementsByClass("knswli-time").first();
//            news.setTime(time.text().replace("\"", "\\\""));
            listNews.add(news);
        }        
        JsonNews j = new JsonNews();
        j.writeJson(j.arrayJsonToString(listNews),path);
//        return json;
    }
    public static void main(String[] args) throws IOException {
//        get("D:/xamp/htdocs/practice/jsoup/ParseGenk/build/web/json/content.json");
    }
}
