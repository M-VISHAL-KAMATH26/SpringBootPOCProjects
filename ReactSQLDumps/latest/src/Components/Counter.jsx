import React from 'react'
import {useState,useEffect} from 'react'
const Counter = () => {
    const [count,setCount]=useState(0);

    useEffect(()=>{
        document.title=`count is ${count}`;
    },[count])
  return (
    <div>
      <h1>welcome to counter app</h1>
      <p>Counter: {count}</p>

      <button onClick={()=>setCount(count+1)}>Incremenet</button>
      <button disabled={count==0} onClick={()=>setCount(count-1)}>decremenet</button>
      <button onClick={()=>setCount(0)}>reset</button>
    </div>
  )
}

export default Counter;
