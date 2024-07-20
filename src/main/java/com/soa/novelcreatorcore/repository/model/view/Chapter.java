package com.soa.novelcreatorcore.repository.model.view;

import lombok.*;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Chapter {
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private Integer index;
    @NonNull
    private Long novelId;
}
