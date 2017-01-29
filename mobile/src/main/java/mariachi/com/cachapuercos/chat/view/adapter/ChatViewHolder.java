package mariachi.com.cachapuercos.chat.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import mariachi.com.cachapuercos.R;
import mariachi.com.cachapuercos.chat.view.model.ChatModel;
import mariachi.com.cachapuercos.chat.view.presenter.ChatPresenter;

/**
 * 28/01/2017.
 */

public class ChatViewHolder extends RecyclerView.ViewHolder {

  @BindView(R.id.label_text_chat) TextView mLabelTextChat;
  private ChatPresenter mChatPresenter;
  private ChatModel mChatModel;

  public ChatViewHolder(View itemView, ChatPresenter chatPresenter) {
    super(itemView);
    ButterKnife.bind(this, itemView);
    mChatPresenter = chatPresenter;
  }

  public void render(ChatModel chatModel) {
    mChatModel = chatModel;
    mLabelTextChat.setText(chatModel.getText());
  }

  @Optional @OnClick(R.id.play_message) public void playMessage() {
    mChatPresenter.playMessage(mChatModel.getText());
  }
}
