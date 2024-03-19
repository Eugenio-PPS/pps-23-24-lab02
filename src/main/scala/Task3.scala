object Task3:
    @annotation.tailrec
    def gcd(a: Int, b: Int): Int = b match
        case _ if a == 0 && b != 0 => b
        case _ if b != 0 => gcd(b, a % b)
        case _ => a