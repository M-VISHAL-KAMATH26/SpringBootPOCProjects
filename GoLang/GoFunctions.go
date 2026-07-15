package main

import "fmt"

func division(dividend ,divisor int)(int,int){
	if divisor!=0{
		quoteint:=dividend/divisor
		remainder :=dividend%divisor
		return quoteint,remainder
	}else{
		fmt.Println("error:division by  zero")
		return 0,-1
	}
}

func main()  {

	qu,remainder:=division(10,7)
	fmt.Println(qu,remainder)
	qu2,rem2:=division(19,0)
	fmt.Println(qu2,rem2)
	
}