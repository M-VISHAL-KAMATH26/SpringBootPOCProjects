package main

import "fmt"

func printArray(numbers [5]int){
	for index,_:=range numbers{
		fmt.Print(numbers[index]," ")
	}
	fmt.Println()
}

func changeArray(numbers * [5]int){
	for i,_:=range(numbers){
		numbers[i]=88;
	}
}

func playwithArraysPointers(){
var numbers [5]int=[5]int {10,20,30,40,50};

printArray(numbers);
changeArray(&numbers);
printArray(numbers);
}

func main(){
playwithArraysPointers();
}