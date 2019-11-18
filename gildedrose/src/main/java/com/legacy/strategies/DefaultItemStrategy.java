package com.legacy.strategies;


import com.legacy.Item;
import com.legacy.ItemDao;
import com.legacy.UpdateItemStrategy;

public class DefaultItemStrategy extends UpdateItemStrategy {

    public DefaultItemStrategy(ItemDao itemDao) {
        super(itemDao);
    }

    public void updateQuality(Item item) {
        decrease(item);
        if (item.sellIn < 1)
            decrease(item);
    }


    private void decrease(Item item) {
        decreaseItemQuality(item);
        itemDao.saveQuality(item);
    }

    private void decreaseItemQuality(Item item) {
        if (item.quality > 0)
            item.quality = item.quality - 1;
    }
}
