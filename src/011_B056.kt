import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var stStr = br.readLine()
    val N = stStr.split(" ")[0].toInt()
    val M = stStr.split(" ")[1].toInt()
    val musicData = Array(M) { Array(N) { "" } }
    val playData = Array(M) { Array(N) { "" } }
    for (i in 0 until M) {
        stStr = br.readLine()
        for (j in 0 until N) {
            musicData[i][j] = stStr.get(j).toString()
            playData[i][j] = stStr.get(j + (N + 1)).toString()
        }
    }


    var combo = 0
    var maxCombo = 0
    var i = 0
    var successFlag: Boolean
    var sharpFlag: Boolean
    var sharp: Int
    while (i < M){
        successFlag = true
        sharpFlag = false
        sharp = 99
        for (j in 0 until N) {
            when (musicData[i][j]) {
                "-" -> {
                    if(playData[i][j] != "-"){
                        successFlag = false
                        if(sharpFlag){
                            successFlag = false
                            if(i == (M - 1)){
                                break
                            }
                            while (musicData[i + 1][sharp] == "#") {
                                i++
                                if(i == (M - 1)){
                                    break
                                }
                            }
                            break
                        }
                    }
                }
                "+" -> {
                    if(playData[i][j] != "+"){
                        successFlag = false
                    }
                }
                "#" -> {
                    sharpFlag = true
                    sharp = j
                    when (playData[i][j]) {
                        "-" -> {
                            successFlag = false
                            if(i == (M - 1)){
                                break
                            }
                            while (musicData[i + 1][j] == "#") {
                                i++
                                if(i == (M - 1)){
                                    break
                                }
                            }
                            break
                        }
                        "+" -> {
                            if(!successFlag){
                                if(i == (M - 1)){
                                    break
                                }
                                while (musicData[i + 1][j] == "#") {
                                    i++
                                    if(i == (M - 1)){
                                        break
                                    }
                                }
                                break
                            }
                        }
                    }
                }
            }
        }
        if(successFlag){
            combo++
            if(combo > maxCombo){
                maxCombo = combo
            }
        }else{
            combo = 0
        }
        i++
    }
    println(maxCombo)
}