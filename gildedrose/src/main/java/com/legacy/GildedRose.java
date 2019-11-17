package com.legacy;

import java.util.HashMap;
import java.util.Map;

public class GildedRose {

    private UpdateItemStrategy defaultItemStrategy;

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
                defaultItemStrategy.updateQuality(items[i]);
                defaultItemStrategy.updateSellIn(items[i]);
            }


        }
    }

    public void setDefaultItemStrategy(UpdateItemStrategy defaultItemStrategy) {
        this.defaultItemStrategy = defaultItemStrategy;
    }

    public void setItemStrategyMap(Map<String, UpdateItemStrategy> itemStrategyMap) {
        this.itemStrategyMap = itemStrategyMap;
    }
}