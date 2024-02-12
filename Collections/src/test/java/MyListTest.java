import Interfaces.MyList;
import MyCollections.MyArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MyListTest {
    private MyList<Car> List;

    @BeforeEach
    public void setUp() throws Exception {
        List = new MyArrayList<>();
        for(int i = 0;i < 100; i++){
            List.add(new Car("Brand" + i, i));
        }
    }
    @Test
    public void areElemInCarList(){
        assertTrue(List.add(new Car("BMW",1)));
        assertTrue(List.contains(new Car("BMW",1)));
        assertTrue(List.remove(new Car("BMW",1)));
        assertFalse(List.contains(new Car("BMW",1)));
    }
    @Test
    public void whenAdded100ElementsThenSizeMustBe100(){
        assertEquals(100, List.size());
    }
    @Test
    public void whenElementRemoveByIndexThenSizeMustBeDecreased(){
        assertTrue(List.removeAt(5));
        assertEquals(99, List.size());
    }
    @Test
    public void whenElementRemoveThenSizeMustBeDecreased(){
        Car car = new Car("Toyota",15);
        List.add(car);
        assertEquals(101, List.size());
        List.remove(car);
        assertEquals(100, List.size());
    }
    @Test
    public void whenNonExistentElementRemovedThenReturnFalse(){
        Car car = new Car("Toyota",15);
        assertFalse(List.remove(car));
        assertEquals(100, List.size());
    }
    @Test
    public void whenListClearedThenSizeMustBe0(){
        List.clear();
        assertEquals(0, List.size());
    }
    @Test
    public void whenIndexOutOfBoundsThenThrownException(){
        Exception exception = assertThrows(Exception.class, () -> {
            List.get(100);
        });
    }
    @Test
    public void methodGetReturnRightValue(){
        Car car = List.get(0);
        assertEquals("Brand0",car.getBrand());

    }
    @Test
    public void insertIntoMidle(){
        Car car = new Car("BMW",1);
        List.add(car,50);
        Car carFromList = List.get(50);
        assertEquals("BMW",carFromList.getBrand());
    }
    @Test
    public void insertIntoFirstPostition() {
        Car car = new Car("BMW", 1);
        List.add(car, 0);
        Car carFromList = List.get(0);
        assertEquals("BMW", carFromList.getBrand());
    }
    @Test
    public void insertIntoLastPosition() {
        Car car = new Car("BMW", 1);
        List.add(car, 100);
        Car carFromList = List.get(100);
        assertEquals("BMW", carFromList.getBrand());
    }
    @Test
    public void testForEach(){
        int index = 0;
        for (Car car : List){
            index++;
        }
        assertEquals(100,index);
    }
}