package com.gildedrose

import kotlin.test.Test
import kotlin.test.assertEquals

class LegendaryTest {

    @Test
    fun legendary_item_has_fixed_quality_and_sellIn() {
        val legendaryItem: Array<Item> = arrayOf(Legendary("expensive", 0, 80))
        val app = GildedRose(legendaryItem)
        val expectedLegendaryItem = Legendary("expensive", 0, 80)

        //When
        app.updateQuality()

        //Then
        assertEquals(expectedLegendaryItem.sellIn, legendaryItem[0].sellIn)
        assertEquals(expectedLegendaryItem.quality, legendaryItem[0].quality)

    }
}