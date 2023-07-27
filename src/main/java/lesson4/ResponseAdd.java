package lesson4;


import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "id",
            "name",
            "measures",
            "usages",
            "usageRecipeIds",
            "pantryItem",
            "aisle",
            "cost",
            "ingredientId"
            })
@Data
    public class ResponseAdd {
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("measures")
        private Measures measures;
        @JsonProperty("usages")
        private List<Object> usages;
        @JsonProperty("usageRecipeIds")
        private List<Object> usageRecipeIds;
        @JsonProperty("pantryItem")
        private Boolean pantryItem;
        @JsonProperty("aisle")
        private String aisle;
        @JsonProperty("cost")
        private Double cost;
        @JsonProperty("ingredientId")
        private Integer ingredientId;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    //  @JsonPropertyOrder( {"amount"})

@Data
        public static class Measures {

        @JsonProperty("original")
        private Original original;
        @JsonProperty("metric")
        private Metric metric;
        @JsonProperty("us")
        private Us us;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    //  @JsonPropertyOrder( {"amount"})
    // @JsonPropertyOrder( {"unit"})
    @Data
    public static class Original {

        @JsonProperty("amount")
        private Double amount;
        @JsonProperty("unit")
        private String unit;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    }


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({"amount, unit"})
    // @JsonPropertyOrder( {"unit"})
    @Data


    public static class Metric {

        @JsonProperty("amount")
        private Double amount;
        @JsonProperty("unit")
        private String unit;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
    }


    @JsonInclude(JsonInclude.Include.NON_NULL)
    //  @JsonPropertyOrder( {"amount"})
    // @JsonPropertyOrder( {"unit"})
    @Data
    public static class Us {

        @JsonProperty("amount")
        private Double amount;
        @JsonProperty("unit")
        private String unit;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();


    }

}





