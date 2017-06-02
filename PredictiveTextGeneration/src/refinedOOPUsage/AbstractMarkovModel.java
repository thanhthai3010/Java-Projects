package refinedOOPUsage;

/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 * 
 * @author Prasandeep Singh
 * @version 06/01/2017
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    protected int seed;
    
    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    
    public void setTraining(String s) {
        myText = s.trim();
    }
    
	//Returns a list of strings that follow the provided key
	protected ArrayList<String> getFollows(String key){
		ArrayList<String> follows = new ArrayList<>();
		for(int i = 0; i<myText.length()-1; ){
			int start = myText.indexOf(key, i);
			if(start == -1 || start==myText.length()-key.length())
				break;
			int index = start+key.length();
			follows.add(myText.substring(index, index+1));
			i = index;
		}
		return follows;
	}
	
    abstract public String getRandomText(int numChars);

}