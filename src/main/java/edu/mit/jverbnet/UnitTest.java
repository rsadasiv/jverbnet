package edu.mit.jverbnet;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import edu.mit.jverbnet.data.IMember;
import edu.mit.jverbnet.data.IVerbClass;
import edu.mit.jverbnet.data.IWordnetKey;
import edu.mit.jverbnet.index.IVerbIndex;
import edu.mit.jverbnet.index.VerbIndex;


public class UnitTest {

	//private static final Logger logger = LogManager.getLogger(UnitTest.class);
	
	
	public UnitTest() {
		super();
	}

	public static void main(String[] args) throws IOException {
		UnitTest me = new UnitTest();
		System.out.println("verbnet31: " + me.checkVerbClasses(me.initVerbnet31()));
		System.out.println("verbnet32: " + me.checkVerbClasses(me.initVerbnet32()));
		System.out.println("verbnet33: " + me.checkVerbClasses(me.initVerbnet33()));

	}
	
	private IVerbIndex initVerbnet31() throws IOException {
		IVerbIndex index = new VerbIndex(
				new URL(
						"file", 
						null, 
						"C:\\Users\\rsada\\Downloads\\verbnet-3.1\\verbnet-3.1"
				)
		);
		return index;
		
	}
	
	private IVerbIndex initVerbnet32() throws IOException {
		IVerbIndex index = new VerbIndex(
				new URL(
						"file", 
						null, 
						"C:\\Users\\rsada\\Downloads\\verbnet-3.2\\new_vn"
				)
		);
		return index;
		
	}
	
	private IVerbIndex initVerbnet33() throws IOException {
		IVerbIndex index = new VerbIndex(
				new URL(
						"file", 
						null, 
						"C:\\Users\\rsada\\Downloads\\verbnet-3.3\\verbnet3.3"
				)
		);
		return index;
		
	}
	
	private int checkVerbClasses(IVerbIndex index) throws IOException {
		int retval = 0;
		index.open();
		Iterator<IVerbClass> verbClassIter = index.iteratorRoots();
		while (verbClassIter.hasNext()) {
			IVerbClass verb = verbClassIter.next();
			for (IMember member : verb.getMembers()) {
				for (IWordnetKey senseKey : member.getWordnetTypes().keySet()) {
					//logger.debug("loaded " + senseKey.toString());
					retval++;
				}
			}
			
		}
		return retval;
	}

}
