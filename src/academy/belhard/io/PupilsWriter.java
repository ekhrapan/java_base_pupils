package academy.belhard.io;

import academy.belhard.entity.Pupil;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PupilsWriter {

    private static final String[] headers = {"First name", "Last name", "Sex", "Average mark"};

    public static void write(List<Pupil> pupils) {
        String headersString = renderHeaders();

        try (FileWriter writer = new FileWriter(IOConstants.FILENAME)) {
            writer.write(headersString);

            for (Pupil pupil : pupils) {
                String pupilCsv = toCsvString(pupil);
                writer.write(pupilCsv);
            }

            System.out.println("Запись выполнена!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String renderHeaders() {
        return String.join(IOConstants.DELIMITER, headers) + "\n";
    }

    private static String toCsvString(Pupil pupil) {
        return pupil.getFirstName() + IOConstants.DELIMITER +
                pupil.getLastName() + IOConstants.DELIMITER +
                pupil.getSex() + IOConstants.DELIMITER +
                pupil.getAverageMark() + "\n";
    }
}