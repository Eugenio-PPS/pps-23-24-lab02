object Task3:
    def gcd(a: Int, b: Int): Int =
        b match
            case b if b != 0 => gcd(b, a % b)
            case _ => a