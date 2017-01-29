package mariachi.com.cachapuercos.chat.view.viewmvp;

import mariachi.com.cachapuercos.common.view.Presenter;

/**
 * 29/01/2017.
 */

public interface ChatView extends Presenter.View {
  void showVoiceIcon();

  void showKeyBoardIcon();

  void clearInputMessage();

  void showNewMessage(String message, int typeChat);

  void showScreenForVoice();
}
