package com.example.mofland.menu

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Slider
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
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mofland.R
import fr.iutlens.mmi.demo.utils.Music
import fr.iutlens.mmi.demo.utils.Music.muteMusic
import fr.iutlens.mmi.demo.utils.Music.muteSound


@Composable
fun Oops(modifier: Modifier = Modifier, visible : Boolean, onDismiss: () -> Unit) {
    val paramsBackground = Color(0xFF715745)
    val paramsBorder = Color(0xFFFFCA38)
    val transparentBlack = Color(0x80000000)
    val activity = (LocalContext.current as? Activity)

    val interactionSource = remember { MutableInteractionSource() }

    var componentHeight by remember { mutableStateOf(0.dp) }
    var componentWidth by remember { mutableStateOf(0.dp) }

    val density = LocalDensity.current

    if(visible){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(transparentBlack)
                .padding(16.dp)
                .pointerInput(Unit){},
            contentAlignment = Alignment.Center
        ) {
            Surface(
                color = paramsBackground,
                modifier = Modifier
                    .fillMaxWidth(0.6f) // Utiliser la moitié de l'espace disponible
                    .background(paramsBackground)
                    .border(width = 2.dp, color = paramsBorder)
                    .onGloballyPositioned {
                        componentHeight = with(density) {
                            it.size.height.toDp()
                        }
                        componentWidth = with(density) {
                            it.size.width.toDp()
                        }
                    },
                content = {
                    Column(
                        modifier = Modifier.fillMaxWidth().padding(16.dp),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Malheureusement, la fonctionnalité n'a pas encore été implémentée. Revenez dans la V2",
                            color = Color.White,
                            fontSize = 30.sp,
                            textAlign = TextAlign.Center,
                        )

                    }
                }
            )
            Image(
                painter = painterResource(id = R.drawable.closeinterface),
                contentDescription = "Image",
                modifier = Modifier
                    .size(60.dp)
                    .offset(x = componentWidth/2, y = -componentHeight/2)
                    .padding(end = 4.dp, top = 4.dp)
                    .clickable(interactionSource = interactionSource, indication = null) { onDismiss() }
            )
        }
    }
}