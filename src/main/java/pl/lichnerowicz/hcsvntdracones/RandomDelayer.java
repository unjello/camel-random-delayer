/*
 * andrzej lichnerowicz, unlicensed (~public domain)
 */
package pl.lichnerowicz.hcsvntdracones;

import java.security.SecureRandom;
import cern.jet.random.Poisson;

/**
 * This class consist of methods for generating random
 * values, for use with Camel routes in ActiveMQ.
 *
 * @author Andrzej Lichnerowicz
 */

public class RandomDelayer {
    /**
     * Takes one integer from Gauss distribution.
     *
     * @param max maximum delay, in milliseconds
     */
    public long getGauss(long max) {
        double random = new SecureRandom().nextGaussian();
        return (long)(random * max);
    }

    /**
     * Takes one integer from Poisson distribution
     *
     * @param mean average number of delay, in milliseconds
     */
    public int getPoisson(double mean) {
        return Poisson.staticNextInt(mean);
    }
}
