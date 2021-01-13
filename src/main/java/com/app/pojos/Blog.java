package com.app.pojos;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="blog_tbl")
public class Blog extends BaseEntity {

	
	
	public Blog() {
		super();
	}

	public Blog(String title, String content, Author author, List<String> keywords, List<Tags> tags, byte[] image) {
		super();
		this.title = title;
		this.content = content;
		this.author = author;
		this.keywords = keywords;
		this.tags = tags;
		this.image = image;
	}

	@Column(length = 20)
	private String title;

	@Column(length = 4096)
	private String content;

	@OneToOne
	private Author author;
	
	@ElementCollection
	private List<String> keywords;

	@ManyToMany (cascade = {CascadeType.MERGE,CascadeType.PERSIST},mappedBy = "blogs")
	private List<Tags> tags;

	@Column(columnDefinition = "longblob")
	private byte[] image;

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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public List<Tags> getTags() {
		return tags;
	}

	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Blog [title=" + title + ", content=" + content + ", author=" + author + ", keywords=" + keywords
				+ ", tags=" + tags + ", image=" + Arrays.toString(image) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + Arrays.hashCode(image);
		result = prime * result + ((keywords == null) ? 0 : keywords.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Blog other = (Blog) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (!Arrays.equals(image, other.image))
			return false;
		if (keywords == null) {
			if (other.keywords != null)
				return false;
		} else if (!keywords.equals(other.keywords))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	
	
	

}
