package org.nanotek.blog.api;

import java.util.List;

/**
 * "kind": "blogger#postList",
 "nextPageToken": "CgkIChiiwJC25yoQ_p3soZbg5LEc",
 "items": [
  {
   "kind": "blogger#post",
   "id": "8186430499679496463",
   "blog": {
    "id": "2045640289942179582"
   },
   "published": "2016-08-13T09:33:00-07:00",
   "updated": "2016-08-13T09:34:15-07:00",
   "etag": "\"GtyIIQmNmmUjEA0nwhSqMElCJ1g/dGltZXN0YW1wOiAxNDcxMTA2MDU1ODA2Cm9mZnNldDogLTI1MjAwMDAwCg\"",
   "url": "http://karnac-root.blogspot.com/2016/08/acdc-jack.html",
   "selfLink": "https://www.googleapis.com/blogger/v3/blogs/2045640289942179582/posts/8186430499679496463",
   "title": "AC/DC - The Jack",
   "content": "\u003cdiv class=\"jumbotron\" style=\"background-color:#090909\"\u003e\n\u003cdiv class=\"row\"\u003e\n\u003cdiv class=\"col-xs-6 col-lg-4\" style=\"float:left\"\u003e\u003ca href=\"https://4.bp.blogspot.com/-3dq3B1ZG5tQ/V69LdThvkII/AAAAAAAAbDU/6KR5GLG9c5wUOEwcHPJ7s0jahc-3OCZ-QCLcB/s1600/girl-in-the-bird-cage-pvc-figure.jpg\" imageanchor=\"1\" \u003e\u003cimg border=\"0\" src=\"https://4.bp.blogspot.com/-3dq3B1ZG5tQ/V69LdThvkII/AAAAAAAAbDU/6KR5GLG9c5wUOEwcHPJ7s0jahc-3OCZ-QCLcB/s200/girl-in-the-bird-cage-pvc-figure.jpg\" width=\"400\" height=\"400\" /\u003e\u003c/a\u003e\u003c/div\u003e\n\u003cdiv class=\"col-xs-6 col-lg-4\" style=\"float:right;margin-right:55px\"\u003e\n\u003ciframe name=\"player\" width=\"420\" height=\"315\" src=\"https://www.youtube.com/embed/eVlRQn6AMYs?autoplay=1\" frameborder=\"0\" allowfullscreen\u003e\u003c/iframe\u003e\n\u003c/div\u003e\n\u003c/div\u003e\n\u003c/div\u003e\n",
   "author": {
    "id": "g108283864565495942757",
    "displayName": "Jose Carlos Canova",
    "url": "https://www.blogger.com/profile/03454886323200271994",
    "image": {
     "url": "//lh3.googleusercontent.com/-MhCD71_yASA/AAAAAAAAAAI/AAAAAAAAB78/qRF2UOGR8O0/s35-c/photo.jpg"
    }
   },
   "replies": {
    "totalItems": "0",
    "selfLink": "https://www.googleapis.com/blogger/v3/blogs/2045640289942179582/posts/8186430499679496463/comments"
   },
   "labels": [
    "AC/DC - The Jack"
   ]
  }
 * @author user
 *
 */
public class BlogPost {
	
	private String kind;
	private String nextPageToken; 
	private String published; 
	private String updated; 
	private String etag;
	private String url; 
	private String title; 
	private String content; 
	private List<?> items;
	private List<?> labels;
	
	
	public String getKind() {
		return kind;
	}
	
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	public String getNextPageToken() {
		return nextPageToken;
	}
	
	public void setNextPageToken(String nextPageToken) {
		this.nextPageToken = nextPageToken;
	}
	
	public String getPublished() {
		return published;
	}
	
	public void setPublished(String published) {
		this.published = published;
	}
	
	public String getUpdated() {
		return updated;
	}
	
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	
	public String getEtag() {
		return etag;
	}
	
	public void setEtag(String etag) {
		this.etag = etag;
	}
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public List<?> getItems() {
		return items;
	}
	
	public void setItems(List<?> items) {
		this.items = items;
	}
	
	public List<?> getLabels() {
		return labels;
	}
	
	public void setLabels(List<?> labels) {
		this.labels = labels;
	}
	
}
