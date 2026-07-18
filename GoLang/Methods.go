
package main

import (
	"fmt"
	"math"
)


type Point struct {
	X, Y float64
}

// Function Taking Two Point Type Arguments
func Distance( p Point, q Point ) float64 {
	return math.Hypot( q.X - p.X , q.Y - p.Y )
}

func ( this Point ) Distance( q Point ) float64 {fmt.println("\n Function:  ",)	
	fmt.Println("Point: Distance Method Called...")
	return math.Hypot( q.X - this.X , q.Y - this.Y )
}

func playWithFunctionsAndMethods() {
	var point1 = Point{ 10.0, 20.0 	 }
	var point2 = Point{ 100.0, 200.0 }

	distance := Distance( point1, point2 )
	fmt.Printf("\nDistance Between %v and %v : %v", point1, point2, distance)

	distance = point1.Distance( point2 )
	fmt.Printf("\nDistance Between %v and %v : %v", point1, point2, distance)	
}


//________________________________________________________________
//________________________________________________________________
//________________________________________________________________
//________________________________________________________________
//________________________________________________________________

func main() {
	fmt.Println("\nFunction: playWithFunctionsAndMethods")
	playWithFunctionsAndMethods()

	// fmt.Println("\nFunction: ")
	// fmt.Println("\nFunction: ")
	// fmt.Println("\nFunction: ")
	// fmt.Println("\nFunction: ")	
}



