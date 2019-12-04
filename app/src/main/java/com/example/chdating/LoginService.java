package com.example.chdating;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
//login service
public class LoginService {

    public static String loginByPost(String username,String password){
        try{
            String path="http://192.168.2.13:8084/redchair/UserServlet";
            //下面的代码的确从论坛网站取到了index.jsp的全部编码信息，意味着通信成功。
            //String path="http://www.jianghehuhai.net/redchair/index.jsp";
            URL url=new URL(path);
            HttpURLConnection conn=(HttpURLConnection)url.openConnection();
            conn.setConnectTimeout(8000);
            conn.setReadTimeout(8000);
            conn.setRequestMethod("POST");
            String data="username="+ URLEncoder.encode(username,"UTF-8")+"&password="+URLEncoder.encode(password,"UTF-8");
            System.out.println(data);
            conn.setRequestProperty("content-type","application/x-www-form-urlencoded");
            conn.setRequestProperty("content-length",data.length()+"");
            conn.setDoOutput(true);
            OutputStream os=conn.getOutputStream();
            os.write(data.getBytes());
            int code=conn.getResponseCode();
            if(code==200){
                InputStream is=conn.getInputStream();
                String text="";
                InputStreamReader in=new InputStreamReader(is);
                BufferedReader buffer=new BufferedReader(in);
                String inputLine=null;
                while((inputLine=buffer.readLine())!=null){
                    text=text+inputLine+"\n";
                }
                in.close();
                conn.disconnect();
                return text;
            }else{
                return "ok";
            }
        }catch(MalformedURLException e){
            e.printStackTrace();
        }catch (ProtocolException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return "bad";
    }
}
