package ru.netology.service;

public class CashbackHackService {
    private final int boundary = 1000;

    public int remain(int amount) {
//       Проблема заключается в том, что выражение amount % boundary вычисляет остаток от деления суммы на границу (boundary),
//       и вычитание этого остатка из границы даст некорректный результат, если сумма равна границе.
        return boundary - amount % boundary;
//        Фикс теста shouldReturnZeroWhenAmountIsExactlyBoundary
//        Когда сумма равна нулю. Тогда возвращаем границу целиком (1000 рублей).
//        if (amount == 0) {
//            return boundary; // Если сумма равна 0, остаток — это минимальная граница для получения кешбэка
//        }
//       Если сумма кратна границе (деление на границу даёт остаток 0), то остаток равен 0
//        if (amount % boundary == 0) {
//            return 0; // Если сумма кратна границе, остаток равен 0
//        }
//        return boundary - (amount % boundary); // Нормальное вычисление остатка
    }
}
