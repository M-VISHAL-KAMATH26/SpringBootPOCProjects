Array.prototype.myForEach=function(callback){
for(let i=0;i<this.length;i++){
    callback(this[i],i);
}
}

const arr=[10,20,30];
arr.myForEach((value,index)=>{
    console.log(value,index);
})


Array.prototype.MyMap=function (callback){
    const res=[];
    for(let i=0;i<this.length;i++){
        const value=callback(this[i],i);
res.push(value);
    }
    return res;
}
const ans=arr.MyMap((e)=>{
    return e*2;
})

console.log(ans);


Array.prototype.myFilter=function(callback){
    let res=[];
    for(let i=0;i<this.length;i++){
        const stateTrue=callback(this[i],i);
        if(stateTrue){
            res.push(stateTrue);
        }
    }
    return res;
}

const x=arr.filter((d)=>{
    return d>25;
})
console.log(x);


Array.prototype.myFind=function(callback){
for(let i=0;i<this.length;i++){
    const val=callback(this[i],i);
    if(val){
        return this[i];
    }
}
return undefined;
}

const gg=arr.myFind((e)=>{
    return e>24;
})
console.log(gg);