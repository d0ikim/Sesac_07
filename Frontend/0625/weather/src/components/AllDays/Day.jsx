
import React from 'react'
import { BottomPart, DayWrapper, TopPart } from "./styles";
import getWeatherIcon from '../../utils/getWeatherIcon';


const Day = ({ day }) => {
  const { date, forecast } = day;
  // console.log(forecast)
  const temp = Math.max(...forecast.map((x)=>(
    Math.round(x.main.temp_max)
  )))
  const lowestTemp = Math.min(...forecast.map((x)=>(
    Math.round(x.main.temp_min)
  )))
  const weekDays = new Date(date);
  const dayOfWeek = weekDays.toDateString().substring(0,3)
  const dates = date.split("-").join(".").substring(5)
  // console.log(forecast[0].weather[0].main)
  let imageSrc = `./images/weatherIcons/${getWeatherIcon(forecast[0].weather[0].main)}`;

  return (
    <DayWrapper>
      <TopPart>
        <div>
          <h2>{dayOfWeek}</h2>
          <h3>{dates}</h3>
        </div>
        <img src={imageSrc} alt="" />
      </TopPart>
      <BottomPart>
        <h2>{temp}°</h2>
        <h3>{lowestTemp}°</h3>
      </BottomPart>
    </DayWrapper>
  )
}

export default Day