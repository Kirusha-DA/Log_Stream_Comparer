package com.logstream.compare.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.Data;

@Data
public class NewAndOldVersionRequest {
    @JsonProperty("oldVersion")
    private JsonNode newVersion;

    @JsonProperty("newVersion")
    private JsonNode oldVersion;
}
