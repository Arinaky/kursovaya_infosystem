package webapp;

public class Order {

    // Получить данные о заказе
    public String getSurname_calc() {return surname_calc;}
    public String getName_calc() {return name_calc;}
    public String getPatronymic_calc() {return patronymic_calc;}
    public String getAddress_calc() {return address_calc;}
    public String getDate_time_calc() {return date_time_calc;}
    public String getClean_area_calc() {return clean_area_calc;}
    public String getClean_type_calc() {return clean_type_calc;}
    public String getClean_service_1_calc() {return clean_service_1_calc;}
    public String getClean_service_2_calc() {return clean_service_2_calc;}
    public String getClean_service_3_calc() {return clean_service_3_calc;}
    public String getClean_service_4_calc() {return clean_service_4_calc;}
    public String getClean_service_5_calc() {return clean_service_5_calc;}
    public String getClean_service_6_calc() {return clean_service_6_calc;}
    public String getClean_service_7_calc() {return clean_service_7_calc;}
    public String getClean_service_8_calc() {return clean_service_8_calc;}
    public int getPrice() {return price;}

    // Задать данные о заказе
    public void setSurname_calc(String surname_calc) {this.surname_calc = surname_calc;}
    public void setName_calc(String name_calc) {this.name_calc = name_calc;}
    public void setPatronymic_calc(String patronymic_calc) {this.patronymic_calc = patronymic_calc;}
    public void setAddress_calc(String address_calc) {this.address_calc = address_calc;}
    public void setDate_time_calc(String date_time_calc) {this.date_time_calc = date_time_calc;}
    public void setClean_area_calc(String clean_area_calc) {this.clean_area_calc = clean_area_calc;}
    public void setClean_type_calc(String clean_type_calc) {this.clean_type_calc = clean_type_calc;}
    public void setClean_service_1_calc(String clean_service_1_calc) {this.clean_service_1_calc = clean_service_1_calc;}
    public void setClean_service_2_calc(String clean_service_2_calc) {this.clean_service_2_calc = clean_service_2_calc;}
    public void setClean_service_3_calc(String clean_service_3_calc) {this.clean_service_3_calc = clean_service_3_calc;}
    public void setClean_service_4_calc(String clean_service_4_calc) {this.clean_service_4_calc = clean_service_4_calc;}
    public void setClean_service_5_calc(String clean_service_5_calc) {this.clean_service_5_calc = clean_service_5_calc;}
    public void setClean_service_6_calc(String clean_service_6_calc) {this.clean_service_6_calc = clean_service_6_calc;}
    public void setClean_service_7_calc(String clean_service_7_calc) {this.clean_service_7_calc = clean_service_7_calc;}
    public void setClean_service_8_calc(String clean_service_8_calc) {this.clean_service_8_calc = clean_service_8_calc;}

    // Данные о заказе
    private String surname_calc;
    private String name_calc;
    private String patronymic_calc;
    private String address_calc;
    private String date_time_calc;
    private String clean_area_calc;
    private String clean_type_calc;
    private String clean_service_1_calc;
    private String clean_service_2_calc;
    private String clean_service_3_calc;
    private String clean_service_4_calc;
    private String clean_service_5_calc;
    private String clean_service_6_calc;
    private String clean_service_7_calc;
    private String clean_service_8_calc;
    private int price = 0;

    // Цены за услуги
    private CleanPrices prices = new CleanPrices();

    // Создание заказа
    public Order(String surname_calc, String name_calc, String patronymic_calc, String address_calc, String date_time_calc, String clean_area_calc, String clean_type_calc, String clean_service_1_calc, String clean_service_2_calc, String clean_service_3_calc, String clean_service_4_calc, String clean_service_5_calc, String clean_service_6_calc, String clean_service_7_calc, String clean_service_8_calc) {
        this.surname_calc = surname_calc;
        this.name_calc = name_calc;
        this.patronymic_calc = patronymic_calc;
        this.address_calc = address_calc;
        this.date_time_calc = date_time_calc;
        this.clean_area_calc = clean_area_calc;
        this.clean_type_calc = clean_type_calc;
        this.clean_service_1_calc = clean_service_1_calc;
        this.clean_service_2_calc = clean_service_2_calc;
        this.clean_service_3_calc = clean_service_3_calc;
        this.clean_service_4_calc = clean_service_4_calc;
        this.clean_service_5_calc = clean_service_5_calc;
        this.clean_service_6_calc = clean_service_6_calc;
        this.clean_service_7_calc = clean_service_7_calc;
        this.clean_service_8_calc = clean_service_8_calc;
    }

    public void Calculate() {
        int clean_area_try;
        try {
            clean_area_try = Integer.parseInt(clean_area_calc);
        } catch (NumberFormatException e) {
            clean_area_try = 0;
        }
        price = price + prices.getClean_type_prices(clean_type_calc) + clean_area_try*prices.getAreaRatio();
        if (clean_service_1_calc != null) {
            price = price + prices.getClean_services_prices(clean_service_1_calc);
        }
        if (clean_service_2_calc != null) {
            price = price + prices.getClean_services_prices(clean_service_2_calc);
        }
        if (clean_service_3_calc != null) {
            price = price + prices.getClean_services_prices(clean_service_3_calc);
        }
        if (clean_service_4_calc != null) {
            price = price + prices.getClean_services_prices(clean_service_4_calc);
        }
        if (clean_service_5_calc != null) {
            price = price + prices.getClean_services_prices(clean_service_5_calc);
        }
        if (clean_service_6_calc != null) {
            price = price + prices.getClean_services_prices(clean_service_6_calc);
        }
        if (clean_service_7_calc != null) {
            price = price + prices.getClean_services_prices(clean_service_7_calc);
        }
        if (clean_service_8_calc != null) {
            price = price + prices.getClean_services_prices(clean_service_8_calc);
        }

        // Добавить изменение цены из-за промокода
    }
}
