package fr.univartois.iutlens.mofland.resources

import kotlin.math.ceil



fun checkUpgradeRes(res: Resources): Boolean {
    return when (res.id) {
        0, 1, 2 -> res.nb >= res.cost && gold.nb >= ceil(res.cost / 2.0).toInt()
        3 -> res.nb >= res.cost && wood.nb >= res.cost * 2 && rock.nb >= res.cost * 2 && wheat.nb >= res.cost * 2
        else -> false
    }
}


fun upgradeClickRes(res : Resources){
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
            if ((res.lvl+1)%10 == 0){
                res.nextMlt = res.mlt + res.lvl + 1
            }else{
                res.nextMlt = res.mlt+res.upMlt
            }
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
            if ((res.lvl+1)%10 == 0){
                res.nextMlt = res.mlt + res.lvl + 1
            }else{
                res.nextMlt = res.mlt+res.upMlt
            }
        }
        else -> Unit
    }
}