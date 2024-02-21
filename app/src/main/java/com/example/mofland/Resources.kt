package com.example.mofland

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue

class Resources(val name : String = "No Name",
                val res : Int = R.drawable.ic_launcher_foreground,
                val tool : Int = R.drawable.ic_launcher_background,
                _cost : Int = 0
) {
    fun click() {
        nb+=mlt
    }

    var nb by mutableIntStateOf(0)
    var mlt by mutableIntStateOf(1)
    var upMlt by mutableIntStateOf(1)
    var cost by mutableIntStateOf(_cost)
}

/*
    class Wood {
        var nb by mutableIntStateOf(0)
        var mlt by mutableIntStateOf(1)
        var wood = R.drawable.ic_launcher_foreground
        var tool = R.drawable.ic_launcher_background
    }


    class Rock {
        var nb by mutableIntStateOf(0)
        var mlt by mutableIntStateOf(1)
        var wood = R.drawable.ic_launcher_foreground
        var tool = R.drawable.ic_launcher_background
    }

    class Wheat {
        var nb by mutableIntStateOf(0)
        var mlt by mutableIntStateOf(1)
        var wood = R.drawable.ic_launcher_foreground
        var tool = R.drawable.ic_launcher_background
    }

    class Gold {
        var nb by mutableIntStateOf(0)
        var mlt by mutableIntStateOf(1)
        var wood = R.drawable.ic_launcher_foreground
        var tool = R.drawable.ic_launcher_background
    }
}*/