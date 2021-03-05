package com.jpa.test.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpa.test.Dao.BookRepository;
import com.jpa.test.entities.Book;

@Component
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	
	
	//private static List<Book> list=new ArrayList<>();
	
//	static {
//		list.add(new Book(1,"Python","X"));
//		list.add(new Book(2,"Java","Y"));
//		list.add(new Book(3,"C++","Z"));
//	}
	
	public List<Book> getAllBooks(){
		
		List<Book> list = (List<Book>) bookRepository.findAll();
		return list;
	}
	
	public Book getBookById(int id)
	{
		Book book=null;
		try {
		//book=list.stream().filter(e->e.getId()==id).findFirst().get();
			book = bookRepository.findById(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return book;
	}
	
	public Book addBook(Book b)
	{
		
		Book result = bookRepository.save(b);
		//list.add(b);
		return result;
	}

	public void deleteBook(int id) {
		//list = list.stream().filter(b->b.getId()!=id).collect(Collectors.toList());
		bookRepository.deleteById(id);
		
		
	}

	public void updateBook(Book book, int id) {
		book.setId(id); 
		bookRepository.save(book);
//		list=list.stream().map(b->{
//			if(b.getId()==id)
//			{
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		
	}
}
