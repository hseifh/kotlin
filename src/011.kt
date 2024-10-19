import java.io.BufferedReader
import java.io.InputStreamReader

class Student(
    var thinkingType: String,
    var english: Int,
    var mathematics: Int,
    var science: Int,
    var language: Int,
    var twoCourses: Int,
    var allCourses: Int,
    var judgment: Boolean
)

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = Integer.parseInt(br.readLine())
    var studentlist = ArrayList<Student>()
    //var stringArray
    /*
    for (i in 1..N){
        var stringArray = br.readLine().split(" ")
        studentlist.add(
            Student(
                stringArray[0],
                stringArray[1],
                stringArray[2],
                stringArray[3],
                stringArray[4],
                stringArray[5]
            )
        )
    }

     */
}