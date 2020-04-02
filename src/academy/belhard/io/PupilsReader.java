package academy.belhard.io;

import academy.belhard.entity.Pupil;
import academy.belhard.entity.Sex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PupilsReader {

    public static List<Pupil> read() {

        List<Pupil> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(IOConstants.FILENAME))) {
            reader.readLine();

            String csvString;
            while ((csvString = reader.readLine()) != null) {
                Pupil pupil;
                pupil = toObject(csvString);


                result.add(pupil);
            }
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }

        return result;
    }

    private static Pupil toObject(String csvString) {
        String[] fields = csvString.split(IOConstants.DELIMITER);

        String firstName = fields[0];
        String lastName = fields[1];
        Sex sex = Sex.valueOf(fields[2]);
        double averageMark;
        try {
            averageMark = Double.parseDouble(fields[3]);
        } catch (NumberFormatException e) {
            return new Pupil(firstName, lastName, sex);
        }


        return new Pupil(firstName, lastName, sex, averageMark);
    }

}