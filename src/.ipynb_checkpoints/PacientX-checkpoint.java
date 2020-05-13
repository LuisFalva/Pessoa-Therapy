public class PacientX {

    private String first_name;
    private String last_name;
    private String pathology;
    private String therapy;

    public String px_name(String first) {
        return this.first_name = first;
    }

    public String px_last_name(String last) {
        return this.last_name = last;
    }

    public String pathology_type(String pathology) {
        return this.pathology = pathology;
    }

    public String therapy_type(String therapy) {
        return this.therapy = therapy;
    }

    public void px_case_file() {
        System.out.println(String.format("Px name: %s", first_name));
        System.out.println(String.format("Px last name: %s", last_name));
        System.out.println(String.format("Px pathology type: %s", pathology));
        System.out.println(String.format("Px therapy applied: %s \n\n", therapy));
    }
}
