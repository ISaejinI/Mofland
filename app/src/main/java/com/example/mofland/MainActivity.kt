package com.example.mofland

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.geometry.Offset
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import com.example.mofland.menu.Home
import fr.iutlens.mmi.demo.utils.Music
import fr.iutlens.mmi.demo.utils.Music.muteMusic
import fr.iutlens.mmi.demo.utils.Music.muteSound
import fr.iutlens.mmi.demo.utils.loadSound

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
        super.onCreate(savedInstanceState)
        loadSound(R.raw.play)
        setContent {
            MoflandTheme {
                // A surface container using the 'background' color from the theme
                Game()
            }
        }
    }

    var previousMusic: Boolean = false
    var previousSound: Boolean = false
    override fun onPause() {
        super.onPause()
        previousMusic = muteMusic
        previousSound = muteSound
        muteMusic = true //couper le son quand on est pas sur l'écran
        muteSound = true
        println("OnPause : $previousMusic")
    }

    override fun onResume(){
        super.onResume()
        muteMusic = previousMusic
        muteSound = previousSound
        println("OnResume : $previousMusic muteMusic : $muteMusic")
    }
}

enum class Screen { Home, Game, Credits }

@Composable
fun Game() {
    var currentScreen by remember { mutableStateOf(Screen.Home) }

    if (currentScreen==Screen.Home || currentScreen==Screen.Credits){
        Music(id = R.raw.home)
    }

    Surface {
        when (currentScreen) {
            Screen.Home -> Home(onNavigate = { screen -> currentScreen = screen })
            Screen.Game -> Map()
            Screen.Credits -> Credits(onNavigate = { screen -> currentScreen = screen })
        }
    }
}