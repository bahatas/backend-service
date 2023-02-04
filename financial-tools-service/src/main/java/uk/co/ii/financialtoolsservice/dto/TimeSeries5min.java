package uk.co.ii.financialtoolsservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeSeries5min {

    private List<Object> timeSeriesData;



}
