import { useState } from "react"

export const HandlerEx = () => {
  const [state, setState] = useState("")
  const [buttonValue, setButtonValue] = useState("보여라")
  const onClickHandler = () =>{
    setButtonValue((prev)=>(
      prev==="보여라"?"사라져라":"보여라")
    )
    setState((prev)=>(
      prev===""?"안녕하세요":""
    ))
  }
  return (<div>
    <h1>{state}</h1>
    <button onClick={onClickHandler}>{buttonValue}</button>
  </div>
  )
}

