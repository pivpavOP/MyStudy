import Interfaces.MySet;
import MyCollections.MyHashSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySetTest {
    private MySet<Car> carSet;

    @BeforeEach
    public void setUp() throws Exception {
        carSet = new MyHashSet();
        for (int i = 0; i < 100; i++) {
            carSet.add(new Car("Brand" + i, i));
        }
    }
    @Test
    public void areElemInCarSet(){
        assertTrue(carSet.add(new Car("Toyota",1)));
        assertTrue(carSet.contains(new Car("Toyota",1)));
        assertTrue(carSet.remove(new Car("Toyota",1)));
        assertFalse(carSet.contains(new Car("Toyota",1)));
    }
    @Test
    void WhenWeAddThreeEqualsElements() {
        assertEquals(100, carSet.size());
        assertTrue(carSet.add(new Car("BMW", 4)));
        assertFalse(carSet.add(new Car("BMW", 4)));
        assertFalse(carSet.add(new Car("BMW", 4)));
        assertEquals(101, carSet.size());
    }


    @Test
    void WhenRemoveElementThenSizeDecresed() {
        assertTrue(carSet.remove(new Car("Brand30", 30)));
        assertEquals(99, carSet.size());
        assertFalse(carSet.remove(new Car("Brand30", 30)));
        assertEquals(99, carSet.size());
    }


    @Test
    void whenSetClearedThenSize0() {
        carSet.clear();
        assertEquals(0, carSet.size());
    }
    @Test
    public void testForEach(){
        int index = 0;
        for (Car car : carSet){
            index++;
        }
        assertEquals(100,index);
    }
}