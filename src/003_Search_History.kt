//https://paiza.jp/works/mondai/c_rank_skillcheck_archive/search_history/edit?language_uid=kotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = Integer.parseInt(br.readLine())
    val words = ArrayList<String>()
    for (i in 1..N){
        words.add(br.readLine())
    }
    val ansWords = ArrayList<String>()
    words.forEach{ word ->
        ansWords.add(0,word)
    }
    ansWords.distinct().forEach{ word ->
        println(word)
    }
}