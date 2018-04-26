package innovvapp.hack.tourism.Models;

/**
 * Created by Yash Arora on 17-03-2018.
 */

public class SecondModel {


    private String Name;



    private boolean isOpen = true;

    private boolean isSaved = false;

    private int imageResource;



    private int firstStar;

    private int secondStar;

    private int thirdStar;

    private int fourthStar;

    private Integer number;

    private double totalRatings;

    public SecondModel(String name, boolean isOpen, boolean isSaved, int imageResource, int firstStar, int secondStar, int thirdStar, int fourthStar, Integer number,double totalRatings) {
        Name = name;
        this.isOpen = isOpen;
        this.isSaved = isSaved;
        this.imageResource = imageResource;
        this.firstStar = firstStar;
        this.secondStar = secondStar;
        this.thirdStar = thirdStar;
        this.fourthStar = fourthStar;
        this.number = number;
        this.totalRatings = totalRatings;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public boolean isOpen() {
        return isOpen;
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

    public int getFirstStar() {
        return firstStar;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setFirstStar(int firstStar) {
        this.firstStar = firstStar;
    }

    public int getSecondStar() {
        return secondStar;
    }

    public void setSecondStar(int secondStar) {
        this.secondStar = secondStar;
    }

    public int getThirdStar() {
        return thirdStar;
    }

    public void setThirdStar(int thirdStar) {
        this.thirdStar = thirdStar;
    }

    public int getFourthStar() {
        return fourthStar;
    }

    public void setFourthStar(int fourthStar) {
        this.fourthStar = fourthStar;
    }

    public double getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(double totalRatings) {
        this.totalRatings = totalRatings;
    }
}
