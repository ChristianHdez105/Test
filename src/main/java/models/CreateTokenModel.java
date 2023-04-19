package models;

import lombok.Data;

@Data
public class CreateTokenModel {
    private String clientID;
    private String clientSecret;
}
