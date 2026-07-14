package main

import (
	"fmt"
	"reflect"
)

type Celcius float64
type Farhenheit float64


func AddNumbers(a int,b int) int{
	 result:=a+b 
	return result

}
func ExperimentWithTypes(){
	var celciusValue Celcius =100.55;
	var  farhenheit Farhenheit=20.44;

	const (
		Apples=20
		bananas=70
		name="Vishal"
	)
	var sum=float64(celciusValue)+float64(farhenheit);

	var sumCel=celciusValue+ Celcius(farhenheit)

	fmt.Println(Apples,bananas,name)
	//below one ins invalid and type mismatch -strongly typed
	// var sum=celciusValue+farhenheit
	fmt.Println(sum);
	fmt.Println("converting the farhen to celcius explicitly-->",sumCel)
}


func main(){
	fmt.Println("welcome to the code")

	res:=AddNumbers(4,5)
	var res2 float64=float64 (AddNumbers(5,5));
	fmt.Println(reflect.TypeOf(res2));
	fmt.Println(res2);
	fmt.Println(reflect.TypeOf(res))
	fmt.Printf("%T\n",res)
	fmt.Println("sum of two nubers is : ",res);
	ExperimentWithTypes();
}