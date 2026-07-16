package main
import "fmt"
func playWithArraysAndSlices(){
	a:=[10]int{10,20,30,40,50,60,70,80,90,99}

	fmt.Printf("%d\n",a);
	fmt.Printf("%d\n",len(a));
	fmt.Printf("%T\n",a);

	some1:=a[0:5]
	fmt.Printf("%d\n",some1)

	some2:=some1[0:3]
	fmt.Printf("%d\n",some2)

	fmt.Printf("%T\n",some2);

	some1[2]=777;

	fmt.Printf("%d\n",a)
}
func reverse(s []int){
	for i,j:=0,len(s)-1;i<j;i,j=i+1,j-1 {
		s[i],s[j]=s[j],s[i]
	}
}
//function taking 2 slices as the argumnts
func printCommon(month1 []string,month2 []string){
	for _,mon1Val:=range month1{
		for _,mon2Val:=range month2{
			if(mon1Val==mon2Val){
				fmt.Printf("%s and %s are common \n",mon1Val,mon2Val)
			}
		}
	}
}

func slicesEqual(month1 []string,month2 []string) bool{
	if len(month1)!=len(month2){
		fmt.Println("Slices are not equal")
		return false;
	}
	for index:=range month1{
		if month1[index]!=month2[index]{
					fmt.Println("Slices are not equal")

		return false;
	}
}
fmt.Println("slices are equal")
return true;
}
func playWithSlicesMore(){
	months:=[...]string{"jan","feb","mar","apr","may","june","july","agust"}

	months1:=months[0:6]
	months2:=months[5:7]

printCommon(months1,months2);

slice1:=months[0:5]
slice2:=months[0:5]

res :=slicesEqual(slice1,slice2)
fmt.Println(res)
}
func playWithArraysAndSlicesAgain(){

	a:=[...]int{10,20,30,40,50,60,70,80,90,99}
		fmt.Printf("%d\n",a);

		some1 := a[ 0 : 4 ]
	fmt.Println("Array a: ", a )	
	reverse( some1 )
	fmt.Println("Array a: ", a )

	some2:=a[ : ]
	fmt.Println("Array a: ",a)
	reverse(some2)
	fmt.Println("Reversed array ",a)

}


func main(){
fmt.Println("hello")

playWithArraysAndSlices()
fmt.Println("-----------------------------------")
playWithArraysAndSlicesAgain()
fmt.Println("-----------------------------------")
playWithSlicesMore()
}