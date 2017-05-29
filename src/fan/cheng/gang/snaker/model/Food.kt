package fan.cheng.gang.snaker.model

import com.sun.javafx.scene.control.GlobalMenuAdapter
import fan.cheng.gang.snaker.util.Global
import java.awt.Color
import java.awt.Graphics
import java.awt.Point

/**
 * creater: fancg
 * date:2017-05-29.
 * package:fan.cheng.gang.snaker.model
 * project:RetroSnaker
 */
class Food :Point(){


    fun isSnakeEatFood(snake: Snake):Boolean{
        return this.equals(snake.getHead())
    }
    fun drawMe(g:Graphics){
        g.color= Color.BLUE
        g.fill3DRect(x*Global().CELL_SIZE,y*Global().CELL_SIZE,Global().CELL_SIZE,Global().CELL_SIZE,true)
    }

    fun newFood(p:Point){
        this.location=p
    }

}