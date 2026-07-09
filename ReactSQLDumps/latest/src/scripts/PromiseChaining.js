//promise chaining for login 

function login(){
    return new Promise((resolve,reject)=>{
        setTimeout(()=>{
            console.log("user has logged in");
            resolve("vishal kamath")
        },1000)
    })
}

function getProfile(username){
    return new Promise((resolve,reject)=>{
        setTimeout(()=>{
                    console.log("profile fetched from"+username);
// resolve({
//     name:username,
//     gender:"male",
//     place:"puttur"
// })
reject("db error")
        },1000)
    })
}

function getOrder(profile){
    return new Promise((resolve,reject)=>{
        setTimeout(() => {
            console.log("orders fetched for "+profile.name);
            resolve(["biriyani","kabab","noodles"]);
        }, 1000);
    })
}

function logout(){
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log("user logged out");
            resolve();
        }, 1000);
    })
}


login().then((res)=>{
    return getProfile(res);
})
.then((res)=>{
    return getOrder(res);
}).then((res)=>{
    return logout(res);
}).catch((e)=>{
console.log(e);
}).finally(()=>{
    console.log("happy ending")
})