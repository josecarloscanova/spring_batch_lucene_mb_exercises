package org.nanotek.samples;

import java.util.HashMap;
import java.util.Map;

public class BloggerUrlCollection {

	private Map<String,String> bloggerUrlCollection = new HashMap<String,String>();
	
	public BloggerUrlCollection()
	{ 
		bloggerUrlCollection.put("userId", "https://www.googleapis.com/blogger/v3/users/userId");
		bloggerUrlCollection.put("self" , "https://www.googleapis.com/blogger/v3/users/self");
		bloggerUrlCollection.put("userId" ,  "https://www.googleapis.com/blogger/v3/users/userId/blogs");
		bloggerUrlCollection.put("selfBlogs" , "https://www.googleapis.com/blogger/v3/users/self/blogs");
		bloggerUrlCollection.put("blogId" , "https://www.googleapis.com/blogger/v3/blogs/blogId");
		bloggerUrlCollection.put("byUrl" , "https://www.googleapis.com/blogger/v3/blogs/byurl");
		bloggerUrlCollection.put("posts" , "https://www.googleapis.com/blogger/v3/blogs/blogId/posts");
		bloggerUrlCollection.put("postsByPath" , "https://www.googleapis.com/blogger/v3/blogs/blogId/posts/bypath");
		bloggerUrlCollection.put("postsSearch" , "https://www.googleapis.com/blogger/v3/blogs/blogId/posts/search");
		bloggerUrlCollection.put("postsById"  , "https://www.googleapis.com/blogger/v3/blogs/blogId/posts/postId");
		bloggerUrlCollection.put("postComments" , "https://www.googleapis.com/blogger/v3/blogs/blogId/posts/postId/comments");
		bloggerUrlCollection.put("commentsById" , "https://www.googleapis.com/blogger/v3/blogs/blogId/posts/postId/comments/commentId");
		bloggerUrlCollection.put("blogPages" , "https://www.googleapis.com/blogger/v3/blogs/blogId/pages");
		bloggerUrlCollection.put("pagesById" , "https://www.googleapis.com/blogger/v3/blogs/blogId/pages/pageId");
	}
	
}
