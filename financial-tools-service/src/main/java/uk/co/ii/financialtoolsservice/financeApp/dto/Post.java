package uk.co.ii.financialtoolsservice.financeApp.dto;

import lombok.Data;

@Data
public class Post {
    private Integer id;
    private Integer userId;
    private String title;
    private String body;

}
