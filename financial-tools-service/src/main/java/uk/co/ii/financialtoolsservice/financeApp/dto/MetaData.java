package uk.co.ii.financialtoolsservice.financeApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetaData {

    @JsonProperty("1. Information")
    public String information;
    @JsonProperty("2. Symbol")
    public String symbol;
    @JsonProperty("3. Last Refreshed")
    public String refreshed;
    @JsonProperty("4. Interval")
    public String interval;
    @JsonProperty("5. Output Size")
    public String outputSize;
    @JsonProperty("6. Time Zone")
    public String timeZone;
}
