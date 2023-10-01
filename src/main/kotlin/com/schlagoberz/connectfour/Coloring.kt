package com.schlagoberz.connectfour

// Extension functions for colorizing the foreground
fun String.black() = colorizeForeground(this, Color.BLACK)
fun String.red() = colorizeForeground(this, Color.RED)
fun String.green() = colorizeForeground(this, Color.GREEN)
fun String.yellow() = colorizeForeground(this, Color.YELLOW)
fun String.blue() = colorizeForeground(this, Color.BLUE)
fun String.magenta() = colorizeForeground(this, Color.MAGENTA)
fun String.cyan() = colorizeForeground(this, Color.CYAN)
fun String.white() = colorizeForeground(this, Color.WHITE)
fun String.brightBlack() = colorizeForeground(this, Color.BRIGHT_BLACK)
fun String.brightRed() = colorizeForeground(this, Color.BRIGHT_RED)
fun String.brightGreen() = colorizeForeground(this, Color.BRIGHT_GREEN)
fun String.brightYellow() = colorizeForeground(this, Color.BRIGHT_YELLOW)
fun String.brightBlue() = colorizeForeground(this, Color.BRIGHT_BLUE)
fun String.brightMagenta() = colorizeForeground(this, Color.BRIGHT_MAGENTA)
fun String.brightCyan() = colorizeForeground(this, Color.BRIGHT_CYAN)
fun String.brightWhite() = colorizeForeground(this, Color.BRIGHT_WHITE)

// Extension functions for colorizing the background
fun String.blackBackground() = colorizeBackground(this, Color.BLACK)
fun String.redBackground() = colorizeBackground(this, Color.RED)
fun String.greenBackground() = colorizeBackground(this, Color.GREEN)
fun String.yellowBackground() = colorizeBackground(this, Color.YELLOW)
fun String.blueBackground() = colorizeBackground(this, Color.BLUE)
fun String.magentaBackground() = colorizeBackground(this, Color.MAGENTA)
fun String.cyanBackground() = colorizeBackground(this, Color.CYAN)
fun String.whiteBackground() = colorizeBackground(this, Color.WHITE)
fun String.brightBlackBackground() = colorizeBackground(this, Color.BRIGHT_BLACK)
fun String.brightRedBackground() = colorizeBackground(this, Color.BRIGHT_RED)
fun String.brightGreenBackground() = colorizeBackground(this, Color.BRIGHT_GREEN)
fun String.brightYellowBackground() = colorizeBackground(this, Color.BRIGHT_YELLOW)
fun String.brightBlueBackground() = colorizeBackground(this, Color.BRIGHT_BLUE)
fun String.brightMagentaBackground() = colorizeBackground(this, Color.BRIGHT_MAGENTA)
fun String.brightCyanBackground() = colorizeBackground(this, Color.BRIGHT_CYAN)
fun String.brightWhiteBackground() = colorizeBackground(this, Color.BRIGHT_WHITE)

private fun colorizeBackground(string: String, color: Color) = colorize(string, color.background)
private fun colorizeForeground(string: String, color: Color) = colorize(string, color.foreground)
private fun colorize(string: String, ansiColor: String) = "$ansiColor$string$RESET"

private const val BG_MODIFIER = 10
private const val ESCAPE = "\u001b"
private const val RESET = "$ESCAPE[0m" // to reset color to the default

private enum class Color(colorCode: Int) {
    BLACK(30),
    RED(31),
    GREEN(32),
    YELLOW(33),
    BLUE(34),
    MAGENTA(35),
    CYAN(36),
    WHITE(37),

    BRIGHT_BLACK(90),
    BRIGHT_RED(91),
    BRIGHT_GREEN(92),
    BRIGHT_YELLOW(93),
    BRIGHT_BLUE(94),
    BRIGHT_MAGENTA(95),
    BRIGHT_CYAN(96),
    BRIGHT_WHITE(97);

    val foreground: String = "$ESCAPE[${colorCode}m"
    val background: String = "$ESCAPE[${colorCode + BG_MODIFIER}m"
}
