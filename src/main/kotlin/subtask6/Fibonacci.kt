package subtask6

class Fibonacci {

    fun productFibonacciSequenceFor(n: Int): IntArray {
        for (i in 0..n) {
            val fibonacci1 = fibonacciSequence(i)
            val fibonacci2 = fibonacciSequence(i + 1)
            if (fibonacci1 * fibonacci2 == n) return intArrayOf(fibonacci1, fibonacci2, 1)
            else if (fibonacci1 * fibonacci2 > n) return intArrayOf(fibonacci1, fibonacci2, 0)
        }
        return intArrayOf()
    }

    private fun fibonacciSequence(n: Int): Int {
        return if (n < 2) n else fibonacciSequence(n - 1) + fibonacciSequence(n - 2)
    }
}
