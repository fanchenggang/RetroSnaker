package fan.cheng.gang.snaker.model

import fan.cheng.gang.snaker.util.Global
import java.awt.Color
import java.awt.Graphics
import java.awt.Point
import java.util.*

/**
 * creater: fancg
 * date:2017-05-29.
 * package:fan.cheng.gang.snaker.model
 * project:RetroSnaker
 */
class Ground {

    val rocks = Array(Global().WIDTH) { IntArray(Global().HEIGHT) }

    init {
            for (x in 0..Global().WIDTH - 1){
                rocks[x][Global().HEIGHT - 1] = 1
                rocks[x][0] = 1
            }
            for (y in 0..Global().HEIGHT - 1) {
                rocks[Global().WIDTH - 1][y] = 1
                rocks[0][y] = 1
            }
    }

    fun isSnakeEatRock(snake: Snake):Boolean{
        for (x in 0..Global().WIDTH-1){
            for(y in 0..Global().HEIGHT-1){
                if(rocks[x][y]==1&&x==snake.getHead().x&&y==snake.getHead().y) return true
            }
        }
        return false
    }
    fun getPoint(): Point {
        var r=Random()
        var x=0
        var y=0
        do {
            x=Random().nextInt(Global().WIDTH)
            y=Random().nextInt(Global().HEIGHT)
        }while (rocks[x][y]==1);//如果是石头坐标继续随机生成
        return Point(x,y)
    }
    fun drawMe(g: Graphics) {
        for (x in 0..Global().WIDTH - 1)
            for (y in 0..Global().HEIGHT - 1) {
                if (rocks[x][y]==1) {
                    g.color = Color.DARK_GRAY
                    g.fill3DRect(x * Global().CELL_SIZE, y * Global().CELL_SIZE,Global().CELL_SIZE, Global().CELL_SIZE,true)
                }
            }
    }


}