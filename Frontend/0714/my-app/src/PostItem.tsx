// PostItem 컴포넌트입니다.
import type { Post } from '../types/types.ts'
interface Props {
  // props를 이용해서 데이터를 상위 컴포넌트에게 받을 때는, props가 어떤 형태로 넘어오는지 type을 미리 적어둬야 함
  post: Post
}

const PostItem = ({ post }: Props) => {
  return (
    <div className='PostItem'>
      <div>
        <span className='id'>No. {post.id}</span>
        <span className='title'>- {post.title}</span>
      </div>
      <p className='body'>{post.body.slice(0, 120)}...</p>
    </div>
  );
};

export default PostItem;