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
        for ( Item item : items)
            if (itemStrategyMap.containsKey(item.name))
                itemStrategyMap.get(item.name).update(item);
            else
                defaultItemStrategy.update(item);
    }

    public void setDefaultItemStrategy(UpdateItemStrategy defaultItemStrategy) {
        this.defaultItemStrategy = defaultItemStrategy;
    }

    public void setItemStrategyMap(Map<String, UpdateItemStrategy> itemStrategyMap) {
        this.itemStrategyMap = itemStrategyMap;
    }
}