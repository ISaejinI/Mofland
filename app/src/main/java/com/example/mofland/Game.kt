package com.example.mofland

import com.example.mofland.game.Game
import com.example.mofland.game.sprite.RessourceSprite
import com.example.mofland.game.sprite.Sprite
import com.example.mofland.game.sprite.get
import com.example.mofland.game.sprite.mutableSpriteListOf
import com.example.mofland.game.sprite.tiledArea
import com.example.mofland.game.sprite.toMutableTileMap
import com.example.mofland.game.transform.FitTransform
import com.example.mofland.resources.Resources

fun makeGame(listRes : List<Resources>): Game {
    val map = """
            12
            34
        """.trimIndent().toMutableTileMap(
        "12" +
                "34")
    val tileMap = R.drawable.map.tiledArea(map)
    // val sprite = BasicSprite(R.drawable.car,3.5f*tileMap.w,2.5f*tileMap.h)
    val list = mutableSpriteListOf() // Notre liste de sprites
    val min = 115
    listRes.forEach{ ressource ->
        repeat(7){ // On crée plusieurs sprites aléatoires
            val maxX = (tileMap.sizeX * tileMap.w) - min
            val maxY = (tileMap.sizeY * tileMap.h) - min

            val randomX = (min..maxX).random()
            val randomY = (min..maxY).random()
            list.add(
                RessourceSprite(
                    ressource,
                    randomX.toFloat(),
                    randomY.toFloat(),
                    0,
                    (0..2).random()
                )
            )
        }
    }
    //list.add(
    //    MofleSprite(
    //        listRes[0].elt,
    //        10.00.toFloat(),
    //        0.00.toFloat(),
    //        0
    //    ){
    //        gold.nb+=1
    //    }
    //)


    val game = Game(background = tileMap,
        spriteList = list,
        transform = FitTransform(tileMap) //jeu visible entièrement sur l'écran, basé sur le fond
    ){ (x,y)->
        val target  =  list[x,y]
        if (target != null && target is RessourceSprite) {
            target.ressource.click()
            if(target.nbClick>0){
                target.nbClick-=1
            }else {
                val maxX = (tileMap.sizeX * tileMap.w) - min
                val maxY = (tileMap.sizeY * tileMap.h) - min

                val randomX = (min..maxX).random()
                val randomY = (min..maxY).random()

                //System.out.println("${listRes[0].name} : ${listRes[0].nb}")
                //System.out.println("${listRes[1].name} : ${listRes[1].nb}")
                //System.out.println("${listRes[2].name} : ${listRes[2].nb}")
                //System.out.println("${listRes[3].name} : ${listRes[3].nb}")
                //list.remove(target)
                target.x=randomX.toFloat()
                target.y=randomY.toFloat()
                target.nbClick=(0..2).random()
                //list.add(
                //    RessourceSprite(
                //        target.ressource,
                //        randomX.toFloat(),
                //        randomY.toFloat(),
                //        0,
                //        (0..2).random()
                //    )
                //)
            }
        }
    }

    var current : Sprite? = null

    game.animationDelayMs = 1000
    game.update ={
        it.spriteList.update()
        it.invalidate()
    }

    return game
}

//@Preview(showBackground = true)
//@Composable
//fun GamePreview() {
//    LocalContext.current.loadSpritesheet(R.drawable.map, 2, 2)
//    LocalContext.current.loadSpritesheet(R.drawable.logressource, 1, 1)
//    val game = makeGame()
//    MoflandTheme {
//        game.View(modifier = Modifier.fillMaxSize())
//    }
//}