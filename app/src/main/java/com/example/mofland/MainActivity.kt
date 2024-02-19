package com.example.mofland

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    val rock = painterResource(R.drawable.pierre)
    val rocks = 2000

    val wood = painterResource(R.drawable.bois)
    val woods = 2000

    val wheat = painterResource(R.drawable.ble)
    val wheats = 2000

    val gold = painterResource(R.drawable.bourse)
    val golds = 2000

    val pickaxe = painterResource(R.drawable.pioche)
    val upgrade = painterResource(R.drawable.upgrade)
    val backpack = painterResource(R.drawable.backpack)
    val book = painterResource(R.drawable.book)

    val espacement = 16

    Row (modifier = Modifier,
        verticalAlignment = Alignment.Top) {
        CadreComposantUp(modifier = Modifier, nbrRessource = rocks, imgRessource = rock)
        Spacer(modifier = Modifier.width(espacement.dp))
        CadreComposantUp(modifier = Modifier, nbrRessource = woods, imgRessource = wood)
        Spacer(modifier = Modifier.width(espacement.dp))
        CadreComposantUp(modifier = Modifier, nbrRessource = wheats, imgRessource = wheat)
        Spacer(modifier = Modifier.width(espacement.dp))
        CadreComposantUp(modifier = Modifier, nbrRessource = golds, imgRessource = gold)
        Spacer(modifier = Modifier.width(180.dp))
        EngrenageIcon(modifier = Modifier)

    }

    Row (modifier = Modifier,
        verticalAlignment = Alignment.Bottom) {
        CadreComposantDown(modifier = Modifier, imgRessource = pickaxe)
        Spacer(modifier = Modifier.width(espacement.dp))
        CadreComposantDown(modifier = Modifier, imgRessource = upgrade)
        Spacer(modifier = Modifier.width(espacement.dp))
        CadreComposantDown(modifier = Modifier, imgRessource = backpack)
        Spacer(modifier = Modifier.width(espacement.dp))
        CadreComposantDown(modifier = Modifier, imgRessource = book)
        Spacer(modifier = Modifier.width(espacement.dp))
    }
}

@Composable
fun CadreComposantUp(modifier: Modifier = Modifier, nbrRessource: Int, imgRessource: Painter){
    val cadre = painterResource(R.drawable.cadre)


    Box(modifier = Modifier
        .width(125.dp)
        .height(75.dp)) {
        Image(
            painter = cadre,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        Row(modifier= Modifier
            .fillMaxSize()
            .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = imgRessource,
                contentDescription = null,
                modifier = Modifier.size(50.dp, 50.dp)
            )
            Text(
                text = nbrRessource.toString()
            )
        }

    }
}

@Composable
fun CadreComposantDown(modifier: Modifier = Modifier, imgRessource: Painter){
    val cadre = painterResource(R.drawable.cadre)

    Box(modifier = Modifier
        .width(100.dp)
        .height(75.dp)) {
        Image(
            painter = cadre,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = imgRessource,
                contentDescription = null,
                modifier = Modifier.size(50.dp, 50.dp)
            )
        }
    }
}

@Composable
fun EngrenageIcon(modifier: Modifier = Modifier){
    Box(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.engrenage),
            contentDescription = null,
            modifier = Modifier.size(50.dp, 50.dp)
        )
    }
}