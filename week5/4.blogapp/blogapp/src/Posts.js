import React, { Component } from 'react';

class Posts extends Component {
  constructor(props) {
    super(props);

    this.state = {
      posts: []
    };
  }

  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => response.json())
      .then(data => {
        this.setState({
          posts: data
        });
      })
      .catch(error => {
        console.log(error);
      });
  }
componentDidMount() {
    this.loadPosts();

}
componentDidCatch(error, info) {
    alert(error);

}

  render() {
    const { posts } = this.state;
    return (
      <div>
        {posts.map(post => (
            <div key={post.id}>
                <h2>{post.title}</h2>
                <p>{post.body}</p>
            </div>
  
        ))}
      </div>
    );
  }
}

export default Posts;