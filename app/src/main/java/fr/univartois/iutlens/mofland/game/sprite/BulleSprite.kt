package fr.univartois.iutlens.mofland.game.sprite

import android.graphics.Typeface
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.drawText
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.w3c.dom.Text

class BulleSprite(sprite: Int, x: Float, y: Float, ndx: Int, var duration: Int, text : String) :
    BasicSprite(sprite,x,y,ndx){

        init {
            this.action = {
                this.y -= 10
                --duration
                this.x += (Math.random()*4-2).toFloat()
            }
        }
    val textPaint = Paint().asFrameworkPaint().apply {
        isAntiAlias = true
        textSize = 20f
        color = android.graphics.Color.WHITE
        typeface = Typeface.create(Typeface.MONOSPACE, Typeface.BOLD)
    }

    val content = text

    override fun paint(drawScope: DrawScope, elapsed: Long) {
        //super.paint(drawScope, elapsed)
        drawScope.drawIntoCanvas {
            it.nativeCanvas.drawText(
                content,
                x,            // x-coordinates of the origin (top left)
                y, // y-coordinates of the origin (top left)
                textPaint
            )
        }
    }

}
