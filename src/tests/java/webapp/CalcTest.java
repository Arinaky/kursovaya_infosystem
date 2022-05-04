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
        assertTrue(order.getPrice() == 10050);
    }
}