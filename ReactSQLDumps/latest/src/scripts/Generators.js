
function* numbers(){
yield(10);
yield(20);
yield(30);
}

const hwyeah=numbers();

console.log(hwyeah.next());
console.log(hwyeah.next());
console.log(hwyeah.next());
console.log(hwyeah.next());

