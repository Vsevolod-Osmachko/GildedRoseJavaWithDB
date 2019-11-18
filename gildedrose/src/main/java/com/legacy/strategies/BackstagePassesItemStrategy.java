package com.legacy.strategies;

import com.legacy.Item;
import com.legacy.ItemDao;
import com.legacy.UpdateItemStrategy;

public class BackstagePassesItemStrategy extends UpdateItemStrategy {

    private static final int SECOND_LIMIT = 5;
    private static final int FIRST_LIMIT = 10;

    public BackstagePassesItemStrategy(ItemDao itemDao) {
        super(itemDao);
    }

    public void updateQuality(Item item) {
        if (item.sellIn <= 0)
            drop(item);
        else if (item.sellIn <= SECOND_LIMIT)
            increase(item, 3);
        else if (item.sellIn <= FIRST_LIMIT)
            increase(item, 2);
        else
            increase(item, 1);
    }

    private void drop(Item item) {
        item.quality = 0;

        itemDao.saveQuality(item);
    }

}
