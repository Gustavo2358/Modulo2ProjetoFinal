package CarRental.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void testEqualsIfPlateEquals(){
        Car car1 = new Car("x","a", "a", BigDecimal.valueOf(100.0));
        Car car2 = new Car("y","b", "a", BigDecimal.valueOf(100.0));
        assertEquals(car1, car2);
    }
    @Test
    void notEqualsIfPlateIdDifferent(){
        Car car1 = new Car("x","a", "a", BigDecimal.valueOf(100.0));
        Car car2 = new Car("x","a", "b", BigDecimal.valueOf(100.0));
        assertNotEquals(car1,car2);

    }
}