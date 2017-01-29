package mariachi.com.cachapuercos.chat.view.activity;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.OnClick;
import java.util.ArrayList;
import java.util.List;
import mariachi.com.cachapuercos.R;
import mariachi.com.cachapuercos.chat.view.adapter.ChatAdapter;
import mariachi.com.cachapuercos.chat.view.model.ChatModel;
import mariachi.com.cachapuercos.chat.view.presenter.ChatPresenter;
import mariachi.com.cachapuercos.chat.view.viewmvp.ChatView;
import mariachi.com.cachapuercos.common.view.BaseActivity;

/**
 * 28/01/2017.
 */

public class ChatActivity extends BaseActivity implements ChatView {

  @BindView(R.id.list_chat) RecyclerView mListChat;
  @BindView(R.id.input_message) EditText mInputMessage;
  private ChatAdapter mAdapter;

  private ChatPresenter mChatPresenter;

  @Override protected int getLayout() {
    return R.layout.activity_chat;
  }

  @Override protected void initView() {
    super.initView();
    initializePresenter();
    initializeAdapter();
    initializeList();
  }

  private void initializePresenter() {
    mChatPresenter = new ChatPresenter();
    mChatPresenter.setView(this);
  }

  private void initializeAdapter() {
    mAdapter = new ChatAdapter(this);
  }

  private void initializeList() {
    mListChat.setLayoutManager(new LinearLayoutManager(this));
    mListChat.setAdapter(mAdapter);

    mAdapter.setAll(createDataDummy());
  }

  @OnClick(R.id.btn_send_message) public void sendMessage() {
    mChatPresenter.sendMessage(mInputMessage.getText().toString());
  }

  private List<ChatModel> createDataDummy() {
    List<ChatModel> chatModels = new ArrayList<>();

    chatModels.add(new ChatModel("Hola como estas?", ChatModel.TYPE_SEND));
    chatModels.add(new ChatModel("me esta multando por .... ", ChatModel.TYPE_SEND));
    chatModels.add(new ChatModel("No puede hacerlo por ... ", ChatModel.TYPE_RECEIVED));

    return chatModels;
  }

  @Override public Context getContext() {
    return this;
  }


  @Override public void showNewMessage(String message, int typeChat) {
    mAdapter.add(new ChatModel(message, typeChat));
    mListChat.smoothScrollToPosition(mAdapter.getItemCount());
  }

}
