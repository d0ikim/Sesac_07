import React, { useState, useEffect } from 'react'
import axios from 'axios';

interface UserResponse {
  message: string;
}

const About = () => {
  const [data, setData] = useState<UserResponse | null>(null);

  useEffect(()=>{
    const postUser = async () => {
      try {
        const response = await axios.post<UserResponse>("http://localhost:4000/users", {
          name: "홍길동"
        });
        console.log(response.data);
        setData(response.data);

      } catch(e) {
        console.log(e)
        throw new Error()
      }
    }
    postUser();
  },[])

  useEffect(()=>{
    console.log(data)
  },[data])

  return (
    <>
      <div>About
        <p>{data?.message}</p>
      </div>
    </>
  )
}

export default About