package engine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList; 


/*
 * This class is for downloading webpages and extracting a variety of useful information.
 * Part of the code was taken from code written by Nishu Aggarwal for GeeksForGeeks.org.
 * The rest of it was written by Alexis Low.
 */
public class WebpageDownloaderAndScraper9001 {
    
    private ArrayList<String> urls;
    private ArrayList<String> images;
    private ArrayList<String> comments;
    private static int pagesRead = 0;
    
    public static void getWebPage(String webpage) { 
        
        File file = new File("page" + pagesRead + ".html");
        try { 
            file.createNewFile();
  
            // Create URL object 
            URL url = new URL(webpage); 
            BufferedReader readr = new BufferedReader(new InputStreamReader(url.openStream())); 
  
            // Enter filename in which you want to download 
            BufferedWriter writer =  
              new BufferedWriter(new FileWriter(file)); 
              
            // read each line from stream till end 
            String line; 
            while ((line = readr.readLine()) != null) { 
                writer.write(line); 
                writer.write("\n");
            }
  
            readr.close(); 
            writer.close(); 
            System.out.println("Successfully Downloaded."); 
            
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            while((line = fileReader.readLine()) != null) {
                // if the line contains a link, put it in links
                // if the line contains a comment, put it in comments
                // if the line contains words:
                    // check to see if the word already has a node in the StringLinkedList
                        // if it does, does that StringNode's associated UrlLinkedList already have the current URL?
                            // if it does, increment the counter at that UrlNode
                            // if it does not, add it and set its counter to 1
                        // if it does not, add the word to the StringLinkedList, add the URL to the UrlLinkedList,
            }
        } 
  
        // Exceptions 
        catch (MalformedURLException mue) { 
            System.out.println("Malformed URL Exception raised"); 
        } 
        catch (IOException ie) { 
            System.out.println("IOException raised"); 
            System.out.println(ie.getMessage());
        } 
    } 
    public static void main(String args[]) 
        throws IOException 
    { 
        String url = "http://www.chinese-poems.com/"; 
        getWebPage(url); 
    } 

}
