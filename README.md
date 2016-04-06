# Experiment with Memcached
 
## 1. Download URL:
libevent-2.0.22-stable

https://github.com/libevent/libevent/releases/download/release-2.0.22-stable/libevent-2.0.22-stable.tar.gz

memcached-1.4.25

https://memcached.org/files/memcached-1.4.25.tar.gz

spymemcached

https://github.com/couchbase/spymemcached
 
## 2. Install Libeven and Memcached
<img src="https://github.com/Peleus1992/MemcachedTest/blob/master/screeshot/Picture1.png"/>
<img src="https://github.com/Peleus1992/MemcachedTest/blob/master/screeshot/Picture2.png"/>

## 3. Use telnet to operate memcached
Step 1. First connect memcached at port 11211 of localhost

Step 2. Set key value pair (“mykey”, “myvalue”) in memcached.

Step 3. Get “mykey” from memcached
<img src="https://github.com/Peleus1992/MemcachedTest/blob/master/screeshot/Picture3.png"/>
Step 4. The following are the statistics of memcached during runtime. The first picture shows the memory information and second shows the information of the items stored in the memcached.
<img src="https://github.com/Peleus1992/MemcachedTest/blob/master/screeshot/Picture4.png"/>
<img src="https://github.com/Peleus1992/MemcachedTest/blob/master/screeshot/Picture5.png"/>

## 4. Use Java program to operate memcached
I need to first import the dependency of spymemcached in my project in order to use memcached APIs. 
The Java code has beed uploaded onto github: https://github.com/Peleus1992/MemcachedTest.git
```Java
// Try to connect memcached at port 11211 of localhost
MemcachedClient cache = new MemcachedClient(AddrUtil.getAddresses("127.0.0.1:11211"));
// Set a key-value part ("mykey", "myvalue") with 30 seconds duration.
Book book1 = new Book("The Art of War", 123l);
cache.set("mybook", 30, book1);
// Get value by key
Book book2 = (Book)cache.get("mybook");
System.out.println(book2);
```
## 5. Results and Experience
Memcached is a distributed memory caching system which is often used as a middleware between servers and database. It is used to reduce the database load and speed-up the data reading.
In this experiment, I first install the memcached. Then I test it using both telnet and java program. I found the memcached is really a very useful memory caching system to speed-up web application by alleviate the database load. It is in use by many famous companies such as Facebook, Twitter, Google, etc. For example, Google App Engine integrates memcached in Google Datastore to speed up the data retrieval.
However, one must understand the caveat of using memcached. First, the program should normally function even without memcached. Memcached should only serve to make the performance of the program better.  Second, memcached does not support transaction. So one must check whether the data stored in the memory is touched or not. Also one must remember the data stored in memcached will expire after a period of time.
 

