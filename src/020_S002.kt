import java.util.*

data class Pos(val y: Int, val x: Int, val dist: Int)

fun main() {
    val (w, h) = readln().split(" ").map { it.toInt() }
    val map = Array(h) { CharArray(w) }
    var sy = 0
    var sx = 0

    // 入力とスタート位置の記録
    for (i in 0 until h) {
        val row = readln().replace(" ", "").toCharArray()
        map[i] = row
        for (j in 0 until w) {
            if (map[i][j] == 's') {
                sy = i
                sx = j
            }
        }
    }

    val visited = Array(h) { BooleanArray(w) }
    val q: Queue<Pos> = LinkedList()
    q.add(Pos(sy, sx, 0))
    visited[sy][sx] = true

    val dy = arrayOf(-1, 1, 0, 0)
    val dx = arrayOf(0, 0, -1, 1)

    while (q.isNotEmpty()) {
        val cur = q.poll()

        if (map[cur.y][cur.x] == 'g') {
            println(cur.dist)
            return
        }

        for (i in 0 until 4) {
            val ny = cur.y + dy[i]
            val nx = cur.x + dx[i]
            if (ny in 0 until h && nx in 0 until w &&
                !visited[ny][nx] &&
                (map[ny][nx] == '0' || map[ny][nx] == 'g')
            ) {
                visited[ny][nx] = true
                q.add(Pos(ny, nx, cur.dist + 1))
            }
        }
    }

    println("Fail")
}
