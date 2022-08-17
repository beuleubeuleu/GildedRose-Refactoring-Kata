package com.gildedrose

import kotlin.test.Test
import kotlin.test.assertEquals


class BackstageTest {

    @Test
    fun update_quality_decrements_sellIn_by1_and_increments_quality_by1() {
        //Given
        val napsTicket: Array<Item> = arrayOf(Backstage("naps", 14, 2))
        val app = GildedRose(napsTicket)
        val expectedNapsTicket = Backstage("naps", 13, 3)

        //When
        app.updateQuality()

        //Then
        assertEquals(expectedNapsTicket.sellIn, napsTicket[0].sellIn)
        assertEquals(expectedNapsTicket.quality, napsTicket[0].quality)

    }

    @Test
    fun update_quality_increments_quality_by2_when_sellin10() {
        //Given
        val poloGTicket: Array<Item> = arrayOf(Backstage("polo G", 9, 24))
        val app = GildedRose(poloGTicket)
        val expectedPoloGTicket = Backstage("polo G", 8, 26)

        //When
        app.updateQuality()

        //Then
        assertEquals(expectedPoloGTicket.sellIn, poloGTicket[0].sellIn)
        assertEquals(expectedPoloGTicket.quality, poloGTicket[0].quality)
    }

    @Test
    fun update_quality_increments_quality_by3_when_sellin5() {
        //Given
        val tupacTicket: Array<Item> = arrayOf(Backstage("2pac", 1, 45))
        val app = GildedRose(tupacTicket)
        val expectedTupacTicket = Backstage("2pac", 0, 48)

        //When
        app.updateQuality()

        //Then
        assertEquals(expectedTupacTicket.sellIn, tupacTicket[0].sellIn)
        assertEquals(expectedTupacTicket.quality, tupacTicket[0].quality)
    }

    @Test
    fun update_quality_makes_quality_0_when_sellin0() {
        //Given
        val tupacTicket: Array<Item> = arrayOf(Backstage("2pac", 0, 48))
        val app = GildedRose(tupacTicket)
        val expectedTupacTicket = Backstage("2pac", -1, 0)

        //When
        app.updateQuality()

        //Then
        assertEquals(expectedTupacTicket.sellIn, tupacTicket[0].sellIn)
        assertEquals(expectedTupacTicket.quality, tupacTicket[0].quality)
    }

    @Test
    fun quality_is_never_over_50() {
        //Given
        val tupacTicket: Array<Item> = arrayOf(Backstage("2pac", 1, 48))
        val app = GildedRose(tupacTicket)
        val expectedTupacTicket = Backstage("2pac", 0, 50)

        //When
        app.updateQuality()

        //Then
        assertEquals(expectedTupacTicket.sellIn, tupacTicket[0].sellIn)
        assertEquals(expectedTupacTicket.quality, tupacTicket[0].quality)
    }
}