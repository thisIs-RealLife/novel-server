package com.soa.novelcreatorcore.web.model.rq;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.soa.novelcreatorcore.web.model.rq.tg.WebAppChat;
import com.soa.novelcreatorcore.web.model.rq.tg.WebAppUser;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TgInitDataRq {
    @JsonProperty("query_id")
    private String queryId;
    private WebAppUser user;
    private WebAppUser receiver;
    private WebAppChat chat;
    @JsonProperty("chat_type")
    private String chatType;
    @JsonProperty("chat_instance")
    private String chatInstance;
    @JsonProperty("start_param")
    private String startParam;
    @JsonProperty("can_send_after")
    private Long canSendAfter;
    @JsonProperty("auth_date")
    private Long authDate;

    private String hash;
}
