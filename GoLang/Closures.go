package main

import "fmt"

func playWithClosures(){
	var x,y=40,20

	add:=func(x,y int) int {return x+y}
	sub:=func(x,y int) int {return x-y}

	result:=add(x,y)
	fmt.Println("Result: ",result)

	result:=sub(x,y)
	fmt.Println("Result: ",result)
}

func main(){

	playWithClosures();
}