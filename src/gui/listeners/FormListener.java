package gui.listeners;

import java.util.EventListener;

import gui.events.FormEvent;

public interface FormListener extends EventListener {

    public void formEventOccurred(FormEvent e);
    
}
