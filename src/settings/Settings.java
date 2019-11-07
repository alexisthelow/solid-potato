package settings;

import java.util.ArrayList;
import java.util.Arrays;

public class Settings {
    
    private static ScrapeType scrapeType;               // page depth or same site
    private static int maxPageDepth;                    // how deep to follow links
    public static String[] defaultList = new String[]{  // default list of words to ignore
            "a", "an", "and", "at", "if", 
            "is", "it", "in", "of", "on", 
            "or", "to", "the", "this", "that", 
            "which"  
    };
    
    // actual list of words to ignore
    private static ArrayList<String> stopWords = new ArrayList<String>(Arrays.asList(defaultList)); 
    /*
     * Default constructor for default settings.
     */
    public Settings() {
        scrapeType = ScrapeType.SAME_SITE;
        maxPageDepth = 0;
        stopWords = new ArrayList<String>(Arrays.asList(defaultList));
    }

    public static ScrapeType getScrapeType() {
        return scrapeType;
    }

    public static void setScrapeType(ScrapeType scrapeType) {
        Settings.scrapeType = scrapeType;
    }

    public static int getPageDepth() {
        return maxPageDepth;
    }

    public static void setPageDepth(int pageDepth) {
        Settings.maxPageDepth = pageDepth;
    }

    public static ArrayList<String> getStopWords() {
        return stopWords;
    }

    public static void setStopWords(ArrayList<String> stopWords) {
        Settings.stopWords = stopWords;
    }
    
}
