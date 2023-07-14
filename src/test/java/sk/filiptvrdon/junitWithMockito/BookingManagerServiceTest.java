package sk.filiptvrdon.junitWithMockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookingManagerServiceTest {
    private HotelDao hotelDaoMock;
    private BookingManagerService bookingManagerService;

    @BeforeEach
    public void setUp() {
        hotelDaoMock = mock(HotelDao.class);
        bookingManagerService = new BookingManagerService(hotelDaoMock);
    }

    @Test
    public void testCheckRoomAvailabilityTrue() throws SQLException {
        when(hotelDaoMock.fetchAvailableRooms()).thenReturn(List.of("001", "002", "003"));
        assertTrue(bookingManagerService.checkRoomAvailability("001"));
    }

    @Test
    public void testCheckRoomAvailabilityFalse() throws SQLException {
        when(hotelDaoMock.fetchAvailableRooms()).thenReturn(List.of("001", "002", "003"));
        assertFalse(bookingManagerService.checkRoomAvailability("A1"));
    }


}