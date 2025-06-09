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
    Post.hasMany(models.Post, { foreignkey: 'userId', as: 'posts'})
    // 여기 코드 보여주시다가 말고 게시판과제 안내하심.. 뭐.. 나는 시퀄라이즈 어려워서 안쓰고 프리즈마 쓸거니 ㄱㅊ음
  };

  return Post;
}
