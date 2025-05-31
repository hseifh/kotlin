fun main(args: Array<String>) {
    var brStr = readln()
    val H = brStr.split(" ")[0].toInt()
    val W = brStr.split(" ")[1].toInt()
    var bArray = Array(H + 2) {
        Array(W + 2) { '.' }
    }
    for (i in 1 until (bArray.size - 1)) {
        brStr = readln()
        for (j in 1 until (bArray[i].size - 1)) {
            if (brStr[j - 1] == '#') {
                bArray[i][j] = brStr[j - 1]
            }
        }
    }
    var cList = mutableListOf<Coordinate3>()
    var ans = 0
    fun isSea(row:Int,col:Int): Boolean {
        if(bArray[row][col] == '.'){
            return true
        }
        return false
    }
    while(true) {
        for (i in (1 + ans) until (bArray.size - (1 + ans))) {
            for (j in (1 + ans) until (bArray[i].size - (1 + ans))) {
                if(bArray[i][j] == '#'){
                    if(isSea(i - 1,j)){
                        cList.add(Coordinate3(i,j))
                    }else if(isSea(i,j + 1)){
                        cList.add(Coordinate3(i,j))
                    }else if(isSea(i + 1,j)){
                        cList.add(Coordinate3(i,j))
                    }else if(isSea(i,j - 1)){
                        cList.add(Coordinate3(i,j))
                    }
                }
            }
        }
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
class Coordinate3(var i: Int, var j: Int)