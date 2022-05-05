package webapp;

import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * The Class CleanPrices.
 * @author Yunusbaev R.I.
 */
public class CleanPrices {
    
    /**
     * Gets the clean type prices.
     *
     * @param clean_type the clean type
     * @return the clean type prices
     */
    public static int getClean_type_prices(String clean_type) {return clean_type_prices.get(clean_type);}
    
    /**
     * Gets the clean services prices.
     *
     * @param clean_service the clean service
     * @return the clean services prices
     */
    public static int getClean_services_prices(String clean_service) {return clean_services_prices.get(clean_service);}
    
    /**
     * Gets the area ratio.
     *
     * @return the area ratio
     */
    public static int getAreaRatio() {return areaRatio;}

    /** The area ratio. */
    public static int areaRatio = 200;

    /** The clean type prices. */
    public static HashMap<String, Integer> clean_type_prices = new HashMap<>();

    /** The clean services prices. */
    public static HashMap<String, Integer> clean_services_prices = new HashMap<>();

    /**
     * Inits the clean prices.
     */
    public static void initCleanPrices() {
        clean_type_prices.put("Генеральная", SQLConnect.getValueFromDB("CleanTypes", "clean_type", "Генеральная"));
        clean_type_prices.put("Облегченная", SQLConnect.getValueFromDB("CleanTypes", "clean_type", "Облегченная"));
        clean_type_prices.put("После ремонта", SQLConnect.getValueFromDB("CleanTypes", "clean_type", "После ремонта"));
        clean_type_prices.put("Послестроительная", SQLConnect.getValueFromDB("CleanTypes", "clean_type", "Послестроительная"));

        clean_services_prices.put("Полировка полов", SQLConnect.getValueFromDB("CleanServices", "clean_service", "Полировка полов"));
        clean_services_prices.put("Мытье посуды", SQLConnect.getValueFromDB("CleanServices", "clean_service", "Мытье посуды"));
        clean_services_prices.put("Стирка+глажка", SQLConnect.getValueFromDB("CleanServices", "clean_service", "Стирка+глажка"));
        clean_services_prices.put("Мытье окон", SQLConnect.getValueFromDB("CleanServices", "clean_service", "Мытье окон"));
        clean_services_prices.put("Уборка стен", SQLConnect.getValueFromDB("CleanServices", "clean_service", "Уборка стен"));
        clean_services_prices.put("Чистка унитаза", SQLConnect.getValueFromDB("CleanServices", "clean_service", "Чистка унитаза"));
        clean_services_prices.put("Чистка раковин", SQLConnect.getValueFromDB("CleanServices", "clean_service", "Чистка раковин"));
        clean_services_prices.put("Уборка балкона", SQLConnect.getValueFromDB("CleanServices", "clean_service", "Уборка балкона"));

        areaRatio = SQLConnect.getValueFromDB("CleanArea", "clean_area", "Площадь помещения");
    }

    /**
     * Change clean type price.
     *
     * @param clean_type the clean type
     * @param price the price
     */
    public static void changeClean_type_price(String clean_type, int price) {
        clean_type_prices.computeIfPresent(clean_type, (k,v) -> v = price);
    }
    
    /**
     * Change clean services price.
     *
     * @param clean_service the clean service
     * @param price the price
     */
    public static void changeClean_services_price(String clean_service, int price) {
        clean_services_prices.computeIfPresent(clean_service, (k,v) -> v = price);
    }
    
    /**
     * Change area ratio.
     *
     * @param ratio the ratio
     */
    public static void changeAreaRatio(int ratio) {
        areaRatio = ratio;
    }
}
