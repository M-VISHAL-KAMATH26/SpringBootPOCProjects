import React from 'react'
import StudentCard from './StudentCard'
const StudentCardCollection = () => {
    const students=[
        {id:1,name:"Vishal",age:21},
        {id:2,name:"delson",age:22},
        {id:3,name:"preya",age:25}
        ]
  return (
    <div>
    {/* <StudentCard names='Vishal' age='21'></StudentCard>
        <StudentCard names='delson'></StudentCard>
    <StudentCard age='21'></StudentCard> */}
{
students.map((student) => (
          <StudentCard
            key={student.id}
            name={student.name}
            age={student.age}
          />
    ))
}
    </div>
  )
}

export default StudentCardCollection
