package com.gildedrose

import kotlin.test.Test
import kotlin.test.assertEquals



internal class GildedRoseTest {

    @Test
    fun sell_limit_of_nonLegendary_item_decrements_by1(){
        //Given
        val items = arrayOf(Item("normalStuff", 4, 5))
        val app = GildedRose(items)
        val expectedSellInNormalStuff = 3


        //When
        app.updateQuality()

        //Then

        assertEquals(expectedSellInNormalStuff, app.items[0].sellIn)
    }

    @Test
    fun quality_of_aged_brie_increases_by1_when_sellIn_isPositive_or_by2_when_sellIn_is0(){
        //Given
        val items = arrayOf(Item("Aged Brie", 0, 5), Item("Aged Brie", 3, 2))
        val app = GildedRose(items)
        val expectedQualityOld = 7
        val expectedQualityYoung = 3


        //When
        app.updateQuality()

        //Then
        assertEquals(expectedQualityOld, app.items[0].quality)
        assertEquals(expectedQualityYoung, app.items[1].quality)
    }

    @Test
    fun when_sellIn_of_concert_pass_is0_quality_is0(){
        //Given
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 0, 5))
        val app = GildedRose(items)
        val expectedQualityConcertPass = 0


        //When
        app.updateQuality()

        //Then
        assertEquals(expectedQualityConcertPass, app.items[0].quality)
    }

    @Test
    fun quality_of_normal_stuff_decrease_by1_or_by2_when_sellIn_is0(){
        //Given
        val items = arrayOf(Item("some thing", 0, 5), Item("this thing", 3, 6))
        val app = GildedRose(items)
        val expectedQualitySomeThing = 3
        val expectedQualityThisThing = 5


        //When
        app.updateQuality()

        //Then
        assertEquals(expectedQualitySomeThing, app.items[0].quality)
        assertEquals(expectedQualityThisThing, app.items[1].quality)
    }

    @Test
    fun quality_of_concert_pass_increase_by1_or_by2_when_sellIn_10orUnder_or_by3_when_sellIn_5orUnder(){
        //Given
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 22, 2),
                            Item("Backstage passes to a TAFKAL80ETC concert", 7, 23),
                            Item("Backstage passes to a TAFKAL80ETC concert", 2, 35)
                    )
        val app = GildedRose(items)
        val expectedQuality0 = 3
        val expectedQuality1 = 25
        val expectedQuality2 = 38


        //When
        app.updateQuality()

        //Then
        assertEquals(expectedQuality0, app.items[0].quality)
        assertEquals(expectedQuality1, app.items[1].quality)
        assertEquals(expectedQuality2, app.items[2].quality)
    }
}


