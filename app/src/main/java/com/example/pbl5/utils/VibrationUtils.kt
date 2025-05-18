package com.example.pbl5.utils

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager

object VibrationUtils {

    private var lastVibrationTime = 0L
    private val vibrationInterval = 2000L // giới hạn rung mỗi 2 giây

    // Rung bình thường không giới hạn
    fun vibrate(context: Context, duration: Long = 500, amplitude: Int = VibrationEffect.DEFAULT_AMPLITUDE) {
        val vibrator: Vibrator? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vm = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as? VibratorManager
            vm?.defaultVibrator
        } else {
            @Suppress("DEPRECATION")
            context.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
        }

        vibrator?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                it.vibrate(VibrationEffect.createOneShot(duration, amplitude))
            } else {
                @Suppress("DEPRECATION")
                it.vibrate(duration)
            }
        }
    }


    // Nếu dữ liệu cảnh báo tốc độ quá nhiều thì chỉ 2s mới rung
    fun safeVibrate(context: Context, duration: Long) {
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastVibrationTime >= vibrationInterval) {
            VibrationUtils.vibrate(context, duration)
            lastVibrationTime = currentTime
        }
    }

    // Rung theo chu kỳ
    fun vibrateWithPattern(context: Context, pattern: LongArray, repeat: Int = -1) {
        val vibrator: Vibrator? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vm = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as? VibratorManager
            vm?.defaultVibrator
        } else {
            @Suppress("DEPRECATION")
            context.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
        }

        vibrator?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val effect = VibrationEffect.createWaveform(pattern, repeat)
                it.vibrate(effect)
            } else {
                @Suppress("DEPRECATION")
                it.vibrate(pattern, repeat)
            }
        }
    }

    // Hủy rung
    fun cancelVibration(context: Context) {
        val vibrator: Vibrator? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vm = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as? VibratorManager
            vm?.defaultVibrator
        } else {
            @Suppress("DEPRECATION")
            context.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
        }
        vibrator?.cancel()
    }



}