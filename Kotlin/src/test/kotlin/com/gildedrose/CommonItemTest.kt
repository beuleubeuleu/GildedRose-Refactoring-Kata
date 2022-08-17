package com.gildedrose

import kotlin.test.Test
import kotlin.test.assertEquals

internal class CommonItemTest {

    @Test
    fun update_quality_decrements_sellIn_and_quality_by1() {
        //Given
        val commonItem: Array<Item> = arrayOf(CommonItem("normal thing", 3, 5))
        val app = GildedRose(commonItem)
        val expectedCommonItem = CommonItem("normal thing", 2, 4)

        //When
        app.updateQuality()

        //Then
        assertEquals(expectedCommonItem.sellIn, commonItem[0].sellIn)
        assertEquals(expectedCommonItem.quality, commonItem[0].quality)
    }

    @Test
    fun update_quality_decrements_quality_by2_when_sellIn_isNegative() {
        val commonItem: Array<Item> = arrayOf(CommonItem("normal object", 0, 5))
        val app = GildedRose(commonItem)
        val expectedCommonItem = CommonItem("normal object", -1, 3)

        //When
        app.updateQuality()

        //Then
        assertEquals(expectedCommonItem.sellIn, commonItem[0].sellIn)
        assertEquals(expectedCommonItem.quality, commonItem[0].quality)
    }

    @Test
    fun quality_is_never_negative(){
        val commonItem: Array<Item> = arrayOf(CommonItem("normal object", 0, 1))
        val app = GildedRose(commonItem)
        val expectedCommonItem = CommonItem("normal object", -1, 0)

        //When
        app.updateQuality()

        //Then
        assertEquals(expectedCommonItem.sellIn, commonItem[0].sellIn)
        assertEquals(expectedCommonItem.quality, commonItem[0].quality)
    }

}
