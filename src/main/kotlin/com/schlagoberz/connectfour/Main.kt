package com.schlagoberz.connectfour

fun main() {
    // Initialize a new game of https://en.wikipedia.org/wiki/Connect_Four.
    val board = Board(7, 6)
    val connectFour = ConnectFour(board)
    val renderer = Renderer(board)
    val gameEngine = GameEngine(renderer, connectFour)

    gameEngine.start()
}




