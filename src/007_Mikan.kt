//https://paiza.jp/works/mondai/c_rank_skillcheck_archive/mikan_00/edit?language_uid=kotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val NMstr = br.readLine()
    val N = Integer.parseInt(NMstr.split(" ")[0])
    val M = Integer.parseInt(NMstr.split(" ")[1])
    var w: Int
    var work: Int
    for (i in 1..M){
        w = Integer.parseInt(br.readLine())
        if(w <= N){
            println(N)
            continue
        }
        work = w % N
        if(work == 0){
            println((w / N) * N)
            continue
        }
        if(work < (N / 2)){
            println((w / N) * N)





        } else {
            println(((w + N) / N) * N)
        }
    }
}