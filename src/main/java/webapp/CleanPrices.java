package webapp;

import java.util.HashMap;

public class CleanPrices {
    public static int getClean_type_prices(String clean_type) {return clean_type_prices.get(clean_type);}
    public static int getClean_services_prices(String clean_service) {return clean_services_prices.get(clean_service);}
    public static int getAreaRatio() {return areaRatio;}

    public static HashMap<String, Integer> clean_type_prices = new HashMap<String, Integer>() {{
        clean_type_prices.put("Генеральная", 8000);
        clean_type_prices.put("Облегченная", 5000);
        clean_type_prices.put("После ремонта", 10000);
        clean_type_prices.put("Послестроительная", 20000);
    }};

    public static HashMap<String, Integer> clean_services_prices = new HashMap<String, Integer>() {{
        clean_services_prices.put("Полировка полов", areaRatio*50);
        clean_services_prices.put("Мытье посуды", 500);
        clean_services_prices.put("Стирка+глажка", 500);
        clean_services_prices.put("Мытье окон", 500);
        clean_services_prices.put("Уборка стен", 500);
        clean_services_prices.put("Чистка унитаза", 500);
        clean_services_prices.put("Чистка раковин", 500);
        clean_services_prices.put("Уборка балкона", 500);
    }};

    public static int areaRatio = 200;

    public static void changeClean_type_price(String clean_type, int price) {
        clean_type_prices.computeIfPresent(clean_type, (k,v) -> v = price);
    }
    public static void changeClean_services_price(String clean_service, int price) {
        clean_services_prices.computeIfPresent(clean_service, (k,v) -> v = price);
    }
    public static void changeAreaRatio(int ratio) {
        areaRatio = ratio;
    }
}
