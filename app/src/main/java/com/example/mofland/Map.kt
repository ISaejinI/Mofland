package com.example.mofland

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import com.example.mofland.utils.loadSpritesheet

val spritePositions = listOf(
    Offset(100f, 200f),
    Offset(300f, 400f),
    Offset(500f, 600f)
    // Ajoutez d'autres positions si nécessaire
)

val wood = Resources(name = "wood",  elt = R.drawable.forestelement, res = R.drawable.logressource, tool =  R.drawable.ic_launcher_foreground, _cost = 10, id=0)
val rock = Resources(name = "rock",  elt = R.drawable.mineelement, res = R.drawable.rockressource, tool =  R.drawable.ic_launcher_background, _cost = 10, id=1)
val wheat = Resources(name = "wheat",  elt = R.drawable.farmelement, res = R.drawable.wheatressource, tool =  R.drawable.ic_launcher_foreground, _cost = 10, id = 2)
val gold = Resources(name = "gold",  elt = R.drawable.townelement, res = R.drawable.moneyressource, tool =  R.drawable.ic_launcher_background, _cost = 15, id = 3)
val listRes = listOf(wood, rock, wheat, gold)
@Composable
fun ClickButton(modifier: Modifier = Modifier, resource : Resources){
    //System.out.println("${resource.name} : ${resource.nb}")
    Column {

        Text(text = "Clicks pour ${resource.name} : ${resource.nb}")

    }
}

@Composable
fun Map() {
    LocalContext.current.loadSpritesheet(R.drawable.map, 2, 2)
    listRes.forEach{
        LocalContext.current.loadSpritesheet(it.elt, 1, 1)
    }
    val game by remember { mutableStateOf(makeGame(listRes))}
    Box(modifier = Modifier.fillMaxSize()) {
        var offsetX by remember { mutableStateOf(0f) }
        var offsetY by remember { mutableStateOf(0f) }
        var scale by remember { mutableStateOf(3f) }

        Box(
            Modifier
                .graphicsLayer(
                    scaleX = scale,
                    scaleY = scale,
                    translationX = offsetX,
                    translationY = offsetY
                )
                .pointerInput(Unit) {
                    detectTransformGestures { centroid, pan, zoom, rotation ->
                        offsetX = (offsetX + pan.x * scale)
                        //offsetX = (offsetX + pan.x * scale).coerceAtMost(0f)
                        offsetY += pan.y * scale
                        //offsetX = (offsetX + pan.x * scale).coerceAtMost(0f)
                        //offsetY += pan.y * scale
                        scale = (zoom * scale).coerceIn(3f..4f)
                    }
                }
                .fillMaxSize(),
            content = {
                game.View(modifier = Modifier
                    .fillMaxSize()
                )
            }
        )
        Row {
            ClickButton(Modifier, wood)
            ClickButton(Modifier, rock)
            ClickButton(Modifier, wheat)
            ClickButton(Modifier, gold)
        }
    }
}