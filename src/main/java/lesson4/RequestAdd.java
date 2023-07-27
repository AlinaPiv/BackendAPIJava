package lesson4;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "item",
            "aisle",
            "parse"
    })

@Data
    public class RequestAdd {

        @JsonProperty("item")
        private String item;
        @JsonProperty("aisle")
        private String aisle;
        @JsonProperty("parse")
        private Boolean parse;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    }

