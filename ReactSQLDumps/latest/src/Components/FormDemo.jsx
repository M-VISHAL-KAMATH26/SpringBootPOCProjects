import React from 'react'
import { useState } from 'react';
const FormDemo = () => {
    const [username,SetUsername]=useState("");
    const [password,SetPassword]=useState("");

    const handleSubmit = (e) => {
    e.preventDefault();

    if (username === "" || password === "") {
        alert("Please fill all fields");
        return;
    }

    console.log(username, password);
    SetUsername("");
    SetPassword("");
}
  return (
    <div>
        <form action="" onSubmit={handleSubmit}>
            <input type="text" value={username}  onChange={(e)=>SetUsername(e.target.value)}/>
            <input type="password" value={password} onChange={(e)=>SetPassword(e.target.value)} />
            <button onMouseOver={()=>alert('hey babes')}>submit</button>
        </form>
      
    </div>
  )
}

export default FormDemo
