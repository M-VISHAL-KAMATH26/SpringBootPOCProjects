package main
import "fmt"


func firstFunction() 	{ fmt.Println("First Function Called...") 	}
func secondFunction() 	{ fmt.Println("Second Function Called...") 	}
func thirdFunction() 	{ fmt.Println("Third Function Called...")	}

func playWithDeferFunctions() { // Enclosing Function
	// defer Keyword Delays Execution Of Statement
	//		Till End Of Enclosing Function
	defer firstFunction()
	secondFunction()
	defer thirdFunction()
// defer Statements Are Called Just 
//		Before Return Out Of Enclosing Functions
//		Multiple Defers Are Called Last In First Out Order
}	


func someFunction() ( some int ) {
	defer func() { some++ }()
	return 1
}

func playWithDeferFunctionsAgain() {
	result := someFunction()
	fmt.Println("Result : ", result)
}

func main(){

	fmt.Println("hello... welcome to the main function")
	playWithDeferFunctions()

	fmt.Println("Defer functions again ...")
	playWithDeferFunctionsAgain()
}