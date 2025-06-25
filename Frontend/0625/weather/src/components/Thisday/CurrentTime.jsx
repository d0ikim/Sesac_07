import React from 'react'

const CurrentTime = () => {
  const time = new Intl.DateTimeFormat("ko-KR", 
    {
      hour: "numeric",
      minute: "numeric",
    }
  ).format( // 위 설정한 포맷으로 바꿈
    new Date()  // 현재시간
  );

  return (
    <div>{time}</div>
  )
}

export default CurrentTime