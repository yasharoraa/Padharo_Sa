package innovvapp.hack.tourism.Models;

/**
 * Created by Yash Arora on 15-03-2018.
 */

public class Models {

    private String Type;

    private String Name;

    private int startsNum;

    private boolean isOpen = true;

    private boolean isSaved = false;

    private int imageResource;

    private Integer number;


    public Models(String type, String name, int startsNum, boolean isOpen, boolean isSaved, int imageResource,Integer number) {
        Type = type;
        Name = name;
        this.startsNum = startsNum;
        this.isOpen = isOpen;
        this.isSaved = isSaved;
        this.number = number;
        this.imageResource = imageResource;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getStartsNum() {
        return startsNum;
    }

    public void setStartsNum(int startsNum) {
        this.startsNum = startsNum;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public boolean isSaved() {
        return isSaved;
    }

    public void setSaved(boolean saved) {
        isSaved = saved;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
