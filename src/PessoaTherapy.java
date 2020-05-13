import java.lang.Math;


public class PessoaTherapy {


    public double mean_dose(double[] doseArray, int ddof) {

        double sum = 0.0;
        int length = doseArray.length-ddof;

        for(int i = 0; i < length; i++) {
            sum += doseArray[i];
        }

        return sum / length;
    }

    public double dose_deviation(double doseArray[], int ddof) {

        double mean = mean_dose(doseArray, ddof);
        double dev = 0.0;
        int length = doseArray.length-ddof;

        for(int i = 0; i < length; i++) {
            dev += Math.pow(doseArray[i] - mean, 2);
        }

        return Math.sqrt(dev/length);
    }

    public double outlier_detection(double doseArray[], double chg_prc, int ddof) {

        double lst = doseArray[doseArray.length - 1];
        double mean = mean_dose(doseArray, ddof);
        double std = dose_deviation(doseArray, ddof);
        double rel_std = std/mean;

        if (std == 0.0) {
            if (lst == doseArray[0]) {
                return 0.0;
            } if (lst > (doseArray[0] * (1.0 + chg_prc))) {
                return 2.5;
            } if (lst < (doseArray[0] * (1.0 - chg_prc))) {
                return -2.5;
            } else {
                return 0.0;
            }
        }
        if (std / Math.abs(mean) < rel_std) {
            return 0.0;
        } else {
            return (lst - mean) / std;
        }
    }

    public double improve_ratio(double doseArray[]) {

        double d = doseArray[doseArray.length-1];
        double d_1 = doseArray[doseArray.length-2];
        return Math.pow(((d - d_1) / d), 2);
    }

    public double pessoa_accuracy(double doseDev, double improveRatio, double outBehaviour) {
        return Math.abs((doseDev / improveRatio) * outBehaviour);
    }
}
