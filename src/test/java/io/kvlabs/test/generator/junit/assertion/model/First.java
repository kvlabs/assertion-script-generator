package io.kvlabs.test.generator.junit.assertion.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author prasanthkv
 */
public class First {

    private String oruString;
    private int oruInt;
    private boolean oruBoolean;
    private float oruFloat;
    private long oruLong;
    private double oruDoble;
    private OruEnum oruEnum;
    private Second second;
    private List<Thrird> listOfThrird;
    private Set<Object> collectionOfObjects;
    private Map<String, Thrird> mapOfThrird;
    private Map< Object, String> mapOfObjects;
    private Thrird[] arrayOfThrird;
    private String[] arrayOfString;

    public String getOruString() {
        return oruString;
    }

    public void setOruString(String oruString) {
        this.oruString = oruString;
    }

    public int getOruInt() {
        return oruInt;
    }

    public void setOruInt(int oruInt) {
        this.oruInt = oruInt;
    }

    public boolean isOruBoolean() {
        return oruBoolean;
    }

    public void setOruBoolean(boolean oruBoolean) {
        this.oruBoolean = oruBoolean;
    }

    public float getOruFloat() {
        return oruFloat;
    }

    public void setOruFloat(float oruFloat) {
        this.oruFloat = oruFloat;
    }

    public double getOruDoble() {
        return oruDoble;
    }

    public void setOruDoble(double oruDoble) {
        this.oruDoble = oruDoble;
    }

    public Second getSecond() {
        return second;
    }

    public void setSecond(Second second) {
        this.second = second;
    }

    public List<Thrird> getListOfThrird() {
        return listOfThrird;
    }

    public void setListOfThrird(List<Thrird> listOfThrird) {
        this.listOfThrird = listOfThrird;
    }

    public Map<String, Thrird> getMapOfThrird() {
        return mapOfThrird;
    }

    public void setMapOfThrird(Map<String, Thrird> mapOfThrird) {
        this.mapOfThrird = mapOfThrird;
    }

    public long getOruLong() {
        return oruLong;
    }

    public void setOruLong(long oruLong) {
        this.oruLong = oruLong;

    }

    public Map< Object, String> getMapOfObjects() {
        return mapOfObjects;
    }

    public void setMapOfObjects(Map< Object, String> mapOfObjects) {
        this.mapOfObjects = mapOfObjects;
    }

    public Set<Object> getCollectionOfObjects() {
        return collectionOfObjects;
    }

    public void setCollectionOfObjects(Set<Object> collectionOfObjects) {
        this.collectionOfObjects = collectionOfObjects;
    }

    public OruEnum getOruEnum() {
        return oruEnum;
    }

    public void setOruEnum(OruEnum oruEnum) {
        this.oruEnum = oruEnum;
    }

    public Thrird[] getArrayOfThrird() {
        return arrayOfThrird;
    }

    public void setArrayOfThrird(Thrird[] arrayOfThrird) {
        this.arrayOfThrird = arrayOfThrird;
    }

    public String[] getArrayOfString() {
        return arrayOfString;
    }

    public void setArrayOfString(String[] arrayOfString) {
        this.arrayOfString = arrayOfString;
    }

}
