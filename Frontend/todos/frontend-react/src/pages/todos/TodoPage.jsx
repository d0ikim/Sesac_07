import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';
import Header from '../../components/ui/Header';
import TodoList from '../../components/todo/TodoList';

import TodoForm from '../../components/todo/TodoForm';
import ConfirmDialog from '../../components/ui/ConfirmDialog';
import TodoActions from '../../components/ui/TodoActions';
import TodoStats from '../../components/ui/TodoStats';

import { useTodo } from '../../context/TodoContext';
import { useAuth } from '../../context/AuthContext';
import { useAddTodo, useToggleTodo, useDeleteTodo } from '../../hooks/useTodos';

function TodoPage() {

  const navigate = useNavigate();
  const { currentUser, logout } = useAuth();
  const [currentFilter, setCurrentFilter] = useState('all')

  const [showTodoForm, setShowTodoForm] = useState(false);
  const [showConfirmDialog, setShowConfirmDialog] = useState(false);
  const [todoToDelete, setTodoToDelte] = useState(null)

  const { todos, isLoading, error, stats} = useTodos()

  const addTodoMutation = useAddTodo();
  const toggleTodoMutation = useToggleTodo();
  const deleteTodoMutation = useDeleteTodo();

  const handleFiltterChange = (filter) => {
    setCurrentFilter(filter);
  };

  // 필터 변경 처리 함수
  const handleFilterChange = (filter) => {
    setCurrentFilter(filter)
  }

  // 할 일 삭제 시작
  const handleDeleteTodo = (todoId) => {
    setTodoToDelte(todoId);
    setShowConfirmDialog(true);
  }

  // 삭제 취소 처리 함수
  const handleCancelDelete = () => {
    setTodoToDelte(null);
    setShowConfirmDialog(false);
  }

  const {
    handleToggleComplete,
    handleConfirmDelete,
    handleAddTodo,
    openTodoForm,
    closeTodoForm } = useTodo();


  const handleLogout = () => {
    logout()
    navigate('/login');
  };
  if (!currentUser) {
    navigate('/login');
    return null;
  }
  return (

    <div className="bg-light ">
      <Header currentUser={currentUser} onLogout={handleLogout} />
      <div className="container mt-4">
        <div className="d-flex justify-content-between align-items-center mb-4">
          <TodoStats
            todos={todos} />
          <TodoActions
            onAddClick={openTodoForm}
            currentFilter={currentFilter}
            onFilterChange={handleFilterChange}
          />
        </div>
        <TodoList
          todos={todos}
          currentFilter={currentFilter}
          onToggleComplete={handleToggleComplete}
          onDeleteTodo={handleDeleteTodo}
        />

        <TodoForm
          show={showTodoForm}
          onClose={closeTodoForm}
          onAddTodo={handleAddTodo}
        />

        <ConfirmDialog
          show={showConfirmDialog}
          title="할 일 삭제"
          message="정말로 이 할 일을 삭제하시겠습니까?"
          confirmText="삭제"
          onConfirm={handleConfirmDelete}
          onCancel={handleCancelDelete}
        />
      </div>
    </div>
  )
}

export default TodoPage