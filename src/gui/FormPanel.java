package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.events.FormEvent;
import gui.listeners.FormListener;

public class FormPanel extends JPanel {

    // components
    private JLabel fieldLabel;
    private JTextField searchField;
    private JButton searchFieldButton;
//    private JList<String> searchList;
//    private JLabel listLabel;
//    private JButton searchListButton;
    
//    private DefaultListModel<String> listModel;
    
    
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
//        searchList = new JList<String>();
//        listLabel = new JLabel("Select terms:");
//        searchListButton = new JButton("Go");
        
        // set up components
//        listModel = new DefaultListModel<String>();
//        searchList.setModel(listModel);
//        searchList.setPreferredSize(new Dimension(110, 70));
//        searchList.setBorder(BorderFactory.createEtchedBorder());
        
        searchFieldButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                FormEvent fe = new FormEvent(this);
                String searchTerms = searchField.getText();
                String[] termArray = searchTerms.split(" ");
                fe.setSearchTerms(termArray);
                
                if (formListener != null) {
                    formListener.formEventOccurred(fe);
                }
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
        
        
        // search label
        gc.gridx = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(fieldLabel, gc);
        
        // search field
        gc.gridx = 1;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(searchField, gc);
        
        // second row
        
        gc.gridy++;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        gc.gridx = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 5);
        add(searchFieldButton, gc);
        
    }
    
//    public void populateSearchListBox(String[] words) {
//        //TODO
//    }
    
    public void setFormListener(FormListener fl) {
        this.formListener = fl;
    }
    
}
