package sk.filiptvrdon.junitWithMockito;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class NewsletterSenderTest {
    @Test
    public void constructorAssignDatabase() {
        // MOCK
        MessagingEngine messagingEngineMock = mock(MessagingEngine.class);
        SubscribersDatabase subscribersDatabase = new SubscribersDatabase();
        NewsLetterSender newsletterSender = new NewsLetterSender(subscribersDatabase, messagingEngineMock);
        assertEquals(subscribersDatabase, newsletterSender.getSubscribersDatabase());
    }

    @Test
    public void numberOfSubscribers() {
        SubscribersDatabase subscribersDatabaseMock = mock(SubscribersDatabase.class);
        MessagingEngine messagingEngineMock = mock(MessagingEngine.class);
        NewsLetterSender newsletterSender = new NewsLetterSender(subscribersDatabaseMock, messagingEngineMock);

        // SPY
        List<String> subscribers = List.of("a", "b", "c");
        when(subscribersDatabaseMock.getSubscribers()).thenReturn(subscribers);
        assertEquals(3, newsletterSender.numberOfSubscribers());
    }

    @Test
    public void zeroSubscribersException(){
        NewsLetterSender newsletterSender = new NewsLetterSender(new SubscribersDatabase(), new MessagingEngine());
        NewsLetterSender newsletterSenderSpy = spy(newsletterSender);

        when(newsletterSenderSpy.numberOfSubscribers()).thenReturn(0);

        assertThrows(ZeroSubscribersException.class, () -> {
            newsletterSenderSpy.sendNewsletter("subject");
        });
    }


}
