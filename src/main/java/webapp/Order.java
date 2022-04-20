package webapp;

import java.util.HashSet;

public class Order {

    // Получить данные о заказе
    public String getSurname_calc() {return surname_calc;}
    public String getName_calc() {return name_calc;}
    public String getPatronymic_calc() {return patronymic_calc;}
    public String getAddress_calc() {return address_calc;}
    public String getDate_calc() {return date_calc;}
    public String getTime_calc() {return time_calc;}
    public String getClean_area_calc() {return clean_area_calc;}
    public String getClean_type_calc() {return clean_type_calc;}
    public HashSet<String> getClean_services() {return clean_services;}
    public int getPrice() {return price;}
    
    // Данные о заказе
    private String surname_calc;
    private String name_calc;
    private String patronymic_calc;
    private String address_calc;
    private String date_calc;
    private String time_calc;
    private String clean_area_calc;
    private String clean_type_calc;
    private HashSet<String> clean_services = new HashSet<>();
    private int price = 0;

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
    }

    public void Calculate() {
        int clean_area_try;

        try {clean_area_try = Integer.parseInt(clean_area_calc);}
        catch (NumberFormatException e) {clean_area_try = 0;}

        CleanPrices.initCleanPrices();

        price = price + CleanPrices.getClean_type_prices(clean_type_calc) + clean_area_try*CleanPrices.getAreaRatio();

        for (String clean_service: clean_services) {
            // price = price + CleanPrices.getClean_services_prices(clean_service);
        }
        
        // Добавить изменение цены из-за промокода
    }
}
