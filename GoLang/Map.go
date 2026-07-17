package main

import "fmt"
import "os"
import "bufio"

func removeDuplicates(){
	seen:=make(map[string] bool)
	input:=bufio.NewScanner(os.Stdin)

	for input.Scan(){
		line:=input.Text()
		if !seen[line]{
			seen[line]=true
			fmt.Println(line)
		}
	}
	if err:=input.Err():err!=nil{
		fmt.Printf(os.Stderr,"removeDuplicates:%v\n",err)
		os.Exit(1)
	}
	fmt.Println(seen)
}

func playWithClosures(){
	var x,y=40,20

	add:=func(x,y int) int {return x+y}
	sub:=func(x,y int) int {return x-y}

	result:=add(x,y)
	fmt.Println("Result: ",result)

	result:=sub(x,y)
	fmt.Println("Result: ",result)
}
func main() {
    // // 1. Using make() (Creates an empty, writable map)
    // employeeAges := make(map[string]int)
    // employeeAges["Alice"] = 30
    
    // // 2. Using a Map Literal (Declaring with initial values)
    // scores := map[string]int{
    //     "John": 95,
    //     "Alex": 88, // Trailing comma is mandatory here
    // }
    
    // fmt.Println(employeeAges, scores)


	m:=make(map[string] int)

	m["vishal"]=100
	m["delson"]=85
	m["narayan"]=85
	m["amog"]=89
	m["delson"]=99 //overrids if we add same key

	fmt.Println("student database: ",m)

	value:=m["delson"]
	fmt.Println("marks of delson: ",value)

	fmt.Println("the length of the student-marks database is ",len(m))

	//delete from the map with the help of the key
	delete(m,"delson");
	fmt.Println("student database after delson left the college : ",m)
	fmt.Println("the length of the student-marks database after delson left the college is ",len(m))

	val:=m["delson"];
	fmt.Println("marks of delson: ",val)

	//declarative syntax -- to create an map with initialization list
	facult:=map[string] int64{
		"ram mohan": 25000,
		"ramanand":45000,
		"saleem":20000,
	}
	fmt.Println("the faculty in the college are: ",facult)
		fmt.Println("number of faculty in the college are: ",len(facult))

facult["roshan singh"]=30000;
	fmt.Println("the faculty in the college after roshan joined are: ",facult)
		fmt.Println("number of faculty in the college after roshan joined are: ",len(facult))


		playWithClosures()
}