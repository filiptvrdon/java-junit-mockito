package sk.filiptvrdon.junitWithMockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookManagerTest {
    private BooksRepository booksRepository = mock(BooksRepository.class);

    private BookManager bookManager;
    private Set<String> booksDatabaseSet;

    @BeforeEach
    public void setUp() {
        bookManager = new BookManager(booksRepository);
        booksDatabaseSet = new HashSet<String>();
        booksDatabaseSet.add("Harry Potter");

    }

    @Test
    public void getBookInventoryCountTest() {
        BookManager bookManagerSpy = spy(bookManager);
        when(booksRepository.getBooks()).thenReturn(booksDatabaseSet);

        assertEquals(1, bookManagerSpy.getBookInventoryCount());
    }

    @Test
    public void addBookTest() {
        BookManager bookManagerSpy = spy(bookManager);
        when(booksRepository.getBooks()).thenAnswer(new GetBooks());

        Integer booksCount = bookManagerSpy.getBookInventoryCount();
        assertEquals(1, booksCount);

        when(booksRepository.addBook(anyString())).thenAnswer(new AddBook());

        bookManagerSpy.addBook("Lord of the Rings");
        assertEquals(2, bookManagerSpy.getBookInventoryCount());
    }

    class GetBooks implements Answer<Object> {
        @Override
        public Object answer(org.mockito.invocation.InvocationOnMock invocationOnMock) throws Throwable {
            return booksDatabaseSet;
        }
    }

    class AddBook implements Answer<Object> {
        @Override
        public Object answer(org.mockito.invocation.InvocationOnMock invocationOnMock) throws Throwable {
            String book = (String) invocationOnMock.getArguments()[0];
            booksDatabaseSet.add(book);
            return book;
        }
    }

}