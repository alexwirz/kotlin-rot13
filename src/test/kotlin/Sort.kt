import io.kotlintest.specs.FlatSpec
import io.kotlintest.specs.StringSpec

fun <T: Comparable<T>> sorted(xs: List<T>): List<T> {
    if(xs.isEmpty()) return xs
    val median = xs[0]
    val smaller = xs.takeLast(xs.size - 1).filter { it <= median }
    val greater = xs.takeLast(xs.size - 1).filter { it > median }
    return sorted(smaller) + listOf(median) + sorted(greater)
}

class SortSpecs : FlatSpec() {
    init {
        "sorted []" should "be []" {
            sorted(listOf<Int>()).isEmpty() shouldBe true
        }

        "sorted [1]" should "be [1]" {
            sorted(listOf(1)) shouldBe listOf(1)
        }

        "sorted [2, 1]" should "be [1, 2]" {
            sorted(listOf(2, 1)) shouldBe listOf(1, 2)
        }

        "sorted [1, 2]" should "be [1, 2]" {
            sorted(listOf(1, 2)) shouldBe listOf(1, 2)
        }

        "sorted [3, 2, 1]" should "be [1, 2, 3]" {
            sorted(listOf(3, 2, 1)) shouldBe listOf(1, 2, 3)
        }

        "sorted [1, 1, 1]" should "be [1, 1, 1]" {
            sorted(listOf(1, 1, 1)) shouldBe listOf(1, 1, 1)
        }
    }
}

class SortPropertySpec: StringSpec() {
    init {
        "sorted list of integers should be sorted" {
            forAll({ xs: List<Int> ->
                xs.sorted().equals(sorted(xs))
            })
        }
    }
}
