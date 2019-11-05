package gui.events;

import java.util.EventObject;

public class FormEvent extends EventObject {

    private String[] searchTerms;
    
    public FormEvent(Object source) {
        super(source);
    }
    
    public FormEvent(Object source, String[] searchTerms) {
        super(source);
        this.searchTerms = searchTerms;
    }

    public String[] getSearchTerms() {
        return searchTerms;
    }

    public void setSearchTerms(String[] searchTerms) {
        this.searchTerms = searchTerms;
    }
    
}
