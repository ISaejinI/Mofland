package com.example.mofland.resources

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import com.example.mofland.R

class Resources(val name : String = "No Name",
                val nameTool : String = "No Name",
                val elt : Int = R.drawable.ic_launcher_foreground,
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

    var upgrade : ((Unit) -> Unit)? = null

    fun click() {
        nb+=mlt
    }
}

val wood = Resources(name = "bois", nameTool = "hache",  elt = R.drawable.forestelement, res = R.drawable.logressource, tool =  R.drawable.axetool, _cost = 10, id=0)
val rock = Resources(name = "pierre", nameTool = "pioche",  elt = R.drawable.mineelement, res = R.drawable.rockressource, tool =  R.drawable.pickaxetool, _cost = 10, id=1)
val wheat = Resources(name = "blé", nameTool = "houe",  elt = R.drawable.farmelement, res = R.drawable.wheatressource, tool =  R.drawable.sickletool, _cost = 10, id = 2)
val gold = Resources(name = "or", nameTool = "bourse",  elt = R.drawable.townelement, res = R.drawable.moneyressource, tool =  R.drawable.pursetool, _cost = 15, id = 3)
val listRes = listOf(wood, rock, wheat, gold)

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