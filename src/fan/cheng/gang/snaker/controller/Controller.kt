package fan.cheng.gang.snaker.controller

import fan.cheng.gang.snaker.SnakeListener
import fan.cheng.gang.snaker.model.Food
import fan.cheng.gang.snaker.model.Ground
import fan.cheng.gang.snaker.model.Snake
import fan.cheng.gang.snaker.view.GamePanel
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent

/**
 * creater: fancg
 * date:2017-05-29.
 * package:fan.cheng.gang.snaker.controller
 * project:RetroSnaker
 */
class Controller (var snake: Snake?,var food: Food?,var ground: Ground?,var gamePanel: GamePanel?): SnakeListener, KeyAdapter(){



    override fun keyPressed(e: KeyEvent?) {
        when(e!!.keyCode){
            KeyEvent.VK_UP->this.snake!!.changeDirection(Snake().SNAKE_MOVE_UP)
            KeyEvent.VK_DOWN->snake!!.changeDirection(Snake().SNAKE_MOVE_DOWN)
            KeyEvent.VK_LEFT->snake!!.changeDirection(Snake().SNAKE_MOVE_LEFT)
            KeyEvent.VK_RIGHT->snake!!.changeDirection(Snake().SNAKE_MOVE_RIGHT)
        }
    }

    override fun snakeMove(snake: Snake) {
        if(food!!.isSnakeEatFood(snake)){
            snake.eatFood()
            food!!.newFood(ground!!.getPoint())
        }
        if(ground!!.isSnakeEatRock(snake)) snake.die()
        if(snake.isEatBody()) snake.die()
        gamePanel!!.display(snake!!,food!!,ground!!)
    }

    fun newGame(){
        snake!!.start()
        food!!.newFood(ground!!.getPoint())
    }

}