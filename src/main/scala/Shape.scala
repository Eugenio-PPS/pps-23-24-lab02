import scala.annotation.tailrec

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
    case Square(e) => Square(e * alpha)