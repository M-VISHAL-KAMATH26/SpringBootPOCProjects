package main
import "fmt"

func playWithSlicesLengthAndCapacity(){
	s:=make([] string ,3)
	fmt.Printf("Type : %T\n",s);
	fmt.Printf("%d is the length and %d is the capacity :\n",len(s),cap(s))
	fmt.Println("Slice ",s);

	s[0]="Vishal"
	s[1]="rahul"
	s[2]="shukla"

	// s[3]="param"  runtime error index out of bounds
	s=append(s,"guru")
	s=append(s,"delson")

	fmt.Println("Slice ",s);
	fmt.Printf("%d is the length and %d is the capacity :\n",len(s),cap(s))

fmt.Println("-----------------------")
	someCopy:=s
	fmt.Println("s:",s)
	fmt.Println("somcpy:",someCopy)


s[0]="mahatma gandhi"
fmt.Println("s:",s)
	fmt.Println("somcpy:",someCopy)

fmt.Println("--------deep copy-----------")
	dd:=make([] string,len(s))
	copy(dd,s)
	fmt.Println(dd);
	fmt.Println(s);

	s[0]="Krishna kumar"
	fmt.Println(dd);
	fmt.Println(s);
}

func playWithArraysAndSlices(){
	numbers:=[...]int{10,20,30,40,50,60,70,80,90,99}

	
	nums:=numbers
		fmt.Println(nums);

		numbers[0]=777
		 numbers[1]=888
			fmt.Println(numbers);




}
func appendInt( x []int, y int ) []int {
	var z []int

	zlen := len( x ) + 1
	if zlen <= cap(x) {
		z = x[ : zlen ]
	} else {
		zcap := zlen
		if zcap < 2 * len( x ) {
			zcap = 2 * len( x )
		}

		z = make( []int, zlen, zcap )
		copy( z, x )
	}

	z[ len( x )] = y
	return z
}

func playWithAppendInt() {
	var x, y []int

	for i := 0 ; i < 10 ; i++ {
		y = appendInt( x, i )
		fmt.Printf(" %d Capacity = %d \t %v \n", i, cap(y), y )
		x = y
	}
}

func summation(numbers ...int) int{
	total:=0;
	for _,value:=range numbers{
		total=total+value;
	}
	return total;
}


func playWithVariableArguments(){
	res1:=summation(1,2,3,4,5,6,7);
	fmt.Println(res1);

	res2:=summation(10,20,30,40,50)
	fmt.Println(res2);
	ListOfNumbers := []int{7, 7, 7, 7, 7}

res3 := summation(ListOfNumbers...)
fmt.Println(res3)
}


func appendSlice( x []int, y ...int ) [] int {
	var z []int

	zlen := len(x) + len(y)

	if zlen <= cap(x) {
		z = x[ : zlen ]
	} else {
		zcap := zlen
		if zcap < 2 * len(x) {
			zcap = 2 * len(x)
		}
		z = make( []int, zlen, zcap )
		copy(z, x)
	}
	copy( z[ len(x) : ], y )
	return z
}

func playWithAppendSlices() {
	var x, y []int

	for i := 0 ; i < 10 ; i++ {
		y = appendSlice(x, i)
		fmt.Printf( " %d Capacity=%d \t %v \n", i, cap(y), y )
		x = y
	}
	fmt.Println( x )

	x = appendSlice(x, 10, 20, 30)
	fmt.Println( x )

	x = appendSlice(x, 11, 22, 33, 44, 55, 66)
	fmt.Println( x )

	numbers := []int{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
	x = appendSlice(x, numbers...)
	fmt.Println( x )	
}
func main(){
// playWithSlicesLengthAndCapacity()
playWithVariableArguments()
// playWithArraysAndSlices()
fmt.Println("---------------------------")
playWithAppendSlices()

}