package com.missclick.webviewdeeplink


import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.missclick.webviewdeeplink.data.FbHelp
import android.app.Application;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLibCore.LOG_TAG
import java.util.Map;


class MainActivity : AppCompatActivity(),SensorEventListener {


    private var sensorManager: SensorManager? = null

    private var xy_angle = 0f
    private var xz_angle = 0f
    private var zy_angle = 0f

    private val devKey = "pP55HP9udtdDHpXaPzNDyF"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManager = (getSystemService(SENSOR_SERVICE) as SensorManager)
//        val listSensor = sensorManager!!.getSensorList(Sensor.TYPE_ACCELEROMETER)
        val accelerometer = sensorManager!!.getSensorList(Sensor.TYPE_ACCELEROMETER)[0]
        sensorManager!!.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME)
//        Log.e("list",listSensor.toString())



        val fb = FbHelp(this).tree()
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        navController.navigate(R.id.mainScreenFragment)

        val conversionDataListener  = object : AppsFlyerConversionListener{
            override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
                data?.let { cvData ->
                    cvData.map {
                        Log.i(LOG_TAG, "conversion_attribute:  ${it.key} = ${it.value}")
                    }
                }
            }

            override fun onConversionDataFail(error: String?) {
                Log.e(LOG_TAG, "error onAttributionFailure :  $error")
            }

            override fun onAppOpenAttribution(data: MutableMap<String, String>?) {
                data?.map {
                    Log.d(LOG_TAG, "onAppOpen_attribute: ${it.key} = ${it.value}")
                }
            }

            override fun onAttributionFailure(error: String?) {
                Log.e(LOG_TAG, "error onAttributionFailure :  $error")
            }
        }
        Log.e("DickPick",conversionDataListener.toString())

        AppsFlyerLib.getInstance().init(devKey, conversionDataListener, this)
        AppsFlyerLib.getInstance().startTracking(this)
    }

    override fun onAccuracyChanged(
        sensor: Sensor?,
        accuracy: Int
    ) { //Изменение точности показаний датчика
    }

    override fun onSensorChanged(event: SensorEvent?) {
        xy_angle = event!!.values[0]; //Плоскость XY
        xz_angle = event!!.values[1]; //Плоскость XZ
        zy_angle = event!!.values[2]; //Плоскость ZY
//        Log.e("xy",xy_angle.toString())
//        Log.e("xz",xz_angle.toString())
//        Log.e("zy",zy_angle.toString())
    }





}