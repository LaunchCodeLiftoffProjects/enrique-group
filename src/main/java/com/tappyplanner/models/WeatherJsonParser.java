package com.tappyplanner.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/* Giovanni Brex created
 * on 1/9/2022 inside
 * the package -
 * com.tappyplanner.models */
public class WeatherJsonParser {


    private static ObjectMapper objectMapper = getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper() {

        return new ObjectMapper();
    }

    public static JsonNode parse(String src) throws IOException {

        return objectMapper.readTree(src);
    }

    public static <A> A fromJson(JsonNode node , Class<A> clazz) throws JsonProcessingException {

        return objectMapper.treeToValue(node, clazz);
    }


}
