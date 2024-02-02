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

    Row (modifier = Modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top) {
        CadreComposant(modifier = Modifier, nbrRessource = rocks, imgRessource = rock)
        CadreComposant(modifier = Modifier, nbrRessource = woods, imgRessource = wood)
        CadreComposant(modifier = Modifier, nbrRessource = wheats, imgRessource = wheat)
        CadreComposant(modifier = Modifier, nbrRessource = golds, imgRessource = gold)
    }
}

@Composable
fun CadreComposant(modifier: Modifier = Modifier, nbrRessource: Int, imgRessource: Painter){
    val cadre = painterResource(R.drawable.cadre)


    Box(modifier = Modifier
        .width(150.dp)) {
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