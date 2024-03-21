package com.example.mofland

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.mofland.game.Game
import com.example.mofland.ui.theme.MoflandTheme
import com.example.mofland.game.sprite.BasicSprite
import com.example.mofland.game.sprite.Sprite
import com.example.mofland.game.sprite.get
import com.example.mofland.game.sprite.mutableSpriteListOf
import com.example.mofland.game.sprite.tiledArea
import com.example.mofland.game.sprite.toMutableTileMap
import com.example.mofland.game.transform.FitTransform
import com.example.mofland.utils.SpriteSheet
import com.example.mofland.utils.loadSpritesheet

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
    listRes.forEach{
        val res = it.res
        repeat(7){ // On crée plusieurs sprites aléatoires
            list.add(
                BasicSprite(
                    res,
                    (tileMap.sizeX*Math.random()*tileMap.w).toFloat(),
                    (tileMap.sizeY*Math.random()*tileMap.h).toFloat(),
                    0)
            )
        }
    }

    System.out.println(list)


    val game = Game(background = tileMap,
        spriteList = list,
        transform = FitTransform(tileMap) //jeu visible entièrement sur l'écran, basé sur le fond
    ){ (x,y)->
        val target  =  list[x,y]
        if (target != null) {
            list.remove(target)
            list.add(
                BasicSprite(
                    R.drawable.logressource,
                    (tileMap.sizeX*Math.random()*tileMap.w).toFloat(),
                    (tileMap.sizeY*Math.random()*tileMap.h).toFloat(),
                    0)
            )
        }
    }

    var current : Sprite? = null

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