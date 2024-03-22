package com.example.mofland

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mofland.ui.theme.MoflandTheme

@Composable
fun Menu(modifier: Modifier = Modifier, visible : Boolean, onDismiss: () -> Unit) {
    if (visible){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black.copy(alpha = 0.5f))
        )
    }
    val background = painterResource(R.drawable.menu)
    val profile = painterResource(R.drawable.profile)
    Box(
        modifier = Modifier
            .fillMaxSize()

    ){
        AnimatedVisibility(
            visible = visible,
            enter = slideInVertically(
                initialOffsetY = { it },
                animationSpec = tween(durationMillis = 500)
            ),
            exit = slideOutVertically(
                targetOffsetY = { it },
                animationSpec = tween(durationMillis = 500)
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .align(alignment = Alignment.Center)
            ) {
                Image(
                    painter = background,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .align(alignment = Alignment.Center)
                )
                Row(
                    modifier = Modifier
                        .padding(115.dp, 50.dp)
                    // .background(Color.Black)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .fillMaxHeight()

                    ) {
                        Column (
                            modifier = Modifier
                                .fillMaxHeight(0.3f)
                        ){
                            Row {
                                Image(
                                    painter = profile,
                                    contentDescription = null,
                                    modifier = Modifier
                                )
                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier.fillMaxSize()
                                ) {
                                    Text(modifier= Modifier.padding(8.dp), style= TextStyle(fontSize = 22.sp), text = "GÃ©ralt de Rives")
                                    Text(modifier= Modifier.padding(8.dp), style= TextStyle(fontSize = 22.sp), text = "1m72")
                                }
                            }
                        }
                        Column {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight(0.5f),
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                Image(
                                    painter = profile,
                                    contentDescription = null,
                                    modifier = Modifier.padding(8.dp)
                                )
                                Image(
                                    painter = profile,
                                    contentDescription = null,
                                    modifier = Modifier.padding(8.dp)
                                )
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                Image(
                                    painter = profile,
                                    contentDescription = null,
                                    modifier = Modifier.padding(8.dp)
                                )
                                Image(
                                    painter = profile,
                                    contentDescription = null,
                                    modifier = Modifier.padding(8.dp)
                                )
                            }

                        }
                    }
                    //Column(
                    //    modifier = Modifier
                    //        .fillMaxWidth(1f)
                    //        .fillMaxHeight()
                    //) {
                    //    Image(
                    //        painter = profile,
                    //        contentDescription = null,
                    //        modifier = Modifier
                    //            .weight(1f)
                    //    )
                    //}
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Fermer",
                        modifier = Modifier
                            .offset(x = 320.dp, y = -(30.dp))
                            .clickable { onDismiss() }
                            .padding(8.dp)
                    )
                    val activity = (LocalContext.current as? Activity)
                    Button(onClick = {
                        activity?.finish()
                    }) {
                        Text("Exit")
                    }
                    Row {
                        ClickButton(Modifier, wood)
                        ClickButton(Modifier, rock)
                        ClickButton(Modifier, wheat)
                        ClickButton(Modifier, gold)
                    }

                }
            }
        }
    }


}

@Composable
fun BlockerSurface(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize()
            .pointerInput(Unit){},
        color = Color.Transparent
    ) {}
}

//@Preview(showBackground = true, showSystemUi = true, device = "spec:width=411dp,height=891dp,dpi=420,isRound=false,chinSize=0dp,orientation=landscape")
//@Composable
//fun MenuPreview() {
//    MoflandTheme {
//        Menu()
//    }
//}