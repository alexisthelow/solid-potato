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
import java.util.Arrays;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import linkedlist.StringLinkedList;


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
    
    public static void getWebPage(String webpage) { 
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
        try {
            Document doc = Jsoup.parse(file, "utf-8");
            Elements links = doc.select("a[href]");
            String text = doc.body().text();
            text = text.replaceAll("[^\\w\\s-]", "");
            text = text.replaceAll("-", " ");
            text = text.replaceAll("\\d", "");
            String[] textArray = text.split(" ");
            textArray = removeElements(textArray, "");
            for (String word : textArray) {
                words.add(word, webpage);
            }
//            for (Element element : links) {
//                System.out.println(webpage + element.attr("href"));
//            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    } 
    
    /*
     * Removes all elements matching key from given array.
     * Shamelessly cribbed from GeeksForGeeks.com.
     * @param arr The array from which elements are to be removed.
     * @param key The key defining the elements to be removed.
     */
    public static String[] removeElements(String[] arr, String key) 
    { 
          // Move all other elements to beginning  
          int index = 0; 
          for (int i=0; i<arr.length; i++) 
             if (!arr[i].equalsIgnoreCase("")) 
                arr[index++] = arr[i]; 
  
         // Create a copy of arr[]  
         return Arrays.copyOf(arr, index); 
    } 
    
    /*
     * Resets lists of things to empty lists.
     */
    public static void clearData() {
        words = new StringLinkedList();
        urls = new ArrayList<>();
        comments = new ArrayList<>();
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
        getWebPage(url); 
    } 

}