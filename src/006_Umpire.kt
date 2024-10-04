//https://paiza.jp/works/mondai/c_rank_skillcheck_archive/umpire_01/edit?language_uid=kotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = Integer.parseInt(br.readLine())
    var strike = 0
    var ball = 0
    for (i in 1..N){
        if(br.readLine() == "strike"){
            strike++
            if(strike == 3){
                println("out!")
                break
            }
            println("strike!")
        } else {
            ball++
            if(ball == 4){
                println("fourball!")
                break
            }
            println("ball!")
        }
    }
}