package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import gui.events.FormEvent;
import gui.listeners.FormListener;
import gui.listeners.UrlListener;

public class MainFrame extends JFrame {

    private Toolbar toolbar;
    private TextPanel textPanel;
    private FormPanel formPanel;
    
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
                System.out.println("URL entered into toolbar");
                System.out.println(url);
            }
            
        });
        
        formPanel.setFormListener(new FormListener() {

            @Override
            public void formEventOccurred(FormEvent e) {
                System.out.println("Form event occurred");
                for (String term : e.getSearchTerms()) {
                    System.out.println(term);
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
    
}
