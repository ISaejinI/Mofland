package fr.univartois.iutlens.mofland.game.sprite

import android.graphics.RectF
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.withTransform
import fr.univartois.iutlens.mofland.utils.SpriteSheet

open class MofleSprite(val spriteSheet: SpriteSheet,
                       var x: Float, var y: Float,
                       var ndx : Int = 0,
                       var action: (MofleSprite.()->Unit)? = null) : Sprite {

    constructor(id: Int,  x: Float, y: Float, ndx : Int=0, action: (MofleSprite.()->Unit)? = null) :
            this(SpriteSheet[id]!!, x, y,ndx, action)

    // taille du sprite en pixels, divisée par deux (pour le centrage)
    private val w2 = spriteSheet.spriteWidth / 2f
    private val h2 = spriteSheet.spriteHeight / 2f

    override fun paint(drawScope: DrawScope, elapsed: Long) =
        drawScope.withTransform({translate(x,y)}){
            spriteSheet.paint(this, ndx, -w2, -h2)
        }


    //rectangle occuppé par le sprite
    override val boundingBox get() = RectF(x - w2, y - h2, x + w2, y + h2)
    override fun update() {action?.invoke(this)}
}

/**
 * Construction d'un sprite à partir d'une feuille de sprite (désignée par son numéro de ressource)
 *
 * @param x
 * @param y
 * @param ndx
 * @param action
 */
fun Int.toSprite(x: Float, y: Float, ndx : Int=0, action: (MofleSprite.()->Unit)? = null) =
    MofleSprite(this, x, y,ndx, action)