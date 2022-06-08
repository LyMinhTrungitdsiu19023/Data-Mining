package dmining;

/**
 *
 * @author LyMinhTrung
 */
import java.io.BufferedReader;
import java.io.FileReader;
import weka.core.converters.ConverterUtils.DataSource;
import java.util.Random;
import weka.associations.FPGrowth;
import weka.core.Instances;

public class AssociationFPGrowth {
//Association Rule FPGrowth

    public static void main(String[] args) throws Exception{

        Instances dataset = new Instances(new BufferedReader(new FileReader("C:\\Users\\Asus\\OneDrive - VietNam National University - HCM INTERNATIONAL UNIVERSITY"
                + "\\Study Document - INTERNATIONAL UNIVERSITY\\Năm 3rd\\Sem 2\\Intro to Data Mining\\Project\\trung_train_cluster0.arff")));
    	FPGrowth fpg = new FPGrowth();
        fpg.setMinMetric(0.3);
        fpg.setLowerBoundMinSupport(0.05);
        fpg.setNumRulesToFind(100);
	fpg.buildAssociations(dataset);
        System.out.println(fpg);
       
    }
    
}
