package com.example.mofland

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mofland.ui.theme.MoflandTheme
import com.example.mofland.Resources
import kotlin.math.ceil

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
        super.onCreate(savedInstanceState)
        setContent {
            MoflandTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Render()
                }
            }
        }
    }
}


//@Composable
//fun TotalRessources(){

//}

val wood = Resources(name = "wood",  res = R.drawable.ic_launcher_foreground, tool =  R.drawable.ic_launcher_foreground, _cost = 10, id=0)
val rock = Resources(name = "rock",  res = R.drawable.ic_launcher_background, tool =  R.drawable.ic_launcher_background, _cost = 10, id=1)
val wheat = Resources(name = "wheat",  res = R.drawable.ic_launcher_foreground, tool =  R.drawable.ic_launcher_foreground, _cost = 10, id = 2)
val gold = Resources(name = "gold",  res = R.drawable.ic_launcher_background, tool =  R.drawable.ic_launcher_background, _cost = 15, id = 3)

fun upgradeTest(resource : Resources){

}

@Composable
fun ClickButton(modifier: Modifier = Modifier, resource : Resources){
    Column {
        Image(
            painter = painterResource(resource.tool),
            contentDescription = null,
            modifier=Modifier.clickable { resource.click()})
        Text(text = "Clicks pour ${resource.name} : ${resource.nb}")
        Text(text = "Bonus : ${resource.mlt}")
        Text(text = "Cout ${resource.name} : ${resource.cost}")
        Text(text = "Cout gold : ${ceil(resource.cost/2.0).toInt()}")
        Button(
            onClick = { upgradeClick(resource) },
            enabled = checkUpgrade(resource)
        ) {
            Text(text = "${resource.lvl} -> ${resource.lvl+1}")
        }
    }
}

@Composable
fun Render(modifier: Modifier = Modifier){
    wood.upgrade ={
        wood.mlt++
        gold.nb -= 100
    }
    var menu by remember{ mutableStateOf(true) }
    Row(
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .fillMaxSize())
    {
        Button(onClick = { menu = !menu}) {
            Text(text = "Menu")
        }
    }
    Menu(onClose = {menu = false })
    Row {
        ClickButton(Modifier, wood)
        ClickButton(Modifier, rock)
        ClickButton(Modifier, wheat)
        ClickButton(Modifier, gold)
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MoflandTheme {

    }
}