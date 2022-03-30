import java.util.ArrayList;

public class Animal {
    private String name, likesToPlay, furColor;
    private int codigo;
    public Animal(){

    }

    static ArrayList<Animal> listaAnimais = new ArrayList<Animal>();

    public Animal(int codigo, String name, String likesToPlay, String furColor) {
        this.codigo = codigo;
        this.name = name;
        this.likesToPlay = likesToPlay;
        this.furColor = furColor;
    }

    public int getCodigo() {return codigo;};

    public void setCodigo(int codigo){this.codigo = codigo;};

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
        return "Animal{" +
                "name='" + name + '\'' +
                ", likesToPlay='" + likesToPlay + '\'' +
                ", furColor='" + furColor + '\'' +
                ", codigo=" + codigo +
                '}';
    }
}
