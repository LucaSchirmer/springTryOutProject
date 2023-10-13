import React, { useState, useEffect } from 'react';

function List() {
  const [students, setStudents] = useState([]); // State to hold student data

  useEffect(() => {
    const requestFetch = async () => {
      try {
        const response = await fetch("http://localhost:8080/getStudents", {
          method: "GET",
          headers: {
            "Content-Type": "application/json",
          },
        });

        const data = await response.json();
        setStudents(data); // Set the student data in the state
      } catch (error) {
        console.log(error);
      }
    };

    requestFetch();
  }, []); // Empty dependency array to run the effect only once

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
