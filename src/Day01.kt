fun main() {

    fun processInput(input: String): List<Int> {
        return input.split("\n\n").map { it.split("\n").sumOf { it.toInt() } }
    }

    fun part1(input: String): Int {
        val items = processInput(input).sortedDescending()
        return items.first()
    }

    fun part2(input: String): Int {
        // Find the Elf carrying the most Calories, How many total Calories is that Elf carrying?
        val items = processInput(input).sortedDescending()
        return items.take(3).sum()
    }

    val input = readInputAsString("Day01")
    println(part1(input))
    println(part2(input))
}
