package sukru.springframework.msscwaterclient.web.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sukru.springframework.msscwaterclient.web.model.WaterDto;

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
}
