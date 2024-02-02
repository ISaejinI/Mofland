package com.example.mofland

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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mofland.ui.theme.MoflandTheme
import fr.iutlens.mmi.demo.utils.Music
import fr.iutlens.mmi.demo.utils.loadSound

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
        super.onCreate(savedInstanceState)
        loadSound(R.raw.whoosh)
        setContent {
            MoflandTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Menu()
                }
            }
        }
    }
}

@Composable
fun Menu(modifier: Modifier = Modifier) {
    val background = painterResource(R.drawable.menu)
    val profile = painterResource(R.drawable.profile)
    val gradient = Brush.linearGradient(
        0.0f to Color.Magenta,
        500.0f to Color.Cyan,
        start = Offset.Zero,
        end = Offset.Infinite)
    var menu by remember{ mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient))
    {
        Button(onClick = { menu = true}) {
            Text(text = "Menu")
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()

    ){
        AnimatedVisibility(
            visible = menu,
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
                        .fillMaxSize()
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
                                .fillMaxHeight(0.4f)
                        ){
                            Row {
                                Image(
                                    painter = profile,
                                    contentDescription = null,
                                    modifier = Modifier
                                )
                                Column {
                                    Text(text = "Géralt de Rives")
                                    Text(text = "1m72")
                                }
                            }
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .fillMaxHeight()

                    ) {
                        Image(
                            painter = profile,
                            contentDescription = null,
                            modifier = Modifier
                                .weight(1f)
                        )
                    }
                    //Icon(
                    //    imageVector = Icons.Filled.Clear,
                    //    contentDescription = "Close",
                    //    modifier = Modifier
                    //        .clickable { menu = false }
                    //        .padding(8.dp)
                    //)

                }
            }
            Music.playSound(R.raw.whoosh)
        }
    }

}

@Preview(showBackground = true, showSystemUi = true, device = "spec:width=411dp,height=891dp,dpi=420,isRound=false,chinSize=0dp,orientation=landscape")
@Composable
fun GreetingPreview() {
    MoflandTheme {
        Menu()
    }
}