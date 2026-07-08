
console.log('prototype demo');

const Person={

    greet: function(){
        console.log("good morning");
    }
}

const student={
    name:"vishal"
}
const God={
    hi:function(){
        console.log("i am god")
    }
}

function Employee(name){
this.name=name;
}
Employee.
Object.setPrototypeOf(student,Person);
Object.setPrototypeOf(Person,God);
student.greet();
student.hi()

