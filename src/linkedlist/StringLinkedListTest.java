package linkedlist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringLinkedListTest {

    StringLinkedList s;
    
    @BeforeEach
    void setUp() throws Exception {
        s = new StringLinkedList();
    }

    @AfterEach
    void tearDown() throws Exception {
        s = null;
    }

    @Test
    void test() {
        s.add("hi", "www.omg.com");
        s.add("hi", "www.sandwich.com");
        s.add("the", "www.google.com");
        s.add("omg", "www.google.com");
        s.add("omg", "www.google.com");
        s.add("omg", "www.google.com");
        s.add("omg", "www.omg.com");
        s.add("all", "www.google.com");
        s.add("all", "www.omg.com");
        s.add("all", "www.omg.com");
        s.add("day", "www.omg.com");
        s.add("every", "www.omg.com");
        s.add("day", "www.omg.com");
        s.add("zebras", "www.omg.com");
        s.add("aaaaaaa", "www.omg.com");
        s.add("aaaaaaa", "www.omg.com");
        s.add("aaaaaaa", "www.omg.com");
        s.add("aaaaaaa", "www.google.com");
        s.add("aaaaaaa", "www.sandwich.com");
        s.add("aaaaaaa", "www.sandwich.com");
        s.add("aaaaaaa", "www.omg.com");
        s.add("whooaaaaaa", "www.whoa.com");
        s.add("whooaaaaaa", "www.whoa.com");
        s.add("whooaaaaaa", "www.whoa.com");
        s.add("wooaaaaaah", "www.woah.com");
        
        System.out.println(s.toString());
    }

}