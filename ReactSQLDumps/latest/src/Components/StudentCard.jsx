import React from 'react'

const StudentCard = ({name="not provided",age="not provided"}) => {
  return (
    <div>
      <h2>student names:{name}</h2>
      <h2>age:{age}</h2>
      <br />
    </div>
  )
}

export default StudentCard
