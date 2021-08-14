package com.anncode.offersandcoupons.model

import android.util.Log
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.presenter.CouponsPresenter
import com.anncode.offersandcoupons.view.RecyclerCouponsAdapter
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CouponRepositoryImpl(var couponsPresenter: CouponsPresenter) : CouponRepository {
    var coupons : ArrayList<Coupon>? = ArrayList()

    // Toda la lógica de la conexión
    override fun getCouponsAPI() {
        // CONTROLLER
        val apiAdapter = ApiAdapter()
        val apiService = apiAdapter.getClientService() //
        val call = apiService.getCoupons()

        call.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("ERROR: ", t.message)
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val offersJsonArray = response.body()?.getAsJsonArray("offers")
                offersJsonArray?.forEach { jsonElement: JsonElement ->
                    val jsonObject = jsonElement.asJsonObject
                    val coupon = Coupon(jsonObject)
                    coupons?.add(coupon)
                }
                couponsPresenter.showCoupons(coupons)
            }
        })
    }

}