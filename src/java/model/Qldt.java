/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author TruongDao
 */
public class Qldt {
    private List<String> cookies;
    private HttpURLConnection conn;
    private static final String USER_AGENT = "Mozilla/5.0";
    public String getFormParams(String username, String password) throws UnsupportedEncodingException {

        Map<String, String> params = new HashMap<>();

        params.put("__EVENTTARGET", "");
        params.put("__EVENTARGUMENT", "");
        params.put("ctl00$ContentPlaceHolder1$ctl00$ucDangNhap$txtTaiKhoa", username);
        params.put("ctl00$ContentPlaceHolder1$ctl00$ucDangNhap$txtMatKhau", password);
        params.put("ctl00$ContentPlaceHolder1$ctl00$ucDangNhap$btnDangNhap", "Đăng nhập");

        String result = "";
        for (String key : params.keySet()) {
            result += key + "=" + URLEncoder.encode(params.get(key), "UTF-8") + "&";
        }
        result = result.substring(0, result.length() - 1);

        return result;
    }
    public void sendPost(String url, String postParams) throws Exception {

        URL obj = new URL(url);
        conn = (HttpURLConnection) obj.openConnection();

        conn.setUseCaches(false);
        conn.setRequestMethod("POST");
        for (String cookie : this.cookies) {
            conn.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
        }

        HttpURLConnection.setFollowRedirects(true);
        conn.setDoOutput(true);
        conn.setDoInput(true);

        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.writeBytes(postParams);
        wr.flush();
        wr.close();

    }

    public void GetCookie(String url) throws Exception {
        URL obj = new URL(url);
        conn = (HttpURLConnection) obj.openConnection();
        conn.setRequestMethod("GET");
        conn.setUseCaches(false);
        if (cookies != null) {
            for (String cookie : this.cookies) {
                conn.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
            }
        }
        setCookies(conn.getHeaderFields().get("Set-Cookie"));
    }

    public void setCookies(List<String> cookies) {
        this.cookies = cookies;
    }

    public boolean checkLogin(String msv) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        if (response.toString().contains(msv)) {
            return true;
        }else{
            return false;
        }
    }
}
