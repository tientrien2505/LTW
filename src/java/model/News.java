/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author TruongDao
 */
public class News {
    private String link;
    private String image;
    private String title;
    private String content;
    private Timestamp time;

    public News() {
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
    
    public ArrayList<News> DataToNews() {
        try {
            ArrayList<News> listNews = new ArrayList<>();
            String url = "http://genk.vn";
            Document doc = Jsoup.connect(url).get();
            Element ul = doc.getElementById("LoadListCate");
            Elements li = ul.getElementsByClass("shownews");
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
//                Element time = lii.getElementsByClass("knswli-time").first();
                news.setTime(new Timestamp(new Date().getTime()));
                listNews.add(news);
            }
            return listNews;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public String newsToJson(ArrayList<News> listNews){
        StringBuffer json = new StringBuffer();
        json.append("[");
        for (News news : listNews){
            json.append("{");
            json.append("\"link\":\""+news.getLink()+"\",");
            json.append("\"image\":\""+news.getImage()+"\",");
            json.append("\"title\":\""+news.getTitle()+"\",");
            json.append("\"content\":\""+news.getContent()+"\",");
            json.append("\"time\":\""+news.getTime().toString()+"\"");
            json.append("},");
        }
        json.deleteCharAt(json.length()-1);
        json.append("]");
        
        return json.toString();
    }
    
}
