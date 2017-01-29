package mariachi.com.cachapuercos.chat.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import mariachi.com.cachapuercos.R;
import mariachi.com.cachapuercos.chat.view.model.ChatModel;
import mariachi.com.cachapuercos.chat.view.presenter.ChatPresenter;

/**
 * 28/01/2017.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatViewHolder> {

  private LayoutInflater mInflater;
  private List<ChatModel> mViewModelList;
  private ChatPresenter mChatPresenter;

  public ChatAdapter(Context context, ChatPresenter chatPresenter) {
    mInflater = LayoutInflater.from(context);
    mChatPresenter = chatPresenter;
    mViewModelList = new ArrayList<>();
  }

  public void addAll(List<ChatModel> viewModelList) {
    int previousSize = mViewModelList.size();
    mViewModelList.addAll(viewModelList);
    notifyItemRangeInserted(previousSize, viewModelList.size());
  }

  public void add(ChatModel viewModel) {
    mViewModelList.add(viewModel);
    notifyItemInserted(mViewModelList.size() - 1);
  }

  public void setAll(List<ChatModel> viewModelList) {
    mViewModelList = viewModelList;
    notifyDataSetChanged();
  }

  @Override public int getItemViewType(int position) {
    return mViewModelList.get(position).getTypeChat();
  }

  @Override public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View viewItem = null;

    switch (viewType) {
      case ChatModel.TYPE_RECEIVED:
        viewItem = mInflater.inflate(R.layout.item_chat_received, parent, false);
        break;
      case ChatModel.TYPE_SEND:
        viewItem = mInflater.inflate(R.layout.item_chat_send, parent, false);
        break;
    }

    return new ChatViewHolder(viewItem, mChatPresenter);
  }

  @Override public void onBindViewHolder(ChatViewHolder holder, int position) {
    holder.render(mViewModelList.get(position));
  }

  @Override public int getItemCount() {
    return mViewModelList.size();
  }
}
