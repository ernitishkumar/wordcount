package com.nitish.freecharge.test;
import org.junit.Test;
import static org.junit.Assert.*;
import com.nitish.freecharge.dao.FileDAO;
public class FileDAOTest{
    private FileDAO fileDAO=new FileDAO();
    @Test
    public void testCount(){
        try{
        long count=fileDAO.getCount("java");  
        assertTrue(count>=0);
        }catch(Exception e){
            
        }
    }
}