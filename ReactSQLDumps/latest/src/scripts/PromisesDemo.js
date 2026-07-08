
//callback example
function greet(){
    console.log("Hello")
}

function process(callback){
    console.log("inside the process")
    callback();
}

process(greet);