package com.gildedrose

class AgedBrie(name:String, sellIn:Int, quality:Int): Item(name,sellIn,quality) {

    override fun updateQuality() {
        if (qualityCanIncrease()) {
            this.quality++
        }

        this.sellIn--

        if (noDaysToSell()) {
            if (qualityCanIncrease()) {
                this.quality++
            }
        }
    }
}