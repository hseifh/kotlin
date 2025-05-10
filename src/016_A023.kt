fun main(args: Array<String>) {
    val N = readln().toInt()
    val wkStr = readln()
    val dAry = Array<Int>(N) { 0 }
    for (i in 0 until dAry.size) {
        dAry[i] = wkStr.split(" ")[i].toInt()
    }
    val flagAry = Array<Boolean>(N) { false }
    a@ for (i in 0 until (dAry.size - 6)) {
        var week = Array<Int>(7) { 0 }
        b@ for (j in 0 until week.size) {
            week[j] = dAry[j + i]
        }
        if(isTwoVacation(week)){
            flagAry[i] = true
            if(i == (dAry.size - 7)){
                c@ for (k in i until dAry.size) {
                    flagAry[k] = true
                }
            }
        }
    }
    var ans = 0
    var serial = 0

    for (flag in flagAry) {
        if(flag){
            serial++
            if(serial > ans){
                ans = serial
            }
        }else{
            serial = 0
        }
    }
    println(ans)
}
fun isTwoVacation(dAry: Array<Int>): Boolean {
    var  count = 0
    for (d in dAry) {
        if(d == 0){
            count++
        }
    }
    if(count >= 2){
        return true
    }else{
        return false
    }
}