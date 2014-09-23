
package cs544.letmegiveexam.controller;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.InputStream;


public class ImportData {

    
    public InputStream readFile(String filename){
      return getClass().getResourceAsStream(filename);
    }
    
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://54.165.220.203:3306/cs544db","bidur","bidurbk");
            con.setAutoCommit(false);
            PreparedStatement pstm = null ;
            
            ImportData fn = new ImportData();
            
            InputStream is = fn.readFile("/file.xls");
            System.out.println(is);
            
            POIFSFileSystem fs = new POIFSFileSystem( is);
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            
            String subjectName = sheet.getSheetName();
            
            Row row;
            for(int i=1; i<=sheet.getLastRowNum(); i++){
                row = sheet.getRow(i);
                //int id = (int) row.getCell(1).getNumericCellValue();
                String question = row.getCell(1).getStringCellValue();
                String option1 = row.getCell(2).getStringCellValue();
                String option2 = row.getCell(3).getStringCellValue();
                String option3 = row.getCell(4).getStringCellValue();
                String option4 = row.getCell(5).getStringCellValue();
                String correctAnswer = row.getCell(6).getStringCellValue();
                Long subjet_Id =new Double(row.getCell(7).getNumericCellValue()).longValue();
//                String sql = "INSERT INTO User VALUES('"+id+"','"+name+"','"+address+"')";
                String sql = "INSERT INTO Question(question,) VALUES('"+question+"','"+option1+"','"+option2+"','"+option3+"','"+option4+"','"+correctAnswer+"','"+subjet_Id+"')";
                System.out.println(sql); 
                pstm = (PreparedStatement) con.prepareStatement(sql);
                pstm.execute();
                System.out.println("Import rows "+i);
            }
            con.commit();
            pstm.close();
            con.close();
            //fn.close();
            System.out.println("Success import excel to mysql table");
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }catch(SQLException ex){
            System.out.println(ex);
        }catch(IOException ioe){
            System.out.println(ioe);
        }

    }

}