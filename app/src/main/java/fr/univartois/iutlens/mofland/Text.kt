package fr.univartois.iutlens.mofland

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mofland.R
import fr.iutlens.mmi.demo.utils.Music
import kotlinx.coroutines.delay

@Composable
fun TypewriterText(
    text: String,
    onClick: () -> Unit = {}
) {
    var visibleText by remember { mutableStateOf("") }
    var isTextFullyDisplayed by remember { mutableStateOf(false) }

    if(isTextFullyDisplayed==false){
        Music(id = R.raw.blabla)
    }else{Music.stopMusic(id = R.raw.blabla)}

    LaunchedEffect(text) {
        for (i in text.indices) {
            visibleText = text.take(i + 1)
            delay(20) // Délai entre chaque caractère
            if (isTextFullyDisplayed) {
                visibleText = text
                break
            }
        }
        isTextFullyDisplayed = true
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFFF3E4CD), shape = RoundedCornerShape(15.dp))
            .clickable {
                if (!isTextFullyDisplayed) {
                    // Affiche le texte entier au clic s'il n'est pas déjà affiché entièrement
                    isTextFullyDisplayed = true
                } else {
                    // Appelle le callback onClick si le texte est déjà entièrement affiché
                    onClick()
                    isTextFullyDisplayed = false
                }
            }
            .padding(16.dp)
    ){
        Text(
            text = visibleText,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
        )
        if (isTextFullyDisplayed){
            Text(
                modifier = Modifier
                    .align(Alignment.BottomEnd),
                color = Color.Black,
                text = "Lire la suite..."
            )
        }
    }
}

@Composable
fun TypewriterDemo() {
    var textIndex by remember { mutableStateOf(0) }
    val texts = listOf(
        stringResource(R.string.detail_text1),
        stringResource(R.string.detail_text2),
        stringResource(R.string.detail_text3)
    )

    var visible by remember {
        mutableStateOf(true)
    }
    if(visible)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x80000000))
                .padding(16.dp)
                .pointerInput(Unit) {},
            contentAlignment = Alignment.BottomCenter
        ){
            Column(modifier = Modifier.fillMaxWidth()) {
                TypewriterText(texts[textIndex]) {
                    if (textIndex < texts.lastIndex) {
                        textIndex++
                    }
                    else{
                        visible = false
                    }
                }
            }
        }
}