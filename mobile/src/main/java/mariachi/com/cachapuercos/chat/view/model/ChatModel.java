package mariachi.com.cachapuercos.chat.view.model;

/**
 * 28/01/2017.
 */

public class ChatModel {

  public static final int TYPE_RECEIVED = 1;
  public static final int TYPE_SEND = 2;

  private int typeChat;
  private String text;

  public ChatModel(String text, int typeChat) {
    this.text = text;
    this.typeChat = typeChat;
  }

  public int getTypeChat() {
    return typeChat;
  }

  public void setTypeChat(int typeChat) {
    this.typeChat = typeChat;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
