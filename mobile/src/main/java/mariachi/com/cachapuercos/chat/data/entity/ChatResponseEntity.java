package mariachi.com.cachapuercos.chat.data.entity;

/**
 * 29/01/2017.
 */

public class ChatResponseEntity {

  private Results results;

  public ChatResponseEntity(Results results) {
    this.results = results;
  }

  public Results getResults() {
    return results;
  }

  public void setResults(Results results) {
    this.results = results;
  }

  public class Results{
    private boolean formulario;
    private String subject;
    private String text;

    public Results(boolean formulario, String subject, String text) {
      this.formulario = formulario;
      this.subject = subject;
      this.text = text;
    }

    public boolean isFormulario() {
      return formulario;
    }

    public void setFormulario(boolean formulario) {
      this.formulario = formulario;
    }

    public String getSubject() {
      return subject;
    }

    public void setSubject(String subject) {
      this.subject = subject;
    }

    public String getText() {
      return text;
    }

    public void setText(String text) {
      this.text = text;
    }
  }

}
