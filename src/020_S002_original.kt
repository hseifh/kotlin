fun main(args: Array<String>) {
    var brStr = readln()
    //列
    val M = brStr.split(" ")[0].toInt()
    //行
    val N = brStr.split(" ")[1].toInt()
    var bArray = Array(N + 2) {
        Array(M + 2) { '1' } //全て壁
    }
    var start_i = 0
    var start_j = 0
    var goal_i = 0
    var goal_j = 0
    for (i in 1 until (bArray.size - 1)) {
        brStr = readln()
        for (j in 1 until (bArray[i].size - 1)) {
            bArray[i][j] = brStr.split(" ")[j - 1].first()
            if(bArray[i][j] == 's'){
                start_i = i
                start_i = j
            }
            if(bArray[i][j] == 'g'){
                goal_i = i
                goal_j = j
            }
        }
    }
    /*
    println("" + M + " " + N)
    for (i in 0 until bArray.size) {
        for (j in 0 until bArray[i].size) {
            print(bArray[i][j])
        }
        println()
    }
    System.exit(0)
    */

    var cList = mutableListOf<Coordinate4>()
    cList.add(Coordinate4(start_i,start_j))
    var ans = 0

    fun isWay(row:Int,col:Int): Boolean {
        if(bArray[row][col] == '0'){
            return true
        }
        return false
    }
    fun whereRow(row:Int): Char {
        if(row > goal_i){
            return '>'
        }else if(row < goal_i){
            return '<'
        }else{
            return '='
        }
    }
    fun whereCol(col:Int): Char {
        if(col > goal_j){
            return '>'
        }else if(col < goal_j){
            return '<'
        }else{
            return '='
        }
    }

    while(true) {
        if(cList.isEmpty()){
            break
        }
        bArray[cList.first().i][cList.first().j] == '1'
        when (whereRow(cList.first().i)) {
            '>' -> {
                when (whereCol(cList.first().j)) {
                    '>' -> {}
                    '<' -> {}
                    '=' -> {}
                }
            }
            '<' -> {}
            '=' -> {}
        }
        //for (i in (1 + ans) until (bArray.size - (1 + ans))) {
            //for (j in (1 + ans) until (bArray[i].size - (1 + ans))) {
                //if(bArray[i][j] == '#'){
        /*
                    if(isWhat(i - 1,j)){
                        cList.add(Coordinate3(i,j))
                    }else if(isSea(i,j + 1)){
                        cList.add(Coordinate3(i,j))
                    }else if(isSea(i + 1,j)){
                        cList.add(Coordinate3(i,j))
                    }else if(isSea(i,j - 1)){
                        cList.add(Coordinate3(i,j))
                    }

         */
                //}
            //}
        //}
        if(cList.size == 0){
            break
        }else{
            ans++
        }
        for (c in cList){
            bArray[c.i][c.j] = '.'
        }
        cList.clear()
    }
    println(ans)


}
class Coordinate4(var i: Int, var j: Int)