package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.listeners.UrlListener;

public class Toolbar extends JPanel implements ActionListener {
    
    private JLabel enterUrlLabel;
    private JTextField urlField;
    private JButton scanButton;
    private UrlListener urlListener;
    
    public Toolbar() {
        
        // make pretty
        setBorder(BorderFactory.createEtchedBorder());
        setLayout(new FlowLayout(FlowLayout.CENTER));
        
        // create components
        urlField = new JTextField(30);
        enterUrlLabel = new JLabel("Enter URL:");
        scanButton = new JButton("Scan");
        scanButton.addActionListener(this);
        
        // add components
        add(enterUrlLabel);
        add(urlField);
        add(scanButton);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        urlListener.urlEmitted(urlField.getText());
    }
    
    public void setUrlListener(UrlListener listener) {
        this.urlListener = listener;
    }

}
