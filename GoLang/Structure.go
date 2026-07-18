
package main

import (
	"fmt"
)

// Creating Point Type
//		Having Two Members X and Y Of Type int
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
func main() {
	fmt.Println("\nFunction: playWithPointType")
	playWithPointType()
	fmt.Println("--------------------------")
	playWithTree()
}


