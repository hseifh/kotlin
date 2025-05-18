fun main(args: Array<String>) {
    var brStr = readln()
    val H = brStr.split(" ")[0].toInt()
    val W = brStr.split(" ")[1].toInt()
    var sArray = Array(H + 2) {
        Array(W + 2) {
            '.'
        }
    }
    for (i in 1 until (sArray.size - 1)) {
        brStr = readln()
        for (j in 1 until (sArray[i].size - 1)) {
            sArray[i][j] = brStr[j - 1]
        }
    }
    println(H)
    println(W)
    for (sAry in sArray) {
        for (s in sAry) {
            print(s)
        }
        println()
    }
}