object Hello extends App:
    println("Hello, World!")
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

object Task3:
    @annotation.tailrec
    def gcd(a: Int, b: Int): Int = b match
        case _ if a == 0 && b != 0 => b
        case _ if b != 0 => gcd(b, a % b)
        case _ => aimport scala.annotation.tailrec

enum Shape:
  case Rectangle(w: Double, h: Double)
  case Circle(radius: Double)
  case Square(edge: Double)

object Shape:
  @tailrec
  def perimeterOf(s: Shape): Double = s match
    case Rectangle(w, h) => 2 * (w + h)
    case Circle(radius) => 2 * Math.PI * radius
    case Square(e) => perimeterOf(Rectangle(e, e))

  def scale(s: Shape, alpha: Double): Shape = s match
    case Rectangle(w, h) => Rectangle(w * alpha, h * alpha)
    case Circle(r) => Circle(r * alpha)
    case Square(e) => Square(e * alpha)package task5


object Optionals:
  /**
   * Optional is a type that represents a value that may or may not be present.
   * Similar to Optional in Java but using the ADT concept.
   * Therefore, an Optional is a sum type with two cases: Maybe and Empty.
   * Maybe contains the value, and Empty represents the absence of a value.
   *
   * @tparam A
   */
  enum Optional[+A]:
    case Maybe(value: A)
    case Empty()

  object Optional:
    /**
     * isEmpty returns true if the optional is Empty, false otherwise.
     * Example:
     *
     * isEmpty(Empty()) == true
     * isEmpty(Maybe(1)) == false
     *
     * @param optional the optional to check
     * @tparam A the type of the optional
     * @return true if the optional is Empty, false otherwise
     */
    def isEmpty[A](optional: Optional[A]): Boolean = optional match
      case Empty() => true
      case _ => false

    /**
     *
     * getOrElse returns the value of the optional if it is Maybe, otherwise it returns the default value.
     * Example:
     * orElse(Maybe(1), 0) == 1
     * orElse(Empty(), 0) == 0
     *
     * @param optional the optional to get the value from
     * @param default the default value to return if the optional is Empty
     * @tparam A the type of the optional
     * @tparam B the type of the default value
     * @return the value of the optional if it is Maybe, otherwise the default value
     */
    def orElse[A, B >: A](optional: Optional[A], default: B): B = optional match
      case Maybe(value) => value
      case Empty() => default

    /**
     * map applies the function f to the value of the optional if it is Maybe, otherwise it returns Empty.
     * Example:
     *
     * map(Maybe(1), (x: Int) => x + 1) == Maybe(2)
     * map(Empty(), (x: Int) => x + 1) == Empty()
     *
     *
     * @param optional the optional to apply the function to
     * @param f the function to apply to the value of the optional
     * @tparam A the type of the optional
     * @tparam B the type of the result of the function
     * @return the result of applying the function to the value of the optional if it is Maybe, otherwise Empty
     */
    def map[A, B](optional: Optional[A], f: A => B): Optional[B] = optional match
      case Maybe(x) => Maybe(f(x))
      case _        => Empty()


    def filter[A](optional: Optional[A], f: A => Boolean): Optional[A] = optional match
      case Maybe(x) if f(x) => Maybe(x)
      case _                => Empty()
