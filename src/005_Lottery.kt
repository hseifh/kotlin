//https://paiza.jp/works/mondai/c_rank_skillcheck_archive/lottery/edit?language_uid=kotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val strB = br.readLine()
    val intB = Integer.parseInt(strB)
    val n = Integer.parseInt(br.readLine())
    var aInt: Int
    var aStr: String
    for (i in 1..n){
        aStr = br.readLine()
        aInt = Integer.parseInt(aStr)
        if(aInt == intB){
            println("first")
        } else if((aInt + 1) == intB || (aInt - 1) == intB){
            println("adjacent")
        } else if(aStr.substring(2) ==
                  strB.substring(2)){
            println("second")
        } else if(aStr.substring(3) ==
                  strB.substring(3)){
            println("third")
        } else {
            println("blank")
        }
    }
}