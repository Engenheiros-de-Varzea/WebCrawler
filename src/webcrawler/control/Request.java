package webcrawler.control;

import webcrawler.auxiliar.HTTPStatusCode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Paulo Henrique
 */

public class Request {
    
    public static String getRequest(String URL) throws MalformedURLException, IOException {
        HttpURLConnection con = (HttpURLConnection) new URL(URL).openConnection();
        
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("Accept", "*/*");
        
        String inputLine, response = "";
        try ( BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())) ) {
            while((inputLine = in.readLine()) != null) {
                response += inputLine;
            }
            if(con.getResponseCode() != 200){ System.out.println(URL + "\n" + HTTPStatusCode.getMessage(con.getResponseCode()) + "\n"); }
            return response;
        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
            return "";
        } finally {
            con.disconnect();
        }
    }
    
}
