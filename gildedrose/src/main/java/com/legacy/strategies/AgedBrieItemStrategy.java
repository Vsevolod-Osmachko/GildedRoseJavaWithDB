package com.legacy.strategies;

import com.legacy.Item;
import com.legacy.ItemDao;
import com.legacy.UpdateItemStrategy;

public class AgedBrieItemStrategy extends UpdateItemStrategy {

    public AgedBrieItemStrategy(ItemDao itemDao) {
        super(itemDao);
    }

    public void updateQuality(Item item) {
        increase(item, 1);
    }
}
