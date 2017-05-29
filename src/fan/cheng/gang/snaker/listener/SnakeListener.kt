package fan.cheng.gang.snaker

import fan.cheng.gang.snaker.model.Snake
/**
 * creater: fancg
 * date:2017-05-29.
 * package:fan.cheng.gang.snaker
 * project:RetroSnaker
 */
interface SnakeListener {
    fun snakeMove(snake: Snake)
}