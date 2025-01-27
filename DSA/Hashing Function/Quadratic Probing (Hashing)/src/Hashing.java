
public class Hashing 
{
	String[] str;
	public Hashing(int size)
	{
		str=new String[size];
	}

	public void Insert(String InputStr)
	{
		int index=HashFunction(InputStr);
		System.out.println("The String "+ InputStr+ " is at index : "+index);
		if(str[index] == null)
		{
			str[index]=InputStr;
		}
		else
		{
			int i=1;
			while(true)
			{
				index += (i * i) ;
				if(index > str.length-1)
				{
					index=0;
					i=0;
				}
			
				if(str[index] == null)
				{
					str[index]=InputStr;
					break;
				}
				
				i++; // Quadratic Increment
			}
		}

		System.out.println(" It is placed at Index : "+index);
	}

	public int HashFunction(String InputStr)
	{	// Calculating the Unique index 
		int sum=0;
		for(int i=0;i<InputStr.length();i++)
		{
			sum=sum+InputStr.charAt(i);// comparing with the ASCII values
		}

		int index=sum % str.length;
		return index;
	}


	public void Remove(String InputStr)
	{
		int index= SearchString(InputStr);
		str[index]=null;
		System.out.println(" The String "+InputStr+ " Removed from index : "+index);
	}

	private int SearchString(String InputStr)
	{
		int index=HashFunction(InputStr);
		System.out.println("The String "+InputStr+ "from index : "+index);
		
		if(str[index] != null && str[index].equals(InputStr))
		{
			return index;
		}
		else
		{
			int i=1;
			while(true)
			{
				index += (i * i) ;
				if(index > str.length-1)
				{
					index=0;
					i=0;
				}
				// index=(++index % str.length ); // Circular Condition
				
				if(str[index] != null && str[index].equals(InputStr))
				{
					return index;
				}
			}
		}

	}

}
