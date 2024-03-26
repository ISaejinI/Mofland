package com.example.mofland.menu

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mofland.R


@Composable
fun Params(modifier: Modifier = Modifier, visible : Boolean, onDismiss: () -> Unit) {
    val paramsBackground = Color(0xFF715745)
    val paramsBorder = Color(0xFFFFCA38)
    val transparentBlack = Color(0x80000000)
    val activity = (LocalContext.current as? Activity)


    var interfaceEnabled by remember { mutableStateOf(false) }

    val imageResourceId = if (interfaceEnabled) {
        R.drawable.enableinterface
    } else {
        R.drawable.disableinterface
    }

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
                    .fillMaxSize(0.6f) // Utiliser la moitié de l'espace disponible
                    .background(paramsBackground)
                    .border(width = 2.dp, color = paramsBorder),
                content = {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Paramètres",
                            color = Color.White,
                            fontSize = 40.sp,
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = imageResourceId),
                                contentDescription = "Image",
                                modifier = Modifier
                                    .size(50.dp)
                                    .clickable {
                                        interfaceEnabled = !interfaceEnabled
                                    },
                                contentScale = ContentScale.Fit
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text("Musique", color = Color.White, fontSize = 24.sp)
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Text("Quitter", color = Color.White, fontSize = 30.sp, modifier = Modifier.clickable { activity?.finish() })
                    }
                }
            )
            Image(
                painter = painterResource(id = R.drawable.closeinterface),
                contentDescription = "Image",
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.TopEnd)
                    .padding(end = 4.dp, top = 4.dp)
                    .clickable { onDismiss() }
            )
        }
    }
}