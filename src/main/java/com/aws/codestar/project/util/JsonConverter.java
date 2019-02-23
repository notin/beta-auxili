package com.aws.codestar.project.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.logging.Logger;

public class JsonConverter
{
    private static ObjectMapper mapper = new ObjectMapper();

    public static String toJson(Object object)
    {
        String jsonInString = "";
        try
        {
            jsonInString = JsonConverter.mapper.writeValueAsString(object);
        } catch (Exception e)
        {
            Helper.logger.info(e.getMessage());
        }
        return jsonInString;
    }

    public static <T> T getResponse(Class<T> clazz, T response, String responce)
    {
        try
        {
            response = mapper.readValue(responce, clazz);
        } catch (Exception e)
        {
            Logger.getAnonymousLogger().info(e.getMessage());
        }
        return response;
    }
}
