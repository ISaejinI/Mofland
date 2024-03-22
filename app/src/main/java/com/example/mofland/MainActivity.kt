package com.example.mofland

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mofland.ui.theme.MoflandTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

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
                    Greeting("")
                }
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true, device = "spec:width=411dp,height=891dp,dpi=420,isRound=false,chinSize=0dp,orientation=landscape")
@Composable
fun GreetingPreview() {
    MoflandTheme {
       Greeting("Android")
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val espacement = 200
    val backgroundColor = Color(0xFFE3B13A)

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
                CadreComposantGauche(modifier = Modifier, Txt = "Continuer")
                Spacer(modifier = Modifier.width(espacement.dp))
                CadreComposantDroit(modifier = Modifier, Txt = "Quitter")
            }
            Param(modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd))
        }
    }
}

@Composable
fun CadreComposantGauche(modifier: Modifier = Modifier, Txt: String){
    val cadre = painterResource(R.drawable.scrollinterfacelarge)
    val activity = (LocalContext.current as? Activity)

    Box(modifier = Modifier
        .width(200.dp)
        .height(100.dp)) {
        Image(
            painter = cadre,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = Txt,
                color = Color.White,
                fontSize = 40.sp
            )
        }
    }
}

@Composable
fun CadreComposantDroit(modifier: Modifier = Modifier, Txt: String){
    val cadre = painterResource(R.drawable.scrollinterfacelarge)
    val activity = (LocalContext.current as? Activity)

    Box(modifier = Modifier
        .width(200.dp)
        .height(100.dp)) {
        Image(
            painter = cadre,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .clickable { activity?.finish() }
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
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

@Composable
fun Param(modifier: Modifier = Modifier){
    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomEnd)
    {
        Text(
            text = "Paramètres",
            color = Color.White,
            fontSize = 32.sp,
        )
    }
}