package pl.adamLupinski.service;

import pl.adamLupinski.model.Item;

import java.util.List;

public class PaymentService {
    private static final double DISCOUNT_ABOVE = 400;
    private  static final String DISCOUNT_WITH_TITLE = "monster hunter";


    public static void applyDiscount(List<Item> items){
        standardDiscount(items);
        mhDiscount(items);
    }

    private static void standardDiscount(List<Item> items) {
        if(totalPrice(items) > DISCOUNT_ABOVE)
            items.forEach(item -> item.setDiscountPrice(item.getOriginalPrice()*0.9));
    }

    private static void mhDiscount(List<Item> items){
        items.stream().filter(item -> item.getProduct().toLowerCase().contains(DISCOUNT_WITH_TITLE))
                .forEach(item -> item.setDiscountPrice(item.getDiscountPrice()*0.8));
    }

    public static double totalPrice(List<Item> items) {

        return items.stream().mapToDouble(Item::getOriginalPrice).sum();

    }

    public static double totalPriceAfterDiscount(List<Item> items) {

        return items.stream().mapToDouble(Item::getDiscountPrice).sum();
    }




}
