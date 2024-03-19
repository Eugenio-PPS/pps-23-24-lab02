import org.junit.*
import org.junit.Assert.*

class Task4:
  @Test def calcRectanglePerimeter(): Unit =
    val r: Shape = Shape.Rectangle(1, 1)
    assertEquals(4, Shape.perimeterOf(r), 1e-3)

  @Test def scaleRectangle(): Unit =
    val r1: Shape = Shape.Rectangle(2, 3)
    val r2 = Shape.scale(r1, 2)
    assertEquals(Shape.Rectangle(4, 6), r2)

  @Test def calcCirclePerimeter(): Unit =
    val c: Shape = Shape.Circle(1)
    assertEquals(2 * Math.PI, Shape.perimeterOf(c), 1e-3)

  @Test def scaleCircle(): Unit =
    val c1: Shape = Shape.Circle(1)
    val c2 = Shape.scale(c1, 2)
    assertEquals(Shape.Circle(2), c2)

  @Test def calcSquarePerimeter(): Unit =
    val s: Shape = Shape.Square(1)
    assertEquals(4, Shape.perimeterOf(s), 1e-3)

  @Test def scaleSquare(): Unit =
    val s1: Shape = Shape.Square(1)
    val s2 = Shape.scale(s1, 2)
    assertEquals(Shape.Square(2), s2)