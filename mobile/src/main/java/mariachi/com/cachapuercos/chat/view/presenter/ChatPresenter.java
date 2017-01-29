package mariachi.com.cachapuercos.chat.view.presenter;

import mariachi.com.cachapuercos.chat.view.model.ChatModel;
import mariachi.com.cachapuercos.chat.view.viewmvp.ChatView;
import mariachi.com.cachapuercos.common.view.Presenter;

/**
 * 29/01/2017.
 */

public class ChatPresenter extends Presenter<ChatView> {

  @Override public void destroy() {

  }

  public void sendMessage(String message) {
    getView().showNewMessage(message, ChatModel.TYPE_SEND);
  }
}
