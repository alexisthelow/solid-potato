package engine;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import linkedlist.StringLinkedList;

public class PageScraperTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        PageScraper.getWebPage("http://www.chinese-poems.com/");
        StringLinkedList words = PageScraper.getWords();
        System.out.println(words.toString());
        
    }

}