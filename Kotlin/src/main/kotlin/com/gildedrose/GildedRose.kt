package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {

            fun qualityCanIncrease() = items[i].quality < 50
            fun qualityCanDecrease() = items[i].quality > 0
            val AGED_BRIE = items[i].name == "Aged Brie"
            val BACKSTAGE = items[i].name == "Backstage passes to a TAFKAL80ETC concert"
            val SULFURAS = items[i].name == "Sulfuras, Hand of Ragnaros"
            val SELL_IN_11DAYS = items[i].sellIn < 11
            val SELL_IN_6DAYS = items[i].sellIn < 6
            val NO_DAYS_TO_SELL = items[i].sellIn < 0

            if (!AGED_BRIE && !BACKSTAGE) {
                if (qualityCanDecrease()) {
                    if (!SULFURAS) {
                        items[i].quality --
                    }
                }
            } else {
                if (qualityCanIncrease()) {
                    items[i].quality ++

                    if (BACKSTAGE) {
                        if (SELL_IN_11DAYS) {
                            if (qualityCanIncrease()) {
                                items[i].quality ++
                            }
                        }

                        if (SELL_IN_6DAYS) {
                            if (qualityCanIncrease()) {
                                items[i].quality ++
                            }
                        }
                    }
                }
            }

            if (!SULFURAS) {
                items[i].sellIn --
            }

            if (NO_DAYS_TO_SELL) {
                if (!AGED_BRIE) {
                    if (!BACKSTAGE) {
                        if (qualityCanDecrease()) {
                            if (!SULFURAS) {
                                items[i].quality --
                            }
                        }
                    } else {
                        items[i].quality = 0
                    }
                } else {
                    if (qualityCanIncrease()) {
                        items[i].quality ++
                    }
                }
            }
        }
    }
}

