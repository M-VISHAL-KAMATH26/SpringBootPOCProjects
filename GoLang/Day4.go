
package main

import (
	"fmt"
	"math"
	"image/color"
	"bytes"
)

//________________________________________________________________

type Point struct {
	X, Y float64
}

// Function Taking Two Point Type Arguments
func Distance( p Point, q Point ) float64 {
	return math.Hypot( q.X - p.X , q.Y - p.Y )
}

// Method Taking Two Point Type Arguments
//		Memeber Method/Function Of Type Point
//		Reciever Type Is Point
func ( this Point ) Distance( q Point ) float64 {
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

// Receiver Type Point
// ScaleBy Is Member Function On Type Point

//	  Receiver Type
//	  point is Receiver Object Of Receiver Type
func ( point Point ) ScaleByDesign0( factor float64 ) {
	point.X = point.X * factor
	point.Y = point.Y * factor
}

// Reciever Object is Pass By Value
func ( point Point ) ScaleByDesign1( factor float64 )  Point {
	return Point{ point.X * factor, point.Y * factor }
}

// Reciever Object is Pass By Value
//		But It will Not Create Side Effects
// func ( point Point ) ScaleByDesign2( factor float64 ) {
// 	point.X = point.X * factor
// 	point.Y = point.Y * factor
// }

// Reciever Object is Pass By Reference
func ( point * Point ) ScaleByDesign2( factor float64 ) {
	point.X = point.X * factor
	point.Y = point.Y * factor
}

func playWithScalingPoint() {
	var point1 = Point{ 10.0, 20.0 	}
	var point2 = Point{ 30.0, 40.0 }

	point1.ScaleByDesign0( 5.0 ) 
	point2.ScaleByDesign0( 10.0 ) 

	fmt.Println("Scaled Point: ", point1 )
	fmt.Println("Scaled Point: ", point2 )	

	var point10 = Point{ 10.0, 20.0 }
	var point20 = Point{ 30.0, 40.0 }

	point10 = point10.ScaleByDesign1( 5.0 ) 
	point20 = point20.ScaleByDesign1( 10.0 ) 

	fmt.Println("Scaled Point: ", point10 )
	fmt.Println("Scaled Point: ", point20 )	

	var point11 = Point{ 10.0, 20.0 }
	var point21 = Point{ 30.0, 40.0 }

	point11.ScaleByDesign2( 5.0 ) 
	point21.ScaleByDesign2( 10.0 ) 

	fmt.Println("Scaled Point: ", point11 )
	fmt.Println("Scaled Point: ", point21 )	
}

// Function: playWithScalingPoint
// Scaled Point:  {10 20}
// Scaled Point:  {30 40}

//________________________________________________________________

type Path []Point

func (path Path) Distance() float64 {
	totalDistance := 0.0
	for i := range path {
		if i > 0 {
			totalDistance += path[ i - 1 ].Distance( path[ i ] )
		}
	}
	return totalDistance
}

func playWithMethods() {
	var point1 = Point{ 10.0, 20.0 	 }
	var point2 = Point{ 30.0, 40.0 }

	var path Path = Path { point1, point2, { 50.0, 60.0 }, { 70.0, 80.0 } }
	distance := path.Distance()
	fmt.Println("Distance Total: ", distance)	
}

//________________________________________________________________
// import	"image/color"

type ColoredPoint struct {
	Point 			// Embbeded Type
	Color color.RGBA
}

func ( this ColoredPoint ) Distance( q ColoredPoint ) float64 {
	fmt.Println("ColoredPoint: Distance Method Called...")
	return math.Hypot( q.X - this.X , q.Y - this.Y )
}

func playWithColoredPointMethods() {
	red 	:= color.RGBA{ 255, 0, 0, 255 }
	green 	:= color.RGBA{ 0, 255, 0, 255 }

	var cpoint1 = ColoredPoint{ Point{ 10, 20}, red  }
	var cpoint2 = ColoredPoint{ Point{ 0 , 0 }, green }

	distance1 := cpoint1.Distance( cpoint2 )
	// distance2 := cpoint1.Distance( cpoint2.Point )

	fmt.Println("Distance Between Colored Points: ", distance1)
	// fmt.Println("Distance Between Colored Points: ", distance2)
}


// Wen Can Call Methods Of The Embedded Type Point field Uing A
// Reciever Type ColoredPoint, even though Colored Point has not
// declared method

//________________________________________________________________
// HOME WORK
// HOME WORK
// HOME WORK

// An IntSet is a set of small non-negative integers.
// 		Its zero value represents the empty set.
type IntSet struct {
	words []uint64
}

// Has reports whether the set contains the non-negative value x.
func (s *IntSet) Has(x int) bool {
	word, bit := x/64, uint(x%64)
	return word < len(s.words) && s.words[word]&(1<<bit) != 0
}

// Add adds the non-negative value x to the set.
func (s *IntSet) Add(x int) {
	word, bit := x/64, uint(x%64)
	for word >= len(s.words) {
		s.words = append(s.words, 0)
	}
	s.words[word] |= 1 << bit
}

// UnionWith sets s to the union of s and t.
func (s *IntSet) UnionWith(t *IntSet) {
	for i, tword := range t.words {
		if i < len(s.words) {
			s.words[i] |= tword
		} else {
			s.words = append(s.words, tword)
		}
	}
}

// String returns the set as a string of the form "{1 2 3}".
func (s *IntSet) String() string {
	var buf bytes.Buffer
	buf.WriteByte('{')
	for i, word := range s.words {
		if word == 0 {
			continue
		}
		for j := 0; j < 64; j++ {
			if word&(1<<uint(j)) != 0 {
				if buf.Len() > len("{") {
					buf.WriteByte(' ')
				}
				fmt.Fprintf(&buf, "%d", 64*i+j)
			}
		}
	}
	buf.WriteByte('}')
	return buf.String()
}

func playWithIntSet() {
	var x, y IntSet
	x.Add(1)
	x.Add(144)
	x.Add(9)
	fmt.Println(x.String()) // "{1 9 144}"

	y.Add(9)
	y.Add(42)
	fmt.Println(y.String()) // "{9 42}"

	x.UnionWith(&y)
	fmt.Println(x.String()) // "{1 9 42 144}"

	fmt.Println(x.Has(9), x.Has(123)) // "true false"
}

func playWithIntSetAgain() {
	var x IntSet
	x.Add(1)
	x.Add(144)
	x.Add(9)
	x.Add(42)

	fmt.Println( &x )         // "{1 9 42 144}"
	fmt.Println( x.String() ) // "{1 9 42 144}"
	fmt.Println(x)          // "{[4398046511618 0 65536]}"
}


func main() {
	fmt.Println("\nFunction: playWithFunctionsAndMethods")
	playWithFunctionsAndMethods()

	fmt.Println("\nFunction: playWithScalingPoint")
	playWithScalingPoint()

	fmt.Println("\nFunction: playWithMethods")
	playWithMethods()

	fmt.Println("\nFunction: playWithColoredPointMethods")
	playWithColoredPointMethods()

	fmt.Println("\nFunction: playWithIntSet")
	playWithIntSet()

	fmt.Println("\nFunction: playWithIntSetAgain")
	playWithIntSetAgain()

}
