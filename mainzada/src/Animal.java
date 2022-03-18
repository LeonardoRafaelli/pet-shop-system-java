public class Animal {
    private String name, likesToPlay, furColor;

    public Animal(){

    }

    public Animal(String name, String likesToPlay, String furColor) {
        this.name = name;
        this.likesToPlay = likesToPlay;
        this.furColor = furColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLikesToPlay() {
        return likesToPlay;
    }

    public void setLikesToPlay(String likesToPlay) {
        this.likesToPlay = likesToPlay;
    }

    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    @Override
    public String toString() {
        return "Animals{" +
                "name='" + name + '\'' +
                ", likesToPlay='" + likesToPlay + '\'' +
                ", furColor='" + furColor + '\'' +
                '}';
    }
}
