package linkedlist;

import settings.Settings;

public class StringLinkedList {
    
    StringNode first;                   // pointer to the first node
    int size;                           // the number of elements in this list
    
    
    
    
    public StringLinkedList() {
        super();
    }

    /*
     * Adds specified word to a new StringNode, which is added to the list alphabetically.
     * @param word The word to be added to the StringNode.
     */
    public void add(String word, String url) {
        
        // don't need to add this word if it's a stop word
        for (String stopWord : Settings.getStopWords()) {
            if (word.equalsIgnoreCase(stopWord)) return;
        }
        
        // don't need to add this word if it's already in here
        StringNode check = locate(word);
        if (check != null) {
            check.getPagesContainingWord().add(url);
            return;
        }
        
        // not a stop word, not present--need to add it
        StringNode newNode = new StringNode(word, new URLLinkedList());
        newNode.getPagesContainingWord().add(url);
        if (first == null) { // if first is null, there's nothing in the list
            first = newNode; // set first to this new node
            newNode.getPagesContainingWord().add(url);
        }
        else { // first isn't null, so we want to find the correct place to put this new node
            StringNode current = first;
            // this barebones linked list is very inconvenient, so we have to make a special 
            // check for the first item in the list.
            if (word.compareTo(current.getWord()) < 0) { // the word in the new node goes before the word in the first node
                first = newNode; // now the new node is the first one
                newNode.setNext(current); // and its next is the old first one
            }
            else if (!current.hasNext()) { // no next node, so this word goes after current
                current.setNext(newNode);
            }
            else { // new node doesn't go before first, so check the rest of the list
                boolean newNodePlaced = false;
                StringNode previous;
                while (current.hasNext() && !newNodePlaced) { 
                    previous = current;
                    current = current.getNext(); // grab next node
                    if (word.compareTo(current.getWord()) < 0) { // new word goes before this one
//                        StringNode oldNext = current.getNext();
//                        current.setNext(newNode);
//                        newNode.setNext(oldNext);
//                        newNodePlaced = true;
                        previous.setNext(newNode);
                        newNode.setNext(current);
                        newNodePlaced = true;
                    }
                }
                if (!newNodePlaced) { // if we're here and haven't yet placed the node, it goes at the end
                    current.setNext(newNode);
                }
            }
        }
        size++;
    }
    
    /*
     * Checks the list for the given word. If present, returns the StringNode containing the word.
     * If not present, returns null.
     * @param word The word to be found.
     */
    public StringNode locate(String word) {
        StringNode current = first;
        while (true) {
            if (current == null) {
                return null;
            }
            if (current.getWord().equalsIgnoreCase(word)) {
                return current;
            }
            else {
                if (current.hasNext()) {
                    current = current.getNext();
                }
                else {
                    return null;
                }
            }
        }
    }
    
    /*
     * Returns the size of this StringLinkedList.
     */
    public int size() {
        return size;
    }
    
    /*
     * Returns the first StringNode in this list.
     */
    public StringNode getFirst() {
        return first;
    }

    /*
     * Sets this list's first StringNode to the given StringNode.
     * @param first The StringNode to be set.
     */
    public void setFirst(StringNode first) {
        this.first = first;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringNode current = this.first;
        int counter = 0;
        sb.append("Size: " + this.size() + "\n");
        sb.append("Node #" + counter++ + ": " + current.toString());
        while(current.hasNext()) {
            current = current.getNext();
            sb.append("Node #" + counter++ + ": " + current.toString());
        }
        return sb.toString();
    }

    /*
     * A local class describing the nodes of a StringLinkedList.
     */
    public class StringNode {
       
        StringNode next;                    // pointer to the next node
        String word;                        // this node's word
        URLLinkedList pagesContainingWord;  // linked list of urls containing this node's word
        
        public StringNode(String word, URLLinkedList pagesContainingWord) {
            
            super();
            this.word = word;
            this.pagesContainingWord = new URLLinkedList();
            
        }

        public boolean hasNext() {
            return this.next == null ? false : true;
        }
        
        public StringNode getNext() {
            return next;
        }

        public void setNext(StringNode next) {
            this.next = next;
        }

        public String getWord() {
            return word;
        }

        public URLLinkedList getPagesContainingWord() {
            return pagesContainingWord;
        }
        
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Word: " + this.getWord() + "\n");
            sb.append(this.getPagesContainingWord().toString());
            sb.append("\n");
            return sb.toString();
        }
    }
}