package br.eti.carloslima.workshopmongo.dto;

import java.util.Date;

import br.eti.carloslima.workshopmongo.domain.Post;

public class PostDTO {

	private String id;
	private Date date;
	private String title;
	private String boby;

	private AuthorDTO author;

	public PostDTO() {
	}

	public PostDTO(Post obj) {
		this.id = obj.getId();
		this.date = obj.getDate();
		this.title = obj.getTitle();
		this.boby = obj.getBoby();
		this.author = obj.getAuthor();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBoby() {
		return boby;
	}

	public void setBoby(String boby) {
		this.boby = boby;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

}
