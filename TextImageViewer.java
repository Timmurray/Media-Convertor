public class TextImageViewer extends ImageViewer{
  private TextImageViewer x;
  private final char[] vals = {' ', '.', 'o', 'O', '@'}; //list of characters
  
  public TextImageViewer(){ //Default constructor
  }
  public char getChar(int i){
    return vals[(int)( i*(vals.length/1000.0) )]; 
  }
  public void view(StillImage img){
    for(int i = 0; i < img.height(); i++){ //for loop for the hieght of the pixel
      for(int j = 0; j < img.width(); j++){ //for loop to get the width value of the pixel
        System.out.print(getChar(img.getPixel(j,i))); //prints the pixel at the point
        if(img.width() - 1 == j){
          System.out.println(); //creates a new line if the end of the file is reached
        }
      }
      
    }
  }
}
  
    
    