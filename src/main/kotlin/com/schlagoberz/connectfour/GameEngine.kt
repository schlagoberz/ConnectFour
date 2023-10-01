package com.schlagoberz.connectfour

import kotlin.system.exitProcess

class GameEngine(private val renderer: Renderer, private val connectFour: ConnectFour) {
    fun start() {
        printWelcome()

        while (!connectFour.isGameOver()) {
            println(renderer.render())

            val column = readInColumn() ?: continue

            try {
                connectFour.makeMove(column - 1)
            } catch (ex: Exception) {
                println(ex.message)
            }
        }

        println(renderer.render())

        if (connectFour.hasWinner())
            println("Player ${colorizedPlayerName(connectFour.getWinner()!!)} wins!")
        else
            println("Tie!")

        printGoodbye()
    }

    private fun printWelcome() {
        val welcomeMessage = "Welcome to Connect Four."
        val separator = "=".repeat(welcomeMessage.length)

        println(separator)
        println(welcomeMessage)
        println(separator)
    }

    private fun printGoodbye() {
        println("Good Bye.")
    }

    private fun readInColumn(): Int? {
        println("${colorizedPlayerName(connectFour.next)} it is your turn.")
        print("Please, enter a valid column number (0-6): ")

        try {
            return readln().toIntOrNull()
        } catch (ex: Exception) {
            println("\n")
            printGoodbye()
            exitProcess(0)
        }
    }

    private fun colorizedPlayerName(player: Player): String {
        return when (player) {
            Player.Red -> player.toString().red()
            Player.Yellow -> player.toString().yellow()
        }
    }
}