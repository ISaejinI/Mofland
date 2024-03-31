package com.example.mofland

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.iutlens.mmi.demo.utils.Music

@Composable
fun Credits(modifier: Modifier = Modifier, onNavigate: (Screen) -> Unit){
    val backgroundColor = Color(0xFFE3B13A)
    val MiddleTextColor = Color(0xFF715745)
    Box(modifier = Modifier.fillMaxSize()) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = backgroundColor) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Les crédits",
                    modifier=Modifier.fillMaxWidth(),
                    color = MiddleTextColor,
                    fontSize = 64.sp,
                    textAlign = TextAlign.Center)
                Text(
                    text = "Retour",
                    modifier=Modifier.clickable{onNavigate(Screen.Home)
                    Music.playSound(R.raw.play)},
                    color = Color.White,
                    fontSize = 32.sp)
            }
        }
    }
}