package com.omt.temp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.TreeSet;

public class CreateInsertScripts {

	public static void main(String[] args) throws Exception {
		creatOutput();
	}

	public static void creatOutput() throws Exception {

		File f = new File("Insert_Into_TEMP_FSI_BOPIS_MISSING_SERIAL_NO_REP.txt");
		FileWriter fos = new FileWriter(f);
		BufferedWriter bos = new BufferedWriter(fos);

		File fin = new File("Processed_INC061994169.txt");
		FileReader fins = new FileReader(fin);
		BufferedReader bis = new BufferedReader(fins);
		TreeSet<String> keySet = new TreeSet<>();

		String line = null;

		while ((line = bis.readLine()) != null) {
			String lines[] = line.split("~");

			String key = lines[0] + "-" + lines[1] + "-" + lines[2] + "-" + lines[3] + "-" + lines[4] + "-" + lines[5];

			if (keySet.contains(key)) {
				continue;
			}

			keySet.add(key);

			if (lines[0].trim().length() == 0) {
				System.out.println("Missing serial number for :" + lines[1]);
			} else {
				String insertScript = "Insert into TEMP_FSI_BOPIS_MISSING_SERIAL (ID," + "WEB_ORDER_NUMBER,"
						+ "SALES_ORDER_NUMBER," + "DELIVERY_DOC," + "SERIAL_NUMBER)"
						+ " values (temp_bopis_seq.nextval,'" + lines[1] + "','" + lines[2] + "','" + lines[5] + "','"
						+ lines[0] + "');\n";
				bos.write(insertScript);

			}
		}

		bos.flush();
		bos.close();
	}

}
