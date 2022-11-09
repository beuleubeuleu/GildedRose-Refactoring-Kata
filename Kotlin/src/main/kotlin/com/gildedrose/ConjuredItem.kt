package com.gildedrose

class ConjuredItem(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {

    override fun updateQuality() {
        this.sellIn --
        if(qualityCanDecrease()) {
            this.quality --
        }
        if(qualityCanDecrease()) {
            this.quality --
        }

        if(noDaysToSell()) {
            if (qualityCanDecrease()) {
                this.quality --
            }
            if (qualityCanDecrease()) {
                this.quality --
            }
        }
    }
}
