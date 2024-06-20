package com.soa.novelcreatorcore.repository.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String login;
    private String email;
    private String password;
    private Long roleId;
}
