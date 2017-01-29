package mariachi.com.cachapuercos.chat.data.cloud;

import mariachi.com.cachapuercos.chat.data.entity.CharEntity;
import mariachi.com.cachapuercos.chat.data.entity.ChatResponseEntity;
import mariachi.com.cachapuercos.common.data.cloud.ClientConstants;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 29/01/2017.
 */

public interface ChatApiService {

  @POST(ClientConstants.EndPointApi.SEND_CHAT) Observable<ChatResponseEntity> sendMessage(
      @Body CharEntity charEntity);
}
