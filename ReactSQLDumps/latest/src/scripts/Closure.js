function createCounter(){

    let count=0;

    return {
        increment(){return ++count;},decrement(){return --count;},
        getCount(){return count;}

    }
}

const counter=createCounter();

counter.increment();
counter.decrement();
counter.increment()
console.log(counter.getCount())


const c1 = createCounter();
const c2 = createCounter();

console.log(c1.increment());
console.log(c1.increment());

console.log(c2.increment());

console.log(c1.getCount());
console.log(c2.getCount());


function multiple(a){
    return function(b){
        return a*b;
    }
}

const double=multiple(3);
console.log(double(5));