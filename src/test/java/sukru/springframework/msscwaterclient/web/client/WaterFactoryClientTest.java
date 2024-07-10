package sukru.springframework.msscwaterclient.web.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sukru.springframework.msscwaterclient.web.model.WaterDto;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class WaterFactoryClientTest {

    @Autowired
    WaterFactoryClient waterFactoryClient;

    @Test
    void getWaterById() {
        WaterDto waterDto = waterFactoryClient.getWaterById(UUID.randomUUID());
        assertNotNull(waterDto);
    }

    @Test
    void testSaveNewWater() {
        WaterDto waterDto = WaterDto.builder().waterName("Water").build();

        URI uri = waterFactoryClient.saveWaterDto(waterDto);
        assertNotNull(uri);

        System.out.println(uri.toString());
    }

    @Test
    void testUpdateWater() {
        WaterDto waterDto = WaterDto.builder().waterName("Water").build();

        waterFactoryClient.updateWater(UUID.randomUUID(), waterDto);
    }

    @Test
    void testDeleteWater() {
        waterFactoryClient.deleteWater(UUID.randomUUID());
    }
}
