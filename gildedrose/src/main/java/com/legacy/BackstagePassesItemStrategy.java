package com.legacy;

public class BackstagePassesItemStrategy extends UpdateItemStrategy {

    public BackstagePassesItemStrategy(ItemDao itemDao) {
        super(itemDao);
    }

    public void updateQuality(Item item) {
        if (item.sellIn < 1) {
            drop(item);
        } else if (item.sellIn < 6) {
            increase(item);
            increase(item);
            increase(item);
        } else if (item.sellIn < 11) {
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
