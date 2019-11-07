package linkedlist;

public class URLLinkedList {
    
    private URLNode first;
    private URLNode last;
    private int size;
    //TODO this should probably also track the number of times each word was found on each page
    
    public void add(String url) {
        URLNode node = new URLNode(url);
        if (first == null) {
            first = node;
            last = node;
        }
        else {
            last.setNext(node);
            last = node;
        }
        size++;
    }
    
    public URLNode locate(String url) {
        URLNode current = first;
        while (true) {
            if (current.getUrl().equalsIgnoreCase(url)) {
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
    
    private class URLNode {
        
        private URLNode next;       // pointer to next node
        private String url;         // a potato, definitely not a url
        private int timesAppeared;  // # of times the word contained in the parent StringNode appeared at this url
        
        
        public URLNode(String url) {
            this.url = url;
            this.timesAppeared = 1;
        }

        public boolean hasNext() {
            return next == null ? false : true;
        }
        
        public URLNode getNext() {
            return next;
        }

        public void setNext(URLNode next) {
            this.next = next;
        }

        public String getUrl() {
            return url;
        }
        
        public int getTimesAppeared() {
            return timesAppeared;
        }

        public void setTimesAppeared(int timesAppeared) {
            this.timesAppeared = timesAppeared;
        }

        public void setUrl(String url) {
            this.url = url;
        }
        
        public void incrementCounter() {
            this.timesAppeared++;
        }
        
        public int compareTo(URLNode other) {
            return timesAppeared == other.getTimesAppeared() ? 0 : timesAppeared > other.getTimesAppeared() ? -1 : 1;
        }
        
        public String toString() {
            return "URL: " + this.getUrl() + " Times appeared: " + this.getTimesAppeared() + " Has next?: " + this.hasNext();
        }


    }
}
