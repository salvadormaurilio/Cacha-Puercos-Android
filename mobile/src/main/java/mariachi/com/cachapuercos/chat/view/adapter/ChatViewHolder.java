package mariachi.com.cachapuercos.chat.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import mariachi.com.cachapuercos.R;
import mariachi.com.cachapuercos.chat.view.model.ChatModel;

/**
 * 28/01/2017.
 */

public class ChatViewHolder extends RecyclerView.ViewHolder {

  @BindView(R.id.label_text_chat) TextView mLabelTextChat;

  public ChatViewHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }

  public void render(ChatModel chatModel) {
    mLabelTextChat.setText(chatModel.getText());
  }
}
