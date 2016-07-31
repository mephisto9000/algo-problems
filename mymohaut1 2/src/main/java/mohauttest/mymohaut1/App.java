package mohauttest.mymohaut1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.csv.CSVUtils;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.apache.mahout.classifier.evaluation.Auc;
import org.apache.mahout.classifier.sgd.CsvRecordFactory;
import org.apache.mahout.classifier.sgd.LogisticModelParameters;
import org.apache.mahout.classifier.sgd.OnlineLogisticRegression;
import org.apache.mahout.classifier.sgd.RecordFactory;
import org.apache.mahout.math.Matrix;
import org.apache.mahout.math.RandomAccessSparseVector;
import org.apache.mahout.math.SequentialAccessSparseVector;
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
			//app.api1();
        	app.appTest();
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
         
         //lr = new OnlineLogisticRegression();

         CsvRecordFactory csv = lmp.getCsvRecordFactory();
         lr = lmp.createRegression();
         

         
         int k = 0;
         
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
                 //int lineCount = 2;
                 while (line != null) {
                   
                   Vector input = new RandomAccessSparseVector(lmp.getNumFeatures());
                   
                   line = line.replaceAll(";", ",");
                   int targetValue = csv.processLine(line, input);

                   // update model
                   lr.train(targetValue, input);
                   k++;

                   line = in.readLine();
                   //lineCount++;
                 }
                 in.close();
               }
        
       // System.out.println(lr.toString());
         
         
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

    public void appTest() throws IOException
    {
    	String fileWithoutTarget = "input_bank_data.csv";
    	String fileModel = "model/out1.txt";
    	
    	Auc collector = new Auc();
    	
    	//LogisticModelParameters lmp = LogisticModelParameters.loadFrom(new File(fileModel));
    	LogisticModelParametersPredict lmp = LogisticModelParametersPredict.
    			loadFrom(new File(fileModel));
    	
    	CsvRecordFactoryPredict csv = lmp.getCsvRecordFactory();
    	OnlineLogisticRegression lr = lmp.createRegression();
    	
        //CsvRecordFactory csv = lmp.getCsvRecordFactory();
        //OnlineLogisticRegression lr = lmp.createRegression();
        
        //BufferedReader in = OnlineLogisticRegressionTest.open(inputFile);
        BufferedReader in = new BufferedReader(new FileReader(new File(fileWithoutTarget)));
        
        String line = in.readLine();
        
        System.out.println(line);
        
        csv.firstLine(line);
        
        line = in.readLine();
        
        PrintWriter output = new PrintWriter(new OutputStreamWriter(System.out, Charsets.UTF_8), true);
        
        output.println("\"target\",\"model-output\",\"log-likelihood\"");
        
        int runs = 0;
        int correct = 0;
        while(line != null)
        {
        	Vector v = new SequentialAccessSparseVector(lmp.getNumFeatures());
        	int target = csv.processLine(line, v);
        	double score = lr.classifyScalar(v);
        	
        	output.printf(Locale.ENGLISH, "%d, %.3f, %.6f%n", target, score, lr.logLikelihood(target, v));
        	collector.add(target, score);
        	
        	runs ++;
        	if (target == score)
        		correct ++;
        	
        	line = in.readLine();
        	
        	
        	        	        	        	        			
        }
        
        //output.printf(Locale.ENGLISH, "AUC = %.2f%n", collector.auc());
        output.printf(Locale.ENGLISH, "AUC = %.2f%n", collector.auc());
        Matrix m = collector.confusion();
        output.printf(Locale.ENGLISH, "confusion: [[%.1f, %.1f], [%.1f, %.1f]]%n",
          m.get(0, 0), m.get(1, 0), m.get(0, 1), m.get(1, 1));
        m = collector.entropy();
        output.printf(Locale.ENGLISH, "entropy: [[%.1f, %.1f], [%.1f, %.1f]]%n",
          m.get(0, 0), m.get(1, 0), m.get(0, 1), m.get(1, 1));
        
       // collector.
        
        System.out.println(" runs = "+runs + "; correct = "+correct + "; accuracy = " + (((float) correct / runs)*100) +"%");
        
        
        /*static BufferedReader open(String inputFile) throws IOException {
		    InputStream in;
		    try {
		      in = Resources.getResource(inputFile).openStream();
		    } catch (IllegalArgumentException e) {
		      in = new FileInputStream(new File(inputFile));
		    }
		    return new BufferedReader(new InputStreamReader(in, Charsets.UTF_8));
		  } */
    	
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
    } 
}
