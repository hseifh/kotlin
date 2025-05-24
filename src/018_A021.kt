fun main(args: Array<String>) {
    var brStr = readln()
    val H = brStr.split(" ")[0].toInt()
    val W = brStr.split(" ")[1].toInt()
    var sArray = Array(H + 2) {
        Array(W + 2) {
            '.'
        }
    }
    for (i in 1 until (sArray.size - 1)) {
        brStr = readln()
        for (j in 1 until (sArray[i].size - 1)) {
            sArray[i][j] = brStr[j - 1]
        }
    }
    var ilList = mutableListOf<Island>()
    var cList = mutableListOf<Coordinate2>()
    fun isisland(row:Int,col:Int) {
        when (sArray[row][col]) {
            '#' -> {
                cList.add(Coordinate2(row,col))
                sArray[row][col] = '*'
                ilList.last().land++
            }
            '.' -> {
                ilList.last().sea++
            }
        }
    }
    for (i in 1 until (sArray.size - 1)) {
        for (j in 1 until (sArray[i].size - 1)) {
            if(sArray[i][j] == '#'){
                sArray[i][j] = '*'
                ilList.add(Island(1,0))
                cList.add(Coordinate2(i,j))
                while(cList.size > 0) {
                    //東
                    isisland(cList.first().i,cList.first().j + 1)
                    //南
                    isisland(cList.first().i + 1,cList.first().j)
                    //西
                    isisland(cList.first().i,cList.first().j - 1)
                    //北
                    isisland(cList.first().i - 1,cList.first().j)
                    cList.removeFirst()
                }
            }
        }
    }
    //降順ソート
    val sortilList = ilList.sortedWith(
        compareByDescending<Island> { it.land }.thenByDescending { it.sea }
    )
    for (il in sortilList) {
        println("" + il.land + " " + il.sea)
    }
}
class Island(var land: Int, var sea: Int)
class Coordinate2(var i: Int, var j: Int)