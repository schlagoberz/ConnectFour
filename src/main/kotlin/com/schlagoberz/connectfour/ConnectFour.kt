package com.schlagoberz.connectfour

class ConnectFour(board: Board) {
    private var _next: Player
    private val _board: Board

    init {
        this._next = Player.Red // Red is the starting player.
        this._board = board
    }

    val next: Player
        get() = _next

    fun makeMove(column: Int) {
        _board.dropToken(column, _next)
        nextColor()
    }

    fun isGameOver(): Boolean {
        return hasWinner() || _board.isFull
    }

    fun hasWinner(): Boolean = getWinner() != null

    fun getWinner() = getWinnerHorizontal() ?: getWinnerVertical() ?: getWinnerDiagonal()

    private fun getWinnerHorizontal(): Player? {
        val kernel = listOf(Point(0, 0), Point(1, 0), Point(2, 0), Point(3, 0)) // left to right

        for (row in 0..<_board.height) {
            for (column in 0..<_board.width - 3) {
                val winnerCandidate = checkWinner(column, row, kernel)

                if (winnerCandidate != null)
                    return winnerCandidate
            }
        }

        return null
    }

    private fun getWinnerVertical(): Player? {
        val kernel = listOf(Point(0, 0), Point(0, 1), Point(0, 2), Point(0, 3)) // bottom to top

        for (row in 0..<_board.height - 3) {
            for (column in 0..<_board.width) {
                val winnerCandidate = checkWinner(column, row, kernel)

                if (winnerCandidate != null)
                    return winnerCandidate
            }
        }

        return null
    }

    private fun getWinnerDiagonal(): Player? {
        val kernels = listOf(
            listOf(Point(0, 0), Point(1, 1), Point(2, 2), Point(3, 3)), // left bottom to right top
            listOf(Point(0, 3), Point(1, 2), Point(2, 1), Point(3, 0))  // left top to right bottom
        )

        for (row in 0..<_board.height - 3) {
            for (column in 0..<_board.width - 3) {
                for (kernel in kernels) {
                    val winnerCandidate = checkWinner(column, row, kernel)

                    if (winnerCandidate != null)
                        return winnerCandidate
                }
            }
        }

        return null
    }

    private fun checkWinner(column: Int, row: Int, kernel: List<Point>): Player? {
        val involvedPlayers = kernel
            .map { (x, y) -> Point(column + x, row + y) }
            .map { (x, y) -> _board[x, y] }
            .toSet()

        return if (involvedPlayers.size == 1 && involvedPlayers.first() != null) involvedPlayers.first() else null
    }

    private fun nextColor() {
        _next = if (_next == Player.Red) Player.Yellow else Player.Red
    }
}

private data class Point(val x: Int, val y: Int)