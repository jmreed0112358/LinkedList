package linkedlist;

import static org.junit.Assert.*;
import junit.framework.Assert;
import linkedlist.LinkedList;

import org.junit.Test;

public class LinkedListUnitTest
{

	/**
	 * Tests the listarray constructor. We want to see the list's numItems
	 * parameter be set correctly.
	 */
	@Test
	public void TestConstructorSizeInitalization( )
	{
		LinkedList theList = new LinkedList( );

		Assert.assertEquals( 0, theList.GetNumItems( ) );
	}

	/**
	 * Tests the listarray's AddToEnd method. We'll give the listarray an
	 * integer to be added to the list. Then we check to see if the item has
	 * been added, as well as checking the numItems parameter. This specific
	 * test doesn't fill the list to capcity.
	 */
	@Test
	public void TestBasicAddToEnd( )
	{
		LinkedList theList = new LinkedList( );

		theList.AddToEnd( 73 );

		// Should have 1 item in the list now.
		Assert.assertEquals( 1, theList.GetNumItems( ) );
		Assert.assertEquals( 73, theList.GetCurrentObject( ) );
	}
	
	/**
	 * Tests GetCurrentObject. Some of these unit tests require this function.
	 */
	@Test
	public void TestGetCurrentObject( )
	{
		LinkedList theList = new LinkedList( );

		theList.AddToEnd( 12 );

		Assert.assertEquals( 12, theList.GetCurrentObject( ) );
	}

	/**
	 * Test the ability of the list to return to the first Object.
	 */
	@Test
	public void TestFirstElement( )
	{
		LinkedList theList = new LinkedList( );

		int[] data = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		LoadData( theList, data );

		for( int i = 0 ; i < 5 ; ++i )
		{
			theList.NextElement( );
		}

		// Now we go to the first element.
		theList.FirstElement( );

		// This depends on GetCurrentObject actually working.
		Assert.assertEquals( 0, theList.GetCurrentObject( ) );
	}

	/**
	 * Test the list's ability to iterate forward to the next element.
	 */
	@Test
	public void TestNextElement( )
	{
		LinkedList theList = new LinkedList( );

		int[] data = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		LoadData( theList, data );

		theList.NextElement( );

		Assert.assertEquals( 1, theList.GetCurrentObject( ) );
	}

	@Test
	public void TestHasMoreElementsEmpty( )
	{
		LinkedList theList = new LinkedList( );

		Assert.assertEquals( false, theList.HasMoreElements( ) );
	}

	/**
	 * This tests HasMoreElements when currentObject is in the middle of the
	 * list, and there are more elements ahead. "Normal case"
	 */
	@Test
	public void TestHasMoreElementsNormal( )
	{
		LinkedList theList = new LinkedList( );

		int[] data = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		LoadData( theList, data );

		for( int i = 0 ; i < 5 ; ++i )
		{
			theList.NextElement( );
		}

		Assert.assertEquals( true, theList.HasMoreElements( ) );
	}

	/**
	 * Helper function used by some of the unit tests.
	 * 
	 * @param data
	 */
	private void LoadData( LinkedList theList, int[] data )
	{
		if ( theList != null )
		{
			for( int i = 0 ; i < data.length ; ++i )
			{
				theList.AddToEnd( data[i] );
			}
		}
	}

}
