async function hello(){
    return "hi";
}

console.log(hello());

hello().then((e)=>{
    console.log(e);
})