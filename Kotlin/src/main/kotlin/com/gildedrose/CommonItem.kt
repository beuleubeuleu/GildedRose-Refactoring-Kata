package com.gildedrose

class CommonItem(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    companion object {
        fun updateQuality() {
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