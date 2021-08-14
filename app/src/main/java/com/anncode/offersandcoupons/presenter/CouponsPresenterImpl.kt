package com.anncode.offersandcoupons.presenter

import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.model.CouponsInteractor
import com.anncode.offersandcoupons.model.CouponsInteractorImpl
import com.anncode.offersandcoupons.view.CouponView

class CouponsPresenterImpl(var couponView : CouponView) : CouponsPresenter{
    // private var couponInteractor : CouponInteractor

    private var couponInteractor : CouponsInteractor = CouponsInteractorImpl(this)

    override fun showCoupons(coupons: ArrayList<Coupon>?) {
        couponView.showCoupons(coupons)
    }

    override fun getCoupons() {
        couponInteractor.getCouponsAPI()
    }
}