package com.gildedrose

import kotlin.test.Test
import kotlin.test.assertEquals

class AgedBrieTest {

    @Test
    fun update_quality_decrements_sellIn_by1_and_increments_quality_by1() {
        //Given
        val normalCheese: Array<Item> = arrayOf(AgedBrie("normal cheese", 3, 5))
        val app = GildedRose(normalCheese)
        val expectedNormalCheese = AgedBrie("normal cheese", 2, 6)

        //When
        app.updateQuality()

        //Then
        assertEquals(expectedNormalCheese.sellIn, normalCheese[0].sellIn)
        assertEquals(expectedNormalCheese.quality, normalCheese[0].quality)

    }

    @Test
    fun update_quality_increments_quality_by2_when_sellin_0() {
        //Given
        val oldCheese: Array<Item> = arrayOf(AgedBrie("old cheese", 0, 5))
        val app = GildedRose(oldCheese)
        val expectedOldCheese = AgedBrie("old cheese", -1, 7)

        //When
        app.updateQuality()

        //Then
        assertEquals(expectedOldCheese.sellIn, oldCheese[0].sellIn)
        assertEquals(expectedOldCheese.quality, oldCheese[0].quality)
    }

    @Test
    fun quality_is_never_over_50() {
        //Given
        val niceCheese: Array<Item> = arrayOf(AgedBrie("2pac", -3, 49))
        val app = GildedRose(niceCheese)
        val expectedNiceCheese = AgedBrie("2pac", -4, 50)

        //When
        app.updateQuality()

        //Then
        assertEquals(expectedNiceCheese.sellIn, niceCheese[0].sellIn)
        assertEquals(expectedNiceCheese.quality, niceCheese[0].quality)
    }
}