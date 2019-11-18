package com.legacy;

public class BackstagePassesItemStrategy extends UpdateItemStrategy {

    private static final int SECOND_LIMIT = 5;
    private static final int FIRST_LIMIT = 10;

    public BackstagePassesItemStrategy(ItemDao itemDao) {
        super(itemDao);
    }

    public void updateQuality(Item item) {
        if (item.sellIn < 1) {
            drop(item);
        } else if (item.sellIn <= SECOND_LIMIT) {
            increase(item);
            increase(item);
            increase(item);
        } else if (item.sellIn <= FIRST_LIMIT) {
            increase(item);
            increase(item);
        } else
            increase(item);
    }

    private void drop(Item item) {
        item.quality = 0;

        itemDao.saveQuality(item);
    }

}
