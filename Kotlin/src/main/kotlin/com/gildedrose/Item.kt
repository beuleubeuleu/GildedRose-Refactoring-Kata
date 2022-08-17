package com.gildedrose

open class Item(var name: String, var sellIn: Int, var quality: Int) {

    fun qualityCanIncrease() = this.quality < 50
    fun qualityCanDecrease() = this.quality > 0
    fun sellIn11Days() = this.sellIn < 11
    fun sellIn6Days() = this.sellIn < 6
    fun noDaysToSell() = this.sellIn < 0

    open fun updateQuality() {}
}