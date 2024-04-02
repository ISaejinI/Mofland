package fr.univartois.iutlens.mofland

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import fr.univartois.iutlens.mofland.ui.theme.MoflandTheme
import com.example.mofland.R
import fr.univartois.iutlens.mofland.menu.Home
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

    if (currentScreen== Screen.Home || currentScreen== Screen.Credits){
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