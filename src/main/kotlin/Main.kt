import java.io.File.separator

fun main(args: Array<String>)
{
// Problem 1.
// code for testing problem 1.
    /*
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
    */
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


}