object Task3:
    @annotation.tailrec
    def gcd(a: Int, b: Int): Int =
        println(s"${a}, ${b}")
        b match
            case a if a == 0 => throw java.lang.IllegalArgumentException()
            case a if a == b => a
            case a if a <= b => gcd(b, a)
            case b if b != 0 => gcd(b, a % b)
            case _ => a