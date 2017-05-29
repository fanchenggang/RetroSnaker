package fan.cheng.gang.snaker.game

import fan.cheng.gang.snaker.controller.Controller
import fan.cheng.gang.snaker.model.Food
import fan.cheng.gang.snaker.model.Ground
import fan.cheng.gang.snaker.model.Snake
import fan.cheng.gang.snaker.util.Global
import fan.cheng.gang.snaker.view.GamePanel
import java.awt.BorderLayout
import javax.swing.JFrame
import javax.swing.JFrame.EXIT_ON_CLOSE

/**
 * creater: fancg
 * date:2017-05-29.
 * package:fan.cheng.gang.snaker.game
 * project:RetroSnaker
 */
object Game {

    @JvmStatic
    fun main (args:Array<String>){
        var gamePanel=GamePanel()
        var snake=Snake()
        var controller=Controller(snake, Food(), Ground(), gamePanel)
        val jFrame = JFrame()
        jFrame.defaultCloseOperation=EXIT_ON_CLOSE
        jFrame.setSize(Global().WIDTH*Global().CELL_SIZE+1,Global().HEIGHT*Global().CELL_SIZE+21)
        jFrame.add(gamePanel,BorderLayout.CENTER)
        gamePanel.addKeyListener(controller)
        snake.addSnakeListener(controller)
        jFrame.addKeyListener(controller)
        jFrame.isVisible=true
        controller.newGame()


    }
}


