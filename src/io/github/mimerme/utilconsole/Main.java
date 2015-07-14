package io.github.mimerme.utilconsole;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;

public class Main {

	static String s = null;
	public static final String RELEASE_NAME = "NICKS";
	public static final String DEVELOPER_RELEASE_NAME = "Andros (Mimerme) Yang";
	public static final String VERSION_NAME = "v.0.55b";
	public static final Map<String, String> env = System.getenv();

	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("Running Utility Console [" + RELEASE_NAME + "] : "
				+ "[" + DEVELOPER_RELEASE_NAME + "]");
		System.out.println("VERSION: " + VERSION_NAME);

		if(args.length < 1){
			return;
		}

		if(args[0].equals("dwn")){
			//file structure
			//MASTER BRANCH ROOT
			//	|
			//	--release FOLDER
			//		|
			//		--release.jar
			if(args.length != 3){
				System.out.println("USAGE ERROR!");
				System.out.println("============");
				System.out.println("dwn [GITHUB URL WITH BACKSLASH] "
						+ "[LOCAL NAME TO BE SAVED AS]");
				return;
			}
			String releaseURL = args[1] + "/release.jar";
			System.out.println("Downloading release from " + releaseURL);

			String fileName = args[2] + ".jar"; //Currently only supports .jars and only Java
			URL link = new URL(releaseURL); //The file that you want to download

			//Code to download
			InputStream in = new BufferedInputStream(link.openStream());
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int n = 0;
			while (-1!=(n=in.read(buf)))
			{
				out.write(buf, 0, n);
			}
			System.out.print('>');
			out.close();
			in.close();
			byte[] response = out.toByteArray();
			new File(env.get("UTILS_PATH") + "\\" + args[2]).mkdirs();
			FileOutputStream fos = new FileOutputStream(env.get("UTILS_PATH") + "\\" + args[2] + "\\"+ fileName);
			fos.write(response);
			fos.close();
			//End download code

			System.out.println("==|Finished application download|==");

			//-----------------------------------------------------------

			releaseURL = args[1] + "/release.bat";
			System.out.println("Downloading configuration from " + releaseURL);

			fileName = args[2] + ".bat";
			link = new URL(releaseURL); //The file that you want to download

			//Code to download
			in = new BufferedInputStream(link.openStream());
			out = new ByteArrayOutputStream();
			buf = new byte[1024];
			n = 0;
			while (-1!=(n=in.read(buf)))
			{
				out.write(buf, 0, n);
			}
			System.out.print('>');
			out.close();
			in.close();
			response = out.toByteArray();
			new File(env.get("UTILS_PATH") + "\\" + args[2]).mkdirs();
			fos = new FileOutputStream(env.get("UTILS_PATH") + "\\" + args[2] + "\\"+ fileName);
			fos.write(response);
			fos.close();
			//End download code

			System.out.println("==|Finished configuration download|==");
			System.out.println("--------------------------------------");
			//Removed because it does not support multiple OS's easily
/*			System.out.println("==|Adding to PATH|==");
*/
			/*Process p = Runtime.getRuntime().exec("cmd /c set PATH=%PATH%;" 
					+ env.get("UTILS_PATH") + "\\" + args[2] + "\\"+ fileName);
			
			p.waitFor();		
			Runtime.getRuntime().exec("cmd /c set PATH=%PATH%;" 
					+ env.get("UTILS_PATH") + "\\" + args[2]);

			System.out.println("All files should be stored in " + env.get("UTILS_PATH"));*/

		}
		else if(args[0].equals("run")){

			if(args.length != 2){
				System.out.println("USAGE ERROR!");
				System.out.println("============");
				System.out.println("run [MODULE NAME] ");	
				return;
			}

			String path = env.get("UTILS_PATH")  +"\\" + args[1] + "\\" + args[1] + ".jar";
			File f = new File(path);
			if(!f.exists()) {
				System.out.println("Module specified could not be found");
				return;
			}

			//Only runs jar files
			//TODO: Run batch/bash scripts

			StringBuffer sb = new StringBuffer();
			Process p;

			p = Runtime.getRuntime()
					.exec("cmd /c java -jar " + path + " ");
			p.waitFor();


			BufferedReader reader = 
					new BufferedReader(new InputStreamReader(p.getInputStream()));
			
			

			String line = "";			
			while ((line = reader.readLine())!= null) {
				sb.append(line + "\n");
			}
		}
	}

	static String[] mapToStringArray(Map<String, String> map) {
		final String[] strings = new String[map.size()];
		int i = 0;
		for (Map.Entry<String, String> e : map.entrySet()) {
			strings[i] = e.getKey() + '=' + e.getValue();
			i++;
		}
		return strings;
	}

}
