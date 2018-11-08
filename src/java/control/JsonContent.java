/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import model.SubContent;
import model.News;

/**
 *
 * @author TruongDao
 */
public class JsonContent {
    public JsonContent(){}
    public String jsonToString(SubContent content){
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        sb.append("\"h1\":\""+content.getH1()+"\",");
        sb.append("\"h2\":\""+content.getH2()+"\",");
        sb.append("\"content\":\""+content.getContent()+"\"");
        sb.append("}");
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
