package com.legacy;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    private final Item[] items = new Item[]
            {
                    new Item("Default", 10, 10),
                    new Item("Default", 0, 10),
                    new Item("Default", 1, 0),
                    new Item("Aged Brie", 1, 49),
                    new Item("Aged Brie", 1, 50),
                    new Item("Sulfuras, Hand of Ragnaros", 10, 10),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 6, 10),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 11, 50)
            };
    private GildedRose gildedRose;

    @Before
    public void setUp() throws Exception {
        gildedRose = new GildedRose(items);
        final ItemDaoDummy itemDao = new ItemDaoDummy();
        gildedRose.setItemDao(itemDao);
        gildedRose.setItemStrategyMap(new HashMap<String, UpdateItemStrategy>(){{
            put("Aged Brie", new AgedBrieItemStrategy(itemDao));
            put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassesItemStrategy(itemDao));
            put("Sulfuras, Hand of Ragnaros", new SulfurasItemStrategy(itemDao));
        }});
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

    @Test
    public void shouldDecreaseTwiceItemQualityForDefaultItemIfSellInIsZero() {
        gildedRose.updateQuality();
        assertEquals(8, items[1].quality);
    }

    @Test
    public void shouldNotDecreaseQualityToNegative() {
        gildedRose.updateQuality();
        assertEquals(0, items[2].quality);
    }

    @Test
    public void shouldIncreaseItemQualityForAgedBrie() {
        gildedRose.updateQuality();
        assertEquals(50, items[3].quality);
    }

    @Test
    public void shouldNotIncreaseItemQualityIfQualityMoreTnan50() {
        gildedRose.updateQuality();
        assertEquals(50, items[4].quality);
    }

    @Test
    public void shouldNotChangeItemQualityForSulfuras() {
        gildedRose.updateQuality();
        assertEquals(10, items[5].quality);
    }

    @Test
    public void shouldIncreaseItemQualityForBackstage() {
        gildedRose.updateQuality();
        assertEquals(11, items[6].quality);
    }

    @Test
    public void shouldIncreaseTwiceItemQualityForBackstageIfSellInLessThan10() {
        gildedRose.updateQuality();
        assertEquals(12, items[7].quality);
        assertEquals(12, items[8].quality);
    }

    @Test
    public void shouldIncreaseBy3ItemQualityForBackstageIfSellInLessThan5() {
        gildedRose.updateQuality();
        assertEquals(13, items[9].quality);
    }

    @Test
    public void shouldDropQualityToZeroForBackstageAfterConcert() {
        gildedRose.updateQuality();
        assertEquals(0, items[10].quality);
    }

    @Test
    public void shouldNotIncreaseBackstageItemQualityIfQualityMoreTnan50() {
        gildedRose.updateQuality();
        assertEquals(50, items[11].quality);
    }


}
