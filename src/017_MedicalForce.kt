fun main(args: Array<String>) {
    val original = intArrayOf(1, 2, 2, 3, 4, 4, 5)
    val unique = original.distinct()
    for(o in original){
        println(o)
    }
}

fun solution(arr: Array<Int>): Array<Int> {
    var ary = Array(arr.size) {0}
    for(i in 0 until arr.size){
        ary[i] = arr[i] * 2
    }
    return ary
}

fun solution(nums: Array<Int>, target: Int): Int {
    var ans = 0
    a@ for(i in 0 until nums.size){
        b@ for(j in i until nums.size){
            if((nums[i] + nums[j]) == target){
                println("" + i + "と" + j)
                ans++
            }
        }
    }
    return ans
}


fun solution(reservations: Array<Array<Int>>): Int {

    return 1
}

