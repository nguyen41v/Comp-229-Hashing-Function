public class hashtable
{
	// only holds positive integers
	// -1 = tombstone
	// 0 = unoccupied

	// open addressing (closed hashing)
	// quadratic probing collision resolution
	int max = 101;  // "M"
	int[] array;
	int size;  // "K" number of occupied spaces
	// size/max = load factor

	public hashtable()
	{
		size = 0;
		array = new int[max];
	}

	public boolean search( int key )
	{
		// DO THIS TOGETHER!!!
		return false;
	}

	// returns true upon successful insertion, false otherwise
	public boolean insert( int key )
	{
		int position = hashfunction( key );
		if ( array[position] <= 0 )
		{
			if ( array[position] == 0 )  // if replacing a tombstone, do not increase size
			{
				size++;
			}
			array[position] = key;
			if ( (double)(max/size) <= 2.5 )
			{
				rehash();
			}
			return true;  // successful insertion
		}
		else if ( array[position] == key )
		{
			// found duplicate, no action necessary
			return false;
		}
		else
		{
			position = collision( key );
			if ( position > -1 )
			{
				if ( array[position] == 0 )  // if replacing a tombstone, do not increase size
				{
					size++;
				}
				array[position] = key;
				if ( (double)(max/size) <= 2.5 )
				{
					rehash();
				}
				return true;  // successful insertion
			}
			else
			{
				return false;  // key could not be inserted
			}
		}
	}

	// returns hashed address
	public int hashfunction( int key )
	{
		// simple mod
		return key % max;
	}

	// returns index if not used, -1 otherwise
	public int collision( int key )
	{
		// quadratic probing (no double hashing)
		for ( int ii = 1; ii < max; ++ii )
		{
			int qp = (key + ii * ii) % max;
			if ( array[qp] == key )  // found duplicate
			{
				return -1;
			}
			else if ( array[qp] <= 0 )
			{
				return qp;
			}
		}

		// finished quadratic probing, no viable candidates
		return -1;
	}

	public void printall()
	{
		for ( int ii = 0; ii < max; ++ii )
		{
			System.out.print( array[ii] + " " );
		}
		System.out.print( "\n" );
	}

	// extra credit: 8 pts
	// replaces key with -1 tombstone
	// do not decrease size
	// return true on successful remove, false otherwise
	public boolean remove( int key )
	{

		return false;
	}

	// extra credit: 12 pts
	// double hash with quadratic probing
	// returns index if not used, -1 otherwise
	// h2(k) = 7 * k + 3
	public int doublehashcollision( int key )
	{
		return -1;
	}

	// extra credit: 20 pts
	// re-hashes the table, double the table's "max" appropriately
	// rehash() is called from insert() when load factor is >= 0.4
	// new load factor should be <= 0.1
	public void rehash()
	{
	}
}
