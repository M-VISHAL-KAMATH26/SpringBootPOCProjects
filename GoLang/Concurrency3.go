package main

import (
	"fmt"
	"time"
)

func doSomething(from string) {
	for i := 0; i < 3; i++ {
		fmt.Println(from, ":", i)
		time.Sleep(2 * time.Second)
	}
}

func playWithGoRoutines() {
	fmt.Println(time.Now().Format(time.RFC850))

	go doSomething("Oye Hoyee!!!")
	go doSomething("Ye Dil Maange More!!!")

	go func(message string) {
		for i := 0; i < 3; i++ {
			fmt.Println(message, ":", i)
			time.Sleep(2 * time.Second)
		}
		fmt.Println("Done: Anonymous Go Routine")
	}("Balleee Balleee!!")

	fmt.Println(time.Now().Format(time.RFC850))
	fmt.Println("Done: playWithGoRoutines")
}

func playWithChannels() {
	messages := make(chan string)

	// Sender goroutine
	go func() {
		messages <- "Ping"
		time.Sleep(1 * time.Second)

		messages <- "Pong"
		time.Sleep(1 * time.Second)

		messages <- "Ting"
		time.Sleep(1 * time.Second)

		messages <- "Tong"
		time.Sleep(1 * time.Second)

		fmt.Println("Done: Sender Goroutine")
	}()

	// Receive messages
	messageRead := <-messages
	fmt.Println(messageRead)

	messageRead = <-messages
	fmt.Println(messageRead)

	messageRead = <-messages
	fmt.Println(messageRead)

	messageRead = <-messages
	fmt.Println(messageRead)

	fmt.Println("Done: playWithChannels")
}

func main() {

	fmt.Println("\nFunction: playWithChannels")
	playWithChannels()

	fmt.Println("Main Function: Done")
}