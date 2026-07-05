import React from 'react'
import {useRef} from 'react';
const EnterName = () => {
    const inputId=useRef(null);
    const handleFocus=()=>{
        inputId.current.focus();
        // document.getElementById('inputName').focus();
    }
  return (
    <div>
      <h5>please enter the name</h5>
      <input id='inputName' ref={inputId} type="text" placeholder='enter the name'/>
      <button onClick={handleFocus}>enter name</button>
      <button onClick={()=>alert("name saved in database")}>save</button>
    </div>
  )
}

export default EnterName
