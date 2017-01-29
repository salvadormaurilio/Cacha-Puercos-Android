package mariachi.com.cachapuercos.chat.view.presenter;

import android.text.TextUtils;
import java.text.Normalizer;
import mariachi.com.cachapuercos.chat.data.entity.ChatResponseEntity;
import mariachi.com.cachapuercos.chat.domain.SendMessage;
import mariachi.com.cachapuercos.chat.view.model.ChatModel;
import mariachi.com.cachapuercos.chat.view.viewmvp.ChatView;
import mariachi.com.cachapuercos.common.view.Presenter;
import rx.Subscriber;

/**
 * 29/01/2017.
 */

public class ChatPresenter extends Presenter<ChatView> {

  private static final int STATE_VOICE = 1;
  private static final int STATE_KEYBOARD = 2;

  private int stateChatMessage;

  private SendMessage mSendMessage;

  public ChatPresenter(SendMessage sendMessage) {
    mSendMessage = sendMessage;
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
      sendMessageToServer(message);
    }
  }

  public void sendMessageToServer(String message) {

    String string = Normalizer.normalize(message, Normalizer.Form.NFD);
    string = string.replaceAll("[^\\p{ASCII}]", "");

    getView().clearInputMessage();
    getView().showNewMessage(message, ChatModel.TYPE_SEND);


    mSendMessage.setTextChat(string);
    mSendMessage.execute(new SendMessageSubscriber());
  }


  public void playMessage(String message) {
    getView().showSoundMessage(message);
  }

  @Override public void destroy() {

  }
  private class SendMessageSubscriber extends Subscriber<ChatResponseEntity> {
    @Override public void onCompleted() {

    }

    @Override public void onError(Throwable e) {
      e.printStackTrace();
    }

    @Override public void onNext(ChatResponseEntity chatResponseEntity) {
      getView().showNewMessage(chatResponseEntity.getResults().getText(), ChatModel.TYPE_RECEIVED);
    }
  }
}
