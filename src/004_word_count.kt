//https://paiza.jp/works/mondai/c_rank_skillcheck_archive/word-count_02/edit?language_uid=kotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    if(br.readLine().split(" ").contains("red")){
        println("Yes")
    }else{
        println("No")
    }
}