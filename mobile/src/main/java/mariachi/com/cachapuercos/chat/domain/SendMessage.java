package mariachi.com.cachapuercos.chat.domain;

import mariachi.com.cachapuercos.chat.data.cloud.ChatApiRest;
import mariachi.com.cachapuercos.chat.data.entity.CharEntity;
import mariachi.com.cachapuercos.common.domain.UseCase;
import rx.Observable;

/**
 * 29/01/2017.
 */

public class SendMessage extends UseCase {

  private ChatApiRest mChatApiRest;
  private String textChat;

  public SendMessage(ChatApiRest chatApiRest) {
    mChatApiRest = chatApiRest;
  }

  public void setTextChat(String textChat) {
    this.textChat = textChat;
  }

  @Override protected Observable buildObservableUseCase() {
    return mChatApiRest.sendMessage(new CharEntity(textChat));
  }
}
