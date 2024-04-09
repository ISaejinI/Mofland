package fr.univartois.iutlens.mofland.mofles

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import fr.univartois.iutlens.mofland.resources.Resources
import fr.univartois.iutlens.mofland.resources.gold
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.math.ceil

fun checkUpgradeMof(mof: Mofle): Boolean {
    return when (mof.id) {
        0, 1, 2 -> if(mof.lvl==0) gold.nb >= mof.cost else mof.resource.nb >=mof.cost && gold.nb >= ceil(mof.cost / 2.0).toInt()
        3 -> mof.resource.nb >= mof.cost
        else -> false
    }
}

fun upgradeClickMof(mof : Mofle){
    when (mof.id) {
        0, 1, 2 -> {
            if(mof.lvl==0){
                gold.nb -= mof.cost
                mof.lvl += 1
                mof.cost = ceil(mof.cost * 2.0).toInt()
            }
            else{
                mof.resource.nb -= mof.cost
                mof.lvl += 1
                if (mof.lvl % 10 == 0) {
                    mof.mlt += mof.lvl
                    mof.upMlt += 1
                } else {
                    mof.mlt += mof.upMlt
                }
                gold.nb -= ceil(mof.cost / 2.0).toInt()
                mof.cost = ceil(mof.cost * 2.0).toInt()
            }
            autoIncrement(mof)
        }
        3 -> {
            mof.resource.nb -= mof.cost
            mof.lvl += 1
            if (mof.lvl % 10 == 0) {
                mof.mlt += mof.lvl
                mof.upMlt += 1
            } else {
                mof.mlt += mof.upMlt
            }
            mof.cost = ceil(mof.cost * 1.75).toInt()
            autoIncrement(mof)
        }
        else -> Unit
    }
}

fun autoIncrement(mof: Mofle): Job {
    var statut = true
    val lvl = mof.lvl
    return CoroutineScope(Dispatchers.Default).launch {
        while (statut) {
            if (lvl == mof.lvl) {
                mof.resource.nb += mof.mlt
                delay(1000)
            } else {
                statut = false
            }
        }
        if(!statut){
            autoIncrement(mof)
        }
    }
}