package linkedlist;

public class LinkedList
{
	private ListNode	head;			// Preserves a reference to
										// the first item in the
										// list.
	private ListNode	tail;			// Why not?

	private ListNode	currentNode;	// Current ListNode.
	private ListNode	temp;			// Temporary reference.
	private int			numItems;		// How many items do we have
										// in this list now?

	public LinkedList( )
	{
		head = null;
		tail = null;
		currentNode = null;
		temp = null;
		numItems = 0;
	}

	/**
	 * AddToEnd
	 * 
	 * Given: Object ob Do: Add ob to the end of the list.
	 * 
	 * @param ob
	 *            The object to be added to the list.
	 */
	public void AddToEnd( Object ob )
	{
		if ( head == null )
		{
			head = new ListNode( ob );
			currentNode = head;
			tail = currentNode;
			if ( tail == null )
			{
				System.out.println( "tail == null!!!" );
			}
		}
		else
		{
			temp = new ListNode( ob );
			tail.SetNextItem( temp );
			tail = tail.GetNextItem( );
		}
		++numItems;
	}

	/**
	 * Sets currentObject to the first item in the list.
	 */
	public void FirstElement( )
	{
		currentNode = head;
	}

	/**
	 * Gets the tail reference.
	 */
	public ListNode GetTailReference( )
	{
		return tail;
	}

	/**
	 * Allows us to iterate forward through the list. Moves currentObject to the
	 * next object in the list.
	 */
	public void NextElement( ) throws NoNextElementException
	{
		if ( head != null )
		{
			if ( currentNode.GetNextItem( ) != null )
			{
				currentNode = currentNode.GetNextItem( );
			}
			else
			{
				throw new NoNextElementException( );
			}
		}
		else
		{
			throw new NoNextElementException( );
		}
	}

	/**
	 * Tests if there are more items after the current object. The assignment
	 * defines this in a weird way. We have code to prevent falling off the end
	 * of the list in NextElement, so some of the semantics of the assignment's
	 * definition of this function no longer make sense.
	 * 
	 * @return
	 */
	public boolean HasMoreElements( )
	{
		if ( numItems == 0 || currentNode.GetNextItem( ) == null )
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	/**
	 * Gets the object pointed to by currentObject
	 * 
	 * @return
	 */
	public Object GetCurrentObject( )
	{
		if ( currentNode != null && currentNode.GetElement( ) != null )
		{
			return currentNode.GetElement( );
		}
		else
		{
			return null;
		}
	}

	/**
	 * Get the number of items in the list.
	 */
	public int GetNumItems( )
	{
		return numItems;
	}

	/**
	 * Print
	 * 
	 * Print (to standard output) the objects in the list in order, enclosed in
	 * square brackets, separated by spaces.
	 */
	public void Print( )
	{
		ListNode temp = head;

		System.out.print( "[" );

		while( temp != null )
		{
			System.out.print( temp.GetElement( ) );
			temp = temp.GetNextItem( );
		}

		System.out.print( "]" );
	}
}

// Our node class.
class ListNode
{
	private Object		item;
	private ListNode	nextItem;

	public ListNode( )
	{
		item = null;
		nextItem = null;
	}

	public ListNode( Object ob )
	{
		item = ob;
		nextItem = null;
	}

	public Object GetElement( )
	{
		return item;
	}

	public void SetNextItem( ListNode item )
	{
		if ( item != null )
		{
			nextItem = item;
		}
		else
		{
			System.out
					.println( "ListNode::SetNextItem - Got a null reference!" );
		}
	}

	public ListNode GetNextItem( )
	{
		return nextItem;
	}
}
