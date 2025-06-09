const { DataTypes } = require('sequelize');

module.exports = (sequelize) => {
   const Post = sequelize.define('Post', {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
     title: {
      type: DataTypes.STRING,
      allowNull: false,
    },
    content: {
      type: DataTypes.TEXT,
      allowNull: false,
    },
  }, {
    tableName: 'posts', // 실제 데이터베이스 테이블 이름
    timestamps: true, // createdAt, updatedAt 자동 생성
    underscored: true, // 컬럼명을 snake_case로 자동 변환 (e.g., firstName -> first_name)
  });
  
  // 모델 간의 관계를 여기에 정의
  Post.associate = (models) => {
    // 예: User.hasMany(models.Post);
    Post.hasMany(models.Post, {
      foreignkey: 'userId', // <-- 중요: Post 테이블의 외래 키 컬럼이름 ('userId'와 일치)
      as: 'user'})  // Post 객체에서 연관된 User 객체에 접근할 때 사용할 별칭 (예: post.user)
  };

  return Post;
}
