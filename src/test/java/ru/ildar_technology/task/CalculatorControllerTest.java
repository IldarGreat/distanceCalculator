package ru.ildar_technology.task;

import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CalculatorControllerTest extends BaseApplicationTest {
    @Test
    public void calculateDistanceBetweenExistingCities_thenReturns200() throws Exception {
        String fromCityName = "Moscow";
        String toCityName = "Samara";
        String type = "Crowflight";
        String otherType = "Distance Matrix";
        mockMvc.perform(get("/api/calculate/" + type + "/" + fromCityName + "/" + toCityName))
                .andExpect(status().is(200));

        mockMvc.perform(get("/api/calculate/" + otherType + "/" + fromCityName + "/" + toCityName))
                .andExpect(status().is(200));

        String notExistingType = "dsadsa";
        mockMvc.perform(get("/api/calculate/" + otherType + "/" + fromCityName + "/" + toCityName))
                .andExpect(status().is(200));
    }

    @Test
    public void calculateDistanceBetweenExistingCitiesButNotExistingTYpe_thenReturns404() throws Exception {
        String fromCityName = "Moscow";
        String toCityName = "Samara";
        String notExistingType = "dsadsa";

        mockMvc.perform(get("/api/calculate/" + notExistingType + "/" + fromCityName + "/" + toCityName))
                .andExpect(status().is(404));
    }
}
