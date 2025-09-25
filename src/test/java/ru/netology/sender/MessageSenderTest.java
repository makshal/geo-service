package ru.netology.sender;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MessageSenderTest {

    @Test
    void test_sender_ru_send() {
        GeoService geoService = Mockito.mock(GeoService.class);
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);


        String russianIp = "172.168.113.213";
        String expectedMessage = "Добро пожаловать";
        Location location = new Location("Kazan", Country.RUSSIA, "Pushkina", 10);

        Mockito.when(geoService.byIp(russianIp)).thenReturn(location);
        Mockito.when(localizationService.locale(location.getCountry())).thenReturn("Добро пожаловать");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, russianIp);

        String resultMessage = messageSender.send(headers);

        assertEquals(expectedMessage, resultMessage);
    }

    @Test
    void test_sender_en_send() {
        GeoService geoService = Mockito.mock(GeoService.class);
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);


        String enIp = "96.44.183.130";
        String expectedMessage = "Welcome";
        Location location = new Location("San Diego", Country.USA, "Alb", 10);

        Mockito.when(geoService.byIp(enIp)).thenReturn(location);
        Mockito.when(localizationService.locale(location.getCountry())).thenReturn("Welcome");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, enIp);

        String resultMessage = messageSender.send(headers);

        assertEquals(expectedMessage, resultMessage);
    }
}
