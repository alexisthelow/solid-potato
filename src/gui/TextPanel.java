package gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextPanel extends JPanel {
    
    JTextArea textArea;
    
    public TextPanel() {
        this.textArea = new JTextArea();
        setLayout(new BorderLayout());
        
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }
    
    public void appendText(String text) {
        textArea.append(text);
    }
    
    public void clearText() {
        this.textArea.setText("");
    }

}
