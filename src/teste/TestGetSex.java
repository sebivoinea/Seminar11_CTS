package teste;

import clase.Persoana;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGetSex {

    @Test
    public void testRight(){
        Persoana persoana = new Persoana("Andrei", "5000421330951");
        assertEquals("M", persoana.getSex());
    }

    @Test
    public void testBoundaryInfefrior(){
        Persoana persoana = new Persoana("Mihai", "1001215498853");
        assertEquals("M", persoana.getSex());
    }

    @Test
    public void testBoundarySuperior(){
        Persoana persoana = new Persoana("Andra", "6000917435691");
        assertEquals("F", persoana.getSex());
    }

    @Test
    public void testCrossCheck(){
        Persoana persoana = new Persoana("Andra", "6000917435691");
        int cifra = persoana.CNP.charAt(0);
        assertEquals(cifra%2 != 0 ? "M":"F",persoana.getSex());
    }

    @Test(expected = CNPInvalidException.class)
    public void testError(){
        Persoana persoana = new Persoana("Andra", "0000917435691");
        persoana.getSex();
    }

    @Test(expected = CNPInvalidException.class)
    public void testError2(){
        Persoana persoana = new Persoana("Andra", "f000917435691");
        persoana.getSex();
    }

    @Test(timeout = 100)
    public void performanceTest() {
        Persoana persoana=new Persoana("Antonio","19145453344333");
        persoana.getSex();
    }

    @Test
    public void formatGetSexTest(){
        Persoana persoana = new Persoana("Andra", "6000917435691");
        assertEquals(1, persoana.getSex().length());
    }

    @Test
    public void outOfRangeTest() {
        Persoana persoana=new Persoana("Marian","79145453344333");
        assertEquals("N/A", persoana.getSex());
    }

    @Test(expected = NullPointerException.class)
    public void existanceGetSex() {
        Persoana persoana=new Persoana("Antonio",null);
        persoana.getSex();
    }
}
