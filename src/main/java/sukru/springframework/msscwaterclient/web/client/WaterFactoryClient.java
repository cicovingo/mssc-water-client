package sukru.springframework.msscwaterclient.web.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import sukru.springframework.msscwaterclient.web.model.WaterDto;

import java.net.URI;
import java.util.UUID;

@ConfigurationProperties(prefix = "sfg.water-factory", ignoreUnknownFields = false)
@Component
public class WaterFactoryClient {

    public final String WATER_PATH_V1 = "/api/v1/water/";
    private String apihost;

    private final RestTemplate restTemplate;

    public WaterFactoryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public WaterDto getWaterById(UUID uuid){
        return restTemplate.getForObject(apihost + WATER_PATH_V1 + uuid.toString(), WaterDto.class);
    }

    public URI saveWaterDto(WaterDto dto){
        return restTemplate.postForLocation(apihost + WATER_PATH_V1, dto);
    }

    public void updateWater(UUID uuid, WaterDto dto){
        restTemplate.put(apihost + WATER_PATH_V1 + "/" + uuid.toString(), dto);
    }

    public void deleteWater(UUID uuid){
        restTemplate.delete(apihost + WATER_PATH_V1 + "/" + uuid);
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}
