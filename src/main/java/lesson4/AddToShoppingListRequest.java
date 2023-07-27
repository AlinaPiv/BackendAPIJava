package lesson4;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "item",
            "aisle",
            "parse"
    })
    @Data
    public class AddToShoppingListRequest {
        @JsonProperty("item")
        public String status;
        @JsonProperty("aisle")
        public String id;
        @JsonProperty("parse")
        public Boolean parse;
    }

