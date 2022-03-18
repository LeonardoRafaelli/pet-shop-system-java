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
//                removerAnimal();
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
    //Edits
    private static void editAnimal(){
        int animalChosen = getType("--- Edit ---");
        int editChoice = 1;
        do {
            if (editChoice != 1 && editChoice != 2){
                System.out.println(editChoice + ", Não é uma opção válida!");
            }
            System.out.println("\n1 - Edit all attributes;" +
                    "\n2 - Edit 1 attibute." +
                    "\nType here: ");
            editChoice = sc.nextInt();
        } while (editChoice != 1 && editChoice != 2);

        switch (animalChosen){
            case 1 -> {
                switch (editChoice){
                    case 1->{editAllDog();}
//                    case 2->{edit1Dog();}
                }
            }
        };
    };

    private static void editAllDog(){
        System.out.print("\nInsert animal's code: ");
        int animalCode = sc.nextInt();
        int animalIndex = getAnimalIndex(1, animalCode);

        Animal animal = collectAnimalData();
        Dog tDog = collectDogsData();
        Dog dog = new Dog(animal.getCodigo(), animal.getName(), animal.getLikesToPlay(), animal.getFurColor(), tDog.getBarksDistance(), tDog.getStrength(), tDog.getEyeColor());
        Dog.listDogs.add(dog);

    }

    private static int getAnimalIndex(int animalType, int animalCode){
        switch (animalType){
            case 1 -> {
                for(int i = 0; i < Dog.listDogs.size(); i++){
                    if(Dog.listDogs.get(i).getCodigo() == animalCode){
                        return i;
                    }
                }
            }
            case 2 -> {
                Cat.listCats.forEach(cat -> {
//                    if(cat.getCodigo() == animalCode){
                    System.out.println(cat.getCodigo());
                    System.out.println(Cat.listCats.indexOf(cat));
//                    }
                });
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
                Dog tDog = collectDogsData();
                Dog dog = new Dog(animal.getCodigo(), animal.getName(), animal.getLikesToPlay(), animal.getFurColor(), tDog.getBarksDistance(), tDog.getStrength(), tDog.getEyeColor());
                Dog.listDogs.add(dog);
            }
            case 2 -> {
                Cat tCat = collectCatsData();
                Cat cat = new Cat(animal.getCodigo(), animal.getName(), animal.getLikesToPlay(), animal.getFurColor(), tCat.getHoursSleeping(), tCat.isHaveNail(), tCat.getFoodLikes());
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
    private static Dog collectDogsData(){
        Dog dog = new Dog();
        System.out.print("Bark distance (meters): ");
        dog.setBarksDistance(sc.nextInt());
        System.out.print("Strength (0-10): ");
        dog.setStrength(sc.nextInt());
        System.out.print("Eye color: ");
        dog.setEyeColor(sc.next());
        return dog;
    };
    private static Cat collectCatsData(){
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
