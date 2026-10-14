fun main(args: Array<String>) {
    var brStr = readln()
    //列
    val M = brStr.split(" ")[0].toInt()
    //行
    val N = brStr.split(" ")[1].toInt()
    var bArray = Array(N + 2) {
        Array(M + 2) { '1' } //全て壁
    }
    val lcList_Start = ArrayList<S002_1>()
    var i_Goal = 0
    var j_Goal = 0
    for (i in 1 until (bArray.size - 1)) {
        var brStrArray = readln().split(" ")
        for (j in 1 until (bArray[i].size - 1)) {
            bArray[i][j] = brStrArray[j - 1].first()
            when (bArray[i][j]) {
                //ゴール
                's' -> {
                    lcList_Start.add(S002_1(i,j,0))
                }
                'g' -> {
                    i_Goal = i
                    j_Goal = j
                }
            }
        }
    }
    var ans = "Fail"
    var i_Start = 0
    var j_Start = 0
    var count_Start = 0
    while (true){
        if(lcList_Start.size == 0) {
            ans = "Fail"
            break
        }

        i_Start = lcList_Start.first().i
        j_Start = lcList_Start.first().j
        count_Start = lcList_Start.first().count
        //ゴールと遭遇
        if( i_Start == i_Goal &&
            j_Start == j_Goal){
            ans = count_Start.toString()
            break
        }
        lcList_Start.removeFirst()
        //上が空白
        when (bArray[i_Start - 1][j_Start]) {
            '0','g' -> {
                lcList_Start.add(S002_1(i_Start - 1, j_Start, count_Start + 1))
                //確認済みは黒塗り
                bArray[i_Start - 1][j_Start] = '#'
            }
        }
        //右が空白
        when (bArray[i_Start][j_Start + 1]) {
            '0','g' -> {
                lcList_Start.add(S002_1(i_Start, j_Start + 1, count_Start + 1))
                bArray[i_Start][j_Start + 1] = '#'
            }
        }
        //下が空白
        when (bArray[i_Start + 1][j_Start]) {
            '0','g' -> {
                lcList_Start.add(S002_1(i_Start + 1, j_Start, count_Start + 1))
                bArray[i_Start + 1][j_Start] = '#'
            }
        }
        //左が空白
        when (bArray[i_Start][j_Start - 1]) {
            '0','g' -> {
                lcList_Start.add(S002_1(i_Start, j_Start - 1, count_Start + 1))
                bArray[i_Start][j_Start - 1] = '#'
            }
        }
    }
    println(ans)
}
class S002_1(var i: Int, var j: Int,var count: Int)