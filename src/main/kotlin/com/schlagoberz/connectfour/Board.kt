package com.schlagoberz.connectfour

class Board(val width: Int, val height: Int) {
    private val _matrix: Array<Array<Player?>> = Array(width) { Array(height) { null } }

    operator fun get(column: Int, row: Int): Player? {
        return _matrix[column][row]
    }

    fun dropToken(column: Int, player: Player) {
        if (!isValidColumn(column)) throw IllegalArgumentException("You have to choose column s. t. 0 <= column < $width!")
        if (isColumnFull(column)) throw IllegalArgumentException("The chosen column is full!")

        _matrix[column][getNextRow(column)] = player
    }

    val isFull: Boolean
        get() = (0..<width).all { isColumnFull(it) }

    private fun getNextRow(column: Int): Int {
        for (row in 0..<height) {
            if (_matrix[column][row] == null) return row
        }

        throw IllegalStateException("The column $column is already full!")
    }

    private fun isValidColumn(column: Int) = column in 0..<width
    private fun isColumnFull(column: Int) = _matrix[column][height - 1] != null
}