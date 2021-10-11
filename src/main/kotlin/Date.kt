import java.time.LocalDate

data class Date(val date: LocalDate = LocalDate.now()) : Comparable<Date>
{
    override fun compareTo(other: Date): Int
    {
        if (this.date.year != other.date.year) return this.date.year - other.date.year
        if (this.date.monthValue != other.date.monthValue) return this.date.monthValue - other.date.monthValue
        return this.date.dayOfMonth - other.date.dayOfMonth
    }
}