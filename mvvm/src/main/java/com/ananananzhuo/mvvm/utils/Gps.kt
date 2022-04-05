package com.broaddeep.flow.utils

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle

import android.content.pm.PackageManager

import androidx.core.app.ActivityCompat

import android.content.Intent
import android.location.*

import android.provider.Settings
import android.util.Log
import java.io.IOException


class Gps(val context: Context) {
    private var locationManager: LocationManager? = null
    private val TAG = "GPS-Info"
    private var myLocationListener: MyLocationListener? = null

    init {
        initLocationManager()
    }

    /**
     * 获取权限，并检查有无开户GPS
     */
    private fun initLocationManager() {
        locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager?
//        if (!isGpsOpen()) {
        // 转到手机设置界面，用户设置GPS
//            val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//            context.startActivity(intent)
//            openGps()
//        }
        getProviders()
    }

    fun isGpsOpen(): Boolean {
        return locationManager!!.isProviderEnabled(LocationManager.GPS_PROVIDER)
    }

    fun openGps() {
        val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }

    /**
     * 获取可定位的方式
     */
//    private var myLocationListener: MyLocationListener? = null
    private var bestProvider: String? = null
    private fun getProviders() {
        //获取定位方式
        val providers = locationManager!!.getProviders(true)
        for (s in providers) {
        }
        val criteria = Criteria()
        // 查询精度：高，Criteria.ACCURACY_COARSE比较粗略，Criteria.ACCURACY_FINE则比较精确
        criteria.accuracy = Criteria.ACCURACY_FINE
        // 是否查询海拨：否
        criteria.isAltitudeRequired = true
        // 是否查询方位角 : 否
        criteria.isBearingRequired = false
        // 设置是否要求速度
        criteria.isSpeedRequired = false
        // 电量要求：低
        criteria.powerRequirement = Criteria.POWER_LOW
        bestProvider = locationManager!!.getBestProvider(criteria, false) //获取最佳定位
        myLocationListener = MyLocationListener()
    }

    var callback: (Location?) -> Unit = {

    }

    @SuppressLint("MissingPermission")
    fun startLocation(callback: (Location?) -> Unit) {
        this.callback = callback
//        if (PermissionUtils.hasPermissions(context as Activity, arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION,))){
//
//        }else{
//            callback(null)
//        }
        val provider: String =
            locationManager?.getBestProvider(getCriteria(), true) ?: ""
        val location = locationManager?.getLastKnownLocation(provider)
        if (location == null) {
            locationManager!!.requestLocationUpdates(bestProvider!!, 0, 0f, myLocationListener!!)
//            log("单次定位失败，开始持续定位")
        } else {
            callback(location)
//            log("单次定位成功")
        }
    }

    fun stopLocation() {
        Log.e(TAG, "stopLocation: ")
        locationManager!!.removeUpdates(myLocationListener!!)
    }

    private fun getCriteria(): Criteria {
        val criteria = Criteria()
        //设置定位精确度 Criteria.ACCURACY_COARSE比较粗略，Criteria.ACCURACY_FINE则比较精细
        criteria.accuracy = Criteria.ACCURACY_FINE
        //设置是否要求速度
        criteria.isSpeedRequired = false
        //设置是否允许运营商收费
        criteria.isCostAllowed = true
        //设置是否需要方位信息
        criteria.isBearingRequired = false
        //设置是否需要海拔信息
        criteria.isAltitudeRequired = false
        //设置对电源的需求
        criteria.powerRequirement = Criteria.POWER_LOW
        return criteria
    }

    private inner class MyLocationListener : LocationListener {
        override fun onLocationChanged(location: Location) {
            //定位时调用
            Log.e(TAG, "onLocationChanged")
            var addresses: List<Address> = ArrayList()
            //经纬度转城市
            val geocoder = Geocoder(context)
            try {
                addresses =
                    geocoder.getFromLocation(location.latitude, location.longitude, 10)
                for (address in addresses) {
                    //国家  CN
//                Log.e(TAG, address.getCountryCode())
//                //国家
//                Log.e(TAG, address.getCountryName())
//                //省，市，地址
//                Log.e(TAG, address.getAdminArea())
//                Log.e(TAG, address.getLocality())
//                Log.e(TAG, address.getFeatureName())
//
//                //经纬度
//                Log.e(TAG, java.lang.String.valueOf(address.getLatitude()))
//                Log.e(TAG, java.lang.String.valueOf(address.getLongitude()))
                    callback(location)
                    //                Log.e(TAG,address.getAddressLine());
                }
                stopLocation()
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }
    }
}