package subtask5

import java.lang.IllegalArgumentException
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        if (blockA.isNotEmpty()) {
            return when (blockB) {

                Int::class -> {
                    blockA.filterIsInstance<Int>().sum()
                }

                String::class -> {
                    blockA.filterIsInstance<String>().joinToString("")
                }

                LocalDate::class -> {
                    blockA.filterIsInstance<LocalDate>().max()!!.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
                }

                else -> {
                    throw IllegalArgumentException("Illegal blockB argument")
                }
            }
        } else throw IllegalArgumentException("Illegal blockA argument: it cannot be empty")
    }
}
