package linkedlist;

public class URLLinkedList {
    
    URLNode first;
    URLNode last;
    int size;
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
        
        URLNode next;
        String url;
        
        public URLNode(String url) {
            this.url = url;
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

    }
}
