package com.legacy;

import java.util.HashMap;
import java.util.Map;

public class GildedRose {


    private ItemDao itemDao = new ItemDaoImpl();

    private Item[] items;

    private Map<String, UpdateItemStrategy> itemStrategyMap = new HashMap<String, UpdateItemStrategy>();


    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {


            if (itemStrategyMap.containsKey(items[i].name)){
                itemStrategyMap.get(items[i].name).updateQuality(items[i]);
                itemStrategyMap.get(items[i].name).updateSellIn(items[i]);

            } else {
                new DefaultItemStrategy(itemDao).updateQuality(items[i]);
                new DefaultItemStrategy(itemDao).updateSellIn(items[i]);
            }


        }
    }

    private boolean isDefault(Item item) {
        return !item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert") && !item.name.equals("Sulfuras, Hand of Ragnaros");
    }





    public ItemDao getItemDao() {
        return itemDao;
    }

    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public void setItemStrategyMap(Map<String, UpdateItemStrategy> itemStrategyMap) {
        this.itemStrategyMap = itemStrategyMap;
    }
}