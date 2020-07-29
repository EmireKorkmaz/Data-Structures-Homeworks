public class MyMap<K, V>{

    private int TABLE_LENGTH;
    private double LOAD_THREASHOLD;
    private Entry[] array;
    private int numKeys, numDeletes;

    public int getNumKeys() {
        return numKeys;
    }

    public void setNumKeys(int numKeys) {
        this.numKeys = numKeys;
    }

    public int getNumDeletes() {
        return numDeletes;
    }

    public void setNumDeletes(int numDeletes) {
        this.numDeletes = numDeletes;
    }

    public MyMap(){
        TABLE_LENGTH = 11;
        array = new Entry[TABLE_LENGTH];
        LOAD_THREASHOLD = 0.75;
        for (Entry m: array)
            m = null;
    }

    public int hashFunc(Object k){
        return k.hashCode() % TABLE_LENGTH;
    }

    public int hashFunc2(K k){
        int p = TABLE_LENGTH-2;

        for(int i = TABLE_LENGTH -1; i>=2 ; i--) {
            if (prime(i))
                p = i;
        }
        return p - (k.hashCode() % p);
    }

    public boolean prime(int x){
        for (int i=2; i< x; i++){
            if(x%i==0)
                return false;
        }
        return true;
    }

    private int find(Object key){
        int i = hashFunc(key);

        if(i<0)
            i+=TABLE_LENGTH;
        while ((array[i]!=null) && (!key.equals(array[i].getKey()))){
            i++;
            if (i>=TABLE_LENGTH)
                i=0;
        }
        return i;
    }

    public Object put(K k, V v) {
        if(array[hashFunc(k)]==null){
            Entry<K, V > temp = new Entry<K,V>();
            temp.setKey(k);
            temp.setValue(v);
            array[hashFunc(k)] = temp;
            double loadFactor = (double) (numKeys+numDeletes)/TABLE_LENGTH;
            if(loadFactor > LOAD_THREASHOLD)
                rehash();
            numKeys++;
            return null;
        }
        int i=0, index;

        while (true){
            index = (hashFunc(k) + i*hashFunc2(k)) % TABLE_LENGTH;
            if(array[index]==null){
                Entry<K, V > temp = new Entry();
                temp.setKey(k);
                temp.setValue(v);
                array[index] = temp;
                numKeys++;
                return temp.getValue();
            }
            i++;
        }
    }

    public int size() {
        return numKeys;
    }

    public boolean isEmpty() {
        return numKeys==0;
    }

    public boolean containsKey(Object key) {
        return false;
    }

    public boolean containsValue(Object value) {
        return false;
    }

    public V get(Object k){
        int index = find(k);
        if(array[index].isDeleted())
            return null;
        else if (array[index]!=null)
            return (V) array[index].getValue();
        else
            return null;
    }

    public V remove(Object k) {
        int i = find(k);
        if (array[i] == null)
            return null;
        array[i].setDeleted(true);
        numDeletes++;
        return (V) array[i].getValue();
    }

    private void rehash(){
        Entry<K,V>[] old = array;
        array = new Entry[old.length*2+1];

        TABLE_LENGTH = 2*old.length+1;

        numKeys=0;
        numDeletes=0;

        for(int i = 0; i<old.length; i++){
            if ((old[i] != null) && (old[i].isDeleted()==false)){
                put(old[i].getKey(), old[i].getValue());
            }
        }
    }
}
