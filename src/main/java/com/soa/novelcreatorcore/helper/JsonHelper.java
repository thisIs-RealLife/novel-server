package com.soa.novelcreatorcore.helper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.lang.Nullable;

public class JsonHelper {
    private static final ObjectMapper SERIALIZATION_MAPPER;
    private static final ObjectMapper DESERIALIZATION_MAPPER;

    private static final ObjectWriter WRITER;
    private static final ObjectReader READER;

    static {
        SERIALIZATION_MAPPER = new ObjectMapper();
        SERIALIZATION_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        SERIALIZATION_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        WRITER = SERIALIZATION_MAPPER.writer();

        DESERIALIZATION_MAPPER = new ObjectMapper();
        DESERIALIZATION_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        READER = DESERIALIZATION_MAPPER.reader();
    }

    /**
     * проверяет наличие полей ТОЛЬКО по первому уровню вложенности
     * даже если поле будет null то все равно оно будет учитываться как существующее
     * в сигнатуре объекта
     * {
     * "code": "RQ00030",
     * "message": "Согласие на выполнение платежа",
     * "status": null, <------ СЧИТАЕТСЯ ЧТО ПОЛЕ ЕСТЬ!
     * "originalTrxId": "A003610425360300b4ubOp6511E4F998",
     * "agentRefundRequestId": "3842ca282aea11e88feca860b60304d5",
     * "opkcRefundRequestId": "A003610425360300b4ubOp6511E4565"
     * }
     *
     * @param str    строка JSON из запроса
     * @param fields связка полей по которой нужно идентифицировать объект
     * @return если все поля есть то true, в ином случае false
     */
    public static boolean containsAllFieldsWithoutNested(String str, String... fields) {
        ObjectNode jsonNodes = JsonHelper.fromJson(str, ObjectNode.class);
        if (fields.length == 0) {
            return false;
        }
        for (String field : fields) {
            if (jsonNodes.get(field) == null) {
                return false;
            }
        }
        return true;
    }

    public static String toJson(Object obj) throws JsonProcessingException {
        if (obj == null) {
            return null;
        }
        return WRITER.writeValueAsString(obj);
    }

    @Nullable
    public static <T> T fromJson(String json, Class<T> valueType) {
        if (json == null || json.isEmpty()) {
            return null;
        }
        try (JsonParser jParser = DESERIALIZATION_MAPPER.getFactory().createParser(json)) {
            return READER.readValue(jParser, valueType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T fromJson(String json, TypeReference<T> valueType) {
        if (json == null || json.isEmpty()) {
            return null;
        }
        try (JsonParser jParser = DESERIALIZATION_MAPPER.getFactory().createParser(json)) {
            return READER.readValue(jParser, valueType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
