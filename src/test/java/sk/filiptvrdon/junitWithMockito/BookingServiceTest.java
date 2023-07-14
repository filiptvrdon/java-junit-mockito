package sk.filiptvrdon.junitWithMockito;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class BookingServiceTest {

    @Test
    public void bookSeatTest() {
        BookingRepository bookingRepositorySpy = mock(BookingRepository.class);
        BookingService bookingService = new BookingService(bookingRepositorySpy);


        String ticketShowId = "TICKET:ID_1";
        Ticket ticket = new Ticket(ticketShowId);

        List<String> availableTickets  = new ArrayList<>();
        availableTickets.add(ticketShowId);

        when(bookingRepositorySpy.getSeats(anyString())).thenReturn(availableTickets);
        System.out.println(bookingRepositorySpy.getSeats("TICKETID_1"));

        assertTrue(bookingService.bookSeat(ticket));

    }


}