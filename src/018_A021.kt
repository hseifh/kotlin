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
    fun isisland(direction:Char) {
        println("isisland")
        when (sArray[cList.first().i][cList.first().j]) {
            '#' -> {
                when (direction){
                    'E' -> {
                        cList.add(Coordinate2(cList.first().i,cList.first().j + 1))
                        sArray[cList.last().i][cList.last().j + 1] = '*'
                    }
                    'S' -> {
                        cList.add(Coordinate2(cList.first().i + 1,cList.first().j))
                        sArray[cList.last().i + 1][cList.last().j] = '*'
                    }
                    'W' -> {
                        cList.add(Coordinate2(cList.first().i,cList.first().j - 1))
                        sArray[cList.last().i][cList.last().j - 1] = '*'
                    }
                    'N' -> {
                        cList.add(Coordinate2(cList.first().i - 1,cList.first().j))
                        sArray[cList.last().i - 1][cList.last().j] = '*'
                    }
                }
                ilList.last().land++
            }
            '.' -> {
                ilList.last().sea++
            }
        }
    }
    for (i in 1 until (sArray.size - 1)) {
        for (j in 1 until (sArray[i].size - 1)) {
            println("for")
            if(sArray[i][j] == '#'){
                sArray[i][j] = '*'
                ilList.add(Island(1,0))
                cList.add(Coordinate2(i,j))
                while(cList.size > 0) {
                    //右が陸
                    /*
                    when (sArray[cList.first().i][cList.first().j + 1]) {
                        '#' -> {
                            cList.add(Coordinate2(cList.first().i,cList.first().j + 1))
                            ilList.last().land++
                            sArray[cList.last().i][cList.last().j] = '*'
                        }
                        '.' -> {
                            ilList.last().sea++
                        }
                    }

                     */
                    isisland('E')
                    //下が陸
                    isisland('S')
                    /*
                    when (sArray[cList.first().i + 1][cList.first().j]) {
                        '#' -> {
                            cList.add(Coordinate2(cList.first().i + 1,cList.first().j))
                            ilList.last().land++
                            sArray[cList.last().i][cList.last().j] = '*'
                        }
                        '.' -> {
                            ilList.last().sea++
                        }
                    }

                     */
                    //左が陸
                    isisland('W')
                    /*
                    when (sArray[cList.first().i][cList.first().j - 1]) {
                        '#' -> {
                            cList.add(Coordinate2(cList.first().i,cList.first().j - 1))
                            ilList.last().land++
                            sArray[cList.last().i][cList.last().j] = '*'
                        }
                        '.' -> {
                            ilList.last().sea++
                        }
                    }

                     */
                    //上が陸
                    isisland('N')
                    /*
                    when (sArray[cList.first().i - 1][cList.first().j]) {
                        '#' -> {
                            cList.add(Coordinate2(cList.first().i - 1,cList.first().j))
                            ilList.last().land++
                            sArray[cList.last().i][cList.last().j] = '*'
                        }
                        '.' -> {
                            ilList.last().sea++
                        }
                    }
                    /
                     */
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



    //isisland()
}

class Island(var land: Int, var sea: Int)

class Coordinate2(var i: Int, var j: Int)