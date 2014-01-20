/*
 * GPL v3
 */

package org.lahc.totem;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Vector;
import org.gephi.data.attributes.api.AttributeColumn;
import org.gephi.data.attributes.api.AttributeController;
import org.gephi.data.attributes.api.AttributeModel;
import org.gephi.graph.api.Edge;
//import org.gephi.graph.api.EdgeData;
import org.gephi.graph.api.Graph;
import org.gephi.graph.api.GraphModel;
import org.gephi.graph.api.Node;
//import org.gephi.data.
import org.gephi.statistics.spi.Statistics;
import org.gephi.utils.longtask.spi.LongTask;
import org.gephi.utils.progress.Progress;
import org.gephi.utils.progress.ProgressTicket;

//import uk.ac.shef.wit.simmetrics;
import org.openide.util.Lookup;


import uk.ac.shef.wit.simmetrics.similaritymetrics.*;

//org.chapman.simmetrics;


/**
 *
 * See http://wiki.gephi.org/index.php/HowTo_write_a_metric#Create_Statistics
 * 
 * @author David Combe <david.combe@gmail.com>
 */
public class Totem implements Statistics, LongTask {

    private boolean cancel = false;
    private ProgressTicket progressTicket;
    
    //private boolean directed;
    public String columnText;
    public String res="";
    public String simClass;
    public boolean weighted=false;
    public double threshold=0.3;
    public boolean debug=false;

    public Totem(){
        
    }
    
    
    
    public Totem(String columnText, /*String res,*/ String simClass, boolean weighted, double threshold, boolean debug){
        this.columnText=columnText;
        //this.res=res;
        this.simClass=simClass;
        this.weighted=weighted;
        this.threshold=threshold;
        this.debug=debug;
    }
    
    
    
    @Override
    public void execute(GraphModel graphModel, AttributeModel attributeModel) {
        Graph graph = graphModel.getGraph();
        //graph.readLock();
        
        System.out.println(columnText+simClass+threshold);
        
        //float[][] values=new float[graph.getNodeCount()][graph.getNodeCount()];
        //String columnText=null;
        if(this.columnText==null)
            columnText="lemmas";
        
        res+="Column: "+columnText+"\n";
        res+="Similarity: "+simClass+"\n";
        res+="Threshold: "+threshold+"\n";
        
        //Your algorithm
        //See http://wiki.gephi.org/index.php/HowTo_write_a_metric#Implementation_help
        try {
            
            
            
            
            System.out.println("debut");
            Progress.start(progressTicket, graph.getNodeCount());
            
            
            AbstractStringMetric metric = (AbstractStringMetric)Class.forName(simClass).newInstance();// new JaccardSimilarity();
            
            //Vector<Integer>sources =new Vector<Integer>();
            //Vector<Integer>targets =new Vector<Integer>();
            ArrayList<Edge> edges=new ArrayList<Edge>();
            //Vector<Edge> edges=new Vector<Edge>();
            //int i=0;
            
            for (Node m : graph.getNodes()) {
                System.out.println("azerty");
                String mText=(String)m.getNodeData().getAttributes().getValue(columnText);

                if(mText!=null){
                    int m_inf_n=1;
                    for (Node n : graph.getNodes()) {
                        if(m_inf_n==1){// in order to test only one time each couple of nodes
                            if(m.equals(n))
                                m_inf_n=0;
                            continue;
                        }
                        
                        String nText=(String)n.getNodeData().getAttributes().getValue(columnText);
                        
                        if(nText!=null){
                            //TEST
                            float score=metric.getSimilarity(mText, nText);
                            if(score>threshold){
                                Edge e=//new TextEdge(m,n,score);
                                
                                graphModel.factory().newEdge(m, n,(weighted?score:1),false);
                                //if(weighted)
                                    //e.setWeight(score);
                                
                                edges.add(e);
                            }
                            //Debug
                            if(debug)
                                res+=score+"\n";
                            /*if(graph.getNodeCount()<10)
                                res+=score+"\n";*/
                        }
                    }
                }
                
                System.err.println("finduFor");
                
                Progress.progress(progressTicket);
                if (cancel) {
                    break;
                }
                
            }
            graph.readUnlockAll();
            
            graph.writeLock();
            for( Edge e : edges){
                    graph.addEdge(e);
            }
            res+=edges.size()+" edges were appended.\n";
            
            graph.writeUnlock();
            
            System.err.println("FINTOTEM");

            
        } catch (Exception e) {
            StringWriter sw=new StringWriter();
            PrintWriter pw=new PrintWriter(sw, true);
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
            res+= sw.toString();
            e.printStackTrace();
            
            
            //System.err.println(e.printStackTrace());
            System.err.println("EXCEPTION");

        } finally {
            //Unlock graph
            graph.readUnlockAll();
            System.err.println("UNLOCK");
        }
    }

    /** Only useful if the algorithm takes graph type into account. */

    /*public boolean isDirected() {
        return directed;
    }

    public void setDirected(boolean directed) {
        this.directed = directed;
    }*/

    /** ----------------------------------------------------------- */

    @Override
    public String getReport() {
        //Write the report HTML string here
        String report = "The result is \n"+res;

        return report;
    }

    @Override
    public boolean cancel() {
        cancel = true;
        return true;
    }

    @Override
    public void setProgressTicket(ProgressTicket progressTicket) {
        this.progressTicket = progressTicket;
    }

    public void setColumnText(String selectedValue) {
        columnText=selectedValue;
    }

    @Override
    public String toString() {
        return simClass.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
