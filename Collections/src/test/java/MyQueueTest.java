import Interfaces.MyQueue;
import MyCollections.MyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {
    private MyQueue<Car> queue;

    @BeforeEach
    void setUp() throws Exception{
        queue = new MyLinkedList();
        for(int i = 0; i < 10; i++){
            queue.add(new Car("Brand" + i,i));
        }
    }

    @Test
    void add() {
        assertEquals(10,queue.size());
    }

    @Test
    void peek() {
        Car car = queue.peek();
        assertEquals("Brand0",car.getBrand());
        assertEquals(10,queue.size());
    }

    @Test
    void poll() {
        Car car = queue.poll();
        assertEquals("Brand0",car.getBrand());
        assertEquals(9,queue.size());
    }
}