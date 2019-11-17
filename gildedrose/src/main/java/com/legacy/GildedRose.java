package com.legacy;

public class GildedRose {


    ItemDao itemDao = new ItemDaoImpl();

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {


            if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                new BackstagePassesItemStrategy(itemDao).updateQuality(items[i]);
                new BackstagePassesItemStrategy(itemDao).updateSellIn(items[i]);
            }

            if (items[i].name.equals("Aged Brie")) {
                new AgedBrieItemStrategy(itemDao).updateQuality(items[i]);
                new AgedBrieItemStrategy(itemDao).updateSellIn(items[i]);
            }

            if (items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                new SulfurasItemStrategy(itemDao).updateQuality(items[i]);
                new SulfurasItemStrategy(itemDao).updateSellIn(items[i]);
            }

            if (isDefault(items[i])) {
                decrease(i);

                if (items[i].sellIn < 1) {
                    decrease(i);

                }

                //TODO create Default Strategy
                new AgedBrieItemStrategy(itemDao).updateSellIn(items[i]);
            }


        }
    }

    private boolean isDefault(Item item) {
        return !item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert") && !item.name.equals("Sulfuras, Hand of Ragnaros");
    }


    private void decrease(int i) {
        if (items[i].quality > 0)
            items[i].quality = items[i].quality - 1;

        itemDao.saveQuality(items[i]);
    }


    public ItemDao getItemDao() {
        return itemDao;
    }

    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }
}