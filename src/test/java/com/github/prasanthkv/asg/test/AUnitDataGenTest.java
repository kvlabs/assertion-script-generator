package com.github.prasanthkv.asg.test;

import com.github.prasanthkv.asg.test.gen.TestDataGenerator;
import com.github.prasanthkv.asg.AssertionScriptGenerator;
import com.github.prasanthkv.asg.test.model.First;
import com.github.prasanthkv.asg.test.model.OruEnum;
import com.github.prasanthkv.asg.test.model.Thrird;
import org.junit.Assert;

/**
 *
 * @author prasanthkv
 */
public class AUnitDataGenTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(new AssertionScriptGenerator(new TestDataGenerator().getFirst(), "result").generateAssertionScript());
        //System.out.println(new AssertionScriptGenerator(new TestDataGenerator().getMap(), "map").generateAssertionScript());
    }

    /**
     * Test of getFirst method, of class TestDataGenerator.
     */
    @org.junit.Test
    public void testGetFirst() {
        System.out.println("getFirst");
        TestDataGenerator instance = new TestDataGenerator();
        First result = instance.getFirst();
        //
        Assert.assertEquals("Here is a string to check", result.getOruString());
        Assert.assertEquals(444422, result.getOruInt());
        Assert.assertTrue(result.isOruBoolean());
        Assert.assertEquals(8.8886664E7f, result.getOruFloat(), 0);
        Assert.assertEquals(5555533333222L, result.getOruLong());
        Assert.assertEquals(9.99966663322E9, result.getOruDoble(), 0);
        Assert.assertEquals(OruEnum.FIRST_ENUM, result.getOruEnum());
        Assert.assertNotNull(result.getSecond());
        //  Second //
        Assert.assertEquals(531223, result.getSecond().getSecondInt());
        Assert.assertEquals(666666666L, result.getSecond().getOruLong());
        Assert.assertEquals("Here is a second String", result.getSecond().getSecondString());
        Assert.assertFalse(result.getSecond().isSecondBoolean());
        Assert.assertEquals(4444.333f, result.getSecond().getSecondFloat(), 0);
        Assert.assertEquals(555555.55555, result.getSecond().getSecondDoble(), 0);
        Assert.assertNotNull(result.getListOfThrird());
        //Collection
        Assert.assertEquals(3, result.getListOfThrird().size());
        // 1
        Thrird thrird = result.getListOfThrird().get(0);
        Assert.assertEquals(0, thrird.getThrirdInt());
        Assert.assertEquals(0L, thrird.getThrirdLong());
        Assert.assertEquals("Thrird String 0", thrird.getThrirdString());
        Assert.assertTrue(thrird.isThrirdBoolean());
        Assert.assertEquals(0.0f, thrird.getThrirdFloat(), 0);
        Assert.assertEquals(0.0, thrird.getThrirdDoble(), 0);
        // 2
        Thrird thrird2 = result.getListOfThrird().get(1);
        Assert.assertEquals(1, thrird2.getThrirdInt());
        Assert.assertEquals(1L, thrird2.getThrirdLong());
        Assert.assertEquals("Thrird String 1", thrird2.getThrirdString());
        Assert.assertTrue(thrird2.isThrirdBoolean());
        Assert.assertEquals(1.0f, thrird2.getThrirdFloat(), 0);
        Assert.assertEquals(1.0, thrird2.getThrirdDoble(), 0);
        // 3
        Thrird thrird3 = result.getListOfThrird().get(2);
        Assert.assertEquals(2, thrird3.getThrirdInt());
        Assert.assertEquals(2L, thrird3.getThrirdLong());
        Assert.assertEquals("Thrird String 2", thrird3.getThrirdString());
        Assert.assertTrue(thrird3.isThrirdBoolean());
        Assert.assertEquals(2.0f, thrird3.getThrirdFloat(), 0);
        Assert.assertEquals(2.0, thrird3.getThrirdDoble(), 0);
        Assert.assertNotNull(result.getCollectionOfObjects());
        //Collection
        //Support for [java.util.HashMap$KeySet] is yet to be added
        Assert.assertNotNull(result.getMapOfThrird());
        //MAP
        Assert.assertEquals(5, result.getMapOfThrird().size());
        // 1
        Thrird thrird4 = result.getMapOfThrird().get("KEY_12");
        Assert.assertEquals(12, thrird4.getThrirdInt());
        Assert.assertEquals(12L, thrird4.getThrirdLong());
        Assert.assertEquals("Thrird String 12", thrird4.getThrirdString());
        Assert.assertTrue(thrird4.isThrirdBoolean());
        Assert.assertEquals(12.0f, thrird4.getThrirdFloat(), 0);
        Assert.assertEquals(12.0, thrird4.getThrirdDoble(), 0);
        // 1
        Thrird thrird5 = result.getMapOfThrird().get("KEY_11");
        Assert.assertEquals(11, thrird5.getThrirdInt());
        Assert.assertEquals(11L, thrird5.getThrirdLong());
        Assert.assertEquals("Thrird String 11", thrird5.getThrirdString());
        Assert.assertTrue(thrird5.isThrirdBoolean());
        Assert.assertEquals(11.0f, thrird5.getThrirdFloat(), 0);
        Assert.assertEquals(11.0, thrird5.getThrirdDoble(), 0);
        // 1
        Thrird thrird6 = result.getMapOfThrird().get("KEY_14");
        Assert.assertEquals(14, thrird6.getThrirdInt());
        Assert.assertEquals(14L, thrird6.getThrirdLong());
        Assert.assertEquals("Thrird String 14", thrird6.getThrirdString());
        Assert.assertTrue(thrird6.isThrirdBoolean());
        Assert.assertEquals(14.0f, thrird6.getThrirdFloat(), 0);
        Assert.assertEquals(14.0, thrird6.getThrirdDoble(), 0);
        // 1
        Thrird thrird7 = result.getMapOfThrird().get("KEY_13");
        Assert.assertEquals(13, thrird7.getThrirdInt());
        Assert.assertEquals(13L, thrird7.getThrirdLong());
        Assert.assertEquals("Thrird String 13", thrird7.getThrirdString());
        Assert.assertTrue(thrird7.isThrirdBoolean());
        Assert.assertEquals(13.0f, thrird7.getThrirdFloat(), 0);
        Assert.assertEquals(13.0, thrird7.getThrirdDoble(), 0);
        // 1
        Thrird thrird8 = result.getMapOfThrird().get("KEY_10");
        Assert.assertEquals(10, thrird8.getThrirdInt());
        Assert.assertEquals(10L, thrird8.getThrirdLong());
        Assert.assertEquals("Thrird String 10", thrird8.getThrirdString());
        Assert.assertTrue(thrird8.isThrirdBoolean());
        Assert.assertEquals(10.0f, thrird8.getThrirdFloat(), 0);
        Assert.assertEquals(10.0, thrird8.getThrirdDoble(), 0);
        Assert.assertNotNull(result.getMapOfObjects());
        //MAP
        Assert.assertEquals(8, result.getMapOfObjects().size());
        Assert.assertEquals("VALUE_7", result.getMapOfObjects().get("KEY_FOR_STRING"));
        Assert.assertEquals("VALUE_1", result.getMapOfObjects().get(new Character('1')));
        Assert.assertEquals("VALUE_7", result.getMapOfObjects().get(new Double(123456.7890625)));
        Assert.assertEquals("VALUE_4", result.getMapOfObjects().get(new Integer(1234567)));
        Assert.assertEquals("VALUE_6", result.getMapOfObjects().get(new Float(1234.56F)));
        Assert.assertEquals("VALUE_5", result.getMapOfObjects().get(new Long(1234567891011L)));
        Assert.assertEquals("VALUE_3", result.getMapOfObjects().get(new Short((short) 12345)));
        Assert.assertEquals("VALUE_2", result.getMapOfObjects().get(new Byte((byte) 123)));
        Assert.assertNotNull(result.getArrayOfThrird());
        //Array
        Assert.assertEquals(5, result.getArrayOfThrird().length);
        // 1
        Thrird thrird9 = result.getArrayOfThrird()[0];
        Assert.assertEquals(0, thrird9.getThrirdInt());
        Assert.assertEquals(0L, thrird9.getThrirdLong());
        Assert.assertEquals("Thrird String 0", thrird9.getThrirdString());
        Assert.assertTrue(thrird9.isThrirdBoolean());
        Assert.assertEquals(0.0f, thrird9.getThrirdFloat(), 0);
        Assert.assertEquals(0.0, thrird9.getThrirdDoble(), 0);
        // 2
        Thrird thrird10 = result.getArrayOfThrird()[1];
        Assert.assertEquals(1, thrird10.getThrirdInt());
        Assert.assertEquals(1L, thrird10.getThrirdLong());
        Assert.assertEquals("Thrird String 1", thrird10.getThrirdString());
        Assert.assertTrue(thrird10.isThrirdBoolean());
        Assert.assertEquals(1.0f, thrird10.getThrirdFloat(), 0);
        Assert.assertEquals(1.0, thrird10.getThrirdDoble(), 0);
        // 3
        Thrird thrird11 = result.getArrayOfThrird()[2];
        Assert.assertEquals(2, thrird11.getThrirdInt());
        Assert.assertEquals(2L, thrird11.getThrirdLong());
        Assert.assertEquals("Thrird String 2", thrird11.getThrirdString());
        Assert.assertTrue(thrird11.isThrirdBoolean());
        Assert.assertEquals(2.0f, thrird11.getThrirdFloat(), 0);
        Assert.assertEquals(2.0, thrird11.getThrirdDoble(), 0);
        // 4
        Assert.assertNull(result.getArrayOfThrird()[3]);
        // 5
        Assert.assertNull(result.getArrayOfThrird()[4]);
        Assert.assertNotNull(result.getArrayOfString());
        //Array
        Assert.assertEquals(3, result.getArrayOfString().length);
        // 1
        Assert.assertEquals("array_1", result.getArrayOfString()[0]);
        // 2
        Assert.assertEquals("array_2", result.getArrayOfString()[1]);
        // 3
        Assert.assertEquals("arrat_3", result.getArrayOfString()[2]);
    }

}
