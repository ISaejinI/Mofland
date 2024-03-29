package com.example.mofland

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import fr.iutlens.mmi.demo.utils.Music

@Composable
fun Credits(modifier: Modifier = Modifier, onNavigate: (Screen) -> Unit){
    Text(text = "Les crédits")
    Text(text = "Retour", modifier=Modifier.clickable{onNavigate(Screen.Home)
        Music.playSound(R.raw.play)})
}