import java.util.ArrayList;

public class Cat extends Animal {
    private int hoursSleeping;
    private boolean haveNail;
    private String foodLikes;

    static ArrayList<Cat> listCats = new ArrayList<Cat>();

    public Cat(){

    }

    public Cat(int codigo, String name, String likesToPlay, String furColor, int hoursSleeping, boolean haveNail, String foodLikes) {
        super(codigo, name, likesToPlay, furColor);
        this.hoursSleeping = hoursSleeping;
        this.haveNail = haveNail;
        this.foodLikes = foodLikes;
    }

    public int getHoursSleeping() {
        return hoursSleeping;
    }

    public void setHoursSleeping(int hoursSleeping) {
        this.hoursSleeping = hoursSleeping;
    }

    public boolean isHaveNail() {
        return haveNail;
    }

    public void setHaveNail(boolean haveNail) {
        this.haveNail = haveNail;
    }

    public String getFoodLikes() {
        return foodLikes;
    }

    public void setFoodLikes(String foodLikes) {
        this.foodLikes = foodLikes;
    }

    @Override
    public String toString() {
        return super.toString() + " Cat{" +
                "hoursSleeping=" + hoursSleeping +
                ", haveNail=" + haveNail +
                ", foodLikes='" + foodLikes + '\'' +
                '}';
    }
}
