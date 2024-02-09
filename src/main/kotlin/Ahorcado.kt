/*
Ahorcado con un arreglo de palabras seleccionando una al azar para adivinar
Lista de palabras correctas
Lista de palabras incorrectas
Numero de intentos

 */
fun main() {
    val words = listOf("gato", "perro", "elefante", "leon", "tigre", "ballena", "tiburon")
    //Selecciona una palabra al azar generando un rango automatico en base al numero de palabras existentes
    val wordToGuess = words[words.indices.random()]
    val correctLetters = mutableListOf<Char>()
    val inorrectLetters = mutableListOf<Char>()
    var attempts = 5

    println("Bienvenido al juego del ahorcado")
    println("La palabra tiene ${wordToGuess.length} letras")
    val test = hideWord(wordToGuess, correctLetters)
    while (attempts > 0) {
        println("Palabra ${hideWord(wordToGuess, correctLetters)}")
        println("Ingresa a una letra")
        val letter = readlnOrNull()?.lowercase()?.firstOrNull()

        if (letter == null || !letter.isLetter()) {
            println("Entrada no valida")
            continue
        }

        if(correctLetters.contains(letter) || inorrectLetters.contains(letter)) {
            println("Ya has ingresado esta letra")
            continue
        }
        if (wordToGuess.contains(letter)) {
            correctLetters.add(letter)
            if (wordToGuess.all { c -> correctLetters.contains(c) }) {
                println("Felicidades adivinaste la palabra correctamente")
                println("La palabra era: $wordToGuess")
                break
            }
        } else {
            inorrectLetters.add(letter)
            attempts--
            println("Letras incorrectas: $inorrectLetters")
            println("Te quedan $attempts intentos")

        }
        print("Has Perdido")

    }

}

//fun hideWord(word: String, correctLetters: List<Char>) :String{
//    val hiddenWord = StringBuilder()
//    for (char in word) {
//        if (correctLetters.contains(char)){
//            hiddenWord.append(char)
//        }
//        else {
//            hiddenWord.append("_")
//        }
//        hiddenWord.append(" ")
//
//    }
//
//    return hiddenWord.toString().trim() //Quita lso espacios en blanco
//
//}

fun hideWord(word:String, correctLetters:List<Char>) : String{
    return word.map {if(correctLetters.contains(it)) it else "_"}.joinToString(" ")
}