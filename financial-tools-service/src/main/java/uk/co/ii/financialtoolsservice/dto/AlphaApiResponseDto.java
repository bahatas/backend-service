package uk.co.ii.financialtoolsservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlphaApiResponseDto {

    @JsonProperty("Meta Data")
    private MetaData metaData;
    private TimeSeries5min series;


}
