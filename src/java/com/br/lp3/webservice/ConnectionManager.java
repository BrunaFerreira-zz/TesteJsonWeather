/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 31596861
 */
public class ConnectionManager {
    public static String readContent(String uri) throws IOException{
        String content = "";
        try {     
            URL url = new URL(uri);
            
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.0.10", 3128 ));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(proxy);
            
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = rd.readLine()) != null){
                //Adiciona linha ao StringBuilder
                sb.append(line);
            }
            
            rd.close();
            conn.disconnect();
        } catch (MalformedURLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return content;
    }
    
}
