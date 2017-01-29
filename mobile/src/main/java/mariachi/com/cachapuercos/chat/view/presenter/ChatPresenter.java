package mariachi.com.cachapuercos.chat.view.presenter;

import android.text.TextUtils;
import mariachi.com.cachapuercos.chat.view.model.ChatModel;
import mariachi.com.cachapuercos.chat.view.viewmvp.ChatView;
import mariachi.com.cachapuercos.common.view.Presenter;

/**
 * 29/01/2017.
 */

public class ChatPresenter extends Presenter<ChatView> {

  public static final int STATE_VOICE = 1;
  public static final int STATE_KEYBOARD = 2;

  private int stateChatMessage;

  public ChatPresenter() {
    stateChatMessage = STATE_VOICE;
  }

  public void changeStateText(String message) {
    if (TextUtils.isEmpty(message)) {
      stateChatMessage = STATE_VOICE;
      getView().showVoiceIcon();
    } else {
      stateChatMessage = STATE_KEYBOARD;
      getView().showKeyBoardIcon();
    }
  }

  public void sendMessage(String message) {

    if (stateChatMessage == STATE_VOICE) {
      getView().showScreenForVoice();
    } else {
      getView().clearInputMessage();
      getView().showNewMessage(message, ChatModel.TYPE_SEND);
    }
  }

  @Override public void destroy() {

  }

  public void sendMessageByVoice(String message) {
    getView().clearInputMessage();
    getView().showNewMessage(message, ChatModel.TYPE_SEND);
  }
}
