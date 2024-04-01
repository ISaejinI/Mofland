package com.example.mofland

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mofland.ui.theme.MoflandTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        actionBar?.show()
        super.onCreate(savedInstanceState)
        setContent {
            MoflandTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting()
                    SplitRectangleScreen()
                }
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true, device = "spec:width=411dp,height=891dp,dpi=420,isRound=false,chinSize=0dp,orientation=landscape")
@Composable
fun GreetingPreview() {
    MoflandTheme {
        //Greeting()
        SplitRectangleScreen()
    }
}
@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Text(text = "Salut")
}


@Composable
fun BlockLeft(modifier: Modifier = Modifier, width:Dp) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.offset(x=width),
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .border(
                            width = 2.dp,
                            color = Color(0xFFFFCA38),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .background(
                            color = Color(0xFF715745),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.pawbutton),
                        contentDescription = "Paw Button",
                        modifier = Modifier.size(40.dp)
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .border(
                            width = 2.dp,
                            color = Color(0xFFFFCA38),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .background(
                            color = Color(0xFF715745),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.pawbutton),
                        contentDescription = "Paw Button",
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
        }
    )
}
@Composable
fun SplitRectangleScreen() {
    var componentWidth by remember { mutableStateOf(0.dp) }
    val density = LocalDensity.current
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                bitmap = ImageBitmap.imageResource(id = R.drawable.openbookinterface),
                contentDescription = "Votre description",
                filterQuality = FilterQuality.None,
                modifier = Modifier.fillMaxSize()
                    .onGloballyPositioned {
                        componentWidth = with(density) {
                            it.size.width.toDp()-125.dp
                        }
                    }.background(Color.Black),
            )
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    SplitRectangle(
                        modifier = Modifier.size(width = 500.dp, height = 350.dp),
                        leftContent = {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Top,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(text = "Améliorations",
                                    modifier = Modifier.padding(8.dp),
                                    color = Color(0xFF715745))
                                repeat(4) {
                                    ImprovementItem(
                                        modifier = Modifier
                                            .padding(end = 40.dp)
                                            .background(
                                                Color(0xFF52E7DE),
                                                shape = RoundedCornerShape(8.dp)
                                            )
                                    )
                                    Spacer(modifier = Modifier.height(16.dp))
                                }
                            }
                        },
                        rightContent = {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(start = 40.dp),
                                verticalArrangement = Arrangement.Top,
                                horizontalAlignment = Alignment.Start
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 20.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Box(
                                        modifier = Modifier.size(48.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.pickaxetool),
                                            contentDescription = "Image en haut à gauche",
                                            modifier = Modifier.size(50.dp)
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(40.dp))
                                    Column {
                                        Text(
                                            text = "Pioche",
                                            color = Color(0xFF715745),
                                            fontSize = 24.sp
                                        )
                                        Box(
                                            modifier = Modifier
                                                .size(64.dp)
                                                .padding(start = 20.dp),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.tag),
                                                contentDescription = "Image en dessous",
                                                modifier = Modifier.size(48.dp)
                                            )
                                            Text(
                                                text = "Nv 10",
                                                color = Color(0xFF715745),
                                                fontSize = 14.sp,
                                                modifier = Modifier.padding(start = 4.dp)
                                            )
                                        }
                                    }
                                }
                                Spacer(modifier = Modifier.height(16.dp))
                                Text(
                                    text = "Skills",
                                    color = Color(0xFF715745),
                                    fontSize = 18.sp
                                )
                                Text(
                                    text = "Mine 25 de pierre par click",
                                    color = Color(0xFF715745),
                                    fontSize = 14.sp
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "Prochain Niveau",
                                    color = Color(0xFF715745),
                                    fontSize = 18.sp
                                )
                                Text(
                                    text = "+ 30 par clics",
                                    color = Color(0xFF715745),
                                    fontSize = 14.sp
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceEvenly,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    repeat(4) {
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Image(
                                                modifier = Modifier.size(20.dp),
                                                painter = painterResource(id = R.drawable.rockressource),
                                                contentDescription = "Votre image"
                                            )
                                            Text(
                                                text = "10",
                                                color = Color(0xFF715745),
                                                fontSize = 14.sp,
                                                modifier = Modifier.padding(start = 4.dp)
                                            )
                                        }
                                    }
                                }
                                Spacer(modifier = Modifier.height(16.dp))
                                Box(
                                    modifier = Modifier.size(256.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        modifier = Modifier.size(100.dp),
                                        painter = painterResource(id = R.drawable.yellowlargebutton),
                                        contentDescription = "Image tout en bas"
                                    )
                                    Text(
                                        text = "Améliorer",
                                        color = Color(0xFF715745),
                                        fontSize = 20.sp,
                                        modifier = Modifier.padding(4.dp)
                                    )
                                }
                            }
                        }
                    )
                }
            }
        }
        BlockLeft(width = -componentWidth/2)
    }
}

@Composable
fun SplitRectangle(
    modifier: Modifier = Modifier,
    leftContent: @Composable () -> Unit,
    rightContent: @Composable () -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        ) {
            leftContent()
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        ) {
            rightContent()
        }
    }
}

@Composable
fun ImprovementItem(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.size(64.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier.size(48.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.yellowbutton),
                    contentDescription = "Image à gauche",
                    modifier = Modifier.size(60.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.pickaxetool),
                    contentDescription = "Image à l'intérieur de YellowButton",
                    modifier = Modifier.size(40.dp)
                )
            }
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Pioche",
            modifier = Modifier.weight(1f),
            color = Color(0xFF715745)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Box(
            modifier = Modifier.size(64.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier.size(48.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.tag),
                    contentDescription = "Image à droite",
                    modifier = Modifier.size(36.dp)
                )
                Text(
                    text = "Nv 10",
                    modifier = Modifier.padding(4.dp),
                    color = Color(0xFF715745),
                    fontSize = 10.sp
                )
            }
        }
    }
}