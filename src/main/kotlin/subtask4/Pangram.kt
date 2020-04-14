package subtask4

class Pangram {

    private val vowels = "aeiouy"
    private val regex = "\\s".toRegex()

    fun getResult(inputString: String): String {
        val words = inputString.split(regex).toMutableList()
        val withNumbers = mutableListOf<String>()
        if(isPangram(inputString)) {
            for (j in words.indices) {
                val chars = words[j].toCharArray()
                var counter = 0
                for (i in chars.indices) {
                    if (vowels.contains(chars[i], true)) {
                        counter++
                        chars[i] = chars[i].toUpperCase()
                    }
                }
                if (chars.isNotEmpty()) {
                    words[j] = chars.toString()
                    withNumbers.add(counter.toString() + String(chars))
                }
            }
            withNumbers.sortBy {it[0]}
        } else {
            for (j in words.indices) {
                var counter = 0
                val chars = words[j].toCharArray()
                for (i in chars.indices) {
                    if (!vowels.contains(chars[i], true) && chars[i].toLowerCase() in 'b'..'z') {
                        counter++
                        chars[i] = chars[i].toUpperCase()
                    }
                }
                if (chars.isNotEmpty()) {
                    words[j] = chars.toString()
                    withNumbers.add(counter.toString() + String(chars))
                }
            }
            withNumbers.sortBy {it[0]}
        }
        return withNumbers.joinToString(separator = " ")
    }

    private fun isPangram(str: String): Boolean {
        for (i in 'A'..'Z'){
            if(!str.contains(i, true)) {
                return false
            }
        }
        return true
    }
}
