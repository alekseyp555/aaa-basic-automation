package ru.netology.service;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CashbackHackServiceTest {
    // Создаем экземпляр нашего сервиса
    CashbackHackService service = new CashbackHackService();

    @Test(description = "Тестируем остаток при сумме ровно равной границе")
    public void shouldReturnZeroWhenAmountIsExactlyBoundary() {
        int actual = service.remain(1000);
        int expected = 0;

        assertEquals(actual, expected, "Остаток должен быть равен нулю");
    }

    @Test(description = "Проверяем случай, когда сумма меньше границы")
    public void shouldCalculateSmallerThanBoundary() {
        int actual = service.remain(900); // Нужно доплатить 100 руб., чтобы достичь тысячи
        int expected = 100;

        assertEquals(actual, expected, "Остаток должен быть равен 100 рублям");
    }

    @Test(description = "Проверяем случай, когда сумма больше границы")
    public void shouldCalculateBiggerThanBoundary() {
        int actual = service.remain(1200); // Нужно доплатить 800 руб., чтобы достигнуть следующей тысячи
        int expected = 800;

        assertEquals(actual, expected, "Остаток должен быть равен 800 рублям");
    }

    @Test(description = "Проверяем нулевую сумму")
    public void shouldHandleZeroAmount() {
        int actual = service.remain(0); // Если ничего не куплено, нужно добавить целую тысячу
        int expected = 1000;

        assertEquals(actual, expected, "Остаток должен быть равен 1000 рублям");
    }
}

