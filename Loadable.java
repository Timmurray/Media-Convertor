//methods meant to be used in other classes
public interface Loadable {
  public boolean matches(int[] data);
  public Loadable load(int[] data) throws LoadException;
}
