package CarRental.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void testEqualsIfPlateEquals(){
        Car car1 = new Car("x","a", "a", 100.0);
        Car car2 = new Car("y","b", "a", 100.0);
        assertEquals(car1, car2);
    }
    @Test
    void notEqualsIfPlateIdDifferent(){
        Car car1 = new Car("x","a", "a", 100.0);
        Car car2 = new Car("x","a", "b", 100.0);
        assertNotEquals(car1,car2);

    }
}