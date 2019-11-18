package com.legacy.strategies;

import com.legacy.Item;
import com.legacy.ItemDao;
import com.legacy.UpdateItemStrategy;

public class SulfurasItemStrategy extends UpdateItemStrategy {

    public SulfurasItemStrategy(ItemDao itemDao) {
        super(itemDao);
    }

    public void updateQuality(Item item) {

    }

    @Override
    public void updateSellIn(Item item) {

    }
}
