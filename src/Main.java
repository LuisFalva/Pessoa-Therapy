public class Main {

    public static void main(String[] args) {

        PacientX px = new PacientX();
        PessoaTherapy pessoa = new PessoaTherapy();
        Module m = new Module();

        px.px_name("luis");
        px.px_last_name("vargas");
        px.pathology_type("schizophrenia");
        px.therapy_type("supportive");

        double dose_mean = pessoa.mean_dose(m.doseArray, m.ddof);
        double doseDev = pessoa.dose_deviation(m.doseArray, m.ddof);
        double outBehaviour = pessoa.outlier_detection(m.doseArray,0.05, m.ddof);
        double improveRatio = pessoa.improve_ratio(m.doseArray);
        double pessoaAcc = pessoa.pessoa_accuracy(doseDev, improveRatio, outBehaviour);

        System.out.println();
        px.px_case_file();

        System.out.format("Mean Medical Doses = %.6f \n", dose_mean);
        System.out.format("Medical Dose Deviation = %.6f \n", doseDev);
        System.out.format("Improvement Medical Ratio = %.6f \n", improveRatio);
        System.out.format("Atipical Behaviour = %.6f \n", outBehaviour);
        System.out.format("Clinical Pessoa Accuracy = %.6f\n\n", pessoaAcc);
    }
}
