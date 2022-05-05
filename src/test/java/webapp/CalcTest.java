package webapp;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalcTest {

    @Test
    public void calculate() {
        Order order = new Order("Surname", "Name", "Patronymic", "Address", "Date", "Time",
                "10", "Генеральная",
                "Полировка полов", "", "", "", "",
                "", "", "");
        order.Calculate();
        boolean pass = false;
        if (order.getPrice() != 0) {
            fail();
        }
    }
}