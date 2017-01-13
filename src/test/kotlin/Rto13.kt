import io.kotlintest.specs.FlatSpec

fun rot13(s: String): String =
        s.map { if(it.isLetter()) toLetter(alphabetIndex(it) + 13) else it }.joinToString("")

fun toLetter(x: Int): Char = (x.mod(26) + 65).toChar()

fun alphabetIndex(letter: Char): Int = letter.toUpperCase().toInt() - 65

class Rot13Specs : FlatSpec() {
    init {
        "alphabetIndex of o" should "be 14" {
            alphabetIndex('o') shouldBe 14
        }

        "alphabetIndex of A" should "be 0" {
            alphabetIndex('A') shouldBe 0
        }

        "rot13" should "return empty string given empty string as input" {
            rot13("") shouldBe ""
        }

        "rot13" should "return 'N' given 'A' as input" {
            rot13("A") shouldBe "N"
        }

        "rot13" should "return 'O' given 'B' as input" {
            rot13("B") shouldBe "O"
        }

        "rot13" should "return 'NO' given 'AB' as input" {
            rot13("AB") shouldBe "NO"
        }

        "rot13" should "return 'R' given 'e' as input" {
            rot13("e") shouldBe "R"
        }

        "rot13" should "return 'B' given 'o' as input" {
            rot13("o") shouldBe "B"
        }

        "rot13" should "return ',' given ',' as input" {
            rot13(",") shouldBe ","
        }

        "rot13" should "return ' ' given ' ' as input" {
            rot13(" ") shouldBe " "
        }

        "rot13" should "return 'URYYB, JBEYQ!' given 'Hello, World!'" {
            rot13("Hello, World!") shouldBe "URYYB, JBEYQ!"
        }
    }

}