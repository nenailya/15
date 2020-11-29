package sample

import sample.smth.array
import sample.smth.fooForEachCell

public class Solver {
    val dx = arrayOf(0, -1, 0, 1)
    var resultString = ""

    val dy = arrayOf(1, 0, -1, 0)


    var movedesc = arrayOf('D', 'L', 'U', 'R')
    var oppositemove = arrayOf(2, 3, 0, 1)


    private val infinity = 10000
    var x0 = 0
    var y0 = 0
    var goalX = IntArray(16)
    var goalY = IntArray(16)
    val board: Array<IntArray> = Array(4) { IntArray(4) }

    init {
        for (i in 0..3) {
            for (j in 0..3) {
                board[i][j] = array[i][j]
            }
        }
    }

        var step = 0
        val boardGoal: Array<IntArray> = Array(4) { IntArray(4) }
        var minPrevIteration = 0
        var deepness = 0


        fun initGoalArray() {
            var m = 1
            for (i in 0..3) {
                for (j in 0..3) {
                    boardGoal[i][j] = m
                    m++
                }
            }
            boardGoal[3][3] = 0
        }

        fun initGoalArrays() {
            for (i in 0..14) {
                goalX[i + 1] = i % 4
                goalY[i + 1] = i / 4
            }
            goalX[0] = 4
            goalY[0] = 4
        }

        fun swap(y1: Int, x1: Int, y2: Int, x2: Int) {
            val value1 = board[y1][x1]
            val value2 = board[y2][x2]
            board[y1][x1] = value2
            board[y2][x2] = value1
        }


        private fun estimate(): Int {
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


        private fun recSearch(g: Int, previousMove: Int, x0: Int, y0: Int): Boolean {
            val h = estimate()
            if (h == 0) {
                return true
            }
            val f = g + h
            if (f > deepness) {
                if (minPrevIteration > f) {
                    minPrevIteration = f
                }
                return false
            }
            var newx: Int
            var newy: Int
            var res: Boolean
            for (i in 0..3) {
                if (oppositemove[i] != previousMove) {
                    newx = x0 + dx[i]
                    newy = y0 + dy[i]
                    if ((newy <= 3) && (newy >= 0) && (newx <= 3) && (newx >= 0)) {
                        swap(y0, x0, newy, newx)
                        res = recSearch(g + 1, i, newx, newy)
                        swap(y0, x0, newy, newx)
                        if (res) {
                            resultString += movedesc[i]
                            step++
                            return true
                        }
                    }
                }
            }
            return false
        }


        private fun idaStar(): Boolean {
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
                }
                    step = 0
                    res = recSearch(0, -1, x0, y0)
                    deepness = minPrevIteration
                if (res) break

            }
            resultString = resultString.reversed()
            val a = resultString[0]
            when (a) {
                'D' -> fooForEachCell(y0+1, x0)
                'U' -> fooForEachCell(y0-1, x0)
                'L' -> fooForEachCell(y0, x0-1)
                'R' -> fooForEachCell(y0, x0+1)
            }
            return res
        }

        public fun helper(): String {
            initGoalArray()
            initGoalArrays()
            return if (idaStar()) {
                resultString
            } else "sorry"
        }
    }

