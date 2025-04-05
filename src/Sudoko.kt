fun main ()
{
    //Rule 3 - The digits can only occur once per block (nonet)
    /*
    عايزة اتناقش في فكرة ان انا قررت اعملها Var مش val و list مش mutable
    */
    var valid: List<List<Int>> = listOf(
        listOf(5, 3, 4, 6, 7, 8, 9, 1, 2),
        listOf(6, 7, 2, 1, 9, 5, 3, 4, 8),
        listOf(1, 9, 8, 3, 4, 2, 5, 6, 7),
        listOf(8, 5, 9, 7, 6, 1, 4, 2, 3),
        listOf(4, 2, 6, 8, 5, 3, 7, 9, 1),
        listOf(7, 1, 3, 9, 2, 4, 8, 5, 6),
        listOf(9, 6, 1, 5, 3, 7, 2, 8, 4),
        listOf(2, 8, 7, 4, 1, 9, 6, 3, 5),
        listOf(3, 4, 5, 2, 8, 6, 1, 7, 9)
    )
    test(
        name = "when Sudoko is valid",
        result = SudokoChecker(valid),
        second = true)
    test(
        name = "when sum is n(n-1)/2",
        result = SudokoChecker(valid),
        second = true)
    test(
        name = "when Boundries are correct",
        result = SudokoChecker(valid),
        second = true)
    test(
        name = "when colum are correct",
        result = SudokoChecker(valid),
        second = true)
    test(
        name = "when 3*3 are correct",
        result = SudokoChecker(valid),
        second = true)

    // Rule 1 - Each row must contain the numbers from 1 to 9, without repetitions
    var invalidRow: List<List<Int>> = listOf(
        listOf(3, 4, 5, 2, 8, 6, 1, 7, 8),
        listOf(5, 3, 4, 6, 7, 8, 9, 1, 2),
        listOf(6, 7, 2, 1, 9, 5, 3, 4, 8),
        listOf(1, 9, 8, 3, 4, 2, 5, 6, 7),
        listOf(8, 5, 9, 7, 6, 1, 4, 2, 3),
        listOf(4, 2, 6, 8, 5, 3, 7, 9, 1),
        listOf(7, 1, 3, 9, 2, 4, 8, 5, 6),
        listOf(9, 6, 1, 5, 3, 7, 2, 8, 4),
        listOf(2, 8, 7, 4, 1, 9, 6, 3, 5)
    )
    test(
        name = "when Row is not valid",
        result = SudokoChecker(invalidRow),
        second = false)

    //Rule 2 - Each column must contain the numbers from 1 to 9, without repetitions
    val invalidColumn: List<List<Int>> = listOf(
        listOf(5, 3, 4, 6, 7, 8, 9, 1, 2),
        listOf(6, 3, 2, 1, 9, 5, 3, 4, 8),
        listOf(1, 9, 8, 3, 4, 2, 5, 6, 7),
        listOf(8, 5, 9, 7, 6, 1, 4, 2, 3),
        listOf(4, 2, 6, 8, 5, 3, 7, 9, 1),
        listOf(7, 1, 3, 9, 2, 4, 8, 5, 6),
        listOf(9, 6, 1, 5, 3, 7, 2, 8, 4),
        listOf(2, 8, 7, 4, 1, 9, 6, 3, 5),
        listOf(3, 4, 5, 2, 8, 6, 1, 7, 9)
    )


    test(
        name = "when Column is not valid",
        result =  SudokoChecker(invalidColumn),
        second = false)

    /*Rule 3 - The digits can only occur once per block (nonet)
    1st cell has more than one element فيها احاد و عشرات وانا عايزة احاد بس
    at the same time it above the bound
    */
    val invalidUnitCell: List<List<Int>> = listOf(
        listOf(55, 3, 4, 6, 7, 8, 9, 1, 2),
        listOf(6, 7, 2, 1, 9, 5, 3, 4, 8),
        listOf(1, 9, 8, 3, 4, 2, 5, 6, 7),
        listOf(8, 5, 9, 7, 6, 1, 4, 2, 3),
        listOf(4, 2, 6, 8, 5, 3, 7, 9, 1),
        listOf(7, 1, 3, 9, 2, 4, 8, 5, 6),
        listOf(9, 6, 1, 5, 3, 7, 2, 8, 4),
        listOf(2, 8, 7, 4, 1, 9, 6, 3, 5),
        listOf(3, 4, 5, 2, 8, 6, 1, 7, 9)
    )
    test(
        name = "when matrix in range",
        result = SudokoChecker(invalidUnitCell),
        second = false)

    /*
    Rule 4 - The sum of every single row, column, and nonet must equal 45
    this condition will not be applicable if it's not valid
    TakeCare last num in 1st row less than bound and this will affect on the total sum

    val invalidSum: List<List<Int>> = listOf(
        listOf(5, 3, 4, 6, 7, 8, 9, 1, 0),
        listOf(6, 7, 2, 1, 9, 5, 3, 4, 8),
        listOf(1, 9, 8, 3, 4, 2, 5, 6, 7),
        listOf(8, 5, 9, 7, 6, 1, 4, 2, 3),
        listOf(4, 2, 6, 8, 5, 3, 7, 9, 1),
        listOf(7, 1, 3, 9, 2, 4, 8, 5, 6),
        listOf(9, 6, 1, 5, 3, 7, 2, 8, 4),
        listOf(2, 8, 7, 4, 1, 9, 6, 3, 5),
        listOf(3, 4, 5, 2, 8, 6, 1, 7, 9)
    )
    test(
        name = "when sum is n(n-1)/2",
        result = checkBounds(invalidSum),
        second = false)*/

    //Bareq's Rule Invalid Sudoku that contains any repeated numbers in 3x3 subgrid (box)
    val invalidBox: List<List<Int>> = listOf(
        listOf(5, 3, 4, 6, 7, 8, 9, 1, 2),
        listOf(6, 7, 2, 1, 9, 5, 3, 4, 8),
        listOf(1, 9, 8, 3, 4, 2, 5, 6, 7),
        listOf(8, 5, 9, 7, 6, 1, 4, 2, 3),
        listOf(4, 2, 6, 8, 5, 3, 7, 9, 1),
        listOf(7, 1, 3, 9, 2, 4, 8, 5, 6),
        listOf(9, 6, 1, 5, 3, 7, 2, 8, 4),
        listOf(2, 8, 7, 4, 1, 9, 6, 3, 5),
        listOf(3, 4, 5, 2, 8, 6, 1, 7, 5)
    )
    test(
        name = "when matrix in range",
        result = SudokoChecker(invalidBox),
        second = false)
    //checkBox(invalidBox)

    /* I was make it as a case, due to 1st cell is a "_", but I was intialize a list with int not string -same as all cells are being blank -
    var invalidBlankCell: List<List<Int>> = listOf(
        listOf(_, 3, 4, 6, 7, 8, 9, 1, 2),
        listOf(6, 7, 2, 1, 9, 5, 3, 4, 8),
        listOf(1, 9, 8, 3, 4, 2, 5, 6, 7),
        listOf(8, 5, 9, 7, 6, 1, 4, 2, 3),
        listOf(4, 2, 6, 8, 5, 3, 7, 9, 1),
        listOf(7, 1, 3, 9, 2, 4, 8, 5, 6),
        listOf(9, 6, 1, 5, 3, 7, 2, 8, 4),
        listOf(2, 8, 7, 4, 1, 9, 6, 3, 5),
        listOf(3, 4, 5, 2, 8, 6, 1, 7, 5)
    )*/

}

/**
 * After completing the instructional videos, implement a Sudoku checker function that determines whether a
 * given Sudoku puzzle is valid or not. A valid Sudoku must not contain any repeated numbers in the same row,
 * column, or 3x3 subgrid (box). Use the character '-' to represent empty cells within the puzzle.
 *
 * - The function should return a Boolean value only—true if the Sudoku is valid, and false otherwise.
 * - You must follow a Test-Driven Development (TDD) approach while building this function:
 * - Create a check function, as demonstrated in the tutorial, and write all necessary tests first
 * without implementing any logic inside the actual Sudoku checker function.
 * Initially, the function should always return false.
 * Present your written test cases to your mentor during the daily meeting.
 * Once your mentor approves the test cases, proceed to implement the logic in the function incrementally until all test cases pass successfully.
 * After completing the implementation, design a full flowchart representing the logic of the function using draw.io.
 *
 * Extra: you can make the function dynamic and accept different size of the game like 4 * 4 or 16 * 16 not only 3 * 3
 */
fun test (name: String,result:Boolean, second:Boolean){
    if (result==second)
        println("Success $name")
    else
        println("Failed $name")
}
fun checkBounds(result:List<List<Int>>):Boolean{
    for(i in 0 .. result.size-1) {
        for (j in 0 .. result[i].size-1) {
            if (result[i][j] !in 1..9)
                return false
        }
    }
    return true
}
fun checkSum (result:List<List<Int>>):Boolean{
    var sum = 0
    for(i in 0 .. result.size-1) {
        for (j in 0 .. result.size-1) {
            sum+= result[i][j]
            if (sum == 45)// n(n-1)/2 as n = 9 in this case
                return true
        }
    }
    return false
}

fun checkColumn(result: List<List<Int>>): Boolean {

    for (col in 0..<result.size) {
        val seen = mutableSetOf<Int>()
        for (row in 0..<result.size) {
            val num = result[row][col]
            if(!seen.add(num)) {
                return false
            }
        }
    }
    return true
}









fun checkRow (result:List<List<Int>>):Boolean{
    for(j in 0 until  result.size) {
        val Column = mutableListOf<Int>()
        for (i in 0 .. result.size-1) {
            val row = result[j][i]
            if (row in Column) return false
            Column.add(row)
        }
    }
    return true
}

fun checkBox(result: List<List<Int>>) :Boolean{
    for( i in 0 until result.size ) {
        for ( j in 0 until  result.size ) {
            if(j%3 != 0) {
                return (checkColumn(result)&&checkRow(result))
            }
            if(i%3==0)
                break
        }
    }
    for( i in 0 until  result.size ) {
        for ( j in 0 until  result.size ) {
            if(j%6 != 0) {
                return (checkColumn(result)&&checkRow(result))
            }
        }
        if(i%6!=0)
            break
    }
    for( i in 0 until  result.size ) {
        for ( j in 0 until result.size ) {
            if(j%9 != 0) {
                return (checkColumn(result)&&checkRow(result))
            }
        }
        if(i%9==0)
            break
    }
    return false
}
fun SudokoChecker(result: List<List<Int>>):Boolean{
    return (checkColumn(result)&&checkRow(result)&&checkBox(result)&&checkBounds(result))
}
