import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    var t = Array(N + 2) { Array(N + 2) { '#' } }
    var stStr:String
    for (i in 1 until (t.size - 1)) {
        stStr = br.readLine()
        for (j in 1 until (t[i].size - 1)) {
            t[i][j] = stStr[j - 1]
        }
    }
    val M = br.readLine().toInt()
    var p = Array<String>(M){ "" }
    for (i in 0 until M) {
        p[i] = br.readLine()
    }
    var work : Char
    var flag : Boolean
    a@ for (i in 0 until M) {
        work = p[i][0]
        flag = false
        b@ for (j in 1 until (t.size - 1)) {
            c@ for (k in 1 until (t[j].size - 1)) {
                if(t[j][k] == work){
                    flag = check(t,j,k,p[i],1)
                    if(flag){
                        break@b
                    }
                }
            }
        }
        println(if (flag) "yes" else "no")
    }
}
fun check(t: Array<Array<Char>>, row: Int, col: Int, p: String, index: Int): Boolean {
    if(p.length == index){
        return true
    }
    //配列クローン
    val tCopy = Array(t.size) { i -> t[i].clone() }
    tCopy[row][col] = '#'

    //上が空白
    if(p[index] == t[row - 1][col]){
        if(check(tCopy,row - 1,col,p,index + 1)){
            return true
        }
    }
    //右が空白
    if(p[index] == t[row][col + 1]){
        if(check(tCopy,row,col + 1,p,index + 1)){
            return true
        }
    }
    //下が空白
    if(p[index] == t[row + 1][col]){
        if(check(tCopy,row + 1,col,p,index + 1)){
            return true
        }
    }
    //左が空白
    if(p[index] == t[row][col - 1]){
        if(check(tCopy,row,col - 1,p,index + 1)){
            return true
        }
    }
    return false
}