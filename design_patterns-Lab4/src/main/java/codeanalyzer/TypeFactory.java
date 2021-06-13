package codeanalyzer;

/**
* This class contains the if statements which check if the
* source code location is local, strcwebomp or something wrong which
* is referred to null.
* @param type the type of the source code location (local, web or null) 
* @return a type which will be local, web or null
*/

public class TypeFactory {
	
	public Type type(String type) {
		Type type2;
		if (type.contentEquals("local")) {
			type2 = new Local();
		} else if (type.contentEquals("web")) {
			type2 = new Web();
		} else {
			type2 = new NullType();
		}
		
		return type2;
	}

}
