package sk.filiptvrdon.junitWithMockito;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CashierTest {

    @Test
    public void validateTransactionThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Cashier.validateTransaction("USD", 10));
    }
}
