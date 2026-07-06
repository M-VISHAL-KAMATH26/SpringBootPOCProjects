import React from 'react'
import StudentCard from './StudentCard'
const StudentCardCollection = () => {
  return (
    <div>
    <StudentCard names='Vishal' age='21'></StudentCard>
        <StudentCard names='delson'></StudentCard>
    <StudentCard age='21'></StudentCard>

    </div>
  )
}

export default StudentCardCollection
