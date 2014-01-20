/*
 * GPL 3
 */

package org.lahc.totem;

import org.gephi.statistics.spi.Statistics;
import org.gephi.statistics.spi.StatisticsBuilder;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * See http://wiki.gephi.org/index.php/HowTo_write_a_metric#Create_StatisticsBuilder
 * 
 * @author David Combe <david.combe@gmail.com>
 */
@ServiceProvider(service = StatisticsBuilder.class)
public class MyMetricBuilder implements StatisticsBuilder {

    @Override
    public String getName() {
        return "Append similarity edges";
    }

    @Override
    public Statistics getStatistics() {
        return new Totem();
    }

    @Override
    public Class<? extends Statistics> getStatisticsClass() {
        return Totem.class;
    }

}
