//https://paiza.jp/works/mondai/b_rank_skillcheck_sample/long-table/edit?language_uid=kotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nmStr = br.readLine()
    val n = Integer.parseInt(nmStr.split(" ")[0])
    val m = Integer.parseInt(nmStr.split(" ")[1])
    var a = IntArray(m)
    var b = IntArray(m)
    var abStr: String
    for (i in 0..(m-1)){
        abStr = br.readLine()
        a[i] = Integer.parseInt(abStr.split(" ")[0])
        b[i] = Integer.parseInt(abStr.split(" ")[1])
    }
    var vacancy = BooleanArray(n)
    for (i in 0..(n-1)){
        vacancy[i] = true
    }
    var vacancyBackup = vacancy.copyOf()
    var index: Int
    for (i in 0..(m-1)){
        vacancyBackup = vacancy.copyOf()
        index = b[i] - 1
        for (j in 1..a[i]){
            if(!vacancy[index]){
                vacancy = vacancyBackup.copyOf()
                break
            }
            vacancy[index] = false
            index++
            if(index == n){
                index = 0
            }
        }
    }
    var ans = 0
    for (i in 0..(n - 1)){
        if(!vacancy[i]){
            ans++
        }
    }
    println(ans)
}