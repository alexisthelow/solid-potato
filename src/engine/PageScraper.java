package engine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import linkedlist.StringLinkedList;
import settings.ScrapeType;
import settings.Settings;


/*
 * This class is for downloading webpages and extracting a variety of useful information.
 * Part of the code was taken from code written by Nishu Aggarwal for GeeksForGeeks.org.
 * The rest of it was written by Alexis Low.
 */
public class PageScraper {
    
    private static StringLinkedList words = new StringLinkedList();
    private static ArrayList<String> urls = new ArrayList<>();
    private static ArrayList<String> comments = new ArrayList<>();
    private static int pagesRead = 0;
    
    public static void scrapePage(String webpage) { 
        File file = new File("page" + pagesRead + ".html");
        try { 
            file.createNewFile();
  
            // Create URL object 
            URL url = new URL(webpage); 
            BufferedReader readr = new BufferedReader(new InputStreamReader(url.openStream())); 
  
            // Enter filename in which you want to download 
            BufferedWriter writer = new BufferedWriter(new FileWriter(file)); 
              
            // read each line from stream till end 
            String line; 
            while ((line = readr.readLine()) != null) { 
                writer.write(line); 
                writer.write("\n");
            }
  
            readr.close(); 
            writer.close(); 
            System.out.println("Successfully Downloaded."); 
        } 
        // Exceptions 
        catch (MalformedURLException mue) { 
            System.out.println(mue.getMessage());
        } 
        catch (IOException ie) { 
            System.out.println(ie.getMessage());
        } 
        // finished reading page
        
        // scrape downloaded page
        try {
            Document doc = Jsoup.parse(file, "utf-8");
            
            // scrape text
            String text = doc.body().text();
            // remove all the garbage
            text = text.replaceAll("[^\\w\\s-]", "");
            text = text.replaceAll("-", " ");
            text = text.replaceAll("\\d", "");
            String[] textArray = text.split(" ");
            textArray = removeElements(textArray, "");
            for (String word : textArray) {
                words.add(word, webpage);
            }
            
            // scrape links
            Elements links = doc.select("a[href]");
            for (Element element : links) {
                System.out.println(webpage + element.attr("href"));
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        pagesRead++;
        // finished scraping
        
        // move on to the next set of pages
        if (Settings.getScrapeType() == ScrapeType.TOTAL_PAGES) {
            
        }
        else if (Settings.getScrapeType() == ScrapeType.SAME_SITE) {
            
        }
        
        
        
    } 
    
    /*
     * Removes all elements matching key from given array.
     * Based on code from GeeksForGeeks.com.
     * @param arr The array from which elements are to be removed.
     * @param key The key defining the elements to be removed.
     */
    public static String[] removeElements(String[] array, String key) 
    { 
          int index = 0; 
          for (int i = 0; i < array.length; i++) 
             if (!array[i].equalsIgnoreCase(""))    // if the index isn't an empty string
                 array[index++] = array[i];         // move it to the front 
  
         // Create a copy of arr[]  
         return Arrays.copyOf(array, index); 
    } 
    
    /*
     * Resets lists of things to empty lists.
     */
    public static void clearData() {
        words = new StringLinkedList();
//        urls = new ArrayList<>();
//        comments = new ArrayList<>();
        pagesRead = 0;
    }
    
    public static StringLinkedList getWords() {
        return words;
    }

    public static void setWords(StringLinkedList words) {
        PageScraper.words = words;
    }

    public static ArrayList<String> getUrls() {
        return urls;
    }

    public static void setUrls(ArrayList<String> urls) {
        PageScraper.urls = urls;
    }

    public static ArrayList<String> getComments() {
        return comments;
    }

    public static void setComments(ArrayList<String> comments) {
        PageScraper.comments = comments;
    }

    public static int getPagesRead() {
        return pagesRead;
    }

    public static void setPagesRead(int pagesRead) {
        PageScraper.pagesRead = pagesRead;
    }

    /*
     * For testing. Delete before release.
     */
    public static void main(String args[]) throws IOException { 
        String url = "http://www.chinese-poems.com/"; 
        scrapePage(url); 
    } 

}
