package engine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import linkedlist.StringLinkedList;
import settings.ScrapeType;
import settings.Settings;


/*
 * This class is for downloading webpages and extracting words.
 * Part of the code was taken from code written by Nishu Aggarwal for GeeksForGeeks.org.
 * The rest of it was written by Alexis Low.
 */
public class PageScraper {
    
    private static StringLinkedList words = new StringLinkedList(); 
    private static LinkedBlockingDeque<String> pagesToVisit = new LinkedBlockingDeque<>();
    private static LinkedList<String> visitedPages = new LinkedList<String>();
    private static int pagesRead = 0;
    private static String baseUrl = null;
    
    public static void scrapePage(String webpage) { 
        if (baseUrl == null) baseUrl = webpage; // need to keep track of this 
        File file = new File("page" + pagesRead + ".html");
        System.out.println("Scraping " + webpage + "...");
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
            System.out.println("Success."); 
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
            
            // scrape links and queue up to visit
            Elements links = doc.select("a");
            for (Element link : links) {
                String absUrl = link.absUrl("href");
                if (!visitedPages.contains(absUrl) && !absUrl.equalsIgnoreCase("")) {
                    pagesToVisit.add(absUrl);
                }
            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // update variables
        pagesRead++;
        visitedPages.add(webpage);
        file.deleteOnExit();
        // finished scraping, move on to the next set of pages
        
        // limiting by total pages
        if (Settings.getScrapeType() == ScrapeType.TOTAL_PAGES) {
            for (String link : pagesToVisit) {
                if (pagesRead < Settings.getMaxPagesRead() && !visitedPages.contains(link)) {
                    scrapePage(link);
                }
            }
        }
        // limiting by same site
        else if (Settings.getScrapeType() == ScrapeType.SAME_SITE) {
            for (String link : pagesToVisit) {
                if (link.startsWith(baseUrl) && !visitedPages.contains(link)) {
                    scrapePage(link);
                }
            }
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
        pagesRead = 0;
    }
    
    public static StringLinkedList getWords() {
        return words;
    }

    public static void setWords(StringLinkedList words) {
        PageScraper.words = words;
    }

    public static int getPagesRead() {
        return pagesRead;
    }

    public static void setPagesRead(int pagesRead) {
        PageScraper.pagesRead = pagesRead;
    }
    
    public static LinkedBlockingDeque<String> getPagesToVisit() {
        return pagesToVisit;
    }

    public static void setPagesToVisit(LinkedBlockingDeque<String> pagesToVisit) {
        PageScraper.pagesToVisit = pagesToVisit;
    }

    public static LinkedList<String> getVisitedPages() {
        return visitedPages;
    }

    public static void setVisitedPages(LinkedList<String> visitedPages) {
        PageScraper.visitedPages = visitedPages;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static void setBaseUrl(String baseUrl) {
        PageScraper.baseUrl = baseUrl;
    }

    /*
     * For testing. Delete before release.
     */
    public static void main(String args[]) throws IOException { 
        Settings.setScrapeType(ScrapeType.SAME_SITE);
        Settings.setMaxPagesRead(30);
        String url = "http://www.ashidakim.com/zenkoans/zenindex.html"; 
        scrapePage(url); 
        System.out.println(PageScraper.getWords().toString());
    } 

}
