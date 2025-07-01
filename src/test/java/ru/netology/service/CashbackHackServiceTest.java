package ru.netology.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CashbackHackServiceTest {

    CashbackHackService service = new CashbackHackService();

//    description = "Тестируем остаток при сумме ровно равной границе"
    @Test()
    public void shouldReturnZeroWhenAmountIsExactlyBoundary() {
        int expected = 0;
        int actual = service.remain(1000);

        assertEquals(expected, actual);
    }
//    description = "Проверяем случай, когда сумма меньше границы"
    @Test()
    public void shouldCalculateSmallerThanBoundary() {
        int expected = 100;
        int actual = service.remain(900); // Нужно доплатить 100 руб., чтобы достичь тысячи

        assertEquals(expected, actual);
    }
//    description = "Проверяем случай, когда сумма больше границы"
    @Test()
    public void shouldCalculateBiggerThanBoundary() {
        int expected = 800;
        int actual = service.remain(1200); // Нужно доплатить 800 руб., чтобы достигнуть следующей тысячи

        assertEquals(expected, actual);
    }
//    description = "Проверяем нулевую сумму"
    @Test()
    public void shouldHandleZeroAmount() {
        int expected = 1000;
        int actual = service.remain(0); // Если ничего не куплено, нужно добавить целую тысячу

        assertEquals(expected, actual);
    }
}
