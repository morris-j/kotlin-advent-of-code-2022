fun main() {

    fun createRange(value: String): IntRange {
        val split = value.split("-")
        val first = split[0].toInt()
        val second = split[1].toInt()
        return IntRange(first, second)
    }

    fun processInput(input: List<String>): List<Pair<IntRange, IntRange>> {
        return input.map {
            val split = it.split(",")
            val first = createRange(split[0])
            val second = createRange(split[1])
            Pair(first, second)
        }
    }

    fun part1(input: List<String>): Int {
        var sum = 0
        val processedInput = processInput(input)
        processedInput.forEach {
            if(it.first.contains(it.second.first) && it.first.contains(it.second.last)
                || it.second.contains(it.first.first) && it.second.contains(it.first.last)) {
                sum += 1
            }
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        var sum = 0
        val processedInput = processInput(input)
        processedInput.forEach {
            if(it.first.contains(it.second.first) || it.first.contains(it.second.last)
                || it.second.contains(it.first.first) || it.second.contains(it.first.last)) {
                sum += 1
            }
        }
        return sum
    }

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}