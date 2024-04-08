
package fr.univartois.iutlens.mofland

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mofland.R
import com.example.mofland.SplitRectangle
import fr.univartois.iutlens.mofland.mofles.Mofle
import fr.univartois.iutlens.mofland.resources.Resources

@Composable
fun SplitRectangleScreenI(modifier: Modifier = Modifier, resources: List<Resources>, mofles: List<Mofle>, visible : Boolean, onDismiss: () -> Unit) {
    if(visible) {
        val taille = 80
        val espacement = 20

        Surface(
            color = Color(0x80000000),
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                contentAlignment = Alignment.TopEnd// Alignement en haut à droite
            ) {
                Image(
                    painter = painterResource(id = R.drawable.closeinterface),
                    contentDescription = "Close button",
                    modifier = Modifier.size(50.dp).clickable{onDismiss()},
                )
            }

            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    bitmap = ImageBitmap.imageResource(id = R.drawable.openbookinterface),
                    contentDescription = "Votre description",
                    filterQuality = FilterQuality.None,
                    modifier = Modifier.fillMaxSize(),
                )
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        SplitRectangle(
                            modifier = Modifier.size(width = 500.dp, height = 350.dp),
                            leftContent = {
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    verticalArrangement = Arrangement.Top,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "Outils",
                                        modifier = Modifier.padding(8.dp),
                                        color = Color(0xFF715745)
                                    )
                                    Box(
                                        modifier = Modifier
                                            .width(150.dp)
                                            .height(2.dp) // Hauteur de la barre
                                            .background(
                                                Color(0xFFE76D5A),
                                                shape = RoundedCornerShape(10)
                                            )
                                    )
                                    Box(modifier = Modifier.padding(end = 50.dp)) {
                                        Column {
                                            Spacer(modifier = Modifier.height(espacement.dp))
                                            LazyVerticalGrid(
                                                columns = GridCells.Fixed(2),
                                                verticalArrangement = Arrangement.spacedBy(0.dp),
                                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                                modifier = modifier.padding(8.dp),
                                                userScrollEnabled = false
                                            ) {
                                                items(resources){resource ->
                                                    Column {
                                                        Box(
                                                            modifier = Modifier.size(taille.dp),
                                                            contentAlignment = Alignment.Center
                                                        ) {
                                                            Image(
                                                                painter = painterResource(id = R.drawable.yellowbutton),
                                                                contentDescription = "Image à gauche",
                                                                modifier = Modifier.size(80.dp)
                                                            )
                                                            Image(
                                                                painter = painterResource(id = resource.tool),
                                                                contentDescription = "Image à l'intérieur de YellowButton",
                                                                modifier = Modifier.size(60.dp)
                                                            )
                                                        }
                                                        Box(
                                                            modifier = Modifier
                                                                .size(64.dp)
                                                                .padding(start = 20.dp),
                                                            contentAlignment = Alignment.Center
                                                        ) {
                                                            Image(
                                                                painter = painterResource(id = R.drawable.tag),
                                                                contentDescription = "Image en dessous",
                                                                modifier = Modifier.size(48.dp)
                                                            )
                                                            Text(
                                                                text = "Nv ${resource.lvl}",
                                                                color = Color(0xFF715745),
                                                                fontSize = 14.sp,
                                                                modifier = Modifier.padding(start = 4.dp)
                                                            )
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            },
                            rightContent = {
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    verticalArrangement = Arrangement.Top,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "Mofles",
                                        modifier = Modifier.padding(8.dp),
                                        color = Color(0xFF715745)
                                    )
                                    Box(
                                        modifier = Modifier
                                            .width(150.dp)
                                            .height(2.dp) // Hauteur de la barre
                                            .background(
                                                Color(0xFFE76D5A),
                                                shape = RoundedCornerShape(10)
                                            )
                                    )
                                    Box(modifier = Modifier.padding(start = 50.dp)) {
                                        Column {
                                            Spacer(modifier = Modifier.height(espacement.dp))
                                            LazyVerticalGrid(
                                                columns = GridCells.Fixed(2),
                                                verticalArrangement = Arrangement.spacedBy(0.dp),
                                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                                modifier = modifier.padding(8.dp),
                                                userScrollEnabled = false
                                            ) {
                                                items(mofles){mofle ->
                                                    Column {
                                                        Box(
                                                            modifier = Modifier.size(taille.dp),
                                                            contentAlignment = Alignment.Center
                                                        ) {
                                                            Image(
                                                                painter = painterResource(id = R.drawable.yellowbutton),
                                                                contentDescription = "Image à gauche",
                                                                modifier = Modifier.size(80.dp)
                                                            )
                                                            Image(
                                                                painter = painterResource(id = mofle.elt),
                                                                contentDescription = "Image à l'intérieur de YellowButton",
                                                                modifier = Modifier.size(60.dp)
                                                            )
                                                        }
                                                        Box(
                                                            modifier = Modifier
                                                                .size(64.dp)
                                                                .padding(start = 20.dp),
                                                            contentAlignment = Alignment.Center
                                                        ) {
                                                            Image(
                                                                painter = painterResource(id = R.drawable.tag),
                                                                contentDescription = "Image en dessous",
                                                                modifier = Modifier.size(48.dp)
                                                            )
                                                            Text(
                                                                text = "Nv ${mofle.lvl}",
                                                                color = Color(0xFF715745),
                                                                fontSize = 14.sp,
                                                                modifier = Modifier.padding(start = 4.dp)
                                                            )
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}
