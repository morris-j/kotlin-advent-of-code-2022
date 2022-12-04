fun main() {

    fun getRank(value: Char): Int {
        if(value.isUpperCase()) {
            return value.code - 64 + 26
        }
        return value.code - 96
    }

    fun findCommon(first: String, second: String): Char {
        first.forEach {
            if(second.contains(it)) {
                return it
            }
        }
        return 'a'
    }

    fun findCommonGroup(first: String, second: String, third: String): Char {
        first.forEach {
            if(second.contains(it) && third.contains(it)) {
                return it
            }
        }
        return 'a'
    }

    fun processInput(input: List<String>): List<Triple<String, String, Char>> {
        return input.map {
            val mid = it.length / 2
            val first = it.substring(0, mid)
            val second = it.substring(mid)
            val common = findCommon(first, second)
            Triple(first, second, common)
        }
    }

    fun processInputGroup(input: List<String>): List<Char> {
        return input.chunked(3).map {
            findCommonGroup(it[0], it[1], it[2])
        }
    }

    fun part1(input: List<String>): Int {
        var sum = 0
        val processedInput = processInput(input)
        processedInput.forEach {
            sum += getRank(it.third)
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        var sum = 0
        val processedInput = processInputGroup(input)
        processedInput.forEach {
            sum += getRank(it)
        }
        return sum
    }

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}