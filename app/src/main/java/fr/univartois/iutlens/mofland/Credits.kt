package fr.univartois.iutlens.mofland

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mofland.R
import fr.iutlens.mmi.demo.utils.Music

@Composable
fun Credits(modifier: Modifier = Modifier, onNavigate: (Screen) -> Unit){
    val backgroundColor = Color(0xFFE3B13A)
    val MiddleTextColor = Color(0xFF715745)
    Box(modifier = Modifier.fillMaxSize()) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = backgroundColor) {
            Box(modifier = Modifier.padding(top = 8.dp, bottom = 42.dp).verticalScroll(rememberScrollState())) {
                Column {
                    Text(
                        text = "Crédits",
                        modifier=Modifier.fillMaxWidth(),
                        color = MiddleTextColor,
                        fontSize = 64.sp,
                        textAlign = TextAlign.Center)
                    Text(
                        text = "Créé et développé par :",
                        modifier=Modifier.fillMaxWidth(),
                        color = MiddleTextColor,
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Ethan Barlet",
                        modifier=Modifier.fillMaxWidth(),
                        color = Color.White,
                        fontSize = 32.sp,
                        textAlign = TextAlign.Center)
                    Text(
                        text = "Lou-Anne Biet",
                        modifier=Modifier.fillMaxWidth(),
                        color = Color.White,
                        fontSize = 32.sp,
                        textAlign = TextAlign.Center)
                    Text(
                        text = "Killian Machu",
                        modifier=Modifier.fillMaxWidth(),
                        color = Color.White,
                        fontSize = 32.sp,
                        textAlign = TextAlign.Center)
                    Text(
                        text = "Remerciements :",
                        modifier=Modifier.fillMaxWidth(),
                        color = MiddleTextColor,
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "IUT de Lens",
                        modifier=Modifier.fillMaxWidth(),
                        color = Color.White,
                        fontSize = 32.sp,
                        textAlign = TextAlign.Center)
                    Text(
                        text = "Vincent Dubois",
                        modifier=Modifier.fillMaxWidth(),
                        color = Color.White,
                        fontSize = 32.sp,
                        textAlign = TextAlign.Center)
                }
            }
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomStart),
                contentAlignment = Alignment.BottomStart)
            {
                Text(
                    text = "Retour",
                    modifier = Modifier.clickable {
                        onNavigate(Screen.Home)
                        Music.playSound(R.raw.bouttons)
                    },
                    color = Color.White,
                    fontSize = 32.sp,
                )
            }
        }
    }
}