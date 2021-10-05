object DictionaryProvider
{
    fun createDictionary(dictType: DictionaryType): IDictionary
    {
        if (dictType == DictionaryType.ARRAY_LIST) return ArrayListDictionary
        if (dictType == DictionaryType.TREE_SET) return TreeSetDictionary
        if (dictType == DictionaryType.HASH_SET) return HashSetDictionary
        return ListDictionary
    }
}
