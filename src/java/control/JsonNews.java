/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import model.News;

/**
 *
 * @author TruongDao
 */
public class JsonNews {
    public JsonNews(){}
    public String jsonToString(News news){
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        sb.append("\"link\":\""+news.getLink()+"\",");
        sb.append("\"image\":\""+news.getImage()+"\",");
        sb.append("\"title\":\""+news.getTitle()+"\",");
        sb.append("\"content\":\""+news.getContent()+"\",");
        sb.append("\"time\":\""+news.getTime()+"\"");
        sb.append("}");
        return sb.toString();
    }
    public String arrayJsonToString(ArrayList<News> list){
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (News news : list){
            sb.append(jsonToString(news));
            sb.append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }
    public void writeJson(String jsonChain, String path) throws FileNotFoundException, IOException{      
        File fileName = new File(path);
        fileName.createNewFile();        
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(fileName),StandardCharsets.UTF_8);
        osw.write(jsonChain);
        osw.close();
    }
}
