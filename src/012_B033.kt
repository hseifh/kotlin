import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val W = br.readLine().toInt()
    //最大文字数
    var maxSize = Array<Int>(W){ 0 }
    //////////
    var c = Array<String>(W){ "" }
    val cStr = br.readLine()
    for (i in 0 until W) {
        c[i] = cStr.split(" ")[i]
        if(c[i].length > maxSize[i]){
            maxSize[i] = c[i].length
        }
    }
    val H = br.readLine().toInt()
    var r = Array(H) { Array(W) { "" } }
    var rStr :String
    for (i in 0 until H) {
        rStr = br.readLine()
        for (j in 0 until W) {
            r[i][j] = rStr.split(" ")[j]
            if(r[i][j].length > maxSize[j]){
                maxSize[j] = r[i][j].length
            }
        }
    }

    //ヘッダー
    for (i in 0 until W) {
        print("| ")
        print(c[i])
        for (i in 0 until (maxSize[i] - c[i].length)) {
            print(" ")
        }
        print(" ")
    }
    println("|")

    //見出し区切り
    for (i in 0 until W) {
        print("|")
        for (i in 0 until (maxSize[i] + 2)) {
            print("-")
        }
    }
    println("|")

    //明細
    for (i in 0 until H) {
        for (j in 0 until W) {
            print("| ")
            print(r[i][j])
            for (i in 0 until (maxSize[j] - r[i][j].length)) {
                print(" ")
            }
            print(" ")
        }
        println("|")
    }
}