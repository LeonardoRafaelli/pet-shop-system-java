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

        switch (animalChosen){
            case 1 -> {
                switch (editChoice){
                    case 1->{ editAllAnimal(1);}
                    case 2->{ edit1Atb(1);}
                }
            }
            case 2 -> {
                switch (editChoice){
                    case 1 -> { editAllAnimal(2);}
                    case 2->{ edit1Atb(2);}
                }
            }
        };
    };

    // Edit all attributes
    private static void editAllAnimal(int type){
        int animalIndex = getAnimalIndex(type);

        Animal animal = collectAnimalData();
        switch (type){
            case 1 -> {
                Dog dog = collectDogsData(animal);
                Dog.listDogs.set(animalIndex, dog);
            }
            case 2 -> {
                Cat cat = collectCatsData(animal);
                Cat.listCats.set(animalIndex, cat);
            }
        }
    }

    // Edit 1 attibute
    private static void edit1Atb(int type){
        int editChoice = editChoice(type);
        int animalIndex = getAnimalIndex(type);
        System.out.print("Type the new data: ");
        switch (type){
            case 1 -> {
                switch (editChoice) {
                    case 1 -> {
                        Dog.listDogs.get(animalIndex).setName(sc.next());
                    }
                    case 2 -> {
                        Dog.listDogs.get(animalIndex).setLikesToPlay(sc.next());
                    }
                    case 3 -> {
                        Dog.listDogs.get(animalIndex).setFurColor(sc.next());
                    }
                    case 4 -> {
                        Dog.listDogs.get(animalIndex).setBarksDistance(sc.nextInt());
                    }
                    case 5 -> {
                        Dog.listDogs.get(animalIndex).setStrength(sc.nextInt());
                    }
                    case 6 -> {
                        Dog.listDogs.get(animalIndex).setEyeColor(sc.next());
                    }
                }
            }
                case 2 -> {
                switch (editChoice) {
                    case 1 -> {
                        Cat.listCats.get(animalIndex).setName(sc.next());
                    }
                    case 2 -> {
                        Cat.listCats.get(animalIndex).setLikesToPlay(sc.next());
                    }
                    case 3 -> {
                        Cat.listCats.get(animalIndex).setFurColor(sc.next());
                    }
                    case 4 -> {
                        Cat.listCats.get(animalIndex).setHoursSleeping(sc.nextInt());
                    }
                    case 5 -> {
                        int choose;
                        do {
                            System.out.print("Does the cat have nails? (1 - yes) (2 - no): ");
                            choose = sc.nextInt();
                            switch (choose) {
                                case 1 -> {
                                    Cat.listCats.get(animalIndex).setHaveNail(true);
                                }
                                case 2 -> {
                                    Cat.listCats.get(animalIndex).setHaveNail(false);
                                }
                            }
                        } while (choose != 1 && choose != 2);
                    }
                    case 6 -> {
                        Cat.listCats.get(animalIndex).setFoodLikes(sc.next());
                    }
                }
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
        switch (animalType){
            case 1 -> {
                for(int i = 0; i < Dog.listDogs.size(); i++){
                    if(Dog.listDogs.get(i).getCodigo() == animalCode){
                        return i;
                    }
                }
            }
            case 2 -> {
                for(int i = 0; i < Cat.listCats.size(); i++){
                    if(Cat.listCats.get(i).getCodigo() == animalCode){
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    // Registers
    private static void registerAnimal(){
        Animal animal = collectAnimalData();
        int animalChosen = getType("--- Register ---");
        switch (animalChosen){
            case 1 -> {
                Dog dog = collectDogsData(animal);
                Dog.listDogs.add(dog);
            }
            case 2 -> {
                Cat cat = collectCatsData(animal);
                Cat.listCats.add(cat);
            }
        }
    }

    // List animals
    private static void listAnimal(){
        int animalChosen = getType("--- List ---");
        switch (animalChosen){
            case 1-> {
                Dog.listDogs.forEach(dog -> { System.out.println(dog.toString()); });
            }
            case 2-> {
                Cat.listCats.forEach(cat -> { System.out.println(cat.toString()); });
            }
        }
    }

    //Data collects
    private static Animal collectAnimalData(){
        Animal animal = new Animal();
        System.out.print("Insert the following datas: " +
                "\nAnimal ID: ");
        animal.setCodigo(sc.nextInt());
        System.out.print("Name: ");
        animal.setName(sc.next());
        System.out.print("Likes to play with: ");
        animal.setLikesToPlay(sc.next());
        System.out.print("Fur color: ");
        animal.setFurColor(sc.next());
        return animal;

    };
    private static Dog collectDogsData(Animal animal){
        Dog dog = new Dog();
        System.out.print("Bark distance (meters): ");
        dog.setBarksDistance(sc.nextInt());
        System.out.print("Strength (0-10): ");
        dog.setStrength(sc.nextInt());
        System.out.print("Eye color: ");
        dog.setEyeColor(sc.next());
        dog.setCodigo(animal.getCodigo());
        dog.setName(animal.getName());
        dog.setLikesToPlay(animal.getLikesToPlay());
        dog.setFurColor(animal.getFurColor());
        return dog;
    };
    private static Cat collectCatsData(Animal animal){
        Cat cat = new Cat();
        System.out.print("Hours sleeping in a day: ");
        cat.setHoursSleeping(sc.nextInt());
        int choose;
        do {
            System.out.print("Does the cat have nails? (1 - yes) (2 - no): ");
            choose = sc.nextInt();
            switch (choose) {
                case 1 -> {
                    cat.setHaveNail(true);
                }
                case 2 -> {
                    cat.setHaveNail(false);
                }
            }
        } while (choose != 1 && choose != 2);
        System.out.print("Insert the cat's favorite food: ");
        cat.setFoodLikes(sc.next());
        cat.setCodigo(animal.getCodigo());
        cat.setName(animal.getName());
        cat.setLikesToPlay(animal.getLikesToPlay());
        cat.setFurColor(animal.getFurColor());
        return cat;
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
