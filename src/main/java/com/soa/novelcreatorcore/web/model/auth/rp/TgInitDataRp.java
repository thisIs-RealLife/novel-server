package com.soa.novelcreatorcore.web.model.auth.rp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TgInitDataRp {
    private String token;
}
