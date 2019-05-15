public class LoadableImage implements Loadable, StillImage{

  private int width;
  private int height;
  private int[][] b;
  
  public LoadableImage(){
  }
  
  public void setX(int[][] d){ //creates a list to be maintained
    this.b = d;
  }
  
  public LoadableImage(int w, int h){
    this.width = w;
    this.height = h; //constructor for width and height
  }
  
  public boolean matches(int[] data){
    //checks to see if file is an image
    if(data[0] == 55){
      return true;}
    return false;
  }
  
  public LoadableImage load(int[] data) throws LoadException{
      if(data.length < 3 ){ //Checks if there is width or length
        throw new LoadException("No width or length values");
      }
      if(data[1] * data[2] + 3 > data.length || data[1] * data[2] + 3 < data.length){ //CHecks if there is enough or too much
        throw new LoadException("Not enough data or too much data");
      }
      for(int i = 3; i < data.length; i++){ //Checks to see if the data is within the range 0-999
        if(data[i] < 0 || data[i] > 999){
          throw new LoadException("Data out of Bounds");
        }
      }
      LoadableImage z = new LoadableImage(data[1], data[2]);
      int f = 3; // initial index for values
      int[][] d = new int[data[1]][data[2]];
      for(int i = 0; i < data[2]; i++){
        for(int j = 0; j < data[1]; j++){
          d[j][i] = data[f]; //goes through length and width values and adds them to the new list at that specific point
          f++;
        }
      }
      z.setX(d); //sets d = z
      return z;
  }
  
  public int width(){ //returns width
    return this.width;
  }
  
  public int height(){ //returns height
    return this.height;
  }
  
  public int getPixel(int x, int y){
      return this.b[x][y]; //returns the pixel at a point
  }
  
}
  
      