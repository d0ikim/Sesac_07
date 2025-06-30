import React, { useEffect } from 'react'

const Header = ({ currentUser, onLogout }) => {

  return (
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary sticky-top">
      <div class="container-fluid">
        <div class="navbar-brand" href="#">Doi's ToDo App</div>
        <div class="d-flex">
            <span class="navbar-text text-white me-3">{currentUser.email}님 환영합니다!</span>
            <button class="btn btn-light" onClick={onLogout}>로그아웃</button>
        </div>
      </div>
    </nav>
  )
}

export default Header