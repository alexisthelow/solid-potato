package engine;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PageTest {
    
    String url = "http://www.ashidakim.com/zenkoans/";

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        ArrayList<String> urls = new ArrayList<String>();
        Page p;
        try {
            p = new Page(url); //where name is a string of the complete Url including the http://);
        } catch (Exception ee) {
           return;
        } 
        while (p != null && !p.pageDone()) {
            while (p != null && !p.pageDone()) {
                String line = p.getLine();            // reads a line from this webpage
            } 
            ArrayList<String> links = p.getLinks();   // get extracted links
            for (int i = 0; i < links.size(); i++) {
                urls.add(links.get(i));               // add these links to the arrayList of known links
            }
//            if (++current_url >= urls.size())    p = null;
//            else {
//                do {
//                    try {
//                        p = new Page(urls.get(current_url));
//                    } catch (Exception eee) { //bad url - just ignore
//                        current_url++;
//                    }
//                } while (current_url < urls.size() && p == null);
//            }
//            if (++siteCount >= MAXSITES)  break;
//            
        }
        for (String string : urls) {
            System.out.println(string);
        }
    }

}
