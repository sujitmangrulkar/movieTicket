package com.bookmyshow.api.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class JwtResponse
{
    private String jwtToken;
    private String username;

}
