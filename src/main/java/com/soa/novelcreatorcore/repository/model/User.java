package com.soa.novelcreatorcore.repository.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    @NonNull
    private String login;
    private String email;
    @NonNull
    private String password;
    @NonNull
    private Long roleId;
}
