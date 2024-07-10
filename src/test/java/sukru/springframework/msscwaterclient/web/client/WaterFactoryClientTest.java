package sukru.springframework.msscwaterclient.web.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sukru.springframework.msscwaterclient.web.model.CustomerDto;
import sukru.springframework.msscwaterclient.web.model.WaterDto;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class WaterFactoryClientTest {

    @Autowired
    WaterFactoryClient client;

    @Test
    void getWaterById() {
        WaterDto waterDto = client.getWaterById(UUID.randomUUID());
        assertNotNull(waterDto);
    }

    @Test
    void testSaveNewWater() {
        WaterDto waterDto = WaterDto.builder().waterName("Water").build();

        URI uri = client.saveWaterDto(waterDto);
        assertNotNull(uri);

        System.out.println(uri.toString());
    }

    @Test
    void testUpdateWater() {
        WaterDto waterDto = WaterDto.builder().waterName("Water").build();

        client.updateWater(UUID.randomUUID(), waterDto);
    }

    @Test
    void testDeleteWater() {
        client.deleteWater(UUID.randomUUID());
    }

    @Test
    void getCustomerById() {
        CustomerDto waterDto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(waterDto);
    }

    @Test
    void testSaveNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("test 1").build();

        URI uri = client.saveCustomerDto(customerDto);
        assertNotNull(uri);

        System.out.println(uri.toString());
    }

    @Test
    void testUpdateCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("test 2").build();

        client.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void testDeleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}
