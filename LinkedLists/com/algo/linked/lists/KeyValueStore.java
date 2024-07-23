package com.algo.linked.lists;

public class KeyValueStore {
	/**
	 * 
	 * capacity requirements : 
	 * storage space : kv store of 100 TB
	 * QPS to handle . 1lakh QPS
	 * 
	 * simple KV store .
	 * using hash table . but then for large data sets how we will manage . 
	 * we can keep a reference of large data thats store in hardrive a reference to it in hashtable.
	 * 
	 * lets design a distributed KV store
	 * 
	 * to store large amount of data . we will to do database sharding / partioning .
	 *  sharding is to spread data over numerous systems 
	 *  
	 * consistency . if we are using replicas. 
	 * 1. using coordinator . its a process which will take the local copy of the update and then re-commit it to 
	 * replica in case the update to replica fails .
	 * 2. using commit log : log.s all the commit that has happened over a specific timeframe and then a process
	 * reads the commit log and commit all the transactions into the replicas.
	 * 
	 * 
	 * Redis:
	 * Redis cannot store large files or binary data and is best suited for small
	 * amounts of textual data that need to be accessed, changed, and inserted
	 * quickly. If we try to write more data than the available memory allows, we
	 * may encounter errors. Overall, Redis is a useful tool for fast read and
	 * write operations with small amounts of textual data, but it is important to
	 * consider its limitations when using it to store and access data.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
