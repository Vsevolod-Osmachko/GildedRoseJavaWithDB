package com.legacy;

public class GildedRose {


    ItemDao itemDao = new ItemDaoImpl();

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                    decrease(i);
                }
            } else {
                increase(items[i]);


                if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (items[i].sellIn < 11) {
                        increase(items[i]);
                    }

                    if (items[i].sellIn < 6) {
                        increase(items[i]);
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;

                itemDao.saveSellIn(items[i]);

            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                            decrease(i);

                        }
                    } else {
                        items[i].quality = 0;

                        itemDao.saveQuality(items[i]);

                    }
                } else {
                    increase(items[i]);
                }
            }
        }
    }

    private void decrease(int i) {
        if (items[i].quality > 0)
            items[i].quality = items[i].quality - 1;

        itemDao.saveQuality(items[i]);
    }

    private void increase(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            itemDao.saveQuality(item);
        }
    }


    public ItemDao getItemDao() {
        return itemDao;
    }

    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }
}