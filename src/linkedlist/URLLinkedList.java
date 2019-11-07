package linkedlist;

public class URLLinkedList {
    
    private URLNode first;
    private URLNode last;
    private int size;

    public void add(String url) {
        
        // check to see if it's already in this list
        URLNode check = locate(url);
        if (check == null) { // url not in the list
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
        else { // url is already in the list
            check.incrementCounter();
        }
    }
    
    public URLNode locate(String url) {
        URLNode current = first;
        if (first == null) {
            return null;
        }
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
    
    
    public URLNode getFirst() {
        return first;
    }

    public void setFirst(URLNode first) {
        this.first = first;
    }

    public URLNode getLast() {
        return last;
    }

    public void setLast(URLNode last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        URLNode current = this.getFirst();
        if (current == null) {
            return null;
        }
        else {
            int counter = 0;
            sb.append("URL #" + counter++ + ": " + current.toString() + " ||| ");
            while(current.hasNext()) {
                current = current.getNext();
                sb.append("URL #" + counter++ + ": " + current.toString() + " ||| ");
            }
            return sb.toString();
        }
    }
    
    
    
    public class URLNode {
        
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