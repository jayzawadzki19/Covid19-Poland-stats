
package pl.zawadzki.polandcovidinfo.pojo;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "infected",
    "deceased",
    "infectedByRegion",
    "sourceUrl",
    "lastUpdatedAtApify",
    "readMe"
})
@Data
public class Infections {

    @JsonProperty("infected")
    public Integer infected;
    @JsonProperty("deceased")
    public Integer deceased;
    @JsonProperty("infectedByRegion")
    public List<InfectedByRegion> infectedByRegion = null;
    @JsonProperty("sourceUrl")
    public String sourceUrl;
    @JsonProperty("lastUpdatedAtApify")
    public String lastUpdatedAtApify;
    @JsonProperty("readMe")
    public String readMe;
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
        return "Infections{" +
                "infected=" + infected +
                ", deceased=" + deceased +
                ", infectedByRegion=" + infectedByRegion +
                ", sourceUrl='" + sourceUrl + '\'' +
                ", lastUpdatedAtApify='" + lastUpdatedAtApify + '\'' +
                ", readMe='" + readMe + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
