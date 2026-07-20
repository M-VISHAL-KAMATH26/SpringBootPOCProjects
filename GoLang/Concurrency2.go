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
func playWithChannels() {
	messages := make( chan string )
	var messageRead string
	go func() {
		messages <- "Ping"
		time.Sleep( time.Second * 1 )	
		messages <- "Pong"
		time.Sleep( time.Second * 1 )
		messages <- "Ting"
		time.Sleep( time.Second * 1 )
		messages <- "Tong"
		time.Sleep( time.Second * 1 )
		fmt.Println("Done: Closure Go Routine")
	}()

	// Reading From Channel messages
	messageRead = <- messages
	fmt.Println( messageRead )

	messageRead = <- messages
	fmt.Println( messageRead )

	messageRead = <- messages
	fmt.Println( messageRead )

	messageRead = <- messages
	fmt.Println( messageRead )

	fmt.Println("Done: playWithChannels")
}

//________________________________________________________________
//________________________________________________________________
//________________________________________________________________
//________________________________________________________________
//________________________________________________________________

func main() {
	// fmt.Println("\nFunction: playWithGoRoutines")
	// playWithGoRoutines()

	fmt.Println("\nFunction: playWithChannels")
	// playWithChannels()
	go playWithChannels()

	// fmt.Println("\nFunction: playWithSum")
	// playWithSum()

	// fmt.Println("\nFunction: playWithChannelWithReadWriteOnly")
	// playWithChannelWithReadWriteOnly()

	// fmt.Println("\nFunction: playWithWorkers")
	// playWithWorkers()

	// fmt.Println("\nFunction: playWithClosingChannel")
	// playWithClosingChannel()

	// fmt.Println("\nFunction: playWithFibonaccis")
	// playWithFibonaccis()

	// fmt.Println("\nFunction: playWithFibonaccisAgain")
	// playWithFibonaccisAgain()

	// fmt.Println("\nFunction: playWithTimeTick")
	// playWithTimeTick()

	// fmt.Println("\nFunction: playWithSafeCounter")
	// playWithSafeCounter()

	// fmt.Println("\nFunction: ")
	// fmt.Println("\nFunction: ")
	// fmt.Println("\nFunction: ")

	time.Sleep( time.Second * 2 )
	fmt.Println("Main Function: Done")
}


