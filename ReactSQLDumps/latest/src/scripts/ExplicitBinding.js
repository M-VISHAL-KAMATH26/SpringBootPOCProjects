//used to explicitly bind the function to the object

//call example
function greet(hobby,city){
    console.log(`Hello i am ${this.name} and i like ${hobby} and i live in ${city}`);
}
const person={name:"vishal"};

greet.call(person,"cricket","delhi");


function sweet(sweetName,sweetLevel){
    console.log(`the sweet ${sweetName} is ${sweetLevel} sweet level and price is ${this.price}`);
    
}
const sweetprice={price:100};
const sweetprice2={price:120};

sweet.apply(sweetprice,["jalebi",9]);

const bindex=sweet.bind(sweetprice2,'kaju katli',677);

bindex();