//https://paiza.jp/works/challenges/384/retry

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
    /*
    println("" + N + " " + M)
    for (i in 0 until M) {
        for (j in 0 until N) {
            print(musicData[i][j])
        }
        print(" ")
        for (j in 0 until N) {
            print(playData[i][j])
        }
        println()
    }
    */
    var combo = 0
    var maxCombo = 0
    for (i in 0 until M) {
        var flag = true
        for (j in 0 until N) {
            when (musicData[i][j]) {
                "-" -> {
                    if(playData[i][j] != musicData[i][j]){
                        flag = false
                        break
                    }
                }
                "+" -> {
                    if(playData[i][j] != musicData[i][j]){
                        flag = false
                        break
                    }
                }
                "#" -> {
                    if(playData[i][j] != "+"){
                        flag = false
                        break
                    }
                }
            }
        }
        if(flag){
            combo++
            if(combo > maxCombo){
                maxCombo = combo
            }
        }else{
            combo = 0
        }
    }
    println(maxCombo)
}