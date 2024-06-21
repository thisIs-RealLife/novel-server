package com.soa.novelcreatorcore.web.model.rq;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.soa.novelcreatorcore.helper.JsonHelper;
import com.soa.novelcreatorcore.web.model.rq.tg.WebAppChat;
import com.soa.novelcreatorcore.web.model.rq.tg.WebAppUser;
import lombok.*;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TgInitDataRq {
    private final static String QUERY_ID = "queryId";
    private final static String USER = "user";
    private final static String RECEIVER = "receiver";
    private final static String CHAT = "chat";
    private final static String CHAT_TYPE = "chat_type";
    private final static String CHAT_INSTANCE = "chat_instance";
    private final static String START_PARAM = "start_param";
    private final static String CAN_SEND_AFTER = "can_send_after";
    private final static String AUTH_DATE = "auth_date";
    private final static String HASH = "hash";

    @JsonIgnore
    private Map<String, String> rowInitData;

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

    public TgInitDataRq(@NonNull Map<String, String> params)  {
        setRowInitData(params);
        setQueryId(params.get(QUERY_ID));
        setUser(JsonHelper.fromJson(params.get(USER), WebAppUser.class));
        setReceiver(JsonHelper.fromJson(params.get(RECEIVER), WebAppUser.class));
        setChat(JsonHelper.fromJson(params.get(CHAT), WebAppChat.class));
        setChatType(params.get(CHAT_TYPE));
        setChatInstance(params.get(CHAT_INSTANCE));
        setStartParam(params.get(START_PARAM));
        setCanSendAfter(Long.valueOf(params.get(CAN_SEND_AFTER)));
        setAuthDate(Long.valueOf(params.get(AUTH_DATE)));
        setHash(params.get(HASH));
    }
}
