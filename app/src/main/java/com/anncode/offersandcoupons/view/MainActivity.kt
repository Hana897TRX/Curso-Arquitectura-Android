package com.anncode.offersandcoupons.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.databinding.ActivityMainBinding
import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.viewmodel.CouponViewModel

class MainActivity : AppCompatActivity() {
    private var couponViewModel : CouponViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        setupBindins(savedInstanceState)
    }

    fun setupBindins(savedInstanceState: Bundle?) {
        val activityMainBinding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        couponViewModel = ViewModelProviders.of(this).get(CouponViewModel::class.java)

        activityMainBinding.model = couponViewModel
        setupListUpdate()
    }

    fun setupListUpdate() {
        couponViewModel?.callCoupons()

        couponViewModel?.getCoupons()?.observe(this, Observer { coupons : List<Coupon> ->
            couponViewModel?.setCouponsInRecyclerAdapter(coupons)
        })
    }
}
