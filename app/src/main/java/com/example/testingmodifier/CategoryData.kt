package com.example.testingmodifier

class CategoryData() {
    fun loadCategories(): List<Categories> {
        return listOf<Categories>(
            Categories(R.string.clothing, R.drawable.clothing_small),
            Categories(R.string.jewelry, R.drawable.jewelry_small),
            Categories(R.string.appliances, R.drawable.appliances_small),
            Categories(R.string.furniture, R.drawable.furniture_small),
            Categories(R.string.electronics, R.drawable.electronics_small),
            Categories(R.string.toys_and_games, R.drawable.toys_and_games_small),
            Categories(R.string.accessories, R.drawable.accessories_small),
        )
    }
}

/*
When you are to add photos within the app, make sure that they are small or it will cause the app to crash.
Make sure that the photos dimensions are between the 400's and the 200's
Ex. Accessories_small.jpg = 413 x 275
 */