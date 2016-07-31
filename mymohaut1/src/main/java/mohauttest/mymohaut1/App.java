package mohauttest.mymohaut1;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.csv.CSVUtils;
import org.apache.mahout.classifier.sgd.CsvRecordFactory;
import org.apache.mahout.classifier.sgd.LogisticModelParameters;
import org.apache.mahout.classifier.sgd.OnlineLogisticRegression;
import org.apache.mahout.classifier.sgd.RecordFactory;
import org.apache.mahout.math.RandomAccessSparseVector;
import org.apache.mahout.math.Vector;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) 
    {
        System.out.println( "mohaut1" );
        
        App app = new App();
        
        try {
			app.api1();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //app.recommender1();
        //app
       

    }
    
    public void api1() throws IOException
    {
    	String inputFile = "bank-additional-full.csv";
    	String outputFile = "model/out1.txt";
    	
    	 
    	
    	 List<String> predictorList =Arrays.asList("age",
    			 									"job",
    			 									"marital",
    			 									"education",
    			 									"default",
    			 									"housing",
    			 									"loan",
    			 									"contact",
    			 									"month",
    			 									"day_of_week",
    			 									"duration",
    			 									"campaign",
    			 									"pdays",
    			 									"previous",
    			 									"poutcome",
    			 									"emp.var.rate",
    			 									"cons.price.idx",
    			 									"cons.conf.idx",
    			 									"euribor3m",
    			 									"nr.employed");
         List<String> typeList = Arrays.asList("n", "w", "w", "w", "w", "w", "w", "w", "w", "w", "n", "n", "n", "n",
         		"w", "n", "n", "n", "n", "n");
         
         LogisticModelParameters lmp = new LogisticModelParameters();
                  
         lmp.setMaxTargetCategories(2);
         lmp.setNumFeatures(20);
         lmp.setUseBias(false);
         lmp.setTypeMap(predictorList,typeList);
         lmp.setLearningRate(0.5);
         lmp.setTargetVariable("y");
         
         
         int passes = 50;
         OnlineLogisticRegression lr;     
         

         CsvRecordFactory csv = lmp.getCsvRecordFactory();
         lr = lmp.createRegression();
         

         
         
         
         for (int pass = 0; pass < passes; pass++) {
                 BufferedReader in = new BufferedReader(new FileReader(inputFile));

                 
                // csv.firstLine(in.readLine());
                 
                 
                 //csv.firstLine(in.readLine());
                 String s = in.readLine();
                 
                 //s = s.replaceAll("\"", "");
                 s = s.replaceAll(";", ",");
                 //System.out.println(s);
                 
                 /*
                 
                 final Map<String, Integer> vars = Maps.newHashMap();
                 List<String> variableNames = parseCsvLine(s);
                 int column = 0;
                 for (String var : variableNames) {
                   vars.put(var, column++);
                 }
                 
                 

                 // record target column and establish dictionary for decoding target
                 
                 //vars.containsKey(key)
                 System.out.println("size == "+vars.size());
                 int target = vars.get("y");
                 
                 System.out.println("target == "+target);
                 
                 */
                 
                 csv.firstLine(s);

                 String line = in.readLine();
                 
                 while (line != null) {
                   
                   Vector input = new RandomAccessSparseVector(lmp.getNumFeatures());
                   
                   line = line.replaceAll(";", ",");
                   int targetValue = csv.processLine(line, input);

                   // update model
                   lr.train(targetValue, input);
                   

                   line = in.readLine();
                   
                 }
                 in.close();
               }
        
         
         
         OutputStream modelOutput = new FileOutputStream(outputFile);
         try {
           lmp.saveTo(modelOutput);
         } finally {
           modelOutput.close();
         }
         PrintWriter output=new PrintWriter(new OutputStreamWriter(System.out, Charsets.UTF_8), true);
         output.println(lmp.getNumFeatures());
         output.println(lmp.getTargetVariable() + " ~ ");
         String sep = "";
         for (String v : csv.getTraceDictionary().keySet()) {
           double weight = predictorWeight(lr, 0, csv, v);
           if (weight != 0) {
             output.printf(Locale.ENGLISH, "%s%.3f*%s", sep, weight, v);
             sep = " + ";
           }
         }
         output.printf("%n");
         for (int row = 0; row < lr.getBeta().numRows(); row++) {
           for (String key : csv.getTraceDictionary().keySet()) {
             double weight = predictorWeight(lr, row, csv, key);
             if (weight != 0) {
               output.printf(Locale.ENGLISH, "%20s %.5f%n", key, weight);
             }
           }
           for (int column = 0; column < lr.getBeta().numCols(); column++) {
             output.printf(Locale.ENGLISH, "%15.9f ", lr.getBeta().get(row, column));
           }
           output.println();
         }
    }
    
    /*
    private List<String> parseCsvLine(String line) {
        try {
          return Arrays.asList(CSVUtils.parseLine(line));
    	   }
    	   catch (IOException e) {
          List<String> list = Lists.newArrayList();
          list.add(line);
          return list;
       	}
      }
   */   
      
    private static double predictorWeight(OnlineLogisticRegression lr, int row, RecordFactory csv, String predictor) {
	    double weight = 0;
	    for (Integer column : csv.getTraceDictionary().get(predictor)) {
	      weight += lr.getBeta().get(row, column);
	    }
	    return weight;
	  }
    
    /*
    public void recommender1() throws IOException, TasteException
    {
    	 DataModel model = new FileDataModel(new File("dataset1.txt"));
         
         UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
         
         UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
         
         UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
         
         List<RecommendedItem> recommendations = recommender.recommend(2, 3);
         for (RecommendedItem recommendation : recommendations) {
           System.out.println(recommendation);
         }
    } */
}
