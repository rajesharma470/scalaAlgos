
import Array._
import java.util._

object BinaryTreeIterator{

	def main(args: Array[String]) {
		val rightTree = Node(100,Some(Node(50, Some(Node(25)))), Some(Node(200, Some(Node(125)), Some(Node(350)))))
		val iterator = new Iterator(Some(rightTree))
		while(iterator.hasNext){
			val node = iterator.getNext
			node match{
				case Some(nodeVal) => print(s" ${nodeVal.value}, ")
				case _ => print("")
			}
		}	
	}
}

class Iterator{

	val stack = new Stack[Node]

	def this(root: Option[Node]){
		this

		def recursion(root:Option[Node]):Unit = {
			root match {
				case Some(node) => stack.push(node)
									recursion(node.left) 
				case None => Unit
			}
		}
		recursion(root)
	}

	def hasNext():Boolean = !stack.isEmpty
	def getNext() = {
		if(stack.isEmpty)
			None
		val curr = stack.pop
		var next = curr.right
		while(next != None){
			next match{
				case Some(node) => stack.push(node)
									next=node.left
				case None => print("")
			}
		}
		Some(curr)
	}
}
case class Node(value: Int, left: Option[Node]=None, right: Option[Node]=None)