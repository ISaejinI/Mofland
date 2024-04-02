package com.example.mofland.game.sprite

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import com.example.mofland.resources.Resources

class RessourceSprite(val ressource: Resources, x: Float, y: Float, ndx: Int, _nbClick: Int) :
    BasicSprite(ressource.elt,x,y,ndx) {
    var nbClick by mutableIntStateOf(_nbClick)
}
