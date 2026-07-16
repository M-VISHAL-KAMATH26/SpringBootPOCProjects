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

func main(){
playWithSlicesLengthAndCapacity()

// playWithArraysAndSlices()

}