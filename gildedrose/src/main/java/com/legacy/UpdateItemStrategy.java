package com.legacy;

public abstract class UpdateItemStrategy {

    private static final int MAX_QUALITY = 50;

    ItemDao itemDao = new ItemDaoImpl();

    public UpdateItemStrategy(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public void update(Item item){
        updateQuality(item);
        updateSellIn(item);
    }

    protected void updateSellIn(Item item){
        item.sellIn = item.sellIn - 1;
        itemDao.saveSellIn(item);
    }

    protected abstract void updateQuality(Item item);


    protected void increase(Item item, int n) {
        if (item.quality < MAX_QUALITY) {
            item.quality = item.quality + n;
            itemDao.saveQuality(item);
        }
    }
}
