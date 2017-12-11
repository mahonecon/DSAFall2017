
public class Data<KT extends Comparable<? super KT>> extends KeyedItem<KT> {

    private String data;

    public Data(KT key) {
        super(key);
    }

    public String toString(KT key) {
        return data;
    }

}
