//https://paiza.jp/works/mondai/c_rank_skillcheck_archive/search_history/edit?language_uid=kotlin

import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val N = scanner.nextInt()
    val words = ArrayList<String>()
    for (i in 0..N){
        if(i == 0){
            scanner.nextLine()
            continue
        }
        words.add(scanner.nextLine())
    }
    val ansWords = ArrayList<String>()

    words.forEach{ word ->
        ansWords.add(0,word)
    }
    ansWords.distinct().forEach{ word ->
        println(word)
    }
}