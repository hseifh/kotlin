//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner
fun main() {
    var numbers = IntArray(5)
    for(n in numbers){ println(n) }
    val original = intArrayOf(1,2,3,4,5)
    var ary = original.map { it * 2 }
    ary.toMutableList().add(2)


    println(ary::class.simpleName)
    System.exit(0)

    //var ary = original.map { it * 2 }
    //var ary = original.filter { it % 2 == 0 }
    //for(a in ary){ println(a) }
    //for(o in original){ println(o) }
    //ary.toIntArray()

    println(15.times(2))
    //println(times(15,2))


    val name = "Kotlin1"
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Hello, " + name + "!saa")

    for (i in 1..5) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        println("i = $i")
    }
    val scanner = Scanner(System.`in`)

    val N = scanner.nextInt()



    println("${N::class.simpleName}")

}

