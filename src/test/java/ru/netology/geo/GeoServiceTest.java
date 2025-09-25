package ru.netology.geo;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.assertNull;

public class GeoServiceTest {

    @Test
    void test_location_by_ip() {

        GeoService geoService = new GeoServiceImpl();
        Location location = geoService.byIp("100.97.213.94");
        assertNull(location);

    }

}
