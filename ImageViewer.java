public abstract class ImageViewer implements Player{
  
  public ImageViewer(){
  }
  public abstract void view(StillImage img); //abstract method view
  public boolean canPlay(Loadable l){
    if(l instanceof StillImage){ //checks to see if l is an object with StillImage type
      return true;
    }
    return false;
  }
  public void play(Loadable l){
    StillImage x = (StillImage) l; //casts l as a StillImage
    view(x);
  }
}