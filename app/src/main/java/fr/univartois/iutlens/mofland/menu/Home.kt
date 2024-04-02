package fr.univartois.iutlens.mofland.menu

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mofland.R
import fr.univartois.iutlens.mofland.Screen
import fr.iutlens.mmi.demo.utils.Music

@Composable
fun Home(modifier: Modifier = Modifier, onNavigate: (Screen) -> Unit) {
    val espacement = 200
    val backgroundColor = Color(0xFFE3B13A)
    var menu by remember {
        mutableStateOf(false)
    }

    val interactionSource = remember { MutableInteractionSource() }

    val activity = (LocalContext.current as? Activity)

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = backgroundColor
        ) {
            MiddleText(
                modifier = Modifier.padding(bottom = 128.dp))

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 64.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            ) {
                CadreComposant(modifier = Modifier, Txt = "Continuer", onNavigate = onNavigate){onNavigate(Screen.Game);Music.playSound(R.raw.play)}
                Spacer(modifier = Modifier.width(espacement.dp))
                CadreComposant(modifier = Modifier, Txt = "Quitter", onNavigate = onNavigate){activity?.finish()}
            }
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomEnd),
                contentAlignment = Alignment.BottomEnd)
            {
                Text(
                    text = "Paramètres",
                    color = Color.White,
                    fontSize = 32.sp,
                    modifier = Modifier.clickable(interactionSource = interactionSource, indication = null) { menu = true }
                )
            }
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomStart),
                contentAlignment = Alignment.BottomStart)
            {
                Text(
                    text = "Crédits",
                    color = Color.White,
                    fontSize = 32.sp,
                    modifier = Modifier.clickable(interactionSource = interactionSource, indication = null) { onNavigate(
                        Screen.Credits)
                        Music.playSound(R.raw.play)}
                )
            }
        }
        Params(visible = menu, onDismiss = {menu = false})
    }
}

@Composable
fun CadreComposant(modifier: Modifier = Modifier, Txt: String, onNavigate: (Screen) -> Unit, onClickAction: () -> Unit){
    val cadre = R.drawable.scrollinterfacelarge
    val activity = (LocalContext.current as? Activity)

    val interactionSource = remember { MutableInteractionSource() }

    Box(modifier = Modifier
        .width(200.dp)
        .height(100.dp)) {
        Image(
            bitmap = ImageBitmap.imageResource(id = cadre),
            filterQuality = FilterQuality.None,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
                .clickable(interactionSource = interactionSource, indication = null) { onClickAction()}
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
                .offset(x = 0.dp, y = (-7).dp)
        ) {
            Text(text = Txt,
                color = Color.White,
                fontSize = 40.sp
            )
        }
    }
}

@Composable
fun MiddleText(modifier: Modifier = Modifier) {
    val MiddleTextColor = Color(0xFF715745)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Bienvenue sur Mofland",
            color= MiddleTextColor,
            fontSize = 64.sp)
    }
}