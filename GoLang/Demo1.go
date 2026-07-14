package main

import (
	"fmt"
	"reflect"
	"os"
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

func playwithCommandLineArg(){
	var someString,seperator string
	seperator="\n"
	var args=os.Args

	for i:=0;i<len(args);i++{
		someString=someString+seperator+args[i];
	}
	fmt.Println(someString)
}

func playWithArray(){
	var a[4] int;
	fmt.Println(a)

	for i,value :=range(a){
		fmt.Println(i,value);
	}

	fmt.Println(a[0]);
		fmt.Println(a[1]);
	fmt.Println(a[len(a)-1])

	for _,value:=range(a){
		fmt.Println(value);
	}
	for index:=range(a){
		fmt.Println(index,a[index]);
	}
}


func playWithArrayAgain(){
	var a[5] int=[5]int{10,20,30,40,50}
	var b[5] int=[5]int{10,20,30}

	fmt.Printf("%T\n",a);
	fmt.Printf("%T\n",b);

	for index,value:=range a{
		fmt.Println(index,"----->",value);
	}

	for _,value:=range b{
		fmt.Println(value)
	}

}
func main(){
	fmt.Println("welcome to the code")
playwithCommandLineArg();
	res:=AddNumbers(4,5)
	var res2 float64=float64 (AddNumbers(5,5));
	fmt.Println(reflect.TypeOf(res2));
	fmt.Println(res2);
	fmt.Println(reflect.TypeOf(res))
	fmt.Printf("%T\n",res)
	fmt.Println("sum of two nubers is : ",res);
	ExperimentWithTypes();

	fmt.Println("-----------------------------")
	var f1 float32=13.55
	var f2 float64=44.44
	fmt.Println(f1,f2);
	var s1 string="Vishal";
	fmt.Println(s1);
	var b bool=true;
	fmt.Println(b);

	var c1 complex64;
	fmt.Println(c1);

	var c2 complex128;
	fmt.Println(c2)


	var c3 complex64=complex(33.4,55.4);
	fmt.Println(c3)
	var num int=33;
	fmt.Printf("%T\n",num)

	fmt.Println("-----------playing with array------------")
	playWithArray();

	fmt.Println("-------playing with arrayy again-------")
	playWithArrayAgain();
}