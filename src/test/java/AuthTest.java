import com.codeborne.selenide.Selenide;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AuthTest extends SelenideSetup {
    /**
     * Тестовый кейс №1:
     * <p>
     * 1. Перейти на страницу https://online.mkb.ru (https://online.mkb.ru/)
     * 2. Страница должна загрузиться в течение 10 секунд
     * 3. Ввести логин Avtotest
     * 4. Ввести пароль 123456
     * 5. Нажать кнопку Войти
     * 6. Проверить ожидаемый результат:  появиться сообщение об ошибке
     * 7. Повторить пункты 4,5 (3 раза)
     * 8. Проверить ожидаемый результат:  появиться сообщение о блокировке на  15 минут
     * Результат выполнения задания: архив с проектом.
     */

    @Test
    public void test() {

        String user = "Avtotest";
        String password = "123456";
        String errorText = "Ошибка аутентификации.\nПроверьте правильность указания логина и пароля.";
        String blockedTextContains = "Вы ввели неправильный логин / пароль 3 раза. В целях безопасности вход в систему ограничен. Повторите попытку через 14 мин 5";

        LoginPage page = new LoginPage();
        page.onMainPage();
        page.login(user, password);
        String error = page.getErrorMessage();
        assertEquals("Проверка сообщения об ошибке", errorText, error);

        for (int i = 0; i < 3; i++) {
            page.inputPassword(password);
            page.clickOnButton();
            Selenide.sleep(2000L);
        }

        error = page.getErrorMessage();
        assertTrue(error.contains(blockedTextContains));
    }
}
