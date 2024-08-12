package com.example.flash.data


import com.example.flash.R

object DataSource {
    fun loadCategories(): List<Categories>{
        return listOf<Categories>(
            Categories(stringResourceId = R.string.fresh_fruits , imageResourceId = R.drawable.fruits),
            Categories(stringResourceId = R.string.bath_body , imageResourceId = R.drawable.bathbody),
            Categories(stringResourceId = R.string.bread_biscuits , imageResourceId = R.drawable.bread),
            Categories(stringResourceId = R.string.kitchen_essentials , imageResourceId = R.drawable.kitchen),
            Categories(stringResourceId = R.string.munchies , imageResourceId = R.drawable.munchies),
            Categories(stringResourceId = R.string.packaged_food , imageResourceId = R.drawable.packaged),
            Categories(stringResourceId = R.string.pet_food , imageResourceId = R.drawable.pet),
            Categories(stringResourceId = R.string.sweet_tooth , imageResourceId = R.drawable.sweet),
            Categories(stringResourceId = R.string.vegetables , imageResourceId = R.drawable.vegetables),
            Categories(stringResourceId = R.string.beverages , imageResourceId = R.drawable.beverages)
        )
    }
}