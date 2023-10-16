import React, { useState, useEffect } from 'react';

  export function  requestFetch(setStudents) {
    return async () => {
      try {
        const response = await fetch("http://localhost:8080/getStudents", {
          method: "GET",
          headers: {
            "Content-Type": "application/json",
          },
        });

        const data = await response.json();
        setStudents(data);
      } catch (error) {
        console.log(error);
      }
    }
  };



function List() {
  const [students, setStudents] = useState([]);

  const fetchData = requestFetch(setStudents);

  useEffect(() => {
    fetchData();
  });


  return (
    <div className="list" id="List">
      <h1>Students:</h1>
      {students.map((student) => (
        <div className="studentItem" key={student.id}>
          <span>Name: {student.name}</span>
          <span>Email: {student.email}</span>
          <span>Date of Birth: {student.dob}</span>
          <span>Age: {student.age}</span>
        </div>
      ))}
    </div>
  );
}

export default List;
