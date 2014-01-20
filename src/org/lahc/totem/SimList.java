/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.lahc.totem;

import javax.swing.AbstractListModel;
import javax.swing.ListModel;

/**
 *
 * @author David
 */
public class SimList extends AbstractListModel{

    final String[] strings = {"uk.ac.shef.wit.simmetrics.similaritymetrics.BlockDistance",
        "uk.ac.shef.wit.simmetrics.similaritymetrics.Candida",
        "uk.ac.shef.wit.simmetrics.similaritymetrics.ChapmanLengthDeviation",
        "uk.ac.shef.wit.simmetrics.similaritymetrics.ChapmanMatchingSoundex",
        "uk.ac.shef.wit.simmetrics.similaritymetrics.ChapmanMeanLength",
        "uk.ac.shef.wit.simmetrics.similaritymetrics.ChapmanOrderedNameCompoundSimilarity",
        "uk.ac.shef.wit.simmetrics.similaritymetrics.CosineSimilarity",
        "uk.ac.shef.wit.simmetrics.similaritymetrics.DiceSimilarity",
        "uk.ac.shef.wit.simmetrics.similaritymetrics.EuclideanDistance",
        "uk.ac.shef.wit.simmetrics.similaritymetrics.JaccardSimilarity",
        "uk.ac.shef.wit.simmetrics.similaritymetrics.Jaro",
        "uk.ac.shef.wit.simmetrics.similaritymetrics.JaroWinkler",
        "uk.ac.shef.wit.simmetrics.similaritymetrics.Levenshtein",
        "uk.ac.shef.wit.simmetrics.similaritymetrics.MatchingCoefficient",
        "uk.ac.shef.wit.simmetrics.similaritymetrics.MongeElkan",
        "uk.ac.shef.wit.simmetrics.similaritymetrics.NeedlemanWunch",
        "uk.ac.shef.wit.simmetrics.similaritymetrics.OverlapCoefficient",
        "uk.ac.shef.wit.simmetrics.similaritymetrics.QGramsDistance",
        "uk.ac.shef.wit.simmetrics.similaritymetrics.SmithWatermanGotoh",
        "uk.ac.shef.wit.simmetrics.similaritymetrics.SmithWatermanGotohWindowedAffine",
        "uk.ac.shef.wit.simmetrics.similaritymetrics.SmithWaterman",
        "uk.ac.shef.wit.simmetrics.similaritymetrics.Soundex",
        "uk.ac.shef.wit.simmetrics.similaritymetrics.TagLink",
        "uk.ac.shef.wit.simmetrics.similaritymetrics.TagLinkToken"};
    public int getSize() { return strings.length; }
    public Object getElementAt(int i) { return strings[i];}
}

