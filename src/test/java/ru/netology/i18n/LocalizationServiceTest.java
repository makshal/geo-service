package ru.netology.i18n;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

public class LocalizationServiceTest {

    @Test
    void test_return_text_by_location() {

        String expectedText = "Добро пожаловать";

        LocalizationService localizationService = new LocalizationServiceImpl();

        Location location = new Location("Moscow", Country.RUSSIA, "Pushkina", 15);

        String realText = localizationService.locale(location.getCountry());

        assertEquals(expectedText, realText);

    }

}
