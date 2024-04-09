package fr.univartois.iutlens.mofland

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mofland.R
import com.example.mofland.SplitRectangleScreenM
import com.example.mofland.SplitRectangleScreenR
import fr.iutlens.mmi.demo.utils.Music
import fr.univartois.iutlens.mofland.menu.Params
import fr.univartois.iutlens.mofland.mofles.listMof
import fr.univartois.iutlens.mofland.resources.Resources
import fr.univartois.iutlens.mofland.resources.listRes
import fr.univartois.iutlens.mofland.utils.loadSpritesheet

val spritePositions = listOf(
    Offset(100f, 200f),
    Offset(300f, 400f),
    Offset(500f, 600f)
    // Ajoutez d'autres positions si nécessaire
)

var componentWidth = 0.dp

@Composable
fun CadreComposantUp(modifier: Modifier = Modifier, resource: Resources){
    val cadre = R.drawable.scrollinterfacepetit2

    Box(modifier = Modifier
        .width(125.dp)
        .aspectRatio(2f/1f)) {
        Image(
            bitmap = ImageBitmap.imageResource(id = cadre),
            filterQuality = FilterQuality.None,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        Row(modifier= Modifier
            .fillMaxSize()
            .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Image(
                bitmap = ImageBitmap.imageResource(id = resource.res),
                filterQuality = FilterQuality.None,
                contentDescription = null,
                modifier = Modifier.size(45.dp, 45.dp)
            )
            Text(
                text = formatNumber(resource.nb).toString(),
                color = Color.White
            )
        }

    }
}

@Composable
fun CadreComposantDown(modifier: Modifier = Modifier, imgRessource: Int, texte: String, onClickAction: () -> Unit){
    val cadre = R.drawable.yellowbutton
    val WriteColor = Color(0xFF715745)
    val interactionSource = remember { MutableInteractionSource() }

    Box(modifier = Modifier
        .padding(bottom = 5.dp)
        .width(80.dp)
        .height(60.dp)) {
        Image(
            bitmap = ImageBitmap.imageResource(id = cadre),
            filterQuality = FilterQuality.None,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                bitmap = ImageBitmap.imageResource(id = imgRessource),
                filterQuality = FilterQuality.None,
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp, 50.dp)
                    .offset(x = 0.dp, y = -(20.dp))
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) { onClickAction();Music.playSound(R.raw.bouttons) }
            )
            Text(text = texte,
                color = WriteColor,
                fontSize = 12.sp,
                modifier = Modifier.padding(top = 32.dp)
            )
        }
    }
}

@Composable
fun Map() {
    LocalContext.current.loadSpritesheet(R.drawable.map, 2, 2)
    listRes.forEach{
        LocalContext.current.loadSpritesheet(it.elt, 1, 1)
    }
    val game by remember { mutableStateOf(makeGame(listRes))}
    var menuParams by remember {
        mutableStateOf(false)
    }

    var menuLivreRes by remember {
        mutableStateOf(false)
    }

    var menuLivreMof by remember {
        mutableStateOf(false)
    }

    var menuLivreInv by remember {
        mutableStateOf(false)
    }

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
        val espacement = 16
        Row (modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Top) {
            listRes.forEach{ ressource->
                Spacer(modifier = Modifier.width(espacement.dp))
                CadreComposantUp(modifier = Modifier, resource = ressource)
            }
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(20.dp)
            .align(Alignment.BottomCenter)
            .background(
                color = Color(0xFF715745)
            )
        )
        Row (modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Bottom) {
            //CadreComposantDown(modifier = Modifier, imgRessource = R.drawable.islandinterface, texte = "Île"){menuOops=true}
            //Spacer(modifier = Modifier.width(espacement.dp))
            //CadreComposantDown(modifier = Modifier, imgRessource = R.drawable.backpackinterface, texte = "Inventaire"){menuOops=true}
            //Spacer(modifier = Modifier.width(espacement.dp))
            CadreComposantDown(modifier = Modifier, imgRessource = R.drawable.upgradeinterface, texte = "Upgrade"){menuLivreRes=true}
            Spacer(modifier = Modifier.width(espacement.dp))
            CadreComposantDown(modifier = Modifier, imgRessource = R.drawable.backpackinterface, texte = "Inventaire"){menuLivreInv=true}
            Spacer(modifier = Modifier.weight(1f))
            CadreComposantDown(modifier = Modifier, imgRessource = R.drawable.gearinterface, texte = "Setting"){menuParams=true}
        }
    }
    Params(visible = menuParams, onDismiss = {menuParams = false})
    SplitRectangleScreenR(resources = listRes, visible = menuLivreRes, onDismiss = {menuLivreRes = false}, onClickOther = {menuLivreMof = true})
    SplitRectangleScreenM(resources = listMof, visible = menuLivreMof, onDismiss = {menuLivreMof = false}, onClickOther = {menuLivreRes = true})
    SplitRectangleScreenI(resources = listRes, mofles = listMof, visible = menuLivreInv, onDismiss = {menuLivreInv = false})
    TypewriterDemo()
}

fun formatNumber(number: Int): String {
    return when {
        number >= 1_000_000_000 -> String.format("%.0fM", number / 1_000_000_000f)
        number >= 1_000_000 -> String.format("%.1fm", number / 1_000_000f)
        number >= 10_000 -> String.format("%.1fK", number / 1_000f)
        else -> number.toString()
    }
}