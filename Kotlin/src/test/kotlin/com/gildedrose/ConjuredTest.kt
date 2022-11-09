package com.gildedrose

import kotlin.test.Test
import kotlin.test.assertEquals

class ConjuredTest {
    @Test
    fun can_create_conjured_item() {
        val conjuredItems: Array<Item> = arrayOf(ConjuredItem("Conjured SkillBook", 4, 25))
    }

    @Test
    fun update_quality_decrements_sellIN_by1() {
        //Given
        val conjuredItems: Array<Item> = arrayOf(ConjuredItem("Conjured SkillBook", 4, 25))
        val app = GildedRose(conjuredItems)
        val expectedConjuredItems: Array<Item> = arrayOf(ConjuredItem("Conjured SkillBook", 3, 23))

        //When
        app.updateQuality()

        //Then
        assertEquals(expectedConjuredItems[0].sellIn, conjuredItems[0].sellIn)
    }

    @Test
    fun update_quality_decrements_quality_by2() {
            //Given
            val conjuredItems: Array<Item> = arrayOf(ConjuredItem("Conjured SkillBook", 4, 25))
            val app = GildedRose(conjuredItems)
            val expectedConjuredItems: Array<Item> = arrayOf(ConjuredItem("Conjured SkillBook", 3, 23))

            //When
            app.updateQuality()

            //Then
            assertEquals(expectedConjuredItems[0].quality, conjuredItems[0].quality)
    }

    @Test
    fun update_quality_decrements_quality_by4_when_sellIn_isNegative(){
        //Given
        val conjuredItems: Array<Item> = arrayOf(ConjuredItem("Conjured stuff", 0, 5))
        val app = GildedRose(conjuredItems)
        val expectedConjuredItems: Array<Item> = arrayOf(ConjuredItem("Conjured stuff", -1, 1))

        //When
        app.updateQuality()

        //Then
        assertEquals(expectedConjuredItems[0].quality, conjuredItems[0].quality)
    }

    @Test
    fun quality_is_never_negative() {
        //Given
        val conjuredItems: Array<Item> = arrayOf(ConjuredItem("Conjured SkillBook", 4, 1),
                                                 ConjuredItem("Conjured Thing", 0, 2),
                                                 ConjuredItem("Conjured stuff", 0, 3))
        val app = GildedRose(conjuredItems)
        val expectedConjuredItems: Array<Item> = arrayOf(ConjuredItem("Conjured SkillBook", 3, 0),
                                                         ConjuredItem("Conjured Thing", -1, 0),
                                                         ConjuredItem("Conjured stuff", -1, 0))

        //When
        app.updateQuality()

        //Then
        assertEquals(expectedConjuredItems[0].quality, conjuredItems[0].quality)
        assertEquals(expectedConjuredItems[1].quality, conjuredItems[1].quality)
        assertEquals(expectedConjuredItems[2].quality, conjuredItems[2].quality)
    }
}