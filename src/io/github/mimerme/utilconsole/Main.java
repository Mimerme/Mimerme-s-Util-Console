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
		System.out.println("\nRunning Utility Console [" + RELEASE_NAME + "] : "
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
				System.out.println("\nUSAGE ERROR!");
				System.out.println("============");
				System.out.println("dwn [GITHUB URL WITH BACKSLASH] "
						+ "[LOCAL NAME TO BE SAVED AS]");
				return;
			}
			String releaseURL = args[1] + "/release.jar?raw=true";
			System.out.println("\nDownloading release from " + releaseURL);

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
			System.out.print('\n');
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

			releaseURL = args[1] + "/release.bat?raw=true";
			System.out.println("\nDownloading configuration from " + releaseURL);

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
			System.out.print('\n');
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
				System.out.println("\nUSAGE ERROR!");
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

			Process p;
			
			String command = "cmd /c java -jar " + path;
			
			//Parse additional arguments
			for(int i = 2; i < args.length; i++){
				command += " " + args[i];
			}
			
			p = Runtime.getRuntime()
					.exec(command);
			
			p.waitFor();

			System.out.println();
			
            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(p.getInputStream()));
    
               BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(p.getErrorStream()));
    
               // read the output from the command
               while ((s = stdInput.readLine()) != null) {
                   System.out.println(s);
               }
                
               // read any errors from the attempted command
               while ((s = stdError.readLine()) != null) {
                   System.out.println(s);
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
