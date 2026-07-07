const people=[
    {name:"Vishal",age:22,position:"developer"},
    {name:"Vishal",age:25,postition:"HR"},
    {name:"delson",age:23,position:"tester"},
    {name:"preya",age:25,position:"manager"}
]

const peoplesAge=people.map((people)=>{
return people.age;
})

console.log(peoplesAge)

const peoplesData=people.map((i)=>{
    return console.log(`${i.name} is of the age ${i.age} and has the position of ${i.position}`)
})

// const uniqueNames=new Set(people.map((people)=>people.name));
//its an object to create the array use spread operator


const uniqueNames=[... new Set(people.map((people)=>people.name))];
uniqueNames.map((e)=>console.log(e));
console.log(uniqueNames);


//filtering
const filteredByAge=people.filter((e)=>e.age>22);
console.log(filteredByAge);

const findPersonByName=people.find((e)=>e.name?.toLowerCase()==="vishal")

console.log(findPersonByName)


//reduce

const totalAge=people.reduce((total,curr)=>{
total+=curr.age;
return total;
},0)

console.log(totalAge);