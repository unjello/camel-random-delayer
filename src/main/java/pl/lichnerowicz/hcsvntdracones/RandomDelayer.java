// andrzej lichnerowicz, unlicensed (~public domain)
package pl.lichnerowicz.hcsvntdracones;

import java.security.SecureRandom;
import cern.jet.random.Poisson;

public class RandomDelayer {
    public long getGauss(long max) {
        double random = new SecureRandom().nextGaussian();
        return (long)(random * max);
    }

    public int getPoisson(double lambda, int max) {
        int poisson = Poisson.staticNextInt(lambda);
        return poisson == 0 ? max : max / poisson ;
    }
}
