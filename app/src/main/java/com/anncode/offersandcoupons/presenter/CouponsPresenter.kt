package com.anncode.offersandcoupons.presenter

import com.anncode.offersandcoupons.model.Coupon

// Acciones
interface CouponsPresenter {
    // Vista
    fun showCoupons(coupons : ArrayList<Coupon>?)

    // Interactor
    fun getCoupons()
}