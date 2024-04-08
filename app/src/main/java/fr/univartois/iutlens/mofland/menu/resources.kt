package com.example.mofland

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.univartois.iutlens.mofland.resources.Resources
import fr.univartois.iutlens.mofland.resources.checkUpgradeRes
import fr.univartois.iutlens.mofland.resources.gold
import fr.univartois.iutlens.mofland.resources.listRes
import fr.univartois.iutlens.mofland.resources.rock
import fr.univartois.iutlens.mofland.resources.upgradeClickRes
import fr.univartois.iutlens.mofland.resources.wheat
import fr.univartois.iutlens.mofland.resources.wood
import java.util.Locale
import kotlin.math.ceil

@Composable
fun BlockLeft(modifier: Modifier = Modifier, width:Dp, img: Int, onClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.offset(x=width),
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
            ) {
                Box(
                    modifier = Modifier
                        .clickable{onClick()},
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bookmarkinterface),
                        contentDescription = "Paw Button",
                        modifier = Modifier.size(70.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.pawbutton),
                        contentDescription = "Paw Button",
                        modifier = Modifier.size(40.dp).offset(x=6.dp)
                    )
                }
            }
        }
    )
}
@Composable
fun SplitRectangleScreenR(modifier: Modifier = Modifier, resources: List<Resources>, visible : Boolean, onDismiss: () -> Unit) {
    if(visible) {
        var componentWidth by remember { mutableStateOf(0.dp) }
        val density = LocalDensity.current
        var clickRes by remember {
            mutableStateOf(listRes[0])
        }
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

            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center) {
                Box(modifier = Modifier.aspectRatio(3f/2f)){
                    Image(
                        bitmap = ImageBitmap.imageResource(id = R.drawable.openbookinterface),
                        contentDescription = "Votre description",
                        filterQuality = FilterQuality.None,
                        modifier = Modifier
                            .fillMaxSize()
                            .onGloballyPositioned {
                                componentWidth = with(density) {
                                    it.size.width.toDp()
                                }
                            },
                    )
                }
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
                            modifier = Modifier.size(width = 490.dp, height = 350.dp),
                            leftContent = {
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    verticalArrangement = Arrangement.Top,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "Améliorations",
                                        modifier = Modifier.padding(8.dp),
                                        color = Color(0xFF715745),
                                        fontSize = 20.sp
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
                                    listRes.forEach { ressource ->
                                        Spacer(modifier = Modifier.height(12.dp))
                                        ImprovementItemR(
                                            modifier = Modifier
                                                .padding(end = 40.dp)
                                                .background(
                                                    Color(0xFF52E7DE),
                                                    shape = RoundedCornerShape(8.dp)
                                                )
                                                .clickable { clickRes = ressource },
                                            resource = ressource

                                        )
                                    }
                                }
                            },
                            rightContent = {
                                RightPartR(resource = clickRes)
                            }
                        )
                    }
                }
            }
           // BlockLeft(width = -componentWidth / 2){}
        }
    }
}

@Composable
fun SplitRectangle(
    modifier: Modifier = Modifier,
    leftContent: @Composable () -> Unit,
    rightContent: @Composable () -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        ) {
            leftContent()
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        ) {
            rightContent()
        }
    }
}

@Composable
fun ImprovementItemR(modifier: Modifier = Modifier, resource: Resources) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.size(64.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier.size(50.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.yellowbutton),
                    contentDescription = "Image à gauche",
                    modifier = Modifier.size(60.dp)
                )
                Image(
                    painter = painterResource(id = resource.tool),
                    contentDescription = "Image à l'intérieur de YellowButton",
                    modifier = Modifier.size(40.dp)
                )
            }
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = resource.nameTool.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() },
            modifier = Modifier
                .weight(1f)
                .offset(y = -3.dp),
            color = Color(0xFF715745),
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.width(8.dp))
        Box(
            modifier = Modifier.size(64.dp)
            ,
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier.size(48.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.tag),
                    contentDescription = "Image à droite",
                    modifier = Modifier.size(54.dp)
                )
                Text(
                    text = "Nv ${resource.lvl}",
                    modifier = Modifier
                        .padding(4.dp)
                        .offset(y = -3.dp),
                    color = Color(0xFF715745),
                    fontSize = 15.sp
                )
            }
        }
    }
}

@Composable
fun RightPartR(modifier: Modifier = Modifier, resource: Resources){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 40.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.size(48.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = resource.tool),
                    contentDescription = "Image en haut à gauche",
                    modifier = Modifier.size(50.dp)
                )
            }
            Spacer(modifier = Modifier.width(40.dp))
            Column {
                Text(
                    text = resource.nameTool.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() },
                    color = Color(0xFF715745),
                    fontSize = 24.sp
                )
                Box(
                    modifier = Modifier
                        .width(150.dp)
                        .height(2.dp) // Hauteur de la barre
                        .background(Color(0xFFE76D5A), shape = RoundedCornerShape(10))
                )
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
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Skills",
            color = Color(0xFF715745),
            fontSize = 18.sp
        )
        Text(
            text = "Mine ${resource.mlt} de ${resource.name} par click",
            color = Color(0xFF715745),
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Prochain Niveau",
            color = Color(0xFF715745),
            fontSize = 18.sp
        )
        Text(
            text = "+ ${resource.upMlt} par clics",
            color = Color(0xFF715745),
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Coût",
            color = Color(0xFF715745),
            fontSize = 18.sp
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            when (resource.id) {
                0, 1, 2 -> {
                    val listCost = listOf(resource, gold)
                    listCost.forEach {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                modifier = Modifier.size(20.dp),
                                painter = painterResource(id = it.res),
                                contentDescription = "Votre image"
                            )
                            Text(
                                text = if(it.id!=3) "${it.cost}" else "${ceil(resource.cost/2.0).toInt()}",
                                color = if((it.id!=3 && resource.nb >= resource.cost)||(it.id==3 && gold.nb >= ceil(resource.cost / 2.0).toInt())) Color(0xFF715745) else Color(0x80715745),
                                fontSize = 14.sp,
                                modifier = Modifier.padding(start = 4.dp)
                            )
                        }
                    }
                }
                3 -> {
                    val listCost = listOf(wood, rock, wheat, resource)
                    listCost.forEach {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                modifier = Modifier.size(20.dp),
                                painter = painterResource(id = it.res),
                                contentDescription = "Votre image"
                            )
                            Text(
                                text = if(it.id==3) "${it.cost}" else "${gold.cost*2}",
                                color =  if((it.id==3 && it.nb >= it.cost) || (it.id==0 && it.nb >= gold.cost * 2) || (it.id==1 && it.nb >= gold.cost * 2) || (it.id==2 && it.nb >= gold.cost * 2)) Color(0xFF715745) else Color(0x80715745),
                                fontSize = 14.sp,
                                modifier = Modifier.padding(start = 4.dp)
                            )
                        }
                    }
                }
                else -> Unit
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .size(256.dp)
                .graphicsLayer {
                    if (!checkUpgradeRes(resource)) {
                        alpha = 0.5f // Transparence de 50% pour la nuance de gris
                    }
                },
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .size(100.dp)
                    .clickable(enabled = checkUpgradeRes(resource)) { upgradeClickRes(resource) },
                painter = painterResource(id = R.drawable.yellowlargebutton),
                contentDescription = "Image tout en bas"
            )
            Text(
                text = "Améliorer",
                color = Color(0xFF715745),
                fontSize = 20.sp,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}