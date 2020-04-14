package subtask2

import kotlin.math.min

class TimeConverter {
    private val smallNumbers = arrayOf("", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")

    fun toTextFormat(hour: String, minute: String): String {
        var hourInt = hour.toInt()
        var minuteInt = minute.toInt()
        val preposition: String
        if (hourInt in 1..12 && minuteInt in 0..60) {
            when(minute) {
                "00" -> return "${smallNumbers[hourInt]} o' clock"
                "15" -> return "quarter past ${smallNumbers[hourInt]}"
                "30" -> return "half past ${smallNumbers[hourInt]}"
                "45" -> return "quarter to ${smallNumbers[hourInt + 1]}"
                else -> {
                    if (minuteInt < 30) {
                        preposition = "past"
                    } else {
                        preposition = "to"
                        hourInt++
                        minuteInt = 60 - minuteInt
                    }

                    return if (minuteInt < 20) {
                        "${smallNumbers[minuteInt]} minutes $preposition ${smallNumbers[hourInt]}"
                    } else {
                        minuteInt %= 20
                        "twenty ${smallNumbers[minuteInt]} minutes $preposition ${smallNumbers[hourInt]}"
                    }
                }
            }
        } else return ""
    }
 }
