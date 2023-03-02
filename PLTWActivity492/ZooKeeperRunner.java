package PLTWActivity492;
import java.util.ArrayList;

public class ZooKeeperRunner
{
  public static void hearTheAnimal(Animal animal)
  {
    animal.speak();
  }
  public static void main(String[] args)
  {
    ArrayList<Animal> animalList = new ArrayList<Animal>();
    Animal listAnimal = new Animal();
    Animal listBird = new Bird();
    Animal listDeer = new Deer();
    Animal listElephant = new Elephant();
    Animal listFeline = new Feline();
    Animal listGiraffe = new Giraffe();
    Animal listGorilla = new Gorilla();
    Animal listHippo = new Hippo();
    Animal listHooved = new Hooved();
    Animal listLion = new Lion();
    Animal listMonkey = new Monkey();
    Animal listOwl = new Owl();
    Animal listPenguin = new Penguin();
    Animal listPrimate = new Primate();
    Animal listTiger = new Tiger();

    animalList.add(listAnimal);
    animalList.add(listBird);
    animalList.add(listDeer);
    animalList.add(listElephant);
    animalList.add(listFeline);
    animalList.add(listGiraffe);
    animalList.add(listGorilla);
    animalList.add(listHippo);
    animalList.add(listHooved);
    animalList.add(listLion);
    animalList.add(listMonkey);
    animalList.add(listOwl);
    animalList.add(listPenguin);
    animalList.add(listPrimate);
    animalList.add(listTiger);

    for (Animal animal : animalList)
    {
      //animal.speak();
      hearTheAnimal(animal);
    }
    
    Elephant elephant = new Elephant("leaves, grasses, roots", false, 60.0);
    elephant.trumpet();

    elephant.eat();
    elephant.isNocturnal();
    elephant.getLifeSpan();

    System.out.println();

    Elephant elephant2 = new Elephant();
    elephant2.eat();
    elephant2.isNocturnal();
    elephant2.getLifeSpan();

    System.out.println();

    Tiger tiger = new Tiger("meat", true, 17.0);
    tiger.swim();
    tiger.huntAlone();

    tiger.roar();
    tiger.growl();

    tiger.eat();
    tiger.isNocturnal();
    tiger.getLifeSpan();

    System.out.println();

    Tiger tiger2 = new Tiger();
    tiger2.eat();
    tiger2.isNocturnal();
    tiger2.getLifeSpan();

    System.out.println();

    Gorilla gorilla = new Gorilla();

    gorilla.grunt();

    System.out.println();

    Giraffe giraffe = new Giraffe("leaves", false, 25.0);
    
    giraffe.eat();

    System.out.println();

    Hippo hippo = new Hippo("grass", false, 25.0);
    hippo.eat();

    System.out.println();

    Penguin penguin = new Penguin();
    penguin.fish();
    Owl owl = new Owl();
    owl.hunt();
    Owl owl2 = new Owl("mice, insects", true, 4.0);
    owl2.eat();
  }
}