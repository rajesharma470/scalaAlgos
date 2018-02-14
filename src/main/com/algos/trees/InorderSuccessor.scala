
import Array._

object InorderSuccessor{

	def main(args: Array[String]){
		val root = Node(100,Some(Node(50, Some(Node(25)))), Some(Node(200, Some(Node(125)), Some(Node(350)))))
		println(findSuccessor(Some(root), 50).get.value)
	}

	def findSuccessor(root:Option[Node], key:Int):Option[Node]={
		var successor = None:Option[Node];
		var rootNew = root
		while(rootNew != None){
			rootNew match {
				case Some(node) => if(key < node.value){
										rootNew = node.left
										successor = Some(node)
								   }else if(key > node.value){
								   		rootNew = node.right
								   }else {
								   		if(node.right != None){
										   	var newNode = node.right
										   	while(newNode.get.left != None)
										   		newNode = newNode.get.left
									   	}
									   	rootNew = None
								   }
				case None => 	rootNew = None
			}
		}
		successor
	}
}

case class Node(value:Int, left: Option[Node]=None, right: Option[Node]=None)