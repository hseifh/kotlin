fun main(args: Array<String>) {
    var brStr = readln()
    val H = brStr.split(" ")[0].toInt()
    val W = brStr.split(" ")[1].toInt()
    var bArray = Array(H + 2) {
        Array(W + 2) { 0 }
    }
    for (i in 1 until (bArray.size - 1)) {
        brStr = readln()
        for (j in 1 until (bArray[i].size - 1)) {
            if (brStr[j - 1] == '#') {
                bArray[i][j] = 1
            }
        }
    }
    /*
    println("" + H + " " + W)
    for (i in 0 until bArray.size) {
        for (j in 0 until bArray[i].size) {
            print(bArray[i][j])
        }
        println()
    }
     */
    var count: Int = 2
    var continueFlag: Boolean = true
    var ans = 0
    while(continueFlag) {
        println(count)
        continueFlag = false
        for (i in 1 until (bArray.size - 1)) {
            for (j in 1 until (bArray[i].size - 1)) {
                if(
                    (bArray[i][j] == 0 ||
                    bArray[i][j] != count) &&
                    bArray[i][j] != 1
                    
                    ){
                    bArray[i][j] = count
                    continueFlag = true
                }
            }
        }
        if(continueFlag){
            ans++
        }
        count++
    }
    println(ans)
}