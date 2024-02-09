/*
Piedra, Papel o Tijera
*/

//fun main(){
//    var computerChoice = ""
//    var playerChoice = ""
//    print("Selecciona una opcion: piedra, papel o tijera: \n")
//    playerChoice = readln()
//    val randomNumber = (1..3).random()
////    if(randomNumber == 1){
////        computerChoice = "piedra"
////    } else if (randomNumber == 2){
////        computerChoice = "papel"
////    } else {
////        computerChoice = "tijera"
////    }
//    when(randomNumber){
//        1 -> computerChoice = "piedra"
//        2 -> computerChoice = "papel"
//        3 -> computerChoice = "tijera"
//    }
//    print("JUgador escogio: " + playerChoice + "\n")
//    print("Computadora Escogio: " + computerChoice + "\n"
//
//    val winner = when{
//        playerChoice == computerChoice -> "Empate"
//        playerChoice == "piedra" && computerChoice == "tijera" -> "Usuario"
//        playerChoice == "papel" && computerChoice == "piedra" -> "Usuario"
//        playerChoice == "tijera" && computerChoice == "papel" -> "Usuario"
//        else -> "Computadora Gano"
//    }
//    println("El ganador ee: $winner")
//}


//Esta forma se usa para validar solo las opciones validas que se le indiquen al usuario y evitar que ingrese
//otros valores erroneos
enum class Choice {
    PIEDRA, PAPEL, TIJERA, SIN_ELECCION
}
enum class Winner {
    JUGADOR, COMPUTADORA, EMPATE
}
fun main(){
    var computerChoice = Choice.SIN_ELECCION
    var playerChoice = Choice.SIN_ELECCION

    println("Por favor seleccione una opcion: ")
    println("1. Piedra")
    println("2. Papel")
    println("3. Tijera")

    var choiceInput = readln().toIntOrNull()
    var isValidInput : Boolean = choiceInput != null && choiceInput in 1..3

    while(!isValidInput){
        println("Entrada no valida. Por favor ingresa solo numeros del 1 al 3.")
        println("Ingresa el numero correspondiente a tu eleccion (1, 2, 3)")
        choiceInput = readln().toIntOrNull()
        isValidInput = choiceInput != null && choiceInput in 1..3
    }
    //Se valida que haya seleccionado una de las opcioens proporcionadas y validadas
    playerChoice = when(choiceInput) {
        1 -> Choice.PIEDRA
        2 -> Choice.PAPEL
        3 -> Choice.TIJERA
        else -> Choice.SIN_ELECCION
    }

    println("Tu eleccion es: $playerChoice")

    if (playerChoice== Choice.SIN_ELECCION) {
        println("Entrada no valida. Por favor ingresa solo numers del 1 al 3.")
        return
    }
    val randomNUmber = (1..3).random()
    computerChoice = when(randomNUmber) {
        1 -> Choice.PIEDRA
        2 -> Choice.PAPEL
        3 -> Choice.TIJERA
        else -> Choice.SIN_ELECCION
    }
    println("La eleccion de la computadora es: $computerChoice")
    val winner = when {
        playerChoice == computerChoice -> Winner.EMPATE
        playerChoice == Choice.PIEDRA && computerChoice == Choice.TIJERA -> Winner.JUGADOR
        playerChoice == Choice.PAPEL && computerChoice == Choice.PIEDRA -> Winner.JUGADOR
        else -> Winner.COMPUTADORA

    }
    println("El ganador es: $winner")
}