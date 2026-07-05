import React from 'react'
import { useState,useMemo } from 'react';
const FactorialCalculator = () => {
    const [num,setNum]=useState(0);
    const [name,setName]=useState("");
    const factorial=(n)=>{
        if((n==1)||(n==0)) {return 1;}else{
           return n* factorial(n-1);
        }
    }
    const fact=useMemo(()=>{
        return factorial(num);
    },[num]);
  return (
    <div>
      <h2>factorial: {fact}</h2>
      <input value={num} onChange={(e)=>setNum(Number(e.target.value))} type="text" placeholder='number'/>
      <input value={name} onChange={(e)=>setName(e.target.value)} type="text" placeholder='name'/>
      
    </div>
  )
}

export default FactorialCalculator
