package serialization;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person("Olya", 24, new Pet("Pushok"));

        Serializator serializator = new Serializator();
        serializator.serialize(person);

        Person person2 = serializator.deserialize();
        System.out.println("My name is " + person2.getName()+"."+" I am " + person2.getAge() + " years old. " + "My pet has name " + person2.getPet().getName());
    }
}
