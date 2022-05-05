package webapp;

import org.junit.Test;

import static org.junit.Assert.*;

// TODO: Auto-generated Javadoc
/**
 * The Class CalcTest.
 * @author Khizbullina I.F.
 */
public class CalcTest {

    /**
     * Calculate.
     */
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