package com.example.mofland

import kotlin.math.ceil



fun checkUpgrade(res: Resources): Boolean {
    return when (res.id) {
        0, 1, 2 -> res.nb >= res.cost && gold.nb >= ceil(res.cost / 2.0).toInt()
        3 -> res.nb >= res.cost && wood.nb >= res.cost * 2 && rock.nb >= res.cost * 2 && wheat.nb >= res.cost * 2
        else -> false
    }
}


fun upgradeClick(res : Resources){
    when (res.id) {
        0, 1, 2 -> {
            res.nb -= res.cost
            res.lvl += 1
            if (res.lvl % 10 == 0) {
                res.mlt += res.lvl
                res.upMlt += 1
            } else {
                res.mlt += res.upMlt
            }
            gold.nb -= ceil(res.cost / 2.0).toInt()
            res.cost = ceil(res.cost * 1.75).toInt()
        }
        3 -> {
            res.nb -= res.cost
            res.lvl += 1
            if (res.lvl % 10 == 0) {
                res.mlt += res.lvl
                res.upMlt += 1
            } else {
                res.mlt += res.upMlt
            }
            wood.nb -= res.cost * 2
            rock.nb -= res.cost * 2
            wheat.nb -= res.cost * 2
            res.cost = ceil(res.cost * 1.75).toInt()
        }
        else -> Unit
    }
}