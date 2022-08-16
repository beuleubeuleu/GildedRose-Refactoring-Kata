package com.gildedrose;

import kotlin.test.Test
import kotlin.test.assertTrue

internal class CommonItemTest {

    @Test
    fun update_quality_decrements_sellIn_by1() {
        //Given
        val commonItem = arrayOf(CommonItem("normal thing", 3, 5))
        val app = GildedRose(commonItem)
        val updatedCommonItem = CommonItem("normal thing", 2, 5)

        //When
        CommonItem.updateQuality()

        //Then
        assertTrue { commonItem == updatedCommonItem }
    }
}
