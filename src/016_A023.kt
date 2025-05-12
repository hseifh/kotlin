fun main(args: Array<String>) {
    val N = readln().toInt()
    val dStr = readln().filterNot { it.isWhitespace() }
    val flagAry = Array<Boolean>(N) { false }
    val seven = 7
    var i = 0
    while (i < (dStr.length - (seven - 1))) {
    //while (i < dStr.length) {
        //println(dStr.substring(i,(seven + i)))
        //println(i)
        if((dStr.substring(i,(seven + i)).count { it == '0' }) >= 2 ){
            //println(i)
            for (j in i until (i + seven)) {
                //println(i)
                flagAry[j] = true
            }
            i += seven
        }else{
            i++
        }
    }
    //println(i)
    while (i < dStr.length) {
        //println(i)
        //println(dStr.substring(i - (seven - 1), (i + 1)))
        //println(i - (seven - 1) + i)
        if(i <= seven) {
            i++
            continue
        }
        //println(dStr.substring(i - (seven - 1), i))
        if ((dStr.substring(i - (seven - 1), (i + 1)).count { it == '0' }) >= 2) {
            flagAry[i] = true
        }
        i++
    }
    var ans = 0
    var serial = 0

    /*
    for (flag in flagAry) {
        println(flag)
    }

     */
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