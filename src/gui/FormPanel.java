package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.listeners.FormListener;

public class FormPanel extends JPanel {

    // components
    private JTextField searchField;
    private JLabel fieldLabel;
    private JButton searchFieldButton;
    private JList<String> searchList;
    private JLabel listLabel;
    private JButton searchListButton;
    
    private DefaultListModel<String> listModel;
    
    
    // listener
    private FormListener formListener;
    
    public FormPanel() {
       
        // make pretty
        Dimension d = getPreferredSize();
        d.width = 300;
        setPreferredSize(d);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5), BorderFactory.createTitledBorder("Word Search")));
        
        // create components
        searchField = new JTextField(20);
        fieldLabel = new JLabel("Enter search terms:");
        searchFieldButton = new JButton("Go");
        searchList = new JList<String>();
        listLabel = new JLabel("Select terms:");
        searchListButton = new JButton("Go");
        
        // set up components
        listModel = new DefaultListModel<String>();
        searchList.setModel(listModel);
        searchList.setPreferredSize(new Dimension(110, 70));
        searchList.setBorder(BorderFactory.createEtchedBorder());
        
        searchFieldButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO -- get all the search terms from the box, pack em into an array, pack into a formevent and put it in the formlistener
                
            }
            
        });
        
        searchListButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO -- get terms from list, put in array, put in form event, send to formlistener
            }
        });
        
        layoutComponents();
        
    }
    
    public void layoutComponents() {
        
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        
        // first row
        
        gc.gridy = 0;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        
    }
    
    public void populateSearchListBox(String[] words) {
        //TODO
    }
    
}
