import java.io.BufferedReader
import java.io.InputStreamReader

class Student(
    var thinkingType: String,
    var english: Int,
    var mathematics: Int,
    var science: Int,
    var language: Int,
    var geography: Int,
    var twoCourses: Int,
    var allCourses: Int,
    var judgment: Boolean
)

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = Integer.parseInt(br.readLine())
    var studentlist = ArrayList<Student>()
    for (i in 1..N){
        var stringArray = br.readLine().split(" ")
        studentlist.add(
            Student(
                stringArray[0],
                Integer.parseInt(stringArray[1]),
                Integer.parseInt(stringArray[2]),
                Integer.parseInt(stringArray[3]),
                Integer.parseInt(stringArray[4]),
                Integer.parseInt(stringArray[5]),
                0,
                0,
                false
            )
        )
    }
    /*
    println(N)
    for (student in studentlist) {
        println(student.thinkingType + " " +
                student.english + " " +
                student.mathematics + " " +
                student.science + " " +
                student.language + " " +
                student.geography
        )
    }
    */
    for (student in studentlist) {
        if(student.thinkingType == "s"){
            student.twoCourses = student.mathematics + student.science
            student.allCourses = student.twoCourses + student.english +
                                 student.language + student.geography
        } else if(student.thinkingType == "l"){
            student.twoCourses = student.language + student.geography
            student.allCourses = student.twoCourses + student.english +
                                 student.mathematics + student.science
        }
        if(student.twoCourses >= 160 && student.allCourses >= 350){
            student.judgment = true
        }
    }
    var ans = 0
    for (student in studentlist) {
        if(student.judgment){
            ans++
        }
    }
    println(ans)
    /*
    for (student in studentlist) {
        println(student.thinkingType + " " +
                student.english + " " +
                student.mathematics + " " +
                student.science + " " +
                student.language + " " +
                student.geography + " " +
                student.twoCourses + " " +
                student.allCourses
        )
    }
    */
}