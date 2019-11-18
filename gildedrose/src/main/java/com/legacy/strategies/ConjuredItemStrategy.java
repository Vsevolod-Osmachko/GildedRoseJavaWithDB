package com.legacy.strategies;

import com.legacy.Item;
import com.legacy.ItemDao;

public class ConjuredItemStrategy extends DefaultItemStrategy {
    public ConjuredItemStrategy(ItemDao itemDao) {
        super(itemDao);
    }

    @Override
    public void updateQuality(Item item) {
        super.updateQuality(item);
        super.updateQuality(item);
    }
}
