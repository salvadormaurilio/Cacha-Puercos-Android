package mariachi.com.cachapuercos.common.data.cloud;

/**
 * Constantes para conectarse al API de la aplicación.
 *
 * @see <p>Para más información ver la documentación del Api.</p>
 */
public class ClientConstants {

  /**
   * Url base del Api.
   */
  public static final String BASE_URL = "https://bot2la.herokuapp.com";

  /**
   * Rutas de acceso al Api.
   */
  public static final class EndPointApi {
    public static final String SEND_CHAT = "/api";
  }

  /**
   * Paths del Api.
   */
  public static final class Path {
    public static final String USER_NAME = "user_name";
  }

  /**
   * Headers del Api.
   */
  public static final class Header {
    public static final String AUTHORIZATION = "Authorization";
  }

  /**
   * Querys del Api.
   */
  public class Query {
    public static final String SEARCH = "search";
    public static final String OFFSET = "offset";
    public static final String DESTINATION = "destination";
    public static final String ORIGIN = "origin";
    public static final String STOP = "stop";
  }
}
