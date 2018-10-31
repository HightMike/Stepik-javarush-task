import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        Animal[] animalM1 = { new Animal("Cat"), new Animal("Dog"), new Animal("Elephant"),
                new Animal("Cock"), new Animal("Bull"), new Animal("Ant"),
                new Animal("Tentecles"), new Animal("Worm")};
        ByteArrayOutputStream bai = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bai);
        oos.writeInt(animalM1.length); //из задания
        for (int i = 0; i < animalM1.length; i++) {
            oos.writeObject(animalM1[i]); //сериализация объектов, запсывает отдельные объекты, поэтому и считывать нужно отдельные объекты

        }
        oos.flush();
        oos.close();
        //byte[] bb = bai.toByteArray();
        //Animal[] arr;


//        ByteArrayInputStream ttt = new ByteArrayInputStream(bb);
//        try (ObjectInputStream ois = new ObjectInputStream(ttt))
//        {
//            //t = ois.readInt();
//            arr = (Animal[]) ois.readObject();
//        }
//        catch (Exception u) {
//            throw new IllegalArgumentException(u);
//        }

        //Animal[] animalM2 = new Animal[animalM1.length];
        Animal[] animalM2 = deserializeAnimalArray(bai.toByteArray());
        for (int i = 0; i < animalM2.length; i++) {
            System.out.printf("%d. %s \n", i+1, animalM2[i].getName());
        }

        //ByteArrayInputStream bai = new ByteArrayInputStream();
//        try (ObjectInputStream ois = new ObjectInputStream(oos)
//        {
//            animalM2 = (Animal[]) ois.readObject();
//        }
//        catch(Exception ex){
//
//            System.out.println(ex.getMessage());
//        }
        //Animal[] animalM2 = deserializeAnimalArray(bai.toByteArray());
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {

        Animal[] arr;
        ByteArrayInputStream ttt = new ByteArrayInputStream(data);

        try (ObjectInputStream ois = new ObjectInputStream(ttt))
        {
            int b = ois.readInt(); // записываем в переменную размер
            arr = new Animal[b];
            for (int t=0; t<b; t++) {
                arr[t] = (Animal) ois.readObject(); // считываем пообъектно
            }
            ois.close();
            ttt.close();

        }
        catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
        catch (ClassCastException e) {
            throw new IllegalArgumentException(e);
        }
        return arr;
    }



}

class Animal implements Serializable {
    private final String name;

    public Animal(String name) { //конструктор
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }
    public String getName() { return name; }

}
