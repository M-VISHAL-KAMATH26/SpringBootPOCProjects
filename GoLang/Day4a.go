
package main

import (
	"fmt"
	"math"
)

//________________________________________________________________

// https://en.wikipedia.org/wiki/Duck_typing
// Duck typing is an application of the duck test—
// 		"If it walks like a duck and it quacks like a duck, then it must be a duck"

//________________________________________________________________

// WHAT TO DO!
type Geometry interface {
	area() float64
	perimeter() float64
}

type Rectangle struct {
	width, height float64	
}

type Circle struct {
	radius float64
}

//________________________________________________________________
// Member Function/Method For Type Rectangle
func ( r Rectangle ) area() float64 {
	return r.width * r.height
}

func ( r Rectangle ) perimeter() float64 {
	return ( r.width + r.height ) * 2
}

func ( r Rectangle ) center() (float64, float64) {
	return 0.0, 0.0 
}

//________________________________________________________________
// Member Function/Method For Type Circle
func ( c Circle ) area() float64 {
	return math.Pi * c.radius * c.radius
}

func ( c Circle ) perimeter() float64 {
	return 2 * math.Pi * c.radius
}

//________________________________________________________________

// func calculateGeometryC( c Circle ) {
func calculateGeometryOfCircle( c Circle ) {
	fmt.Println("Circle : ", c )
	fmt.Println("Circle Area: ", c.area() )
	fmt.Println("Circle Perimeter: ", c.perimeter() )	
}

// func calculateGeometry( r Rectangle ) {
func calculateGeometryOfRectangle( r Rectangle ) {
	fmt.Println("Rectangle : ", r )
	fmt.Println("Rectangle Area: ", r.area() )
	fmt.Println("Rectangle Perimeter: ", r.perimeter() )	
}

//________________________________________________________________
// Polymorphic Function
//		Using Mechanism: Interface Type Arguemnts
func calculateGeometry( g Geometry ) {
	fmt.Println("Geometry : ", g )
	fmt.Println("Geometry Area: ", g.area() )
	fmt.Println("Geometry Perimeter: ", g.perimeter() )	
}

//________________________________________________________________

type Square struct {
	side float64	
}

func ( s Square ) area() float64 {
	return s.side * s.side
}

func ( s Square ) perimeter() float64 {
	return 4 * s.side
}

//________________________________________________________________

func playWithGeometry() {
	c := Circle{ radius : 10 }
	calculateGeometryOfCircle( c )

	r := Rectangle{ width : 10, height : 20 }
	calculateGeometryOfRectangle( r )

	calculateGeometry( c )
	calculateGeometry( r )

	s := Square{ side : 10 }
	calculateGeometry( s )	
}

// calculateGeometry redeclared in this block
// 	./GoInterfaces.go:47:6: other declaration of calculateGeometry
// ./GoInterfaces.go:64:21: cannot use r (variable of type Rectangle) 
//	as Circle value in argument to calculateGeometry

//________________________________________________________________

// type Writer interface {
// 		Write(p []byte) (n int, err error)
// }
// Writer is the interface that wraps the basic Write method.

// type Reader interface {
// 		Read(p []byte) (n int, err error)
// }
// Reader is the interface that wraps the basic Read method.


// Writer is the interface that wraps the basic Write method.
//
// Write writes len(p) bytes from p to the underlying data stream.
// It returns the number of bytes written from p (0 <= n <= len(p))
// and any error encountered that caused the write to stop early.
// Write must return a non-nil error if it returns n < len(p).
// Write must not modify the slice data, even temporarily.
//
// Implementations must not retain p.
// type Writer interface {
// 		Write(p []byte) (n int, err error)
// }

// Closer is the interface that wraps the basic Close method.
//
// The behavior of Close after the first call is undefined.
// Specific implementations may document their own behavior.
// type Closer interface {
// 		Close() error
// }

// Seeker is the interface that wraps the basic Seek method.
//
// Seek sets the offset for the next Read or Write to offset,
// interpreted according to whence:
// [SeekStart] means relative to the start of the file,
// [SeekCurrent] means relative to the current offset, and
// [SeekEnd] means relative to the end
// (for example, offset = -2 specifies the penultimate byte of the file).
// Seek returns the new offset relative to the start of the
// file or an error, if any.
//
// Seeking to an offset before the start of the file is an error.
// Seeking to any positive offset may be allowed, but if the new offset exceeds
// the size of the underlying object the behavior of subsequent I/O operations
// is implementation-dependent.
// type Seeker interface {
// 		Seek(offset int64, whence int) (int64, error)
// }


//________________________________________________________________
//________________________________________________________________
//________________________________________________________________
//________________________________________________________________

func main() {
	fmt.Println("\nFunction: playWithGeometry")
	playWithGeometry()

	// fmt.Println("\nFunction: ")
	// fmt.Println("\nFunction: ")
	// fmt.Println("\nFunction: ")
	// fmt.Println("\nFunction: ")
	// fmt.Println("\nFunction: ")
	// fmt.Println("\nFunction: ")
}



