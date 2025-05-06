import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    var t = Array(N + 2) { Array(N + 2) { "#" } }
    var stStr:String
    for (i in 1 until (t.size - 1)) {
        stStr = br.readLine()
        for (j in 1 until (t[i].size - 1)) {
            t[i][j] = stStr.get(j - 1).toString()
        }
    }
    val M = br.readLine().toInt()
    var p = Array<String>(M){ "" }
    for (i in 0 until M) {
        p[i] = br.readLine()
    }
    var work : String
    var flag : Boolean
    a@ for (i in 0 until M) {
        //println("i = " + i)
        //println("p[i] = " + p[i])
        work = p[i].get(0).toString()
        flag = false
        b@ for (j in 1 until (t.size - 1)) {
            //println("i = " + i)
            c@ for (k in 1 until (t[j].size - 1)) {
                //println(t[j][k] + "と" + work)
                if(t[j][k] == work){
                    //println("if内")
                    flag = check(t,j,k,p[i],1)
                    if(flag){
                        break@b
                    }
                }
            }
        }
        if(flag){
            println("yes")
        }else{
            println("no")
        }
    }
}
fun check(t: Array<Array<String>>, row: Int, col: Int, p: String, index: Int): Boolean {
    /*
    println(p)
    for (i in 0 until t.size) {
        for (j in 0 until t[i].size) {
            print(t[i][j])
        }
        println()
    }
    */
    if(p.length == index){
        return true
    }
    var tCopy = t.copyOf()
    tCopy[row][col] = "#"
    var flag = false

    //上が空白
    if(p.get(index).toString() == t[row - 1][col]){
        if(check(tCopy,row - 1,col,p,index + 1)){
            return true
        }
    }
    //右が空白
    if(p.get(index).toString() == t[row][col + 1]){
        if(check(tCopy,row,col + 1,p,index + 1)){
            return true
        }
    }
    //下が空白
    if(p.get(index).toString() == t[row + 1][col]){
        if(check(tCopy,row + 1,col,p,index + 1)){
            return true
        }
    }
    //左が空白
    if(p.get(index).toString() == t[row][col - 1]){
        if(check(tCopy,row,col - 1,p,index + 1)){
            return true
        }
    }
    return false
}