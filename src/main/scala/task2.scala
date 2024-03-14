object Task2a extends App:
    def positive(x: Int): String = x match
        case x if x >= 0 => "positive"
        case _ => "negative"

    val positive_lambda = (x: Int) => x match
        case x if x >= 0 => "positive"
        case _ => "negative"
    
    println(positive(0));
    println(positive(-10));

    println(positive_lambda(0));
    println(positive_lambda(-10));

    def neg(predicate: String => Boolean): String => Boolean = 
        (s) => !predicate(s)
    
    val neg_lambda = (predicate: String => Boolean) => (s: String) => !predicate(s)

    val predicate = (s: String) => s.length() % 2 == 0
    println(s"ciao -> ${predicate("ciao")}")
    println(s"ciao -> ${neg(predicate)("ciao")}")

    def genericNeg[T](predicate: T => Boolean): T => Boolean =
        (s) => !predicate(s)

object Task2b extends App:
    val p1: Int => Int => Int => Boolean = (x) => (y) => (z) => x <= y && y == z
    val p2 = (x: Int, y: Int, z: Int) => x <= y && y == z
    def p3(x: Int)(y: Int)(z: Int): Boolean =
        x <= y && y == z
    def p4(x: Int, y: Int, z: Int): Boolean =
        x <= y && y == z
    
    println(s"${p1(1)(2)(2)}, ${p2(1, 2, 3)}, ${p3(1)(2)(3)}, ${p4(1, 2, 2)}")

    def compose(f: Int => Int, g: Int => Int): Int => Int =
        (x) => f(g(x))
    
    def genericCompose[T, U, V](f: U => V, g: T => U): T => V =
        (x) => f(g(x))

