package com.example.mofland

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue

class Mofle(val name : String = "No Name",
            val res : Int = R.drawable.ic_launcher_foreground,
            val tool : Int = R.drawable.ic_launcher_background,
            _cost : Int = 0,
            val id : Int
) {
    var nb by mutableIntStateOf(0)
    var mlt by mutableIntStateOf(1) //Bonus (le +combien)
    var upMlt by mutableIntStateOf(1) //Améliorateur du bonus
    var cost by mutableIntStateOf(_cost)
    var lvl by mutableIntStateOf(1)
}