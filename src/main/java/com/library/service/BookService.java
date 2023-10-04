package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.models.Author;
import com.library.models.Book;
import com.library.repository.AuthorRepository;
import com.library.repository.BookRepository;
import com.library.request.CreateBookRequest;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;

	public void create(CreateBookRequest createBookRequest) {
		
		Book book = createBookRequest.to();
		Author authorFromDB = authorRepository.getAuthorWithMailAddress(book.getAuthor().getEmail());
		if(authorFromDB==null) {
			authorFromDB = authorRepository.save(book.getAuthor());
		}
		bookRepository.save(book);
		
	}

	
}
