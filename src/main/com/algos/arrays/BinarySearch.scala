
import Array._

object BinarySearch{

	println("Binary Search");

	def main(args: Array[String]){
		val inputArray = Array(0, 1, 2, 3, 5, 6, 7, 8, 9)
		println( binarySearchRec(4, 0, inputArray.length, inputArray))
	}

	def binarySearchRec(searchKey: Int, low: Int, high: Int, arrayInt: Array[Int]): Int = {
		if(low > high)
			 return -1

		val mid = low + (high - low)/2
	
		if( arrayInt(mid) == searchKey)
			mid
		else if (arrayInt(mid) < searchKey)
			binarySearchRec(searchKey, mid+1, high, arrayInt)
		else
			binarySearchRec(searchKey, low, mid-1, arrayInt)
	}
	
}