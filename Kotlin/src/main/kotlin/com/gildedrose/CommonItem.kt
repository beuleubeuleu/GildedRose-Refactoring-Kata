package com.gildedrose

class CommonItem(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {

        override fun updateQuality() {
            if (qualityCanDecrease()) {
                this.quality--
            }

            this.sellIn--

            if (noDaysToSell()) {
                if (qualityCanDecrease()) {
                    this.quality--
                }
            }
        }
    }