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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author TruongDao
 */
public class SubContent {
    private String h1;
    private String h2;
    private String content;
    private Timestamp time;
    private String link;

    public SubContent(String h1, String h2, String content, Timestamp time) {
        this.h1 = h1;
        this.h2 = h2;
        this.content = content;
        this.time = time;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public SubContent(String h1, String h2, String content) {
        this.h1 = h1;
        this.h2 = h2;
        this.content = content;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getH1() {
        return h1;
    }

    public void setH1(String h1) {
        this.h1 = h1;
    }

    public String getH2() {
        return h2;
    }

    public void setH2(String h2) {
        this.h2 = h2;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public SubContent dataToSubContent(String link, Timestamp time){
        try {
            String url = link;
            Document doc = Jsoup.connect(url).get();
            String h1Str = "";
            String h2Str = "";
            String contentStr = "";
            Element h1 = doc.getElementsByTag("h1").first();
            h1Str = h1.text();
//            h1Str = h1Str.replace("\"", "\\\"");
            Element h2 = doc.getElementsByTag("h2").first();
            h2Str = h2.text();
//            h2Str = h2Str.replace("\"", "\\\"");
            Element content = doc.getElementById("ContentDetail");
            contentStr = content.html();
//            contentStr = contentStr.replace("\"", "\\\"");
//            contentStr = contentStr.replace("\n","");
            SubContent subContent = new SubContent(h1Str, h2Str, contentStr, time);
            return subContent;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public SubContent() {
    }
    
}
