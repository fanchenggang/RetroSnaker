package fan.cheng.gang.snaker.model

import fan.cheng.gang.snaker.SnakeListener
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
class Snake {

    var listeners=mutableSetOf<SnakeListener>()
    var body= LinkedList<Point>()
    var oldDirection=0
    var newDirection=0
    val SNAKE_MOVE_UP = -1
    val SNAKE_MOVE_DOWN=1
    val SNAKE_MOVE_LEFT=2
    val SNAKE_MOVE_RIGHT=-2
    var lastPoint:Point?=null
    var life:Boolean?=null

    init {
        life=true
        var x=Global().WIDTH/2-3
        var y=Global().HEIGHT/2
        for (i in 1..3){
               body.addFirst(Point(x++,y))
        }
        oldDirection=SNAKE_MOVE_RIGHT
        newDirection=SNAKE_MOVE_RIGHT
    }


    //获取贪吃蛇头坐标
    fun getHead():Point{
        return body.first
    }

    fun move(){
        if (!((newDirection+oldDirection)==0)) oldDirection=newDirection
        //1.去尾
        lastPoint=body.removeLast()
        var x=body.first.x
        var y=body.first.y
        when(oldDirection){
            SNAKE_MOVE_UP->{
                y--
                if(y<0) y=Global().HEIGHT-1
            }
            SNAKE_MOVE_DOWN->{
                y++
                if(y==Global().HEIGHT) y=0
            }
            SNAKE_MOVE_LEFT->{
                x--
                if (x<0)  x=Global().WIDTH-1
            }
            SNAKE_MOVE_RIGHT->{
                x++
                if(x==Global().WIDTH) x=0
            }
        }
        //2.加头
        body.addFirst(Point(x,y))
    }

    fun changeDirection(dir:Int) {
        newDirection = dir
    }

    fun eatFood(){
        body.addLast(lastPoint);
    }

    fun isEatBody():Boolean{
       for (i in 1..body.size-1)
           if (body.get(i).equals(getHead()))return true
        return false
    }

    fun drawMe(g:Graphics?){
        g!!.color= Color.BLUE
        body.forEach {
            p-> g.fill3DRect(p.x*Global().CELL_SIZE,p.y*Global().CELL_SIZE,Global().CELL_SIZE,Global().CELL_SIZE,true)
        }
    }
    fun start(){
       Thread(Runnable {
           while (life!!){
               move();
               listeners.forEach {l->l.snakeMove(this)}
               Thread.sleep(200)
           }
       }).start()
    }
    fun die(){
        life=false
    }
    fun  addSnakeListener(l:SnakeListener?){
        if(null!=l) this.listeners.add(l)
    }

}