package com.legacy;

public abstract class UpdateItemStrategy {

    private static final int MAX_QUALITY = 50;

    protected ItemDao itemDao = new ItemDaoImpl();

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
            increaseItemQuality(item, n);
            itemDao.saveQuality(item);
        }
    }

    private void increaseItemQuality(Item item, int n) {
        item.quality = item.quality + n;
    }
}
