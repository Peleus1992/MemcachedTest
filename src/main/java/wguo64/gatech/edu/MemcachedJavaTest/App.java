package wguo64.gatech.edu.MemcachedJavaTest;

import java.io.IOException;
import java.io.Serializable;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.MemcachedClient;

/**
 * Hello world!
 *
 */

public class App 
{
	private static class Book implements Serializable {
		private String name;
		private Long id;
		
		public Book(String name, Long id) {
			super();
			this.name = name;
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		@Override
		public String toString() {
			return "{name: " + name + ", " + "id: " + id + "}";
		}
	}
    public static void main( String[] args )
    {
    	try {
    		// Try to connect memcached at port 11211 of localhost
			MemcachedClient cache = new MemcachedClient(AddrUtil.getAddresses("127.0.0.1:11211"));
			// Set a key-value part ("mykey", "myvalue") with 30 seconds duration.
			Book book1 = new Book("The Art of War", 123l);
			cache.set("mybook", 30, book1);
			// Get value by key
			Book book2 = (Book)cache.get("mybook");
			System.out.println(book2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
