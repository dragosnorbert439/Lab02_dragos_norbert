interface IDictionary
{
    fun add(str :String): Boolean
    fun find(str :String): Boolean
    fun size(): Int

    companion object
    {
        const val fileName: String = "dictionary.txt"
    }
}