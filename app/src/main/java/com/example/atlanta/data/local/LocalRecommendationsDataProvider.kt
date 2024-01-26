package com.example.atlanta.data.local

import com.example.atlanta.data.Category
import com.example.atlanta.data.Recommendation
import com.example.atlanta.R

object LocalRecommendationsDataProvider {


    val allRecommendations = listOf(

        //Coffee
        Recommendation(
            id = 1,
            category = Category.COFFEE,
            name = R.string.cafe_comma,
            description = R.string.cafe_comma_description,
            avatar = R.drawable.coffee_cafe_comma,
            categoryName = R.string.coffee
        ),
        Recommendation(
            id = 2,
            category = Category.COFFEE,
            name = R.string.chrome_yellow,
            description = R.string.chrome_yellow_description,
            avatar = R.drawable.coffee_chrome_yellow_trading_co,
            categoryName = R.string.coffee
        ),
        Recommendation(
            id = 3,
            category = Category.COFFEE,
            name = R.string.con_leche,
            description = R.string.con_leche,
            avatar = R.drawable.coffee_con_leche,
            categoryName = R.string.coffee
        ),
        Recommendation(
            id = 4,
            category = Category.COFFEE,
            name = R.string.the_daily,
            description = R.string.the_daily_description,
            avatar = R.drawable.coffee_the_daily_atl,
            categoryName = R.string.coffee
        ),
        Recommendation(
            id = 5,
            category = Category.COFFEE,
            name = R.string.perc,
            description = R.string.perc_description,
            avatar = R.drawable.coffee_perc,
            categoryName = R.string.coffee
        ),
        Recommendation(
            id = 6,
            category = Category.COFFEE,
            name = R.string.urban_grind,
            description = R.string.urban_grind_description,
            avatar = R.drawable.coffee_urban_grind,
            categoryName = R.string.coffee
        ),

        //Dog Parks
        Recommendation(
            id = 7,
            category = Category.DOG_PARK,
            name = R.string.fetch,
            description = R.string.fetch_description,
            avatar = R.drawable.dog_park_fetch_bark,
            categoryName = R.string.dog_park
        ),
        Recommendation(
            id = 8,
            category = Category.DOG_PARK,
            name = R.string.freedom,
            description = R.string.freedom_description,
            avatar = R.drawable.dog_park_freedom_barkway_dog_park,
            categoryName = R.string.dog_park
        ),
        Recommendation(
            id = 9,
            category = Category.DOG_PARK,
            name = R.string.piedmont,
            description = R.string.piedmont_description,
            avatar = R.drawable.dog_park_piedmont_park,
            categoryName = R.string.dog_park
        ),
        Recommendation(
            id = 10 ,
            category = Category.DOG_PARK,
            name = R.string.glenlake,
            description = R.string.glenlake_description,
            avatar = R.drawable.dog_park_glenlake_dog_park,
            categoryName = R.string.dog_park
        ),
        Recommendation(
            id = 11 ,
            category = Category.DOG_PARK,
            name = R.string.skyland,
            description = R.string.skyland_description,
            avatar = R.drawable.dog_park_skyland_dog_park,
            categoryName = R.string.dog_park
        ),

        //Museums
        Recommendation(
            id = 12 ,
            category = Category.MUSEUM,
            name = R.string.mlk,
            description = R.string.mlk_description,
            avatar = R.drawable.museum_mlk,
            categoryName = R.string.museum
        ),
        Recommendation(
            id = 13 ,
            category = Category.MUSEUM,
            name = R.string.ncchr,
            description = R.string.ncchr_description,
            avatar = R.drawable.museum_ncchr,
            categoryName = R.string.museum
        ),
        Recommendation(
            id = 14 ,
            category = Category.MUSEUM,
            name = R.string.coke,
            description = R.string.coke_description,
            avatar = R.drawable.museum_world_of_cc,
            categoryName = R.string.museum
        ),
        Recommendation(
            id = 15 ,
            category = Category.MUSEUM,
            name = R.string.trap,
            description = R.string.trap_description,
            avatar = R.drawable.museum_rap_music_museum,
            categoryName = R.string.museum
        ),
        Recommendation(
            id = 16 ,
            category = Category.MUSEUM,
            name = R.string.high_museum_of_art,
            description = R.string.high_museum_of_art_description,
            avatar = R.drawable.museum_high_museum_of_art,
            categoryName = R.string.museum
        ),

        //Pizza
        Recommendation(
            id = 17 ,
            category = Category.PIZZA,
            name = R.string.amalfi,
            description = R.string.amalfi_description,
            avatar = R.drawable.pizza_amalfi,
            categoryName = R.string.pizza
        ),
        Recommendation(
            id = 18 ,
            category = Category.PIZZA,
            name = R.string.antico,
            description = R.string.antico_description,
            avatar = R.drawable.pizza_antico,
            categoryName = R.string.pizza
        ),
        Recommendation(
            id = 19 ,
            category = Category.PIZZA,
            name = R.string.fellinis,
            description = R.string.fellinis_description,
            avatar = R.drawable.pizza_fellinis,
            categoryName = R.string.pizza
        ),
        Recommendation(
            id = 20 ,
            category = Category.PIZZA,
            name = R.string.glide,
            description = R.string.glide_description,
            avatar = R.drawable.pizza_glide,
            categoryName = R.string.pizza
        ),
        Recommendation(
            id = 21 ,
            category = Category.PIZZA,
            name = R.string.double_zero,
            description = R.string.double_zero_description,
            avatar = R.drawable.pizza_double_zero,
            categoryName = R.string.pizza
        ),
        Recommendation(
            id = 22 ,
            category = Category.PIZZA,
            name = R.string.juniors,
            description = R.string.juniors_description,
            avatar = R.drawable.pizza_juniors,
            categoryName = R.string.pizza
        ),
        Recommendation(
            id = 23 ,
            category = Category.PIZZA,
            name = R.string.nina_and_rafi,
            description = R.string.nina_and_rafi_description,
            avatar = R.drawable.pizza_nina_and_rafi,
            categoryName = R.string.pizza
        ),
        Recommendation(
            id = 24 ,
            category = Category.PIZZA,
            name = R.string.varuni_napoli,
            description = R.string.varuni_napoli_description,
            avatar = R.drawable.pizza_varuni_napoli,
            categoryName = R.string.pizza
        ),

        //Shopping
        Recommendation(
            id = 25 ,
            category = Category.SHOPPING_CENTER,
            name = R.string.lenox,
            description = R.string.lenox_description,
            avatar = R.drawable.shopping_lenox,
            categoryName = R.string.shopping
        ),
        Recommendation(
            id = 26,
            category = Category.SHOPPING_CENTER,
            name = R.string.atlantic,
            description = R.string.atlantic_description,
            avatar = R.drawable.shopping_atlantic_station,
            categoryName = R.string.shopping
        ),
        Recommendation(
            id = 27 ,
            category = Category.SHOPPING_CENTER,
            name = R.string.perimeter,
            description = R.string.perimeter_description,
            avatar = R.drawable.shopping_perimeter_mall,
            categoryName = R.string.shopping
        ),
        Recommendation(
            id = 28 ,
            category = Category.SHOPPING_CENTER,
            name = R.string.phipps,
            description = R.string.phipps_description,
            avatar = R.drawable.shopping_phipps_plaza,
            categoryName = R.string.shopping
        ),
        Recommendation(
            id = 29 ,
            category = Category.SHOPPING_CENTER,
            name = R.string.ponce,
            description = R.string.ponce_description,
            avatar = R.drawable.shopping_ponce_city_market,
            categoryName = R.string.shopping
        )
    )
}