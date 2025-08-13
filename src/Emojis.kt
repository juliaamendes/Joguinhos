import java.util.Locale
import java.util.Locale.getDefault
import kotlin.random.Random

fun main() {
    val emojis = arrayOf("🍎", "🍌", "🍓", "🍉", "🍍", "🍒", "🍇", "🥥", "🍊", "🍓")

    println("Bem-vindo ao Jogo de Bet de Emojis!")
    var playAgain = true

    while (playAgain) {
        val drawnEmojis = Array(3) { emojis[Random.nextInt(emojis.size)] }
        println("\nTente adivinhar os 3 emojis sorteados!")


        println("Escolha 3 emojis (separe por espaços):")
        print("Exemplo: 🍎 🍌 🍓 > ")
        val userInput = readLine()?.split(" ")

        if (userInput != null && userInput.size == 3) {
            if (userInput == drawnEmojis.toList()) {
                println("\nParabéns! Você acertou todos os emojis: ${drawnEmojis.joinToString(" ")}")
            } else {
                println("\nQue pena! Os emojis sorteados foram: ${drawnEmojis.joinToString(" ")}")
                println("Tente novamente!")
            }
        } else {
            println("Por favor, insira 3 emojis válidos separados por espaço.")
        }

        println("\nQuer jogar novamente? (sim/não)")
        val response = readLine()?.trim()?.lowercase(getDefault())
        if (response != "sim") {
            playAgain = false
            println("\nObrigado por jogar! Até a próxima!")
        }
    }
}
