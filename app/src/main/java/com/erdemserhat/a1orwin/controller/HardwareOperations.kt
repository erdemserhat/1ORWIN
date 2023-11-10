package com.erdemserhat.a1orwin.controller

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.content.getSystemService

class HardwareOperations {

    companion object{
        private lateinit var context:Context

        fun initalizeHardwareOperations(context:Context){
            this.context=context
        }

        fun viberate(millisecondsValue:Long){
            val v = (context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(
                    VibrationEffect.createOneShot(millisecondsValue,
                    VibrationEffect.DEFAULT_AMPLITUDE))
            }
            else {
                v.vibrate(millisecondsValue)
            }
        }

        fun proximateSensorListener(listenerForNear:()->Unit,listenerForAway:()->Unit){
            // calling sensor service.
            val sensorManager: SensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager

            // from sensor service we are
            // calling proximity sensor
            val proximitySensor: Sensor? =sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)

            // calling the sensor event class to detect
            // the change in data when sensor starts working.
            val proximitySensorEventListener: SensorEventListener = object : SensorEventListener {
                override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
                    // method to check accuracy changed in sensor.
                }

                override fun onSensorChanged(event: SensorEvent) {
                    // check if the sensor type is proximity sensor.
                    if (event.sensor.type == Sensor.TYPE_PROXIMITY) {
                        if (event.values[0] == 0f) {
                            // here we are setting our status to our textview..
                            // if sensor event return 0 then object is closed
                            // to sensor else object is away from sensor.
                            //---->sensorStatusTV.setText("Near")
                            listenerForNear()

                        } else {
                            //------>sensorStatusTV.setText("Away")
                            listenerForAway()

                        }
                    }
                }
            }
            // handling the case if the proximity
            // sensor is not present in users device.
            if (proximitySensor == null) {
                Toast.makeText(context, "No proximity sensor found in device.", Toast.LENGTH_SHORT).show();
            } else {
                // registering our sensor with sensor manager.
                sensorManager!!.registerListener(proximitySensorEventListener,
                    proximitySensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
            }


        }

    }
}