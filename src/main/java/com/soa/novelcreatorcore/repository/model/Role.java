package com.soa.novelcreatorcore.repository.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    private Long id;
    private RoleName roleName;
}
