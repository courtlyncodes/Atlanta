package com.example.atlanta.data.local

import com.example.atlanta.data.Category
import com.example.atlanta.data.Recommendation
import com.example.atlanta.R

object LocalRecommendationsDataProvider {


    val allRecommendations = listOf(

        //Coffee
        Recommendation(
            category = Category.Coffee,
            name = R.string.cafe_comma,
            description = R.string.cafe_comma_detail,
            avatar = R.drawable.coffee_cafe_comma,
            categoryName = R.string.coffee
        ),
        Recommendation(
            category = Category.Coffee,
            name = R.string.chrome_yellow,
            description = R.string.chrome_yellow_detail,
            avatar = R.drawable.coffee_chrome_yellow_trading_co,
            categoryName = R.string.coffee
        ),
        Recommendation(
            category = Category.Coffee,
            name = R.string.con_leche,
            description = R.string.con_leche,
            avatar = R.drawable.coffee_con_leche,
            categoryName = R.string.coffee
        ),
        Recommendation(
            category = Category.Coffee,
            name = R.string.the_daily,
            description = R.string.the_daily_detail,
            avatar = R.drawable.coffee_the_daily_atl,
            categoryName = R.string.coffee
        ),
        Recommendation(
            category = Category.Coffee,
            name = R.string.perc,
            description = R.string.perc_detail,
            avatar = R.drawable.coffee_perc,
            categoryName = R.string.coffee
        ),
        Recommendation(
            category = Category.Coffee,
            name = R.string.urban_grind,
            description = R.string.urban_grind_detail,
            avatar = R.drawable.coffee_urban_grind,
            categoryName = R.string.coffee
        ),

        //Dog Parks
        Recommendation(
            category = Category.DogPark,
            name = R.string.fetch,
            description = R.string.fetch_detail,
            avatar = R.drawable.dog_park_fetch_bark,
            categoryName = R.string.dog_park
        ),
        Recommendation(
            category = Category.DogPark,
            name = R.string.freedom,
            description = R.string.freedom_detail,
            avatar = R.drawable.dog_park_freedom_barkway_dog_park,
            categoryName = R.string.dog_park
        ),
        Recommendation(
            category = Category.DogPark,
            name = R.string.piedmont,
            description = R.string.piedmont_detail,
            avatar = R.drawable.dog_park_piedmont_park,
            categoryName = R.string.dog_park
        ),
        Recommendation(
            category = Category.DogPark,
            name = R.string.glenlake,
            description = R.string.glenlake_detail,
            avatar = R.drawable.dog_park_glenlake_dog_park,
            categoryName = R.string.dog_park
        ),
        Recommendation(
            category = Category.DogPark,
            name = R.string.skyland,
            description = R.string.skyland_detail,
            avatar = R.drawable.dog_park_skyland_dog_park,
            categoryName = R.string.dog_park
        ),

        //Museums
        Recommendation(
            category = Category.Museum,
            name = R.string.mlk,
            description = R.string.mlk_detail,
            avatar = R.drawable.museum_mlk,
            categoryName = R.string.museum
        ),
        Recommendation(
            category = Category.Museum,
            name = R.string.ncchr,
            description = R.string.ncchr_detail,
            avatar = R.drawable.museum_ncchr,
            categoryName = R.string.museum
        ),
        Recommendation(
            category = Category.Museum,
            name = R.string.coke,
            description = R.string.coke_detail,
            avatar = R.drawable.museum_world_of_cc,
            categoryName = R.string.museum
        ),
        Recommendation(
            category = Category.Museum,
            name = R.string.trap,
            description = R.string.trap_detail,
            avatar = R.drawable.museum_rap_music_museum,
            categoryName = R.string.museum
        ),
        Recommendation(
            category = Category.Museum,
            name = R.string.high_museum_of_art,
            description = R.string.high_museum_of_art_detail,
            avatar = R.drawable.museum_high_museum_of_art,
            categoryName = R.string.museum
        ),

        //Pizza
        Recommendation(
            category = Category.Pizza,
            name = R.string.amalfi,
            description = R.string.amalfi_detail,
            avatar = R.drawable.pizza_amalfi,
            categoryName = R.string.pizza
        ),
        Recommendation(
            category = Category.Pizza,
            name = R.string.antico,
            description = R.string.antico_detail,
            avatar = R.drawable.pizza_antico,
            categoryName = R.string.pizza
        ),
        Recommendation(
            category = Category.Pizza,
            name = R.string.fellinis,
            description = R.string.fellinis_detail,
            avatar = R.drawable.pizza_fellinis,
            categoryName = R.string.pizza
        ),
        Recommendation(
            category = Category.Pizza,
            name = R.string.glide,
            description = R.string.glide_detail,
            avatar = R.drawable.pizza_glide,
            categoryName = R.string.pizza
        ),
        Recommendation(
            category = Category.Pizza,
            name = R.string.double_zero,
            description = R.string.double_zero_detail,
            avatar = R.drawable.pizza_double_zero,
            categoryName = R.string.pizza
        ),
        Recommendation(
            category = Category.Pizza,
            name = R.string.juniors,
            description = R.string.juniors_detail,
            avatar = R.drawable.pizza_juniors,
            categoryName = R.string.pizza
        ),
        Recommendation(
            category = Category.Pizza,
            name = R.string.nina_and_rafi,
            description = R.string.nina_and_rafi_detail,
            avatar = R.drawable.pizza_nina_and_rafi,
            categoryName = R.string.pizza
        ),
        Recommendation(
            category = Category.Pizza,
            name = R.string.varuni_napoli,
            description = R.string.varuni_napoli_detail,
            avatar = R.drawable.pizza_varuni_napoli,
            categoryName = R.string.pizza
        ),

        //Shopping
        Recommendation(
            category = Category.ShoppingCenter,
            name = R.string.lenox,
            description = R.string.lenox_detail,
            avatar = R.drawable.shopping_lenox,
            categoryName = R.string.shopping
        ),
        Recommendation(
            category = Category.ShoppingCenter,
            name = R.string.atlantic,
            description = R.string.atlantic_detail,
            avatar = R.drawable.shopping_atlantic_station,
            categoryName = R.string.shopping
        ),
        Recommendation(
            category = Category.ShoppingCenter,
            name = R.string.perimeter,
            description = R.string.perimeter_detail,
            avatar = R.drawable.shopping_perimeter_mall,
            categoryName = R.string.shopping
        ),
        Recommendation(
            category = Category.ShoppingCenter,
            name = R.string.phipps,
            description = R.string.phipps_detail,
            avatar = R.drawable.shopping_phipps_plaza,
            categoryName = R.string.shopping
        ),
        Recommendation(
            category = Category.ShoppingCenter,
            name = R.string.ponce,
            description = R.string.ponce_detail,
            avatar = R.drawable.shopping_ponce_city_market,
            categoryName = R.string.shopping
        )
    )
}