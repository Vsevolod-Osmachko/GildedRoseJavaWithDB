package com.legacy;

public abstract class UpdateItemStrategy {

    ItemDao itemDao = new ItemDaoImpl();

    public UpdateItemStrategy(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public void updateSellIn(Item i){

    }

    public abstract void updateQuality(Item i);


    protected void increase(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            itemDao.saveQuality(item);
        }
    }
}
