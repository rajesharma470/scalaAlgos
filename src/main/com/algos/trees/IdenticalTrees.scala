
import Array._

object IdenticalTrees{

	def main(args :Array[String]){
		val rightTree = Node(100,Some(Node(50, Some(Node(25)))), Some(Node(200, Some(Node(125)), Some(Node(350)))))
		val leftTree =  Node(100,Some(Node(50, Some(Node(25)))), Some(Node(200, Some(Node(125)), Some(Node(350)))))

		println(identicalTree(Some(rightTree), Some(leftTree)))
	}

	def identicalTree(rightTree: Option[Node], leftTree: Option[Node]):Boolean = {
		(rightTree, leftTree) match {
			case (Some(right), Some(left)) => (right.value == left.value) && identicalTree(right.left, left.left) && identicalTree(right.right, left.right)
			case (None, None) => true
			case _ => false
		}
	}
}


case class Node(value:Int, left: Option[Node]=None, right:Option[Node]=None)