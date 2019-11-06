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
        s.add("fuck", "www.gay.com");
        s.add("fuck", "www.die.com");
        s.add("the", "www.google.com");
        s.add("police", "www.google.com");
        s.add("police", "www.google.com");
        s.add("police", "www.google.com");
        s.add("police", "www.gay.com");
        s.add("all", "www.google.com");
        s.add("all", "www.gay.com");
        s.add("all", "www.gay.com");
        s.add("day", "www.fuck.com");
        s.add("every", "www.fuck.com");
        s.add("day", "www.fuck.com");
        s.add("zebras", "www.fuck.com");
        s.add("aaaaaaa", "www.fuck.com");
        s.add("aaaaaaa", "www.fuck.com");
        s.add("aaaaaaa", "www.fuck.com");
        s.add("aaaaaaa", "www.google.com");
        s.add("aaaaaaa", "www.gay.com");
        s.add("aaaaaaa", "www.gay.com");
        s.add("aaaaaaa", "www.fuck.com");
        s.add("whooaaaaaa", "www.whoa.com");
        s.add("whooaaaaaa", "www.whoa.com");
        s.add("whooaaaaaa", "www.whoa.com");
        s.add("wooaaaaaah", "www.woah.com");
        
        System.out.println(s.toString());
    }

}
