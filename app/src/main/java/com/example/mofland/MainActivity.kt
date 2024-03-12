package com.example.mofland

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.mofland.ui.theme.MoflandTheme
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

@Composable
fun DraggableTextLowLevel() {
    Box(modifier = Modifier.fillMaxSize()) {
        var offsetX by remember { mutableStateOf(0f) }
        var offsetY by remember { mutableStateOf(0f) }
        var scale by remember { mutableStateOf(3f) }

        Box(
            Modifier
                .graphicsLayer(scaleX = scale, scaleY = scale, translationX = offsetX, translationY = offsetY)
                .pointerInput(Unit) {
                    detectTransformGestures { centroid, pan, zoom, rotation ->
                        offsetX = (offsetX + pan.x*scale).coerceAtMost(0f)
                        offsetY += pan.y*scale
                        scale = (zoom*scale).coerceIn(3f .. 4f)
                    }
                }.fillMaxSize(),
            content = {
                Image(
                    painter = painterResource(R.drawable.map),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
                //Row {
                //    Image(
                //        painter = painterResource(R.drawable.profile),
                //        contentDescription = null,
                //        modifier = Modifier.fillMaxSize()
                //    )
                //}
            }
        )
        Row {

        }
    }
}

@Composable
fun Render(modifier: Modifier = Modifier){

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MoflandTheme {

    }
}