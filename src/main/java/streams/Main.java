package streams;

public class Main {
final static String PATH = "src/test/resources/user.dat";
    public static void main(String[] args) {
        UserDataSaver saver = new UserDataSaver();
        saver.saveUserData(PATH);

        UserDataReader reader = new UserDataReader();
        reader.readUserData(PATH);
    }
}
