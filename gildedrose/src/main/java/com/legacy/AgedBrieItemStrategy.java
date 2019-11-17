package com.legacy;

public class AgedBrieItemStrategy extends UpdateItemStrategy {

    public AgedBrieItemStrategy(ItemDao itemDao) {
        super(itemDao);
    }

    public void updateQuality(Item item) {
        increase(item);
    }
}
