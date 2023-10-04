package com.library.request;

import com.library.models.Author;
import com.library.models.Book;
import com.library.models.BookType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CreateBookRequest {
	
	private String bookName;
	
	private int cost;
	
	private BookType type;
	
	private String bookNo;
	
	private String authorName;
	
	private String authorEmail;
	
	public Book to() {
		Author authorData = Author.builder().name(this.authorName).email(this.authorEmail).build();
		return Book.builder().bookNo(this.bookNo)
				.cost(this.cost).name(this.bookName).type(this.type).author(authorData).build();
	}

}
