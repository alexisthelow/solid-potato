package settings;

import java.util.ArrayList;
import java.util.Arrays;

public final class Settings {
    
    private static ScrapeType scrapeType;                   // what kind of scrape
    private static int maxPagesRead;                        // how many pages to read (for ScrapeType.TOTAL_PAGES) 
    private static String[] defaultList = new String[]{     // default list of words to ignore
            "a", "an", "and", "at", "if", 
            "is", "it", "in", "of", "on", 
            "or", "to", "the", "this", "that", 
            "which"  
    };
    
    // modifiable list of words to ignore
    private static ArrayList<String> stopWords = new ArrayList<String>(Arrays.asList(defaultList)); 
    
    /*
     * Default constructor for default settings.
     */
    
    public static void resetStopWordsToDefault() {
        stopWords = new ArrayList<String>(Arrays.asList(defaultList));
    }

    public static ScrapeType getScrapeType() {
        return scrapeType;
    }

    public static void setScrapeType(ScrapeType scrapeType) {
        Settings.scrapeType = scrapeType;
    }

    public static ArrayList<String> getStopWords() {
        return stopWords;
    }

    public static void setStopWords(ArrayList<String> stopWords) {
        Settings.stopWords = stopWords;
    }
    
    public static void addStopWord(String word) {
        Settings.stopWords.add(word);
    }
    
    public static void removeStopWord(String word) {
        Settings.stopWords.remove(word);
    }

    public static int getMaxPagesRead() {
        return maxPagesRead;
    }

    public static void setMaxPagesRead(int maxPagesRead) {
        if (maxPagesRead <= 0) { 
            Settings.maxPagesRead = 1; // minimum of 1, or else why are you even using this app
        }
        Settings.maxPagesRead = maxPagesRead;
    }

    public static String[] getDefaultList() {
        return defaultList;
    }

    public static void setDefaultList(String[] defaultList) {
        Settings.defaultList = defaultList;
    }
    
}
