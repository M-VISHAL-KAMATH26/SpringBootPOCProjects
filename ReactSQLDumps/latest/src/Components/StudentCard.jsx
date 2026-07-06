import React from 'react'

const StudentCard = ({names="not provided",age="not provided"}) => {
  return (
    <div>
      <h2>student names:{names}</h2>
      <h2>age:{age}</h2>
      <br />
    </div>
  )
}

export default StudentCard
