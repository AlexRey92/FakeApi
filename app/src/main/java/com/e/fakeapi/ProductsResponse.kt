package com.e.fakeapi

data class ProductsResponse (

    val array:List<Products>
        )

data class Products(
    val id:Int,
    val title:String,
    val price:Double,
    val description:String,
    val category:String,
    val image:String,
    val rating:RatingClass
)

data class RatingClass (
    val rate:Double,
    val count:Int

        )


