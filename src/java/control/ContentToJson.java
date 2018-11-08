/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.util.ArrayList;
import model.SubContent;
import model.News;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author TruongDao
 */
public class ContentToJson {
    public void get(String link, String path) throws IOException{
        String url = link;
        Document d = Jsoup.connect(url).get();
        Document doc = Jsoup.connect(url).get();
        String h1Str = "";
        String h2Str = "";
        String contentStr = "";
        Element h1 = doc.getElementsByTag("h1").first();
        h1Str = h1.text();
        h1Str = h1Str.replace("\"", "\\\"");
        Element h2 = doc.getElementsByTag("h2").first();
        h2Str = h2.text();
        h2Str = h2Str.replace("\"", "\\\"");
        Element content = doc.getElementById("ContentDetail");
        contentStr = content.html();
        contentStr = contentStr.replace("\"", "\\\"");
        contentStr = contentStr.replace("\n","");
        SubContent contentDetail = new SubContent(h1Str, h2Str, contentStr);
        JsonContent j = new JsonContent();
        j.writeJson(j.jsonToString(contentDetail),path);
    }
}
