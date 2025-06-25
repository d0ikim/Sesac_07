import React from 'react'
import { ThisDayInfoWrapper, ImgWrapper } from './styles'
const ThisDayInfo = () => {
  return (
    <ThisDayInfoWrapper>
      <div className='info-row'>
        <ImgWrapper>
          <img src='./images/temperature.svg' alt='Temperature' />
        </ImgWrapper>
        <h2>Temperature</h2>
        <p>100</p>
      </div>

      <div className='info-row'>
        <ImgWrapper>
          <img src='./images/pressure.svg' alt='Pressure'/>
        </ImgWrapper>
        <h2>Pressure</h2>
        <p>100</p>
      </div>

      <div className='info-row'>
        <ImgWrapper>
          <img src='./images/Humidity.svg' alt='Humidity' />
        </ImgWrapper>
        <h2>Humidity</h2>
        <p>100</p>
      </div>

      <div className='info-row'>
        <ImgWrapper>
          <img src='./images/wind.svg' alt='Wind' />
        </ImgWrapper>
        <h2>Wind</h2>
        <p>100</p>
      </div>
      
    </ThisDayInfoWrapper>
  )
}
export default ThisDayInfo