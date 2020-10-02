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


class MainActivity : AppCompatActivity(),SensorEventListener {


    private var sensorManager: SensorManager? = null
//    private var accelData: MutableList<Float>? = null

    private var xy_angle = 0f
    private var xz_angle = 0f
    private var zy_angle = 0f

//    private var xyView: TextView? = null
//    private var xzView: TextView? = null
//    private var zyView: TextView? = null

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