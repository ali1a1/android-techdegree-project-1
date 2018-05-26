import java.util.Random;

public class Jar {
  private String mItemName;
  private int mMaxItemsAllowed;
  
  public Jar(String itemName, int maxItemsAllowed) {
    mItemName = itemName;
    mMaxItemsAllowed = maxItemsAllowed;
  }
  
  
  public String getItemName() {
    return mItemName;
  }
  
  public int getMaxItemsAllowed() {
    return mMaxItemsAllowed;
  }
    
  
  public int fill() {
    Random random = new Random();
    return 1 + random.nextInt(mMaxItemsAllowed);
  }
  
  
  
 
  
}