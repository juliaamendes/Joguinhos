import java.util.Locale
import java.util.Locale.getDefault
import kotlin.random.Random

fun main() {
    println("Bem-vindo ao jogo de Roleta!")
    var playAgain = true

    while (playAgain) {
        println("\nEscolha uma opção:")
        println("1. Adivinhar o número (1 a 36)")
        println("2. Adivinhar a cor (Vermelho ou Preto)")
        println("3. Sair")
        print("Escolha: ")
        val choice = readLine()?.toIntOrNull()

        when (choice) {
            1 -> {

                print("\nDigite seu palpite de número (1 a 36): ")
                val userNumber = readLine()?.toIntOrNull()
                if (userNumber != null && userNumber in 1..36) {
                    val winningNumber = Random.nextInt(1, 37)
                    println("O número sorteado foi: $winningNumber")
                    if (userNumber == winningNumber) {
                        println("Parabéns! Você acertou!")
                    } else {
                        println("Que pena, você errou. Tente novamente!")
                    }
                } else {
                    println("Número inválido! Escolha um número entre 1 e 36.")
                }
            }
            2 -> {

                print("\nDigite sua aposta de cor (Vermelho ou Preto): ")
                val userColor = readLine()?.trim()?.lowercase(getDefault())
                if (userColor == "vermelho" || userColor == "preto") {
                    val winningColor = if (Random.nextBoolean()) "vermelho" else "preto"
                    println("A cor sorteada foi: $winningColor")
                    if (userColor == winningColor) {
                        println("Parabéns! Você acertou a cor!")
                    } else {
                        println("Que pena, você errou a cor. Tente novamente!")
                    }
                } else {
                    println("Cor inválida! Escolha entre 'Vermelho' ou 'Preto'.")
                }
            }
            3 -> {
                println("\nObrigado por jogar! Até a próxima!")
                playAgain = false
            }
            else -> println("Escolha inválida. Tente novamente.")
        }


        if (playAgain) {
            print("\nQuer jogar novamente? (sim/não): ")
            val response = readLine()?.trim()?.lowercase(getDefault())
            if (response != "sim") {
                playAgain = false
                println("\nObrigado por jogar! Até a próxima!")
            }
        }
    }
}
