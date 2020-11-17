package sample

import sample.smth.array
import java.io.BufferedWriter
import java.lang.Math.abs


val dx = arrayOf(0, -1, 0, 1)
var resultString = ""

val dy = arrayOf(1, 0, -1, 0)


var move_desc = arrayOf('D', 'L', 'U', 'R')
var opposite_move = arrayOf(2, 3, 0, 1)


const val infinity = 10000
var x0 = 0
var y0 = 0
var goalX = IntArray(15)
var goalY = IntArray(15)
val board: Array<IntArray> = array
var step = 0
val boardGoal: Array<IntArray> = Array(4) { IntArray(4) }
var minPrevIteration = 0
var deepness = 0

fun init() {
    var m = 1
    for (i in 0..3) {
        for (j in 0..3) {
            boardGoal[i][j] = m
            m++
        }
    }
    boardGoal[3][3] = 0
}

fun swap(y1: Int, x1: Int, y2: Int, x2: Int) {
    val value1 = board[y1][x1]
    val value2 = board[y2][x2]
    board[y1][x1] = value2
    board[y2][x2] = value1
}


fun estimate(): Int {
    var manhattan = 0
    var value: Int
    var m: Int

    for (i in 0..3) {
        for (j in 0..3) {
            value = board[i][j]
            if ((value > 0) && (value != boardGoal[i][j])) {
                m = kotlin.math.abs(i - goalY[value]) + kotlin.math.abs(j - goalX[value])
                manhattan += m
            }
        }
    }
    return manhattan
}


fun recSearch(g: Int, previousMove: Int, x0: Int, y0: Int): Boolean {
    val h = estimate()
    if (h == 0) {
        return true
    }
    val f = g + h
    if (f > deepness) {
        if (minPrevIteration > f) {
            minPrevIteration = f
            return false
        }
    }
    var newx: Int
    var newy: Int
    var res: Boolean

    for (i in 0..3) {
        if (opposite_move[i] != previousMove) {
            newx = x0 + dx[i]
            newy = y0 + dy[i]
            if ((newy <= 3) and (newy >= 0) and (newx <= 3) and (newx >= 0)) {
                swap(y0, x0, newy, newx)
                res = recSearch(g + 1, i, newx, newy)
                swap(y0, x0, newy, newx)
                if (res) {
                    resultString += move_desc[i]
                    step++
                    return true
                }
            }
        }
    }
    return false
}


fun idaStar(): Boolean {
    var res = false
    deepness = estimate()
    while (deepness <= 50) {
        minPrevIteration = infinity
        for (i in 0..3) {
            for (j in 0..3) {
                if (board[i][j] == 0) {
                    x0 = j
                    y0 = i
                }
            }
            step = 0
            res = recSearch(0, -1, x0, y0)
            deepness = minPrevIteration
        }

    }
    return res
}

fun dodo(): String {
    init()
    idaStar()
    return resultString
}


