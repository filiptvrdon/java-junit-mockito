package sk.filiptvrdon.junitWithMockito;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

class TrainBarriersTest {

    EmailService emailServiceMock = mock(EmailService.class);
    final int PASSENGER_ID = 1;

    @Test
    public void passengerEntry() {

        //given - setup for test
        TrainBarriers trainBarriers = new TrainBarriers(emailServiceMock);
        TrainBarriers trainBarriersSpy = spy(trainBarriers);
        when(trainBarriersSpy.passengerIsEligible(PASSENGER_ID)).thenReturn(true);

        //when - method invocation
        trainBarriersSpy.passengerEntry(PASSENGER_ID);

        //then - what we expect
        verify(emailServiceMock).notifyPassenger(PASSENGER_ID);
        assertTrue(trainBarriersSpy.getPassengersOnBoard().contains(PASSENGER_ID));
    }

    @Test
    public void passengerEntryTestBDD() {

        //given - setup for test
        TrainBarriers trainBarriers = new TrainBarriers(emailServiceMock);
        TrainBarriers trainBarriersSpy = spy(trainBarriers);
        given(trainBarriersSpy.passengerIsEligible(PASSENGER_ID))
                .willReturn(true);

        //when - method invocation
        trainBarriersSpy.passengerEntry(PASSENGER_ID);

        //then - what we expect
        then(emailServiceMock)
                .should()
                .notifyPassenger(PASSENGER_ID);
        assertTrue(trainBarriersSpy.getPassengersOnBoard().contains(PASSENGER_ID));

    }


}