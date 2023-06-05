package sk.filiptvrdon.data.api;

import java.sql.SQLException;
import java.util.List;

public class BookingManagerService {
    private HotelDao dao;

    public BookingManagerService(HotelDao dao) {
        this.dao = dao;
    }

    public boolean checkRoomAvailability (String roomNo) throws SQLException {
        List<String> roomsAvailable = dao.fetchAvailableRooms();
        return roomsAvailable.contains(roomNo);
    }
}
