//https://paiza.jp/works/challenges/384/retry

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val stStr = br.readLine()
    val s = stStr.split(" ")[0]
    val t = stStr.split(" ")[1]
    val alphabettrStr = "abcdefghijklmnopqrstuvwxyz"
    val list = mutableListOf<Alphabettr>()
    for (i in 1..alphabettrStr.length) {
        list.add(Alphabettr(alphabettrStr.get(i - 1).toString(), i))
    }
    for (item in list) {
        println(item.alphabettr)
        println(item.order)
    }

}

class Alphabettr(
    val alphabettr: String,
    val order: Int
)