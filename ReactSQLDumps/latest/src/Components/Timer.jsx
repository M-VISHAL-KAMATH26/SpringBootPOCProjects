import React from 'react'
import {useState,useEffect} from 'react';
const Timer = () => {
    const [time,setTime]=useState(0);
    const [isRunning,SetIsRunning]=useState(false);

    useEffect(()=>{
        let intervalId;
        if(isRunning){
            intervalId=setInterval(()=>{
                setTime(prevTime=>prevTime+1);
            },1000);
        }
        return ()=>{
            clearInterval(intervalId);
        }
    },[isRunning]);
  return (
    <div>
        <h2>Time:{time}</h2>
        <button onClick={()=>SetIsRunning(true)}>start</button>
                <button onClick={()=>SetIsRunning(false)}>stop</button>
                        <button onClick={()=>{SetIsRunning(false);setTime(0)}}>reset</button>

      
    </div>
  )
}

export default Timer
