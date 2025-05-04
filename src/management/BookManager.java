package management;

import datastructures.maps.CustomHashMap;
import library.Book;
import library.Member;

public class BookManager {
    CustomHashMap<String , Book> books;

    private MemberManager memberManager;

    public BookManager(MemberManager memberManager) {
        books = new CustomHashMap<>();
        this.memberManager = memberManager;
    }

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public Book getBookByIsbn(String isbn) {
        return books.get(isbn);
    }

    public boolean isBookAvailable(String isbn) {
        if(books.get(isbn).isAvailable())
            return true;
        return false;
    }

    public void setBookAvailability(String isbn, boolean available) {
        books.get(isbn).setAvailable(available);
    }

    public void addToWaitlist(String isbn, String memberId) {
        books.get(isbn).addToWaitlist(memberManager.getMember(memberId));
    }

    public Member getNextFromWaitlist(String isbn) {
        return books.get(isbn).getNextInWaitlist();
    }

    public boolean hasWaitlist(String isbn) {
        if(books.get(isbn).hasWaitlist())
            return true;
        return false;
    }
}