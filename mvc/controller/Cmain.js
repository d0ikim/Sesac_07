// 경로와 연결될 함수 내용을 정리
const Comment = require('../model/Comment.js');

exports.main = (req, res) => {
  res.render('index');
};

exports.comments = (req, res) => {
  res.render('comments');
};