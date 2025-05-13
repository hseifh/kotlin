fun main(args: Array<String>) {
    val N = readln().toInt()
    val dStr = readln().filterNot { it.isWhitespace() }
    val flagAry = Array<Boolean>(N) { false }
    val seven = 7
    var i = 0
    while (i < (dStr.length - (seven - 1))) {
        if((dStr.substring(i,i + seven).count { it == '0' }) >= 2 ){
            for (j in i until (i + seven)) {
                flagAry[j] = true
            }
            i += seven
        }else{
            i++
        }
    }
    while (i < dStr.length) {

        if(i < (seven - 1)) {
            i++
            continue
        }
        if ((dStr.substring(i - (seven - 1), (i + 1)).count { it == '0' }) >= 2) {
            for (j in (i - (seven - 1)) until (i + 1)) {
                flagAry[j] = true
            }
        }
        i++
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