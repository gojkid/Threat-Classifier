/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentingTheResult;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Souvik
 */
public class tools {
    
//This method returns the contents of a file
    // f - The file whose contents are to be extracted
    @SuppressWarnings("ConvertToTryWithResources")
   public static String FileToString(File f) throws FileNotFoundException, IOException {
        String file = "";
        FileInputStream fis = new FileInputStream(f);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String feed = br.readLine();
        while (!feed.isEmpty()) {
            file = file + feed + " ";
            feed = br.readLine();
        }
        br.close();
        isr.close();
        fis.close();
        return file;
    }
    
    //This method returns the contents of a web address. Tries to remove as much as shit possible.
    //url - The complete web address in a string format
    
    public static String getContents(String url) throws MalformedURLException, IOException
    {
        URL u=new URL(url.toString()); // the url object for that particular string
URLConnection conn=u.openConnection(); // a new connection is created agains the url
conn.connect(); //connecting with the new url
BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream())); 
String inputLine="",buffer=""; 
while ((inputLine = in.readLine()) != null) {
if(inputLine.startsWith("{") || inputLine.endsWith("}")  || 
  inputLine.startsWith("(") || inputLine.endsWith(")")  || 
   inputLine.startsWith("[") || inputLine.endsWith("]")  || 
    inputLine.startsWith("_") || inputLine.endsWith(";") ||
        inputLine.contains("$") || inputLine.contains("#") ||
        inputLine.contains("{") || inputLine.contains("if(") ||
        inputLine.contains("else{")|| (inputLine.contains("else") ))
;
else
buffer = buffer +inputLine; 
}
//replacing these symbols from the buffer
buffer=buffer.replaceAll("<br>", "\n");
buffer=buffer.replaceAll("\\<[^>]*>","");
buffer=buffer.replaceAll("&nbsp;"," ");
buffer=buffer.replaceAll("&amp;","&");
buffer=buffer.replaceAll("&lt;","<");
buffer=buffer.replaceAll("&gt;",">");
buffer=buffer.replaceAll("&cent;","¢");
buffer=buffer.replaceAll("&pound;","£");
buffer=buffer.replaceAll("&yen;","¥");
buffer=buffer.replaceAll("&euro;","€");
buffer=buffer.replaceAll("&sect;","§");
buffer=buffer.replaceAll("&copy;","©");
buffer=buffer.replaceAll("&reg;","®");
buffer=buffer.replaceAll("&trade;","™");
buffer=buffer.replaceAll("|", "");
return buffer;
    }
    
    //Converting an large array into a single String string
    //This needs not to be bothered with. Used only to enhance the performance of reading/writing from the database.
    public static String ArrayToString(String arr[])
    {
        String res="";
        for(int i=0;i<arr.length;i++)
            res=res+arr[i]+",";
        return res;
    }
}
