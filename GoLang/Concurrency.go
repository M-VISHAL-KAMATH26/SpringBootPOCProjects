package main
import (
	"fmt"
	"time"
	// "sync"
)
func doSomething( from string ) {
	for i := 0 ; i < 3 ; i++ {
		fmt.Println( from, " : ", i )
		time.Sleep( time.Second * 2 )
	}
}
func playWithGoRoutines() {
	fmt.Println( time.Now().Format( time.RFC850 ) )
	go doSomething("Oye Hoyee!!!")  			// Non Blocking Function Call
	go doSomething("Ye Dil Maange More!!!") 	// Non Blocking Function Call
	go func( message string ) { // Non Blocking Function Call
		for i := 0 ; i < 3 ; i++ {
			fmt.Println( message, " : ", i )
			time.Sleep( time.Second * 2 )
		}
		time.Sleep( time.Second * 3 )
	}("Balleee Balleee!!")
	fmt.Println( time.Now().Format( time.RFC850 ) )
	fmt.Println("Done: playWithGoRoutines")
}
func main() {
	fmt.Println("\nFunction: playWithGoRoutines")
	playWithGoRoutines()
	time.Sleep( time.Second * 5 )
}

