package academy.belhard;

import academy.belhard.entity.Pupil;
import academy.belhard.io.PupilsReader;
import academy.belhard.io.PupilsWriter;

import java.util.List;

public class PupilsBusinessLogic {

    public static List<Pupil> getAll() {
        return PupilsReader.read();
    }

    public static void addNew(Pupil newPupil) {
        List<Pupil> pupils = PupilsReader.read();

        pupils.add(newPupil);

        PupilsWriter.write(pupils);
    }
}
