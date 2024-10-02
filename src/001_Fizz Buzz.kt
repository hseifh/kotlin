//https://paiza.jp/works/mondai/c_rank_skillcheck_sample/fizz-buzz

import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val N = scanner.nextInt()

    for (i in 1..N){
        if(i % 5 == 0 && i % 3 == 0) {
            println("Fizz Buzz")
        } else if (i % 3 == 0) {
            println("Fizz")
        } else if (i % 5 == 0) {
            println("Buzz")
        } else {
            println(i)
        }
    }
}