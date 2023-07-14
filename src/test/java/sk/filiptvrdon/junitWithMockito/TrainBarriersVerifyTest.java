package sk.filiptvrdon.junitWithMockito;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TrainBarriersVerifyTest {
    final int PASSENGER_ID = 3;
    @Test
    public void passengerEntryTest(){

        PassengerRepository passengerRepositoryMock = mock(PassengerRepository.class);
        EmailService emailServiceMock = mock(EmailService.class);
        TrainBarriers trainBarriers = new TrainBarriers(emailServiceMock);

        trainBarriers.passengerEntryOld(PASSENGER_ID);
        verify(emailServiceMock).notifyPassenger(PASSENGER_ID);

    }


}