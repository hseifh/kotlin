fun main(args: Array<String>) {
    var WorkStr = readln()
    val N = WorkStr.split(" ")[0].toInt()
    val H = WorkStr.split(" ")[1].toInt()
    val W = WorkStr.split(" ")[2].toInt()
    WorkStr = readln()
    var sy = WorkStr.split(" ")[0].toInt() - 1
    var sx = WorkStr.split(" ")[1].toInt() - 1
    val s = readln()
    var c = Array(H) { Array(W) { 0 } }
    for (i in 0 until c.size) {
        WorkStr = readln()
        for (j in 0 until c[i].size) {
            c[i][j] = WorkStr.split(" ")[j].toInt()
        }
    }
    for (i in 0 until N) {
        when (s[i]) {
            'F' -> sy--
            'B' -> sy++
            'L' -> sx--
            'R' -> sx++
        }
        println(c[sy][sx])
    }
}