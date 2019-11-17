package com.legacy;


public class DefaultItemStrategy extends UpdateItemStrategy {

    public DefaultItemStrategy(ItemDao itemDao) {
        super(itemDao);
    }

    public void updateQuality(Item item) {
        decrease(item);

        if (item.sellIn < 1) {
            decrease(item);

        }
    }


    private void decrease(Item item) {
        if (item.quality > 0)
            item.quality = item.quality - 1;

        itemDao.saveQuality(item);
    }
}
