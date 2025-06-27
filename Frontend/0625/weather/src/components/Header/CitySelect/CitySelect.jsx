import React from 'react'
import CreatableSelect from 'react-select/creatable'
import { cityOptions } from "../data";
import { SelectWrapper } from '../styles';
import { useNavigate } from 'react-router-dom';

const CitySelect = () => {
  const navigate = useNavigate();

  const handleChange = (newValue, actionmeta) => {
    console.log(newValue)
    navigate(`/${newValue?.value}`)
  }
  return (
    <SelectWrapper>
      <CreatableSelect
        options={cityOptions}
        onChange={handleChange}
        defaultInputValue={null}

        className='react-select-container'
        classNamePrefix='react-select'
      />
    </SelectWrapper>
  )
}

export default CitySelect