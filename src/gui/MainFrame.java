package gui;

import java.awt.BorderLayout;
import java.util.LinkedList;

import javax.swing.JFrame;

import engine.PageScraper;
import gui.events.FormEvent;
import gui.listeners.FormListener;
import gui.listeners.UrlListener;
import linkedlist.StringLinkedList.StringNode;

public class MainFrame extends JFrame {

    // frame components
    private Toolbar toolbar;
    private TextPanel textPanel;
    private FormPanel formPanel;
    
    // engine components
    private PageScraper ps;
    
    public MainFrame() {
        
        // make pretty
        super("Solid Potato");
        setLayout(new BorderLayout());
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // create components
        
        toolbar = new Toolbar();
        textPanel = new TextPanel();
        formPanel = new FormPanel();
        
        // set up listeners
        toolbar.setUrlListener(new UrlListener() {

            @Override
            public void urlEmitted(String url) {
                ps = new PageScraper();
                
                ps.scrapePage(url);
                textPanel.appendText(ps.getWords().toString());
            }
            
        });
        
        formPanel.setFormListener(new FormListener() {

            @Override
            public void formEventOccurred(FormEvent e) {
                System.out.println("Form event occurred");
                
                if (ps != null) { // a scrape has occurred
                    // empty the text area 
                    textPanel.clearText();
                    
                    String[] terms = e.getSearchTerms();
                    
                    // check for OR
                    boolean orFound = false;
                    for (String term : terms) {
                        if (term.equals("OR")) {
                            orFound = true;
                        }
                    }
//                    if (orFound) { // deal with OR terms
//                        LinkedList<String> orTerms = new LinkedList<>();
//                        LinkedList<String> andTerms = new LinkedList<>();
//                        
//                        for (int i = 0; i < terms.length; i++) {
//                            if (terms[i] != null && terms[i].equals("OR")) {
//                                // grab previous term, grab next term, set both and OR to null
//                                terms[i] = null;
//                                if (i - 1 >= 0) { // don't look beyond beginning of array
//                                    orTerms.add(terms[i - 1]);
//                                    terms[i - 1] = null;
//                                }
//                                if (i + 1 <= terms.length - 1) { // don't look beyond end of array
//                                    orTerms.add(terms[i + 1]);
//                                    terms[i + 1] = null;
//                                }
//                            } // extracted OR terms, rest of terms can go into AND array
//                        }
//                        for (int i = 0; i < terms.length; i++) {
//                            if (terms[i] != null) {
//                                andTerms.add(terms[i]);
//                            }
//                        }
//                    }
//                    else { // proceed as normal
                        for (String term : terms) {
                            StringNode node = ps.getWords().locate(term);
                            if (node != null) {
                                textPanel.appendText(node.toString());
                            }
                        }
//                    }
                    
                    
                    
                }
            }
            
        });
        
        // add components to frame
        add(toolbar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        add(formPanel, BorderLayout.WEST);
        
        // gogogo
        setVisible(true);
    }
    
//    public LinkedList<StringNode> getOrSearchResults(LinkedList<String> orTerms, LinkedList<String> andTerms) {
//        
//    }
    
}
