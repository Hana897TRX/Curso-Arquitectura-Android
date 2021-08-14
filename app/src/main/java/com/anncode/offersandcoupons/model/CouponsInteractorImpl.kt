package com.anncode.offersandcoupons.model

import com.anncode.offersandcoupons.presenter.CouponsPresenter

class CouponsInteractorImpl(var couponsPresenter: CouponsPresenter) : CouponsInteractor {
    private var couponRepository : CouponRepository = CouponRepositoryImpl(couponsPresenter)

    override fun getCouponsAPI() {
        couponRepository.getCouponsAPI()
    }

    override fun getCouponsDB() {
        TODO("Not yet implemented")
    }
}