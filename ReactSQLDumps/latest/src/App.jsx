import React from 'react'
import Counter from './Components/Counter'
import Timer from './Components/Timer'
import EnterName from './Components/EnterName'
import FactorialCalculator from './Components/FactorialCalculator'

const App = () => {
  return (
    <div>
      <h1>welcome to the demo page</h1>
      <Counter/>
      <Timer/>
      <EnterName/>
      <FactorialCalculator/>
    </div>
  )
}

export default App
