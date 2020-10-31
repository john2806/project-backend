package com.backend.apiserver.response;

import com.backend.apiserver.utils.MessageUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseMessage {

    InvalidAccessError("99", "api.error.response.invalid.access")
    , DefaultInternalServerMessageError("100", "api.error.response.default.internal.message.error")
    , DuplicatedUsername("101", "api.error.response.duplicated.username")
    , UserRoleNotFound("102", "api.error.response.user.role.not.found")
    , CardIdNotFound("103", "api.error.response.card.id.not.found")
    , AuthenticateUserFailed("104", "api.error.response.authenticate.user.failed")
    , CreateCardSuccessfully("105", "api.success.response.create.card.successfully")
    , UpdateCardSuccessfully("106", "api.success.response.update.card.successfully")
    , DeleteCardSuccessfully("107", "api.success.response.delete.card.successfully")
    , RegisterUserSuccessfully("108", "api.success.response.create.user.successfully")
    ;
    private String code;
    private String messageId;

    public String getMessage(Object... params) {
        String message = MessageUtils.getMessage(this.messageId, params);
        return message;
    }
}