fun main() {

    fun scorePlay(play: String): Int {
        return when(play) {
            "A" -> 1
            "B" -> 2
            "C" -> 3
            else -> 0
        }
    }

    fun scoreOutcome(opponent: String, play: String): Int {
        return when(opponent) {
            // Rock
            "A" -> when(play) {
                "A" -> 3
                "B" -> 6
                "C" -> 0
                else -> 0
            }
            // Paper
            "B" -> when(play) {
                "A" -> 0
                "B" -> 3
                "C" -> 6
                else -> 0
            }
            // Scissors
            "C" -> when(play) {
                "A" -> 6
                "B" -> 0
                "C" -> 3
                else -> 0
            }
            else -> 0
        }
    }

    fun translatePlay(play: String): String {
        return when(play) {
            "X" -> "A"
            "Y" -> "B"
            "Z" -> "C"
            else -> ""
        }
    }

    fun determinePlay(opponent: String, result: String): String {
        return when(opponent) {
            // Rock
            "A" -> when(result) {
                "X" -> "C"
                "Y" -> "A"
                "Z" -> "B"
                else -> ""
            }
            // Paper
            "B" -> when(result) {
                "X" -> "A"
                "Y" -> "B"
                "Z" -> "C"
                else -> ""
            }
            // Scissors
            "C" -> when(result) {
                "X" -> "B"
                "Y" -> "C"
                "Z" -> "A"
                else -> ""
            }
            else -> ""
        }
    }

    fun parseInput(input: List<String>): List<Pair<String, String>> {
        return input.map {
            val split = it.split(" ")
            Pair(split[0], split[1])
        }
    }

    fun part1(input: List<String>): Int {
        val parsedInput = parseInput(input)
        var score = 0

        // Loop each round
        for(item in parsedInput) {
            val play = translatePlay(item.second)
            score += scorePlay(play)
            score += scoreOutcome(item.first, play)
        }

        return score
    }

    fun part2(input: List<String>): Int {
        val parsedInput = parseInput(input)
        var score = 0

        // Loop each round
        for(item in parsedInput) {
            val play = determinePlay(item.first, item.second)
            score += scorePlay(play)
            score += scoreOutcome(item.first, play)
        }

        return score
    }

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}