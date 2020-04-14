package subtask1

import java.util.*

class DateFormatter {
    private val months = arrayOf("января", "февраля", "марта", "апреля", "мая", "июня", "июля", "августа", "сентября", "октября", "ноября", "декабря")
    private val weekDays = arrayOf("воскресенье", "понедельник", "вторник", "среда", "четверг", "пятница", "суббота")

    private fun isLeap(year: Int): Boolean {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
    }

    private fun isDateValid(day: Int, month: Int, year: Int): Boolean {
        if(day in 1..31 && month in 1..12 && year > 0) {

            if(isLeap(year) && month == 2) {
                return day <= 29
            } else if (!isLeap(year) && month == 2) {
                return day <= 28
            }

            if (month == 4 || month == 6 || month == 9 || month == 11) {
                return day < 30
            }

            return true
        }
        return false
    }

    fun toTextDay(day: String, month: String, year: String): String {
        return if (isDateValid(day.toInt(), month.toInt(), year.toInt())) {
            val calendar: Calendar = Calendar.getInstance()
            calendar.set(year.toInt(), month.toInt() - 1, day.toInt())
            "$day ${months[month.toInt() - 1]}, ${weekDays[calendar.get(Calendar.DAY_OF_WEEK) - 1]}"
        } else "Такого дня не существует"
    }
}
