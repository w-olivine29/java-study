package ch26generic.section1necessity.step4practice;

public class AnimalMain {
    public static void main(String[] args) {

        Sheep sheep = new Sheep("구름이", 30);
        Wolf wolf = new Wolf("늑대1", 50);

        Box<Sheep> sheepBox = new Box<>();
        sheepBox.set(sheep);
        Sheep findSheep = sheepBox.get();
        System.out.println("findSheep = " + findSheep);


        Box<Wolf> wolfBox = new Box<>();
        wolfBox.set(wolf);
        Wolf findWolf = wolfBox.get();
        System.out.println("findWolf = " + findWolf);


        Box<Animal> animalBox = new Box<>();
        animalBox.set(sheep);
        Animal findAnimal1 = animalBox.get();
        System.out.println("findAnimal1 = " + findAnimal1);

        animalBox.set(wolf);
        Animal findAnimal2 = animalBox.get();
        System.out.println("findAnimal2 = " + findAnimal2);

    }
}
