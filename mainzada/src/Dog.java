import java.util.ArrayList;

public class Dog extends Animal {
    private int barksDistance, strength;
    private String eyeColor;

    static ArrayList<Dog> listDogs = new ArrayList<Dog>();

    public Dog() {

    }

    public Dog(int codigo, String name, String likesToPlay, String furColor, int barksDistance, int strength, String eyeColor) {
        super(codigo, name, likesToPlay, furColor);
        this.barksDistance = barksDistance;
        this.strength = strength;
        this.eyeColor = eyeColor;
    }

    public int getBarksDistance() {
        return barksDistance;
    }

    public void setBarksDistance(int barksDistance) {
        this.barksDistance = barksDistance;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    @Override
    public String toString() {
        return super.toString() + " Dog{" +
                "barksDistance=" + barksDistance +
                ", strength=" + strength +
                ", eyeColor='" + eyeColor + '\'' +
                '}';
    }
}
