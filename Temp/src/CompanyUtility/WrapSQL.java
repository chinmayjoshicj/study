package CompanyUtility;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.stream.Stream;

public class WrapSQL {

	private static final String ORACLE_BIN = "C:\\ProgramFiles\\Oracle_Home\\BIN";
	private static final String TEMPLATE = ORACLE_BIN + File.separator + "WRAP INAME=\"{0}\" ONAME=\"{0}.plb\"";

	public static void main(String[] args) {

		String path = "D:\\Sources\\12.3_CORE_SUPPORT\\BE\\database\\SQL\\rdpks_gen_sys_type.sql";
		File tmpFile = new File(path);
		wrapFile(tmpFile);
	}

	public static void wrapFile(File file) {

		if (file.isFile()) {
			String cmd = MessageFormat.format(TEMPLATE, file.getAbsolutePath());
			String wrapResult = hostExecute(cmd);
			System.out.println(file.getAbsolutePath() + ":" + wrapResult);
		} else if (file.isDirectory()) {
			Stream.of(file.listFiles()).parallel().forEach(WrapSQL::wrapFile);
		}
	}

	public static String hostExecute(String cmd) {

		String status = "SUCCESS";
		BufferedReader buffRead = null;
		try {
			Process proc = Runtime.getRuntime().exec(cmd);
			buffRead = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			buffRead.lines().forEach(System.out::println);
		} catch (Exception e) {
			System.out.println("FAILED: "+cmd);
			status = "FAILURE";
		}
		return status;
	}
}