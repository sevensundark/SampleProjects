/*
 * Copyright (c) 2011 MTI Ltd.
 */
package DecodePackTool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * ファイルユーティリティー
 * @author LDNS
 */
public class FileUtil {
	
	/** バッファ*/
    private static final int BUFF_SIZE = 1024 * 1024;
 
    /**
     * ファイルを暗号化にする
     * 
     * @param in
     *            パス
     * @param out
     *            パス
     * @throws FileNotFoundException 
     */
    public static void fileEncrypt(String src, String des) throws FileNotFoundException {
    	DesEncryper desEncrypter = new DesEncryper();
    	File filein = new File(src);
    	File fileout = new File(des);
    	InputStream in = new FileInputStream(filein);
    	OutputStream out = new FileOutputStream(fileout);
    	desEncrypter.encryptStream(in, out);
    }
    
    /**
     * ファイルを復号化にする
     * 
     * @param in
     *            InputStream
     * @param out
     *            OutputStream
     * @throws IOException 
     */
    public static void fileDecrypt(String src, String des) throws IOException {
    	DesEncryper desEncrypter = new DesEncryper();
    	File filein = new File(src);
    	File fileout = new File(des);
    	if(filein.isFile()){
    		if(!fileout.exists())
    			fileout.createNewFile();
    		 InputStream in = new FileInputStream(filein);
    		 OutputStream out = new FileOutputStream(fileout);
    		 desEncrypter.decryptStream(in, out);
    	}
    }
    
    /**
     * パスのファイルをInputStreamに転換する
     * 
     * @param filesrc
     *            ファイルのパス
     * @return in 
     * 			  Stream
     */
    public static InputStream fileToStream(String filesrc){
    	File file = new File(filesrc);
    	if(file.exists() && file.isFile())
    	{
    		InputStream in = null;
			try {
				in = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return in;
    	}else {
    		return null;
		}
    }
    
    /**
     * Streamによる、保存先にファイルを作成する
     * 
     * @param srcfile
     *         保存先
     * @param in
     *         InputStream
     * @throws IOException 
     */
    public static void streamToFile(String srcfile,InputStream in) throws IOException{
    	  File desFile = new File(srcfile);
          if (!desFile.exists()) {
              File fileParentDir = desFile.getParentFile();
              if (!fileParentDir.exists()) {
                  fileParentDir.mkdirs();
              }
              desFile.createNewFile();
          }
          OutputStream out = new FileOutputStream(desFile);
          byte buffer[] = new byte[BUFF_SIZE];
          int realLength;
          while ((realLength = in.read(buffer)) > 0) {
              out.write(buffer, 0, realLength);
          }
          out.close();
    }
            
    /**
     * ディレクトリを削除する
     * @param path
     *            ディレクトリ
     * @return 処理結果
     */
    public static boolean delDir(String path) {
        File dir = new File(path);
        if(!dir.exists()){
        	return false;
        }
        else {
	        if (dir.isDirectory()) {
	            File[] tmp = dir.listFiles();
	            for (int i = 0; i < tmp.length; i++) {
	                if (tmp[i].isDirectory()) {
	                    if (!delDir(dir.getPath() + File.separator + tmp[i].getName())) {
	                        return false;
	                    }
	                } else {
	                    if (!tmp[i].delete()) {
	                        return false;
	                    }
	                }
	            }
	            if (!dir.delete()) {
	                return false;
	            }
	            return true;
	        }
	        else 
	        	return false;
        }
    }
    
	/**
	 * ファイルコピー
	 * @param src
	 *            コピー元
	 * @param dst
	 *            コピー先
	 * @return 処理結果
	 */
	public static boolean copyFile(File src, File dst) {
	        FileChannel inChannel = null;
	        FileChannel outChannel = null;
	        try {
	            inChannel = new FileInputStream(src).getChannel();
	            outChannel = new FileOutputStream(dst).getChannel();
	            inChannel.transferTo(0, inChannel.size(), outChannel);
	        } catch (IOException e) {
	            return false;
	        } finally {
	            if (inChannel != null) {
	                try {
	                    inChannel.close();
	                } catch (IOException e) {
	                }
	                inChannel = null;
	            }

	            if (outChannel != null) {
	                try {
	                    outChannel.close();
	                } catch (IOException e) {
	                }
	                outChannel = null;
	            }
	        }
	        return true;
	    }
	 
    /**
     * ディレクトリのファイル一覧を取得
     * @param path
     *            ディレクトリ
     * @return ファイル一覧
     */
    public static List<File> getFileList(String path) {
        List<File> fileList = new ArrayList<File>();

        File dir = new File(path);
        if (dir.exists()) {
            File[] tmp = dir.listFiles();
            for (int i = 0; i < tmp.length; i++) {
                if (tmp[i].isDirectory()) {
                    fileList.addAll(getFileList(path + File.separator + tmp[i].getName()));
                } else {
                    fileList.add(tmp[i]);
                }
            }
        }
        return fileList;
    }
    
	/**
	 * ファイル存在チェック
	 * @param path ファイルパース
	 * @return チェック結果
	 */
	public static boolean checkFileExist(String path) {
		
		if (path == null || "".equals(path)) {
			return false;
		}
		
		File imgFile = new File(path);
		if (imgFile.exists() && imgFile.isFile()) {
			return true;
		} else {
			return false;
		}
	}
	
    /**
     * ディレクトリのファイル名を取得
     * @param path
     *            ディレクトリ
     * @return ファイル名一覧
     */
	public static List<String> getFileNameList(String path){

		if (path == null || "".equals(path)) {
			return null;
		}

    	List<String> fileNameList = new ArrayList<String>();
    	File file = new File(path); 
        
    	if (!file.exists()) {
    		return null;
    	}
    	
        for (File f : file.listFiles())  {
    		try {
    			String name = URLDecoder.decode(f.getName(), "utf-8");
    		if (name.contains(".")) {
        		name = name.substring(0, name.lastIndexOf("."));
    		}

    			fileNameList.add(name);
    		} catch (Exception e) {
    		    e.printStackTrace();
    		}
        }
        return fileNameList;
	}
	
    /**
     * ファイルを解凍
     * @param zipFile
     *            対象ファイル
     *        targetPath
     *            目標パス
     * @throws IOException
     */
	public static void unCompress(File filePath, String targetPath) throws IOException {
   	 
    	File desDir = new File(targetPath);
        if (!desDir.exists()) {
            desDir.mkdirs(); 
        } 
        
        ZipFile zf = new ZipFile(filePath);
        
        for (Enumeration<?> entries = zf.entries(); entries.hasMoreElements();) {
            ZipEntry entry = ((ZipEntry)entries.nextElement());
            
            if (entry.isDirectory()) {
            	continue;
            }
            
            InputStream in = zf.getInputStream(entry);
            String str = targetPath + File.separator + entry.getName();
            str = new String(str.getBytes("UTF-8"));
            File desFile = new File(str);
            if (!desFile.exists()) {
                File fileParentDir = desFile.getParentFile();
                if (!fileParentDir.exists()) {
                    fileParentDir.mkdirs();
                }
                desFile.createNewFile();
            }
            OutputStream out = new FileOutputStream(desFile);
            byte buffer[] = new byte[1024 * 1024];
            int realLength;
            while ((realLength = in.read(buffer)) > 0) {
                out.write(buffer, 0, realLength);
            }
            in.close();
            out.close();
        }
    }

    /**
     * ファイルを解凍
     * @param zipFileIn
     *            対象ファイルインプット
     *        targetPath
     *            目標パス
     * @throws IOException
     */
	public static void unCompress(InputStream zipFileIn, String targetPath) throws IOException {

    	File file = new File(targetPath);
        if (!file.exists()) {
        	file.mkdirs();
        }

        ZipInputStream in = new ZipInputStream(zipFileIn);
        ZipEntry entry = in.getNextEntry();
        String name;
        byte[] buffer = new byte[1024 * 1024];
        int realLength;
        while (entry != null) {
            if (entry.isDirectory()) {
                name = entry.getName();
                name = name.substring(0, name.length() - 1);

                file = new File(targetPath + File.separator + name);
                if (!file.exists()) {
                	file.mkdir();
                }

            } else {
                file = new File(targetPath + File.separator + entry.getName());
                file.createNewFile();
                FileOutputStream out = new FileOutputStream(file);
                while ((realLength = in.read(buffer)) != -1) {
                	out.write(buffer, 0, realLength);
                }
                out.close();
            }
            entry = in.getNextEntry();
        }
        in.close();
    }

	public static void zipCompress(String srcFolder, String destZipFile) throws IOException {
		
		//http://www.blogjava.net/mrcmd/archive/2007/08/24/138963.html
        ZipOutputStream zipOut = null;
        FileOutputStream fileWriter = null;

        fileWriter = new FileOutputStream(destZipFile);
        zipOut = new ZipOutputStream(fileWriter);

        doZip(zipOut, new File(srcFolder), "");
        
        zipOut.flush();
        zipOut.close();
    }
	
    private static void doZip(ZipOutputStream out, File f, String base) throws IOException {
		if (f.isDirectory()) {
			File[] fl = f.listFiles();
			out.putNextEntry(new ZipEntry(base + "/"));
			base = base.length() == 0 ? "" : base + "/";
			for (int i = 0; i < fl.length; i++) {
				doZip(out, fl[i], base + fl[i].getName());
			}
		} else {
			out.putNextEntry(new ZipEntry(base));
			FileInputStream in = new FileInputStream(f);
			int b;
			System.out.println(base);
			while ((b = in.read()) != -1) {
				out.write(b);
			}
			in.close();
		}
    }
	
	/**
	 * ファイル名称より、ZIPファイルの判断処理
	 * @param fileName
	 * @return　ZIPファイルの場合True、以外の場合False
	 */
	public static boolean isZipFileByFileName(String fileName) {
		if (fileName == null || "".equals(fileName)) {
			return false;
		} else {
			return fileName.endsWith(".zip") || fileName.endsWith(".ZIP");
		}
	}
}