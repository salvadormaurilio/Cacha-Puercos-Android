package mariachi.com.cachapuercos.chat.data.cloud;

import mariachi.com.cachapuercos.chat.data.entity.CharEntity;
import mariachi.com.cachapuercos.chat.data.entity.ChatResponseEntity;
import mariachi.com.cachapuercos.common.data.cloud.ApiClient;
import mariachi.com.cachapuercos.common.data.cloud.ClientConstants;
import rx.Observable;

/**
 * 29/01/2017.
 */

public class ChatApiRest extends ApiClient<ChatApiService> {
  @Override protected Class<ChatApiService> getApiService() {
    return ChatApiService.class;
  }

  @Override protected String getBaseURL() {
    return ClientConstants.BASE_URL;
  }

  public Observable<ChatResponseEntity> sendMessage(CharEntity charEntity) {
   return apiService.sendMessage(charEntity);
  }
}
