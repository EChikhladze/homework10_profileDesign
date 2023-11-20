package com.example.homework10_profiledesign

import android.graphics.drawable.Drawable

data class Button(val id: Int, val icon: Drawable, val name: String, val type: ButtonType = ButtonType.NORMAL)