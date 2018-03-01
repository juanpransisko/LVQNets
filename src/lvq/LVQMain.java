package lvq;


import java.util.*;
import java.io.*;

public class LVQMain {
	
	public static void main(String[] args) throws IOException {
	
		// Param in order:
		//  learning rate, iterations, n of neurons, clusters, category type
		LVQNetwork lvqnet = new LVQNetwork(0.1, 10000, 20, 6, 0);
		
		// Initialization
		System.out.println("Initialization START ...");
		lvqnet.initialize();		
		System.out.println("Initialization DONE ...\n");

		// Training data attributes
		//		From CL_Time data
		double[][] tr_data = new double[][] {
			{0,109}, {0,657}, {1,153}, {0,655}, {0,673},
			{0,698}, {0,110}, {1,651}, {1,416}, {1,123},
			{1,660}, {0,157}, {0,651}, {0,667}, {0,230},
			{0,128}, {0,128}, {0,653}, {0,240}, {0,18},
			{0,179}, {0,696}, {0,211}, {0,678}, {0,188}
		};
				
		int[] inp_category = new int[] { 3,4,0,5,5,0,5,5,5,4,2,4,0,4,4,5,1,3,5,1,3,5,3,2,5,4,0,5,3,0 };

		Data[] inputs = new Data[tr_data.length];
		for (int x = 0; x < inputs.length; x ++) {
			inputs[x] = new Data();
			inputs[x].set_attrib(tr_data[x]);
                        inputs[x].set_category(inp_category[x]);
			// System.out.println(Arrays.toString(inputs[x].get_attrib()));
		}

		// Training
		System.out.println("Training START ...");
		lvqnet.train(inputs, inputs.length);
		System.out.println("Training DONE ...\n");
		
	}

	
}