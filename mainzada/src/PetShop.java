import java.util.Scanner;

public class PetShop {
    static  Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        principalMenu();
    }

    private static void principalMenu(){
        System.out.print("\n--- MENU PRINCIPAL ---" +
                "\n1 - Register animal;" +
                "\n2 - Edit animal;" +
                "\n3 - List animals;" +
                "\n4 - Remove animal;" +
                "\n5 - End system." +
                "\nDigite aqui: ");
        int option = sc.nextInt();
        switch (option){
            case 1 -> {
                registerAnimal();
                principalMenu();
            }
            case 2 -> {
                editAnimal();
                principalMenu();
            }
            case 3 -> {
                listAnimal();
                principalMenu();
            }
            case 4 -> {
                removeAnimal();
                principalMenu();
            }
            case 5 -> {
                System.exit(0);
            }
            default -> {
                System.out.println(option + ", Não é uma opção válida");
                principalMenu();
            }
        }
    }

    //Remove animal
    private static void removeAnimal() {
        int animalChosen = getType("--- Remove ---");
        int animalIndex = getAnimalIndex(animalChosen);
        if (animalIndex >= 0){
            switch (animalChosen){
                case 1 -> {
                    Dog.listDogs.remove(animalIndex);
                }
                case 2 -> {
                    Cat.listCats.remove(animalIndex);
                }
            }
        } else {
            System.out.println("Animal code not found!");
            removeAnimal();
        }
        if (animalIndex != -1){
            System.out.print("Animal have been removed!");
        }
    }

    //Edits
    private static void editAnimal(){
        int animalChosen = getType("--- Edit ---");
        int editChoice = 1;
        do {
            if (editChoice != 1 && editChoice != 2){
                System.out.println(editChoice + ", Não é uma opção válida!");
            }
            System.out.print("\n1 - Edit all attributes;" +
                    "\n2 - Edit 1 attibute." +
                    "\nType here: ");
            editChoice = sc.nextInt();
        } while (editChoice != 1 && editChoice != 2);

        switch (editChoice){
            case 1->{ editAllAnimal(animalChosen);}
            case 2->{ edit1Atb(animalChosen);}
        }

    };

    // Edit all attributes
    private static void editAllAnimal(int type){
        int animalIndex = getAnimalIndex(type);
        Animal.listaAnimais.set(animalIndex, collectAnimalData(type));
    }

    // Edit 1 attibute
    private static void edit1Atb(int type){
        int editChoice = editChoice(type);
        int animalIndex = getAnimalIndex(type);
        System.out.print("Type the new data: ");
       switch (editChoice){
           case 1 -> Animal.listaAnimais.get(animalIndex).setName(sc.next());
           case 2 -> Animal.listaAnimais.get(animalIndex).setLikesToPlay(sc.next());
           case 3 -> Animal.listaAnimais.get(animalIndex).setFurColor(sc.next());
       }
        if(type == 1){
            switch (editChoice){
                case 4 -> ((Dog) Animal.listaAnimais.get(animalIndex)).setBarksDistance(sc.nextInt());
                case 5 -> ((Dog) Animal.listaAnimais.get(animalIndex)).setStrength(sc.nextInt());
                case 6 -> ((Dog) Animal.listaAnimais.get(animalIndex)).setEyeColor(sc.next());
            }
        } else {
            switch (editChoice){
                case 4 -> ((Cat) Animal.listaAnimais.get(animalIndex)).setHoursSleeping(sc.nextInt());
                case 5 -> {
                    System.out.print("Does the cat have nails? 1 - y, 2 - n: ");
                    if(sc.nextInt() == 1){
                        ((Cat) Animal.listaAnimais.get(animalIndex)).setHaveNail((true));
                    } else {
                        ((Cat) Animal.listaAnimais.get(animalIndex)).setHaveNail((false));
                    }
                }
                case 6 -> ((Cat) Animal.listaAnimais.get(animalIndex)).setFoodLikes(sc.next());
            }
        }
    }

    private static int editChoice(int type){
        System.out.print("Escolha o atributo que deseja alterar:" +
                "\n1 - Name;" +
                "\n2 - What the animal likes to play;" +
                "\n3 - Animal's fur color;");
        switch (type){
            case 1 -> {
                System.out.println("\n4 - Bark distance (meters);"+
                        "\n5 - Strength (0-10);" +
                        "\n6 - Eye color.");
            }
            case 2 -> {
                System.out.println("\n4 - Hours that sleeps in a day;" +
                        "\n5 - Does the cat have nails? (1 - yes, 2 - no)" +
                        "\n6 - Edit the cat's favorite food.");
            }
        }
        System.out.print("Type here: ");
        return sc.nextInt();
    }

    private static int getAnimalIndex(int animalType){
        System.out.print("\nInsert animal's code: ");
        int animalCode = sc.nextInt();
        for (int i = 0; i < Animal.listaAnimais.size(); i++){
            if(Animal.listaAnimais.get(i).getCodigo() == animalCode){
                return i;
            }
        }
        return -1;
    }

    // Registers
    private static void registerAnimal(){
        int animalChosen = getType("--- Register ---");
        Animal.listaAnimais.add(collectAnimalData(animalChosen));
    }

    // List animals
    private static void listAnimal(){
        int animalChosen = getType("--- List ---");
        switch (animalChosen){
            case 1-> {
                Animal.listaAnimais.forEach(animal -> {
                    if(animal instanceof Dog){
                        System.out.println(animal);
                    }
                });
            }
            case 2-> {
                Animal.listaAnimais.forEach(animal -> {
                    if(animal instanceof Cat){
                        System.out.println(animal);
                    }
                });
            }
        }
    }

    //Data collects
    private static Animal collectAnimalData(int type){
        Animal animal = new Animal();
        System.out.print("Insert the following datas: " +
                "\nAnimal ID: ");
        int id = sc.nextInt();
        System.out.print("Name: ");
        String nome = sc.next();
        System.out.print("Likes to play with: ");
        String likesToPlay = sc.next();
        System.out.print("Fur color: ");
        String furColor = sc.next();

        if(type == 1){
            System.out.print("Bark distance (meters): ");
            int barksDistance = sc.nextInt();
            System.out.print("Strength (0-10): ");
            int strength = sc.nextInt();
            System.out.print("Eye color: ");
            String eyeColor = sc.next();
            return new Dog(id, nome, likesToPlay, furColor, barksDistance, strength, eyeColor);

        } else {
            System.out.print("Hours sleeping in a day: ");
            int hoursSleeping = sc.nextInt();
            int choose;
            boolean bChoose = false;
            do {
                System.out.print("Does the cat have nails? (1 - yes) (2 - no): ");
                choose = sc.nextInt();
                if (choose == 1) {
                    bChoose = true;
                }
            } while (choose != 1 && choose != 2);
            System.out.print("Insert the cat's favorite food: ");
            String favoriteFood = sc.next();
            return new Cat(id, nome, likesToPlay, furColor, hoursSleeping, bChoose, favoriteFood);
        }
    };

    //GetType (cat/dog)
    private static int getType(String title){
        int option;
        int i = 0;
        do {
            if(i != 0){
                System.out.println("Invalid option have been inserted!");
            }
            System.out.print("\n" + title +
                    "\n1 - Dog;" +
                    "\n2 - Cat." +
                    "\nType here: ");
            option = sc.nextInt();
            i++;
        } while(option != 1 && option != 2);
        return option;
    }

}
