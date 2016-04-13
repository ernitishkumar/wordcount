package com.nitish.freecharge.dao;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;
import com.nitish.freecharge.utility.GlobalResources;

/**
 * The FileDAO class helps by providing methods which query underlying txt file and returns the count
 * of th queried word
 */
public class FileDAO {
	/**
	 * counts a concurrenthHashMap to store the count of the word and the word itself after one successfully 
	 * query from the txt file. This concurrent hash map provides thread safe behaviour in accessing the count
	 * of a word which is already there in the map.
	 */
	public static Map<String,Long> counts=new ConcurrentHashMap<String, Long>();

	/**
	 * getCount method which takes a word in string format
	 * queries the underlying file and returns its count. 
	 * If the word is getting queried first time it will be added the hashmap and later if
	 * request comes for the same word its count is returned from the hashmap
	 * @param   word whose count is to be determined.
	 * @exception FileNotFoundException if File specified is not found
	 * @exception IOException
	 */
	public long getCount(String word) throws FileNotFoundException,IOException{
		long count=0;
		Long cacheCount=counts.get(word);
		if(cacheCount==null){
			synchronized(this){
				try(BufferedReader inputFile=new BufferedReader(new FileReader(GlobalResources.FILE_PATH))){
					String line=inputFile.readLine();
					StringTokenizer tokenizer=null;
					while(line!=null){
						tokenizer=new StringTokenizer(line);
						String token=null;
						while(tokenizer.hasMoreElements()){
							token=(String)tokenizer.nextElement();
							if(token.equalsIgnoreCase(word))count++;
						}
						line=inputFile.readLine();
					}
				}catch(FileNotFoundException fileNotFoundException){
					System.out.println("FileNotFoundException in class FileDAO : method : getCount(String) "+fileNotFoundException.getMessage());
					throw fileNotFoundException;
				}catch(IOException ioException){
					System.out.println("IOException in class FileDAO : method : getCount(String) "+ioException.getMessage());
					throw ioException;
				}
			}
			counts.put(word, count);
		}else{
			count=cacheCount.longValue();
		}
		return count;
	}
}