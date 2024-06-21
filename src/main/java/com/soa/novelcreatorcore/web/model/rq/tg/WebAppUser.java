package com.soa.novelcreatorcore.web.model.rq.tg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebAppUser {
    private Long id;

    @JsonProperty("is_bot")
    private Boolean isBot;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private String username;

    @JsonProperty("language_code")
    private String languageCode;

    @JsonProperty("is_premium")
    private Boolean isPremium;

    @JsonProperty("added_to_attachment_menu")
    private Boolean addedToAttachmentMenu;

    @JsonProperty("allows_write_to_pm")
    private Boolean allowsWriteToPm;

    @JsonProperty("photo_url")
    private String photo_url;
}
