package com.example.mofland

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mofland.ui.theme.MoflandTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoflandTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                        ClickButton()
                }
            }
        }
    }
}


//@Composable
//fun TotalRessources(){

//}

@Composable
fun ClickButton(modifier: Modifier = Modifier){
    var counterbois by remember { mutableIntStateOf(0) }
    Column {
        Image(
            painter = painterResource(R.drawable.bois),
            contentDescription = null,
            modifier=Modifier.clickable { counterbois += 1
            })
        Text(text = "Clicks : $counterbois")

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MoflandTheme {

    }
}