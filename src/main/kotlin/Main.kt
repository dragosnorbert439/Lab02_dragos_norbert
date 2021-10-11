import java.io.File.separator
import java.time.DateTimeException
import java.time.LocalDate
import java.util.random.RandomGenerator
import kotlin.random.Random

fun main(args: Array<String>)
{
// Problem 1.
// code for testing problem 1.

    val dict: IDictionary = DictionaryProvider.createDictionary(DictionaryType.HASH_SET)
    println("Number of words: ${dict.size()}")
    var word: String?
    while(true)
    {
        print("What to find? ")
        word = readLine()
        if( word.equals("quit")) break
        println("Result: ${word?.let { dict.find(it) }}")
    }

// Problem 2.
    fun String.printMonogram() { println(this.split(' ').map { it[0] }.joinToString (separator = "")) }
    val name :String = "Will Smith"
    name.printMonogram()

    fun List<String>.joinElementsWithSeparator() = this.joinToString(separator = "#")
    val myList = listOf("apple", "pear", "melon", "grape", "orange")
    println(myList.joinElementsWithSeparator())

    fun List<String>.getLongestString() = this.sortedByDescending { it.length }[0]
    println(myList.getLongestString())

// Problem 3.
    fun Date.isLeapYear(): Boolean = run {
                if (this.date.year % 4 == 0 && this.date.year % 100 != 0 ) return true
                if (this.date.year % 400 == 0) return true
                return false
    }

    fun Date.isValidDate(): Boolean = run {
        if (this.date.year > 9000 || this.date.year < 0) return false
        if (this.date.month.value > 1 || this.date.month.value > 12) return false
        if (this.date.dayOfMonth < 1 || this.date.dayOfMonth > 31) return false

        if (this.date.month.value == 2)
        {
            if (this.isLeapYear()) return this.date.month.value <= 29
            else return this.date.month.value <= 28
        }

        if (this.date.month.value == 4 || this.date.month.value == 6 ||
                this.date.month.value == 9 || this.date.month.value == 11)
            return this.date.dayOfMonth <= 30

        return true
    }

    val dateList = ArrayList<Date>()

    while (dateList.size < 10)
    {
        val year = Random.nextInt(0, 10000)
        val month = Random.nextInt(0, 14)
        val day = Random.nextInt(0, 40)

        try
        {
            val newDate = Date(LocalDate.of(year, month, day))
            dateList.add(newDate)
        }
        catch (e: DateTimeException)
        {
            println("Invalid date generated: $year.$month.$day")
        }
    }
    println()

    println("Valid dates:")
    dateList.forEach{ println(it.date.year.toString() + "." + it.date.monthValue.toString() + "." + it.date.dayOfMonth.toString()) }
    println(); println()

    println("Dates sorted:")
    dateList.sort()
    dateList.forEach{ println(it.date.year.toString() + "." + it.date.monthValue.toString() + "." + it.date.dayOfMonth.toString()) }
    println(); println()

    println("Reversed:")
    dateList.sortDescending()
    dateList.forEach{ println(it.date.year.toString() + "." + it.date.monthValue.toString() + "." + it.date.dayOfMonth.toString()) }
    println(); println()

    println("Custom sort:")
    dateList.sortWith(Comparator<Date> { d1, d2 -> d1.compareTo(d2) })
    dateList.forEach{ println(it.date.year.toString() + "." + it.date.monthValue.toString() + "." + it.date.dayOfMonth.toString()) }
}