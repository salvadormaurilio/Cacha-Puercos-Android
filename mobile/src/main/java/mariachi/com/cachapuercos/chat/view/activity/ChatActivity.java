package mariachi.com.cachapuercos.chat.view.activity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import mariachi.com.cachapuercos.R;
import mariachi.com.cachapuercos.chat.data.cloud.ChatApiRest;
import mariachi.com.cachapuercos.chat.domain.SendMessage;
import mariachi.com.cachapuercos.chat.view.adapter.ChatAdapter;
import mariachi.com.cachapuercos.chat.view.model.ChatModel;
import mariachi.com.cachapuercos.chat.view.presenter.ChatPresenter;
import mariachi.com.cachapuercos.chat.view.viewmvp.ChatView;
import mariachi.com.cachapuercos.common.view.BaseActivity;
import mariachi.com.cachapuercos.ui.activitys.MapsActivity;
import mariachi.com.cachapuercos.ui.activitys.informationactivity.InformationActivity;
import mariachi.com.cachapuercos.ui.activitys.payactivity.PayActivity;

/**
 * 28/01/2017.
 */

public class ChatActivity extends BaseActivity implements ChatView {

  @BindView(R.id.btn_send_message) FloatingActionButton mBtnSendMessage;
  @BindView(R.id.list_chat) RecyclerView mListChat;
  @BindView(R.id.input_message) EditText mInputMessage;
  @BindView(R.id.toolbar) Toolbar toolbar;
  private ChatAdapter mAdapter;
  private final int REQ_CODE_SPEECH_INPUT = 100;

  private ChatPresenter mChatPresenter;

  private TextToSpeech textToSpeech;

  @Override protected int getLayout() {
    return R.layout.activity_chat;
  }

  @Override protected void initView() {
    super.initView();
    initializePresenter();
    initializeAdapter();
    initializeList();
    initializeToolbar();
    initializeTextToSpeech();
  }

  private void initializeTextToSpeech() {
    textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
      @Override public void onInit(int status) {
        if (status != TextToSpeech.ERROR) {
          textToSpeech.setLanguage(new Locale("es", "MX"));
        }
      }
    });
  }

  private void initializeToolbar() {
    setSupportActionBar(toolbar);
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.action_info:
        startActivity(new Intent(this, InformationActivity.class));
        return true;
      case R.id.action_pay:
        startActivity(new Intent(this, MapsActivity.class));
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }

  private void initializePresenter() {

    mChatPresenter = new ChatPresenter(new SendMessage(new ChatApiRest()));
    mChatPresenter.setView(this);
  }

  private void initializeAdapter() {
    mAdapter = new ChatAdapter(this, mChatPresenter);
  }

  private void initializeList() {
    mListChat.setLayoutManager(new LinearLayoutManager(this));
    mListChat.setAdapter(mAdapter);

    //mAdapter.setAll(createDataDummy());
  }

  private List<ChatModel> createDataDummy() {
    List<ChatModel> chatModels = new ArrayList<>();

    chatModels.add(new ChatModel("Hola como estas?", ChatModel.TYPE_SEND));
    chatModels.add(new ChatModel("me esta multando por .... ", ChatModel.TYPE_SEND));
    chatModels.add(new ChatModel("No puede hacerlo por ... ", ChatModel.TYPE_RECEIVED));

    return chatModels;
  }

  @OnTextChanged(R.id.input_message) public void ohoal(Editable message) {
    mChatPresenter.changeStateText(message.toString());
  }

  @OnClick(R.id.btn_send_message) public void sendMessage() {
    mChatPresenter.sendMessage(mInputMessage.getText().toString());
  }

  @Override public Context getContext() {
    return this;
  }

  @Override public void showVoiceIcon() {
    mBtnSendMessage.setImageResource(R.drawable.ic_keyboard_voice_black_24dp);
  }

  @Override public void showKeyBoardIcon() {
    mBtnSendMessage.setImageResource(R.drawable.ic_chevron_right_black_24dp);
  }

  @Override public void clearInputMessage() {
    mInputMessage.setText("");
  }

  @Override public void showNewMessage(String message, int typeChat) {
    mAdapter.add(new ChatModel(message, typeChat));
    mListChat.smoothScrollToPosition(mAdapter.getItemCount());
  }

  @Override public void showScreenForVoice() {
    Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
    intent.putExtra(RecognizerIntent.EXTRA_PROMPT, getString(R.string.speech_prompt));
    try {
      startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
    } catch (ActivityNotFoundException a) {
      Toast.makeText(getApplicationContext(), getString(R.string.speech_not_supported),
          Toast.LENGTH_SHORT).show();
    }
  }

  @Override public void showSoundMessage(String message) {
    textToSpeech.speak(message, TextToSpeech.QUEUE_FLUSH, null);
  }

  @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    switch (requestCode) {
      case REQ_CODE_SPEECH_INPUT: {
        if (resultCode == RESULT_OK && null != data) {
          ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
          mChatPresenter.sendMessageToServer(result.get(0));
        }
        break;
      }
    }
  }

  @Override protected void onStop() {
    super.onStop();
    textToSpeech.stop();
    textToSpeech.shutdown();
  }
}
