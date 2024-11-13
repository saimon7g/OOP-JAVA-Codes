public class Animal {
    private String name;
    private int age;
    Animal(){
    };


    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }



}
class Bird extends Animal{

}
class Mammal extends Animal{
    void printBloodType(){
        System.out.print( "Warm-Blooded!");
    }
}
class Reptile extends Animal{

}
class Fish extends Animal{

}
class Arachnid extends Animal{

}

class Albatross extends Bird{
    super(name,age);

}
class Dog extends Mammal{
    super (name,age);

}
class FruitBat extends Mammal{
    super (name,age);
}
class Platypus extends Mammal{
    super (name,age);
}
class Platypus extends Mammal{
    super (name,age);
}
class Human extends Mammal{
    super (name,age);
}
class EasternBrownSnake extends Reptile{
    super (name,age);
}
class GreatWhiteShark extends Fish{
    super (name,age);

}
class RedBackSpider extends Arachnid{
    super (name,age);

}