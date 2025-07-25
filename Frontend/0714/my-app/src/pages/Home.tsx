import React, { useEffect, useState } from 'react'
import axios from 'axios';

const Home = () => {
  const [data, setData] = useState('');

  useEffect(()=>{
    const fetchData = async () => {
      try {
        const res = await axios.get("http://localhost:4000/");
        console.log(res);
        setData(res.data as string);
      } catch(e) {
        console.log(e);
        throw new Error();
      }
    }
    fetchData();
  },[])

  return (
    <>
      <div>Home</div>
      <p>home page</p>
    </>
  )
}

export default Home