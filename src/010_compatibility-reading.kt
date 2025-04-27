//https://paiza.jp/works/challenges/384/retry

import java.io.BufferedReader
import java.io.InputStreamReader

var alphabettrList = mutableListOf<Alphabettr>()

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val stStr = br.readLine()
    val s = stStr.split(" ")[0]
    val t = stStr.split(" ")[1]
    val alphabettrStr = "abcdefghijklmnopqrstuvwxyz"
    for (i in 1..alphabettrStr.length) {
        alphabettrList.add(Alphabettr(alphabettrStr.get(i - 1).toString(), i))
    }
    val ans1 = calculation(s + t)
    val ans2 = calculation(t + s)
    println(maxOf(ans1, ans2))
}
fun calculation(str: String): Int {
    var numberList = mutableListOf<Int>()
    for (i in 0..(str.length - 1)) {
        for (item in alphabettrList) {
            if(str[i].toString() == item.alphabettr){
                numberList.add(item.order)
                break
            }
        }
    }
    return sumNumbers(numberList)
}
fun sumNumbers(numbers: List<Int>): Int {
    if(numbers.size == 1){
        return numbers.first()
    } else {
        var numberList = mutableListOf<Int>()
        for (i in 0..(numbers.size - 2)) {
            numberList.add(numbers.get(i) + numbers.get(i + 1))
            if(numberList.get(i)  > 101){
                numberList.set(i,numberList.get(i) - 101)
            }
        }
        return sumNumbers(numberList)
    }
}

class Alphabettr(
    val alphabettr: String,
    val order: Int
)