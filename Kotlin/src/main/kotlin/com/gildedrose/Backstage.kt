package com.gildedrose

class Backstage(name:String, sellIn:Int, quality:Int): Item(name,sellIn,quality) {

    override fun updateQuality() {
        if (qualityCanIncrease()) {
            this.quality++
        }

        this.sellIn--

        if (sellIn11Days()) {
            if (qualityCanIncrease()) {
                this.quality++
            }
        }

        if (sellIn6Days()) {
            if (qualityCanIncrease()) {
                this.quality++
            }
        }


        if (noDaysToSell()) {
            this.quality = 0
        }
    }
}