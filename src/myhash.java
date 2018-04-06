public class myhash
{
	public static void main ( String[] args )
	{
		hashtable hhh = new hashtable();

		hhh.insert( 392 );
		hhh.insert( 491 );
		hhh.insert( 175 );
		hhh.insert( 89 );

		hhh.printall();

		System.out.println( "100 " + hhh.search( 100 ) );
		System.out.println( "175 " + hhh.search( 175 ) );
		System.out.println( "89 " + hhh.search( 89 ) );
	}
}
