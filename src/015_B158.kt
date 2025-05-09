fun main(args: Array<String>) {
    val N = readln().toInt()
    var t = Array(N) { Array(N) { 0 } }
    for (i in 0 until N){
        val stStr = readln()
        for (j in 0 until N){
            t[i][j] = stStr.split(" ")[j].toInt()
        }
    }
    val max = (N / 2) + 1
    var ans = 0
    a@ for (i in 0 until max){
        b@ for (j in i until (N - i)) {
            c@ for (k in i until (N - i)) {
                if(
                    j == i ||
                    j == ((N - i) - 1) ||
                    k == i ||
                    k == ((N - i) - 1)
                    ){
                    ans += (t[j][k] - (i + 1))
                }
            }
        }
    }
    println(ans)
}