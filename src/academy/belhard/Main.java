package academy.belhard;

import academy.belhard.entity.Pupil;
import academy.belhard.entity.Sex;

public class Main {

    public static void main(String[] args) {
        System.out.println(PupilsBusinessLogic.getAll());

        Pupil newPupil = new Pupil("Kostya", "Lomov", Sex.MALE, 8.2);

        PupilsBusinessLogic.addNew(newPupil);

        System.out.println(PupilsBusinessLogic.getAll());

    }
}
