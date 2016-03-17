import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;


public class GenericFileManager {

    @SuppressWarnings("unchecked")
    private static <E> E createValue(String value, Class<E> clazz) {
        if (clazz == Integer.class)
            return (E) Integer.valueOf(value);

        if (clazz == Double.class)
            return (E) Double.valueOf(value);

        ////////////////////////////////////////////////////////////////////////
        // Implementations for Other cases
        // ...
        ////////////////////////////////////////////////////////////////////////

        // Default String
        return (E) value;
    }

    @SuppressWarnings("unchecked")
    public static <E extends Number> E[][] loadCsv(final String pathFile, final String delimeter, Class<E> clazz) {

        E[][] out = null; // Return
        FileInputStream inputStream = null;
        BufferedReader reader = null;

        try {
            inputStream = new FileInputStream(pathFile);
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line = reader.readLine();
            String[] params = line.split(delimeter);

            final int rows = Integer.parseInt(params[0].trim());
            final int cols = Integer.parseInt(params[1].trim());

            out = (E[][]) Array.newInstance(clazz, rows, cols);
            int row = 0;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(delimeter);

                for (int col = 0; col < cols; col++) {
                    out[row][col] = createValue(values[col].trim(), clazz);
                }
                row++;
            }

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            try {
                reader.close();
                inputStream.close();
            } catch (IOException e) {
            }
        }
        return out;
    }
}

