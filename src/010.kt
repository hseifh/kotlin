import java.io.BufferedReader
import java.io.InputStreamReader

class Person(var name: String, var age: Int)

fun main(args: Array<String>) {

    val  p = Person("鈴木",23)
    println(p.name + " " + p.age)
    p.name = "佐藤"
    p.age = 43
    println(p.name + " " + p.age)
}
