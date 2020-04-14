package subtask3

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        val upperA = a.toUpperCase()
        for(char in b) {
            if (!a.contains(char, true))
                return "NO"
        }
        val indexes: IntArray = IntArray(b.length)
        for (i in b.indices) {
            indexes[i] = upperA.indexOf(b[i], 0)
        }
        for (i in 0..indexes.size - 2) {
            if (indexes[i] > indexes[i+1]) {
                return "NO"
            }
        }
        return "YES"
    }

}
