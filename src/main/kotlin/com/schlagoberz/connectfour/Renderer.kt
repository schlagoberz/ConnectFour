package com.schlagoberz.connectfour

class Renderer(private val board: Board) {
    fun render(): String {
        var representation = getHeader()
        representation += getBoard()
        representation += getFooter()

        return representation
    }

    private fun getHeader(): String {
        var representation = ""

        for (index in 1..board.width) {
            representation += " $index "
        }

        return representation + "\n"
    }

    private fun getBoard(): String {
        var representation = ""

        for (row in board.height - 1 downTo 0) {
            for (column in 0..<board.width) {
                representation += "|" + when (board[column, row]) {
                    Player.Red -> "R".redBackground()
                    Player.Yellow -> "Y".yellowBackground()
                    null -> " "
                } + "|"
            }
            representation += "\n"
        }

        return representation
    }

    private fun getFooter() = "^^^".repeat(board.width)
}