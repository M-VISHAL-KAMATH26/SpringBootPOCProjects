
package main

import (
	"fmt"
)

type Point struct {
	X int
	Y int 
}

func ScalePoint( point Point, factor int ) Point {

	return Point{ point.X * factor, point.Y * factor }
}

func AddPoint( point1 Point, point2 Point ) Point {

	return Point{ point1.X + point2.X, point1.Y + point2.Y }
}

func playWithPointType() {
	// Creating Point Type Objects
	// 	Using Declarative Syntax With Initialisation List
	point1 	:= Point{ 10, 20 }
	point2 	:= Point{ 100, 200 }
	point11 := Point{ 10, 20 }

	fmt.Println( "point1 : ", point1 )
	fmt.Println( "point2 : ", point2 )

	point3 := ScalePoint( point1, 5 )
	point4 := ScalePoint( point2, 5 )
	fmt.Println( "point3 = point1 * 5 : ", point3 )
	fmt.Println( "point4 = point2 * 5 : ", point4 )

	point5 := AddPoint( point1, point2 )
	fmt.Println( "point1 + point2 : ", point5 )

// HOME WORK
	fmt.Println("Points Equals :", point1.X == point11.X && point1.Y == point11.Y )	
	fmt.Println("Points Equals :", point1 == point11 )	
	fmt.Println("Points Equals :", point1 == point2 )	
}
// Binary Tree Node Definition
type tree struct {
	value int
	left *tree
	right *tree
}

// Adding A Node To Binary Search Tree
func add( t *tree, value int ) *tree {
	if t == nil {
		t = new( tree )
		t.value = value
		return t
	}

	if value < t.value {
		t.left = add( t.left, value )
	} else {
		t.right = add( t.right, value )
	}
	return t
}

func appendValues( values []int, t *tree ) [] int {
	if t != nil {
		values = appendValues( values, t.left )
		values = append( values, t.value )
		values = appendValues( values, t.right )
	}
	return values
}

func playWithTree() {
	data := []int{ 10, 20, 30, 9, 80, 15, 14, 16 }

	// Constructing Binary Search Tree
	var root *tree
	for _, value := range data {
		root = add( root, value )
	}

	fmt.Println( data )

	var values []int
	fmt.Println( appendValues( values, root ) )
}

type Circle struct {
	X, Y, Radius int
}

type Wheel struct {
	X, Y, Radius, Spokes int
}

func playWithCircleAndWheels() {
	var c Circle
	c.X = 10
	c.Y = 20
	c.Radius = 50

	fmt.Println("Circle : ", c)

	var w Wheel
	w.X = 11
	w.Y = 22
	w.Radius = 55
	w.Spokes = 24

	fmt.Println("Wheel : ", w)
}

type Point1 struct {
	X, Y int 
}

type Circle1 struct {
	Center Point1
	Radius int
}

type Wheel1 struct {
	Circle Circle1
	Spokes int
}

func playWithCircleAndWheelsAgain() {
	var w Wheel1
	w.Circle.Center.X = 11
	w.Circle.Center.Y = 22
	w.Circle.Radius = 55
	w.Spokes = 24
	fmt.Println("Wheel : ", w)

}

type Point2 struct {
	X, Y int 
}

type Circle2 struct {
	Point2  //Structure Embedding
	Radius int
}

type Wheel2 struct {
	Circle2 //Structure Embedding
	Spokes int
}

func playWithCircleAndWheelsOnceAgain() {
	var w Wheel2
	w.Circle2.Point2.X = 11
	w.Circle2.Point2.Y = 22
	w.Circle2.Radius = 55
	w.Spokes = 24
	fmt.Println("Wheel : ", w)

	w.X = 110
	w.Y = 220
	w.Radius = 550
	w.Spokes = 240
	fmt.Println("Wheel : ", w)

	var ww Wheel2
	ww = Wheel2{ Circle2{ Point2{ 88, 99 }, 100 }, 24 }
	fmt.Println("Wheel : ", ww)

	var www Wheel2
	www = Wheel2{ // Labelled Initialser
			Circle2 : Circle2{ 
				Point2 : Point2{ 
					X: 88, 
					Y: 99, 
				}, 
				Radius: 100,
			}, 
			Spokes: 24 ,
		  }
	fmt.Println("Wheel : ", www)
}

func main() {
	fmt.Println("\nFunction: playWithPointType")
	playWithPointType()

	fmt.Println("\nFunction: playWithTree")
	playWithTree()

	fmt.Println("\nFunction: playWithCircleAndWheels")
	playWithCircleAndWheels()

	fmt.Println("\nFunction: playWithCircleAndWheelsAgain")
	playWithCircleAndWheelsAgain()

	fmt.Println("\nFunction: playWithCircleAndWheelsOnceAgain")
	playWithCircleAndWheelsOnceAgain()

}


