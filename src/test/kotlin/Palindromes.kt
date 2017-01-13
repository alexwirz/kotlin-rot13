import io.kotlintest.specs.FlatSpec

fun isPalindrome(s: String): Boolean {
    if(s.isEmpty()) return true

    val middle = s.length/2
    for(i in 0..middle) {
        if(!charactersEqual(s, i, s.lastIndex - i)) return false
    }

    return true
}

fun charactersEqual(s: String, firstIndex: Int, secondIndex: Int) =
        s[firstIndex] == s[secondIndex]

class AnagramsSpec : FlatSpec() {
    init {
        "empty string" should "be an palindrome" {
            isPalindrome("") shouldBe true
        }

        "AB" should "not be an palindrome" {
            isPalindrome("AB") shouldBe false
        }

        "A" should "be an palindrome" {
            isPalindrome("A") shouldBe true
        }

        "ABA" should "be an palindrome" {
            isPalindrome("ABA") shouldBe true
        }

        "ABCA" should "not be an palindrome" {
            isPalindrome("ABCA") shouldBe false
        }

        "ABBCBA" should "be an palindrome" {
            isPalindrome("ABBCBA") shouldBe false
        }

        "ABCBA" should "be an palindrome" {
            isPalindrome("ABCBA") shouldBe true
        }
    }
}
