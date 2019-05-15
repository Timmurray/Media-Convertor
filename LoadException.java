//Exception for the Loadable object
public class LoadException extends Exception{
  private String msg;
  public LoadException(String msg){
    super(msg);
  }
}