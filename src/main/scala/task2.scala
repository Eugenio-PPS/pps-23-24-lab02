object Task2 extends App:
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

