/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmining;

/**
 *
 * @author LyMinhTrung
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import weka.classifiers.Evaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.Debug.Random;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
public class Clustering {
    Instances cpu = null;
    SimpleKMeans kmeans;
    public void loadArff(String arffInput){
        DataSource source=null;
        try{
            source=new DataSource(arffInput);
            cpu = source.getDataSet();
         }catch (Exception e1){
        }
    }
    public void clusterData(){
        kmeans=new SimpleKMeans();
        kmeans.setSeed(10);
        try{
            kmeans.setPreserveInstancesOrder(true);
            kmeans.setNumClusters(3);
           kmeans.buildClusterer(cpu);
           int[] assignments=kmeans.getAssignments();
           int i=0;
           for (int clusterNum:assignments) {
               System.out.printf("Instance %d -> Cluster %d\n", i, clusterNum);
               i++;
           }
        }
        catch (Exception e1){
        }
    }



    public static void main(String[] args){
        Clustering cluster=new Clustering();
        cluster.loadArff("C:\\Users\\Asus\\OneDrive - VietNam National University - HCM INTERNATIONAL UNIVERSITY\\Study Document - INTERNATIONAL UNIVERSITY\\Năm 3rd\\Sem 2\\Intro to Data Mining\\Project\\rfm_data.arff");
        cluster.clusterData();

    }
}
