package fr.univartois.iutlens.mofland.mofles

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import com.example.mofland.R
import fr.univartois.iutlens.mofland.resources.Resources
import fr.univartois.iutlens.mofland.resources.gold
import fr.univartois.iutlens.mofland.resources.rock
import fr.univartois.iutlens.mofland.resources.wheat
import fr.univartois.iutlens.mofland.resources.wood

class Mofle(val name : String = "No Name",
            val elt : Int = R.drawable.ic_launcher_foreground,
            val resource : Resources = wood,
            val id : Int
            ) {
    var mlt by mutableIntStateOf(1) //Bonus (le +combien)
    var upMlt by mutableIntStateOf(1) //Améliorateur du bonus
    var cost by mutableIntStateOf(100)
    var lvl by mutableIntStateOf(0)
}


val Mofle1 = Mofle(name = "morgane", elt = R.drawable.woodmofle, resource = wood, id = 0)
val Mofle2 = Mofle(name = "steve", elt = R.drawable.rockmofle, resource = rock, id = 1)
val Mofle3 = Mofle(name = "marnie", elt = R.drawable.wheatmofle, resource = wheat, id = 2)
val Mofle4 = Mofle(name = "teddy", elt = R.drawable.moneymofle, resource = gold, id = 3)
val listMof = listOf(Mofle1, Mofle2, Mofle3, Mofle4)