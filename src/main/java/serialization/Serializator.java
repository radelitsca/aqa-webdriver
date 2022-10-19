package serialization;

import java.io.*;

public class Serializator {
    private static final File FILE = new File("person.dat");

    public boolean serialize(Person person) {
        boolean flag = false;

        try (FileOutputStream fileOutput = new FileOutputStream(FILE);
             ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)) {
            objectOutput.writeObject(person);
            System.out.println("Person has been serialized");
            flag = true;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return flag;
    }

    public Person deserialize() throws IOException, ClassNotFoundException {
        Person person = null;
        FileInputStream inputFile = new FileInputStream(FILE);
        ObjectInputStream inputObject = new ObjectInputStream(inputFile);

        person = (Person) inputObject.readObject();

        System.out.println("Person has been deserialized");
        return person;
    }
}
