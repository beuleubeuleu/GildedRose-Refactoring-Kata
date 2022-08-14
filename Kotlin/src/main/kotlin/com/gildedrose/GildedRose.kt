package com.gildedrose

const val AGED_BRIE = "Aged Brie"
const val BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert"
const val SULFURAS = "Sulfuras, Hand of Ragnaros"


class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {

            val isAgedBrie = items[i].name == AGED_BRIE
            val isBackstage = items[i].name == BACKSTAGE
            val isSulfuras = items[i].name == SULFURAS
            val isCommonItem = !isAgedBrie && !isBackstage && !isSulfuras
            fun qualityCanIncrease() = items[i].quality < 50
            fun qualityCanDecrease() = items[i].quality > 0
            fun sellIn11Days() = items[i].sellIn < 11
            fun sellIn6Days() = items[i].sellIn < 6
            fun noDaysToSell() = items[i].sellIn < 0


            if (isAgedBrie) {

                if (qualityCanIncrease()) {
                    items[i].quality++
                }

                items[i].sellIn --

                if(noDaysToSell()) {
                    if (qualityCanIncrease()) {
                        items[i].quality ++
                    }
                }
            }

            if (isBackstage) {

                items[i].quality ++

                if (sellIn11Days()) {
                    if (qualityCanIncrease()) {
                        items[i].quality ++
                    }
                }

                if (sellIn6Days()) {
                    if (qualityCanIncrease()) {
                        items[i].quality ++
                    }
                }

                items[i].sellIn --

                if(noDaysToSell()) {
                    items[i].quality = 0
                }
            }

            if(isCommonItem) {

                if (qualityCanDecrease()) {
                        items[i].quality --
                }

                items[i].sellIn --
                
                if(noDaysToSell()) {
                    if (qualityCanDecrease()) {
                        items[i].quality--
                    }
                }
            }
        }
    }
}

