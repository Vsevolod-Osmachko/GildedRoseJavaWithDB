package com.legacy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    private final Item[] items = new Item[]{new Item("Default", 10, 10)};
    private GildedRose gildedRose;

    @Before
    public void setUp() throws Exception {
        gildedRose = new GildedRose(items);
        gildedRose.setItemDao(new ItemDaoDummy());
    }

    @Test
    public void shouldDecreaseItemQualityForDefaultItem() {
        gildedRose.updateQuality();
        assertEquals(9, items[0].quality);
    }

    @Test
    public void shouldDecreaseItemSellInnForDefaultItem() {
        gildedRose.updateQuality();
        assertEquals(9, items[0].sellIn);
    }
}
