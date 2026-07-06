import React from 'react'
import Counter from './Components/Counter'
import Timer from './Components/Timer'
import EnterName from './Components/EnterName'
import FactorialCalculator from './Components/FactorialCalculator'
import StudentCardCollection from './Components/StudentCardCollection'
import FormDemo from './Components/FormDemo'
const App = () => {
  return (
    <div>
      <h1>welcome to the demo page</h1>
      <Counter/>
      <Timer/>
      <EnterName/>
      <FactorialCalculator/>
      <StudentCardCollection/>
      <FormDemo/>
    </div>
  )
}

export default App
