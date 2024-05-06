package com.logstream.compare.services;

import javax.json.Json;
import javax.json.JsonPatch;
import javax.json.JsonStructure;

import org.springframework.stereotype.Service;

@Service
public class CompareService {
    public JsonPatch compare(JsonStructure oldVersionReader, JsonStructure newVersionReader) {
        JsonPatch diff = Json.createDiff(oldVersionReader.asJsonObject(), newVersionReader.asJsonObject());
        return diff;
    }
}
