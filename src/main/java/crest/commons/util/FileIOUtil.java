/**
 * 
 */
package crest.commons.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * the file I/O operation
 * 
 * @author Bingo
 * @since 2013-12-28
 * @version 1.0
 */
public class FileIOUtil {

	/**
	 * read the CSV file File
	 * 
	 * @param path
	 * @return
	 */
	public static ArrayList<String> readCSVFile(String path) {

		ArrayList<String> data = new ArrayList<String>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));

			String line = null;
			int index = 0;
			while ((line = reader.readLine()) != null) {
					data.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}
}
