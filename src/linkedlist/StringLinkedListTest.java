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
        s.add("fuck");
        s.printToConsole();
        s.add("the");
        s.printToConsole();
        s.add("police");
        s.printToConsole();
        s.add("all");
        s.printToConsole();
        s.add("day");
        s.printToConsole();
        s.add("every");
        s.printToConsole();
        s.add("day");
        s.printToConsole();
        s.add("zebras");
        s.printToConsole();
        s.add("aaaaaaa");
        s.printToConsole();
    }

}
