fun main(args: Array<String>) {
    val original = intArrayOf(1, 2, 2, 3, 4, 4, 5)
    val unique = original.distinct()
    for(o in original){
        println(o)
    }
}

fun solutio2(arr: Array<Int>): Array<Int> {
    var ary = Array(arr.size) {0}
    for(i in 0 until arr.size){
        ary[i] = arr[i] * 2
    }
    return ary
}

fun solution2(nums: Array<Int>, target: Int): Int {
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


fun solution2(reservations: Array<Array<Int>>): Int {

    return 1
}

//kotlin 引数 int配列 戻り値 int配列
fun sample(input: IntArray): IntArray {
    // 例：すべての値を2倍にする
    return input.map { it * 2 }.toIntArray()
}

//kotlin 引数 intリスト 戻り値 intリスト
fun sample2(input: List<Int>): List<Int> {
    // 例：各要素を2倍にする
    return input.map { it * 2 }
}

//kotlin 引数 int配列 戻り値 intリスト
fun sample3(input: IntArray): List<Int> {
    // 例：すべての値を2倍にする
    return input.toMutableList()
    //toMutableListはListを継承してるのでreturnできる
    //関数を呼び出した元はaddは使えない
}

fun solution2(arr: Array<Int>): Array<Int> {
    // TODO: Implement here!
    return arr.map { it * 2 }.toTypedArray()
}


fun solution3(nums: Array<Int>): Array<Int> {
    val n = nums.size
    val result = Array(n) { 0 }

    for (i in 0 until n) {
        var count = 0
        for (start in 0..i) {
            for (end in i until n) {
                val sub = nums.sliceArray(start..end)
                val max = sub.maxOrNull() ?: continue

                // 条件1: nums[i] が最大で一意
                if (nums[i] == max && sub.count { it == max } == 1) {
                    // 条件2: 部分配列の最初または最後が nums[i]
                    if (sub.first() == nums[i] || sub.last() == nums[i]) {
                        count++
                    }
                }
            }
        }
        result[i] = count
    }

    return result
}


fun solution4(nums: Array<Int>): Array<Int> {
    val n = nums.size
    val result = Array(n) { 0 }

    for (i in 0 until n) {
        val target = nums[i]
        var count = 0

        // 左方向に拡張
        var max = Int.MIN_VALUE
        var freq = mutableMapOf<Int, Int>()
        for (start in i downTo 0) {
            val value = nums[start]
            freq[value] = freq.getOrDefault(value, 0) + 1
            max = maxOf(max, value)

            if (freq[max] == 1 && target == max && (start == i || i == i)) {
                if (nums[start] == target || nums[i] == target) {
                    count++
                }
            }
        }

        // 右方向に拡張
        max = Int.MIN_VALUE
        freq.clear()
        for (end in i until n) {
            val value = nums[end]
            freq[value] = freq.getOrDefault(value, 0) + 1
            max = maxOf(max, value)

            if (freq[max] == 1 && target == max && (i == i || end == i)) {
                if (nums[i] == target || nums[end] == target) {
                    count++
                }
            }
        }

        result[i] = count - 1 // 自分自身が重複カウントされるので1つ減らす
    }

    return result
}

fun solution4(nums: Array<Int>, target: Int): Int {
    val count = IntArray(target) { 0 }

    // 各数の余りをカウント
    for (num in nums) {
        val mod = num % target
        count[mod]++
    }

    var result = 0

    // 余り 0 は1つまで（0+0 が target になるため）
    if (count[0] > 0) result += 1

    // i + (target - i) == target になるペアを処理
    for (i in 1..target / 2) {
        if (i == target - i) {
            // 余りがちょうど target の半分（例: 6/2 = 3）のときは1つだけ
            result += 1.coerceAtMost(count[i])
        } else {
            // 多い方を採用（共存できないペア）
            result += maxOf(count[i], count[target - i])
        }
    }

    return result
}
