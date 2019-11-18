package com.legacy.strategies;

import com.legacy.Item;
import com.legacy.ItemDao;
import com.legacy.UpdateItemStrategy;

public class ConjuredItemStrategy extends UpdateItemStrategy {
    public ConjuredItemStrategy(ItemDao itemDao) {
        super(itemDao);
    }

    protected void updateQuality(Item item) {

    }
}
