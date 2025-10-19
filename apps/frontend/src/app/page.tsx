// src/app/page.tsx
'use client'; // This directive is not strictly necessary for this specific component
             // but is included for cases where interactive features are added.

import { useState, useEffect } from 'react';

// Define the shape of a Student object for type safety
interface Student {
  id: number;
  name: string;
}

const API_BASE_URL = 'http://localhost:8080/api'; // Replace with your Java backend URL

export default function HomePage() {
  const [students, setStudents] = useState<Student[]>([]);
  const [error, setError] = useState<string | null>(null);
  const [loading, setLoading] = useState<boolean>(true);

  // Use the useEffect hook to fetch data when the component mounts
  useEffect(() => {
    async function getStudents() {
      try {
        const res = await fetch(`${API_BASE_URL}/students`);
        if (!res.ok) {
          throw new Error(`Failed to fetch student data: ${res.statusText}`);
        }
        const studentsData: Student[] = await res.json();
        setStudents(studentsData);
      } catch (err: any) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    }
    getStudents();
  }, []); // The empty dependency array ensures this effect runs only once

  return (
    <div className="container">
      <h1 className="title">Student List from Java Backend</h1>
      {loading && <p className="message">Loading students...</p>}
      {error && <p className="error-message">Error: {error}</p>}
      
      {!loading && !error && (
        <ul className="student-list">
          {students.map((student) => (
            <li key={student.id} className="student-item">
              <span className="student-name">{student.name}</span>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}
