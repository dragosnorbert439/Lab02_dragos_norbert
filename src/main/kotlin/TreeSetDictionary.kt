import IDictionary.Companion.fileName
import java.io.File
import java.util.*

object TreeSetDictionary : IDictionary
{
    // private fields
    private var words = TreeSet<String>()

    // init
    init
    {
        this.addFromTxtFile(fileName);
    }

    // methods
    override fun add(str: String): Boolean
    {
        if (str.isNotEmpty() && str.isNotBlank())
        {
            this.words.add(str)
            return true
        }
        return false
    }

    override fun find(str: String): Boolean
    {
        if (str.isNotEmpty() && str.isNotBlank())
        {
            return words.contains(str);
        }
        return false
    }

    override fun size(): Int
    {
        return words.size
    }

    fun addFromTxtFile(fileName: String): Unit
    {
        val file = File(fileName)
        if (!file.isFile) return

        file.forEachLine { this.words.add(it.toString()) }
    }
}