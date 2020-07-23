package pl.zawadzki.polandcovidinfo.pojo;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "region",
    "infectedCount",
    "deceasedCount"
})
@Data
public class InfectedByRegion {

    @JsonProperty("region")
    public String region;
    @JsonProperty("infectedCount")
    public Integer infectedCount;
    @JsonProperty("deceasedCount")
    public Integer deceasedCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "InfectedByRegion{" +
                "region='" + region + '\'' +
                ", infectedCount=" + infectedCount +
                ", deceasedCount=" + deceasedCount +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
