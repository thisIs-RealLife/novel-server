package com.soa.novelcreatorcore.repository.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Chapter {
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private Integer index;
    @NonNull
    private Long novelId;
}
