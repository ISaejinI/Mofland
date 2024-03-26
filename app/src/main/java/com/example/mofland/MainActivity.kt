package com.example.mofland

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.mofland.ui.theme.MoflandTheme
import com.example.mofland.utils.loadSpritesheet
import kotlin.math.ceil
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoflandTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DraggableTextLowLevel()
                }
            }
        }
    }
}

val spritePositions = listOf(
    Offset(100f, 200f),
    Offset(300f, 400f),
    Offset(500f, 600f)
    // Ajoutez d'autres positions si nécessaire
)

val wood = Resources(name = "wood",  res = R.drawable.logressource, tool =  R.drawable.ic_launcher_foreground, _cost = 10, id=0)
val rock = Resources(name = "rock",  res = R.drawable.rockressource, tool =  R.drawable.ic_launcher_background, _cost = 10, id=1)
val wheat = Resources(name = "wheat",  res = R.drawable.wheatressource, tool =  R.drawable.ic_launcher_foreground, _cost = 10, id = 2)
val gold = Resources(name = "gold",  res = R.drawable.moneyressource, tool =  R.drawable.ic_launcher_background, _cost = 15, id = 3)
val listRes = listOf(wood, rock, wheat, gold)
@Composable
fun ClickButton(modifier: Modifier = Modifier, resource : Resources){
    //System.out.println("${resource.name} : ${resource.nb}")
    Column {

        Text(text = "Clicks pour ${resource.name} : ${resource.nb}")

    }
}

@Composable
fun DraggableTextLowLevel() {
    LocalContext.current.loadSpritesheet(R.drawable.map, 2, 2)
    LocalContext.current.loadSpritesheet(R.drawable.profile, 1, 1)
    listRes.forEach{
        LocalContext.current.loadSpritesheet(it.res, 1, 1)
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
                    .background(Color.Black))
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

//@Composable
//fun sprite(modifier: Modifier