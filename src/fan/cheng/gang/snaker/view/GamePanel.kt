package fan.cheng.gang.snaker.view

import fan.cheng.gang.snaker.model.Food
import fan.cheng.gang.snaker.model.Ground
import fan.cheng.gang.snaker.model.Snake
import fan.cheng.gang.snaker.util.Global
import java.awt.Color
import java.awt.Graphics
import javax.swing.JPanel

/**
 * creater: fancg
 * date:2017-05-29.
 * package:fan.cheng.gang.snaker.view
 * project:RetroSnaker
 */
class GamePanel : JPanel() {

    var snake:Snake?=null
    var food:Food?=null
    var ground:Ground?=null

    init {
        this.setSize(Global().WIDTH*Global().CELL_SIZE,Global().HEIGHT*Global().CELL_SIZE)
    }

    fun display(snake: Snake,food: Food,ground: Ground){
        this.food=food
        this.ground=ground
        this.snake=snake
        this.repaint()
    }

    override fun paintComponent(g: Graphics?) {
        g!!.color= Color(0xcfcfcf)
        g.fillRect(0,0,Global().WIDTH*Global().CELL_SIZE,Global().HEIGHT*Global().WIDTH)
        if(null!=this.food&&null!=this.ground&&null!=this.snake) {
            this.food!!.drawMe(g)
            this.ground!!.drawMe(g)
            this.snake!!.drawMe(g)
        }
    }
}