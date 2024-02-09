/*

Generacion de numero aleatorio entre dos rangos
El usuario selecciona un nuero al azar

 */

fun main(){
    val minRange = 1
    val maxRange = 20
    val numberToGuess  = (minRange..maxRange).random()
    var attempts = 0
    var guess: Int?

    println("Bienvenido al juefo Adivina el numero")

    println("Estoy pensando un numero entre el $minRange y el $maxRange adivinalo")

    do{
        println("Ingrsa tu Suposicion: ")
        guess = readln().toIntOrNull()
          if(guess != null){
              attempts++
              when{
                  guess < numberToGuess -> println("El numero es mayor")
                  guess > numberToGuess -> println("El numero es menor")
                  else -> println("Felicidades adivinaste el numero en $attempts intentos")

              }
          }
    }while(guess != numberToGuess)
}