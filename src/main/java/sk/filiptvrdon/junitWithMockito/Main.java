package sk.filiptvrdon.junitWithMockito;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry("Telenovela", "telenovela"));
        entries.add(new Entry("Štatút SKDP", "statut skdp"));
        entries.add(new Entry("solr search test 5673", "solr search test 5673"));
        entries.add(new Entry("Škúška", "skuska"));
        entries.add(new Entry("Skúška príloh", "skuska priloh"));
        entries.add(new Entry("Skuska 12345", "skuska 12345"));
        entries.add(new Entry("Skúšaníčko opravených duplikácií", "skusanicko opravenych duplikacii"));
        entries.add(new Entry("Škúšaníčko opravených duplikácií", "skusanicko opravenych duplikacii"));


        entries.forEach(entry -> {
            System.out.println(entry.value);
            System.out.println(entry.value_sort);
            System.out.println("-----");
        });



    }




    record Entry(String value, String value_sort) {}
}
