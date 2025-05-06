import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var stStr = br.readLine()
    val H = stStr.split(" ")[0].toInt()
    val W = stStr.split(" ")[1].toInt()
    var S = Array(H) { Array(W) { "" } }
    var cList = mutableListOf<Coordinate1>()
    for (i in 0 until H) {
        stStr = br.readLine()
        for (j in 0 until W) {
            S[i][j] = stStr.get(j).toString()
            if(S[i][j] == "S"){
                cList.add(Coordinate1(i,j))
            }
        }
    }
    var ans : String = "NO"
    while(true) {
        if(cList.size == 0) {
            ans = "NO"
            break
        }
        if(
            cList.first().i == 0 ||
            cList.first().i == (H - 1) ||
            cList.first().j == 0 ||
            cList.first().j == (W - 1)
            )
        {
            ans = "YES"
            break
        }
        //右が空白
        if(S
                [cList.first().i]
                [cList.first().j + 1] == "."
        ){
            cList.add(Coordinate1(cList.first().i,cList.first().j + 1))
        }
        //上が空白
        if(S
                [cList.first().i - 1]
                [cList.first().j] == "."
        ){
            cList.add(Coordinate1(cList.first().i - 1,cList.first().j))
        }
        //下が空白
        if(S
                [cList.first().i + 1]
                [cList.first().j] == "."
        ){
            cList.add(Coordinate1(cList.first().i + 1,cList.first().j))
        }
        //左が空白
        if(S
                [cList.first().i]
                [cList.first().j - 1] == "."
        ){
            cList.add(Coordinate1(cList.first().i,cList.first().j - 1))
        }
        //一度踏んだら黒塗り
        S[cList.first().i][cList.first().j] = "#"
        cList.removeFirst()
    }
    println(ans)
}

class Coordinate1(var i: Int, var j: Int)