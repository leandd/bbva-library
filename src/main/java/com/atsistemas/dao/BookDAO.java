package com.atsistemas.dao;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

import com.atsistemas.beans.Book;
import com.googlecode.objectify.ObjectifyService;

public class BookDAO {

	private static final Logger LOGGER = Logger.getLogger(BookDAO.class.getName());
	private static Comparator<Book> bookComparator = new Comparator<Book>() {
		
		@Override
		public int compare(Book o1, Book o2) {
			// TODO Auto-generated method stub
			return o1.getAuthor().compareTo(o2.getAuthor());
		}
	};
	
	public List<Book> list() {
        LOGGER.info("Retrieving list of books sorted by Author");
        List<Book> listBooks = ObjectifyService.ofy().load().type(Book.class).list();
        listBooks.sort(bookComparator);
        return listBooks;
    }
	
	public Book get(Long id) {
        LOGGER.info("Retrieving book " + id);
        return ObjectifyService.ofy().load().type(Book.class).id(id).now();
    }

    /**
     * Saves given book
     * @param book
     */
    public void save(Book book) {
    	LOGGER.info("Entra en el metodo");
        if (book == null) {
            throw new IllegalArgumentException("null book object");
        }
        LOGGER.info("Saving book " + book.getId());
        ObjectifyService.ofy().save().entity(book).now();
    }

    /**
     * Deletes given book
     * @param book
     */
    public void delete(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("null book object");
        }
        LOGGER.info("Deleting book " + book.getId());
        ObjectifyService.ofy().delete().entity(book);
    }
}
