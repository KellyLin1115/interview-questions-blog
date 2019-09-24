package com.kellylin1115.interview.java.basic;

import java.io.*;

public class CopyFile {
    public static void copy(File oldFile, File newFile){
        InputStream in = null ;
        BufferedInputStream bis = null ;

        OutputStream out = null ;
        BufferedOutputStream bos = null ;

        try {
            in = new FileInputStream( oldFile ) ;
            bis = new BufferedInputStream( in ) ;

            out = new FileOutputStream( newFile ) ;
            bos = new BufferedOutputStream( out ) ;

            byte[] b=new byte[1024];   //代表一次最多读取1KB的内容

            int length = 0 ; //代表实际读取的字节数
            while( (length = bis.read( b ) )!= -1 ){
                //length 代表实际读取的字节数
                bos.write(b, 0, length );
            }
            //缓冲区的内容写入到文件
            bos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {

            if( bos != null ){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if( bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if( in != null ){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if ( out != null ) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "/src/main/java/com/kellylin1115/interview/java/basic/";
        String inputPath = path + "input.txt";
        String outputPath = path + "output.txt";
        File file = new File( inputPath ) ;
        File file2 = new File( outputPath ) ;
        copy( file , file2 );
    }

}
