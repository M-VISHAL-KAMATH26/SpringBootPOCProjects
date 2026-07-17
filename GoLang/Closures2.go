package main
import "fmt"
import "math"

func division( dividend int, divisor int) (int, int) {
	if divisor != 0 {
		quotient 	:= dividend / divisor
		remainder 	:= dividend % divisor

		return quotient, remainder
	} else {
		fmt.Println("Error: Division By Zero!")
	}
	return 0, -1
}

func divisionAgain( dividend, divisor int) (int, int) {
	if divisor != 0 {
		quotient 	:= dividend / divisor
		remainder 	:= dividend % divisor

		return quotient, remainder
	} else {
		fmt.Println("Error: Division By Zero!")
	}
	return 0, -1
}

func divisionOnceAgain( dividend, divisor int) (quotient, remainder int) {
	if divisor != 0 {
		quotient 	:= dividend / divisor
		remainder 	:= dividend % divisor

		return quotient, remainder
	} else {
		fmt.Println("Error: Division By Zero!")
	}
	return 0, -1
}

func playWithDivsion() {
	q, r := division( 10, 3 )
	fmt.Printf("\nQuotient: %d Remainder: %d", q, r )

	qq, rr := divisionAgain( 10, 3 )
	fmt.Printf("\nQuotient: %d Remainder: %d", qq, rr )

	qqq, rrr := divisionOnceAgain( 10, 3 )
	fmt.Printf("\nQuotient: %d Remainder: %d", qqq, rrr )

}

func playWithClosures() {
	var x, y = 40, 20
	var result = 0
	// 		Anonmous Functions
	add := func( x, y int ) int { return x + y }
	sub := func( x, y int ) int { return x - y }

	result = add( x, y )
	fmt.Println("Result: ", result)

	result = sub( x, y )
	fmt.Println("Result: ", result)
}

func sum( x, y int ) int { return x + y }
func sub( x, y int ) int { return x - y }

// Higher Order Function
//		Function Which Takes And/Or Return Functions

// Polymorphic Function
//		Using Mechanism By Passing Function/Behaviour To Function/Behaviour
func calculator( x, y int, operation func(int, int)int ) int {
	return operation(x, y)
}

func playWithCalculator() {
	var a, b = 40, 10
	var result = 0

	result = calculator( a, b, sum )
	fmt.Println("Result :", result)

	result = calculator( a, b, sub )
	fmt.Println("Result :", result)

	// Closures/Lambdas
	// 		Anonmous Functions
	addClosure := func( x, y int ) int { return x + y }
	subClosure := func( x, y int ) int { return x - y }

	result = calculator( a, b, addClosure )
	fmt.Println("Result :", result)

	result = calculator( a, b, subClosure )
	fmt.Println("Result :", result)

	result = calculator( a, b, func( x, y int ) int { return x + y } )
	fmt.Println("Result :", result)

	result = calculator( a, b, func( x, y int ) int { return x - y } )
	fmt.Println("Result :", result)

	result = calculator( a, b, func( x, y int ) int { 
		return x + y 
	})
	
	fmt.Println("Result :", result)

	result = calculator( a, b, func( x, y int ) int { 
		return x - y 
	})
	fmt.Println("Result :", result)
}

func doSomething( x int, y int ) int {
	return x + y + 10
}

func playWithFunctionTypes() {
	a, b := 100, 200
	result := 0

	// var something int
	var something func(int, int) int
	// cannot use doSomething 
	// (value of type func(x int, y int) int) 
	// as int value in assignment
	something = doSomething
	result = something(a, b)
	fmt.Println("Result : ", result)

	// somethingAgain := calculator
	// var somethingAgain int
	// cannot use calculator 
	//	(value of type func(x int, y int, operation func(int, int) int) int) 
	//	as int value in assignment
	var somethingAgain func(int, int, func(int, int) int ) int
	somethingAgain = calculator

	result = somethingAgain(a, b, sum)
	fmt.Println("Result : ", result)
}

// Higher Order Function
//		Function Which Returns Function
func Sphere() func(radius float64) float64 {
	volumeClosure := func( radius float64 ) float64 {
		volume := 4 /3 * math.Pi * radius * radius * radius
		return volume
	}

	return volumeClosure
}

func playWithHigherOrderFunctionsAgain() {
	// What Is The Type Of something
	//	func( float64 ) float64
	something := Sphere()
	//								  Invoking Function				
	fmt.Println("Volume Of Sphere: ", something( 5 ) )
	fmt.Println("Volume Of Sphere: ", something( 10 ) )

	// What Is The Type Of something
	// func() func( float64 ) float64
	somethingAgain := Sphere
	fmt.Println("\nValue Of somethingAgain: ", somethingAgain )
	fmt.Printf("\nType Of somethingAgain: %T", somethingAgain)

	fmt.Println("\nValue Of Sphere: ", Sphere( ) )
	fmt.Printf("\nType Of Sphere: %T", Sphere( ) )

	fmt.Println("\nValue Of Sphere: ", Sphere )
	fmt.Printf("\nType Of Sphere: %T", Sphere )
}

func main() {
	fmt.Println("\n\nFunction: playWithDivsion")
	playWithDivsion()

	fmt.Println("\n\nFunction: playWithClosures")
	playWithClosures()
	
	fmt.Println("\n\nFunction: playWithCalculator")
	playWithCalculator()

}


