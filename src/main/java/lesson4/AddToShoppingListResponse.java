package lesson4;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "aisles",
            "cost",
            "startDate",
            "endDate",
                })
    @Data
    public class AddToShoppingListResponse {
        @JsonProperty("aisles")
        private List<Object> aisles;
        @JsonProperty("cost")
        private String cost;
        @JsonProperty("startDate")
        private Integer startDate;
        @JsonProperty("endDate")
        private Integer endDate;
        @JsonProperty("id")
        private List<Integer> id = new ArrayList<Integer>();


        @JsonInclude(JsonInclude.Include.NON_NULL)
        /*@JsonPropertyOrder({
                "aisle",
                "items"
        })*/
        @Data
        public static class Aisles {

            @JsonProperty("aisle")
            private String aisle;
            @JsonProperty("items")
            private List<Items> items;
            @JsonIgnore
            private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

            @Data
            public static class Items {

                @JsonProperty("id")
                private List<Integer> id = new ArrayList<Integer>();
                @JsonProperty("name")
                private String name;
                @JsonIgnore
                private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
            }
        }
    }




