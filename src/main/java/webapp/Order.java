package webapp;

import java.io.IOException;
import java.util.HashSet;

// TODO: Auto-generated Javadoc
/**
 * The Class Order.
 * @author Khizbullina I.F.
 */
public class Order {

    /**
     * Gets the surname calc.
     *
     * @return the surname calc
     */
    // Получить данные о заказе
    public String getSurname_calc() {return surname_calc;}
    
    /**
     * Gets the name calc.
     *
     * @return the name calc
     */
    public String getName_calc() {return name_calc;}
    
    /**
     * Gets the patronymic calc.
     *
     * @return the patronymic calc
     */
    public String getPatronymic_calc() {return patronymic_calc;}
    
    /**
     * Gets the address calc.
     *
     * @return the address calc
     */
    public String getAddress_calc() {return address_calc;}
    
    /**
     * Gets the date calc.
     *
     * @return the date calc
     */
    public String getDate_calc() {return date_calc;}
    
    /**
     * Gets the time calc.
     *
     * @return the time calc
     */
    public String getTime_calc() {return time_calc;}
    
    /**
     * Gets the clean area calc.
     *
     * @return the clean area calc
     */
    public String getClean_area_calc() {return clean_area_calc;}
    
    /**
     * Gets the clean type calc.
     *
     * @return the clean type calc
     */
    public String getClean_type_calc() {return clean_type_calc;}
    
    /**
     * Gets the clean services.
     *
     * @return the clean services
     */
    public HashSet<String> getClean_services() {return clean_services;}
    
    /**
     * Gets the price.
     *
     * @return the price
     */
    public int getPrice() {return price;}
    
    /** The surname calc. */
    // Данные о заказе
    private String surname_calc;
    
    /** The name calc. */
    private String name_calc;
    
    /** The patronymic calc. */
    private String patronymic_calc;
    
    /** The address calc. */
    private String address_calc;
    
    /** The date calc. */
    private String date_calc;
    
    /** The time calc. */
    private String time_calc;
    
    /** The clean area calc. */
    private String clean_area_calc;
    
    /** The clean type calc. */
    private String clean_type_calc;
    
    /** The clean services. */
    private HashSet<String> clean_services = new HashSet<>();
    
    /** The price. */
    private int price = 0;

    /**
     * Instantiates a new order.
     *
     * @param surname_calc the surname calc
     * @param name_calc the name calc
     * @param patronymic_calc the patronymic calc
     * @param address_calc the address calc
     * @param date_calc the date calc
     * @param time_calc the time calc
     * @param clean_area_calc the clean area calc
     * @param clean_type_calc the clean type calc
     * @param clean_service_1_calc the clean service 1 calc
     * @param clean_service_2_calc the clean service 2 calc
     * @param clean_service_3_calc the clean service 3 calc
     * @param clean_service_4_calc the clean service 4 calc
     * @param clean_service_5_calc the clean service 5 calc
     * @param clean_service_6_calc the clean service 6 calc
     * @param clean_service_7_calc the clean service 7 calc
     * @param clean_service_8_calc the clean service 8 calc
     */
    // Создание заказа
    public Order(String surname_calc, String name_calc, String patronymic_calc, String address_calc, String date_calc, String time_calc, String clean_area_calc, String clean_type_calc, String clean_service_1_calc, String clean_service_2_calc, String clean_service_3_calc, String clean_service_4_calc, String clean_service_5_calc, String clean_service_6_calc, String clean_service_7_calc, String clean_service_8_calc) {
        this.surname_calc = surname_calc;
        this.name_calc = name_calc;
        this.patronymic_calc = patronymic_calc;
        this.address_calc = address_calc;
        this.date_calc = date_calc;
        this.time_calc = time_calc;
        this.clean_area_calc = clean_area_calc;
        this.clean_type_calc = clean_type_calc;
        clean_services.add(clean_service_1_calc);
        clean_services.add(clean_service_2_calc);
        clean_services.add(clean_service_3_calc);
        clean_services.add(clean_service_4_calc);
        clean_services.add(clean_service_5_calc);
        clean_services.add(clean_service_6_calc);
        clean_services.add(clean_service_7_calc);
        clean_services.add(clean_service_8_calc);
        clean_services.remove(null);
        clean_services.remove("");
    }

    /**
     * Calculate.
     */
    public void Calculate() {
        int clean_area_try;

        try {clean_area_try = Integer.parseInt(clean_area_calc);}
        catch (NumberFormatException e) {clean_area_try = 0;}

        CleanPrices.initCleanPrices();

        price = price + CleanPrices.getClean_type_prices(clean_type_calc) + clean_area_try*CleanPrices.getAreaRatio();

        for (String clean_service: clean_services) {
            if (clean_service != null) {
                if (clean_service == "Полировка полов") {
                    price = price + CleanPrices.getClean_services_prices(clean_service)*clean_area_try;
                } else {
                    price = price + CleanPrices.getClean_services_prices(clean_service);
                }
            }
        }
        
        // Добавить изменение цены из-за промокода
    }
    
    /**
     * Generate PDF.
     */
    public void GeneratePDF() {
    	String fullName = surname_calc +" "+ name_calc +" "+ patronymic_calc;
        CreatePDF PDF = new CreatePDF();
        try {
        	PDF.Create(fullName, time_calc, date_calc, address_calc, clean_type_calc, clean_area_calc, price, clean_services);
        } catch (IOException e) {
			e.printStackTrace();
		}
    }
}
