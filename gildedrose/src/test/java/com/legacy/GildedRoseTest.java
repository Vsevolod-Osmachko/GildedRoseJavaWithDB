package com.legacy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void shouldDecreaseItemQualityForDefaultItem() {
        Item[] items = {new Item("Default", 10, 10)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.setItemDao(new ItemDaoDummy());
        gildedRose.updateQuality();

        assertEquals(9, items[0].quality);
    }


}
