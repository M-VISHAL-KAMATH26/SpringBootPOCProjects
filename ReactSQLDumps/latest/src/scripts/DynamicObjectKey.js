

const state={
    loading:true,
    name:"",
    position:""
}

function updateState(key,value){
    state[key]=value;

}
updateState("name","Vishal")
updateState("loading",true)
updateState("position","Developer")
updateState("age",22)

console.log(state);
